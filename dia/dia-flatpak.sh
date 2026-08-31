#!/usr/bin/env bash
set -Eeuo pipefail

APP_ID="org.gnome.Dia"
VERSION="0.97.2"

WORK="${HOME}/dia-0.97.2-flatpak"
SRC="${WORK}/src"
BUILD="${WORK}/build"
REPO="${WORK}/repo"
MANIFEST="${WORK}/${APP_ID}.yml"
BUNDLE="${WORK}/Dia-${VERSION}.flatpak"

DIA_URL="https://download.gnome.org/sources/dia/0.97/dia-${VERSION}.tar.xz"
GTK_URL="https://download.gnome.org/sources/gtk+/2.24/gtk+-2.24.33.tar.xz"
INTLTOOL_URL="https://launchpad.net/intltool/trunk/0.51.0/+download/intltool-0.51.0.tar.gz"

# SHA256 VERIFICADOS
DIA_SHA="a761478fb98697f71b00d3041d7c267f3db4b94fe33ac07c689cb89c4fe5eae1"
GTK_SHA="ac2ac757f5942d318a311a54b0c80b5ef295f299c2a73c632f6bfb1ff49cc6da"
ATK_SHA="fb76247e369402be23f1f5c65d38a9639c1164d934e40f6a9cf3c9e96b652788"
INTLTOOL_SHA="67c74d94196b153b774ab9f89b2fa6c6ba79352407037c8c14d5aeb334e959cd"

echo
echo "==============================================="
echo " Dia ${VERSION} -> Flatpak"
echo "==============================================="
echo

# =================================================
# Comprobar herramientas
# =================================================

echo "[0/8] Comprobando herramientas..."

for cmd in flatpak flatpak-builder curl sha256sum awk sed patch; do
    if ! command -v "$cmd" >/dev/null 2>&1; then
        echo
        echo "ERROR: falta el comando: $cmd"
        echo
        echo "Instálalo con:"
        echo
        echo "    sudo pacman -S flatpak flatpak-builder curl"
        echo
        exit 1
    fi
done

# =================================================
# Crear estructura
# =================================================

echo "[1/8] Creando directorios..."

rm -rf "$WORK"

mkdir -p \
    "$SRC" \
    "$BUILD" \
    "$REPO"

# =================================================
# Configurar Flathub
# =================================================

echo "[2/8] Configurando Flathub..."

flatpak remote-add \
    --user \
    --if-not-exists \
    flathub \
    https://dl.flathub.org/repo/flathub.flatpakrepo

# =================================================
# Descargar fuentes
# =================================================

echo "[3/8] Descargando Dia ${VERSION}..."

curl -L --fail --progress-bar \
    "$DIA_URL" \
    -o "$SRC/dia-${VERSION}.tar.xz"

echo
echo "[3/8] Descargando GTK+ 2.24.33..."

curl -L --fail --progress-bar \
    "$GTK_URL" \
    -o "$SRC/gtk+-2.24.33.tar.xz"

# =================================================
# Verificar Dia
# =================================================

echo
echo "Verificando SHA256 oficial de Dia..."

DIA_SHA_ACTUAL="$(
    sha256sum "$SRC/dia-${VERSION}.tar.xz" |
    awk '{print $1}'
)"

if [[ "$DIA_SHA_ACTUAL" != "$DIA_SHA" ]]; then
    echo
    echo "ERROR: checksum incorrecto de Dia."
    echo
    echo "Esperado: $DIA_SHA"
    echo "Obtenido: $DIA_SHA_ACTUAL"
    exit 1
fi

echo "OK: Dia ${VERSION}"

# =================================================
# Verificar GTK2
# =================================================

echo
echo "Verificando SHA256 oficial de GTK+ 2.24.33..."

GTK_SHA_ACTUAL="$(
    sha256sum "$SRC/gtk+-2.24.33.tar.xz" |
    awk '{print $1}'
)"

if [[ "$GTK_SHA_ACTUAL" != "$GTK_SHA" ]]; then
    echo
    echo "ERROR: checksum incorrecto de GTK+ 2.24.33."
    echo
    echo "Esperado: $GTK_SHA"
    echo "Obtenido: $GTK_SHA_ACTUAL"
    exit 1
fi

echo "OK: GTK+ 2.24.33"


# =================================================
# Crear manifest
# =================================================

echo
echo "[5/8] Creando manifest Flatpak..."

cat > "$MANIFEST" <<EOF
app-id: ${APP_ID}

runtime: org.freedesktop.Platform
runtime-version: "23.08"

sdk: org.freedesktop.Sdk

command: dia

finish-args:

  # X11
  - --share=ipc
  - --socket=x11

  # Acceso a los archivos del usuario
  - --filesystem=home

  # GTK2
  - --env=GDK_BACKEND=x11

modules:

  # =================================================
  # ATK 2.36.0
  # =================================================

  - name: atk

    buildsystem: meson

    sources:

      - type: archive
        url: https://download.gnome.org/sources/atk/2.36/atk-2.36.0.tar.xz
        sha256: ${ATK_SHA}


  # =================================================
  # GTK+ 2.24.33
  # =================================================

  - name: gtk2

    buildsystem: autotools

    make-args:
      - "-j1"

    config-opts:
      - --disable-static
      - --disable-cups
      - --disable-gtk-doc
      - --disable-man
      - --disable-papi
      - --disable-gtk-doc-html

    sources:

      - type: archive
        url: ${GTK_URL}
        sha256: ${GTK_SHA}


  # =================================================
  # intltool 0.51.0
  # =================================================

  - name: intltool

    buildsystem: autotools

    sources:

      - type: archive
        url: ${INTLTOOL_URL}
        sha256: ${INTLTOOL_SHA}


  # =================================================
  # Dia 0.97.2
  # =================================================

  - name: dia

    buildsystem: autotools

    config-opts:

      - --disable-static

      - --disable-update-mime-database

      - --disable-python
      - --without-python

      - --without-libart

      - --without-freetype

    build-options:

      env:
        FREETYPE_CONFIG: /app/bin/freetype-config

    post-install:

      # Dia 0.97.2 busca freetype-config.
      # El runtime moderno ya proporciona FreeType,
      # pero no necesariamente este script histórico.

      - |
        cat > /app/bin/freetype-config <<'EOF'
        #!/bin/sh

        case "\$1" in
          --version)
            pkg-config --modversion freetype2
            ;;
          --cflags)
            pkg-config --cflags freetype2
            ;;
          --libs)
            pkg-config --libs freetype2
            ;;
          *)
            echo "freetype-config: use --version, --cflags o --libs" >&2
            exit 1
            ;;
        esac
        EOF

        chmod +x /app/bin/freetype-config

    sources:

      - type: archive
        url: ${DIA_URL}
        sha256: ${DIA_SHA}

      - type: script
        commands:
          - |
            python3 -c '
            import textwrap
            with open("app/render_gdk.h", "r") as f: h = f.read()
            h = h.replace("DiaRenderer *new_gdk_renderer(DDisplay *ddisp);", "DiaRenderer *new_gdk_renderer(DDisplay *ddisp);\nvoid dia_interactive_renderer_gdk_register_interface (void);")
            with open("app/render_gdk.h", "w") as f: f.write(h)

            with open("app/main.c", "r") as f: m = f.read()
            m = m.replace("#include \"interface.h\"", "#include \"interface.h\"\n#include \"render_gdk.h\"").replace("app_init(argc, argv);", "dia_interactive_renderer_gdk_register_interface ();\n  app_init(argc, argv);")
            with open("app/main.c", "w") as f: f.write(m)

            with open("app/render_gdk.c", "r") as f: c = f.read()
            old_func = textwrap.dedent("""DiaRenderer *
            new_gdk_renderer(DDisplay *ddisp)
            {
              DiaGdkRenderer *renderer;
              GType renderer_type = 0;

              renderer = g_object_new (DIA_TYPE_GDK_RENDERER, NULL);
              renderer->transform = dia_transform_new (&ddisp->visible, &ddisp->zoom_factor);
              if (!DIA_GET_INTERACTIVE_RENDERER_INTERFACE (renderer))
                {
                  static const GInterfaceInfo irenderer_iface_info = 
                  {
                    (GInterfaceInitFunc) dia_gdk_renderer_iface_init,
                    NULL,           /* iface_finalize */
                    NULL            /* iface_data     */
                  };

                  renderer_type = DIA_TYPE_GDK_RENDERER;
                  /* register the interactive renderer interface */
                  g_type_add_interface_static (renderer_type,
                                               DIA_TYPE_INTERACTIVE_RENDERER_INTERFACE,
                                               &irenderer_iface_info);

                }
              renderer->parent_instance.is_interactive = 1;
              renderer->gc = NULL;

              renderer->pixmap = NULL;
              renderer->clip_region = NULL;

              return DIA_RENDERER(renderer);
            }""")

            new_func = textwrap.dedent("""void
            dia_interactive_renderer_gdk_register_interface (void)
            {
              static gboolean registered = FALSE;

              if (!registered)
                {
                  static const GInterfaceInfo irenderer_iface_info = 
                  {
                    (GInterfaceInitFunc) dia_gdk_renderer_iface_init,
                    NULL,           /* iface_finalize */
                    NULL            /* iface_data     */
                  };

                  g_type_add_interface_static (DIA_TYPE_GDK_RENDERER,
                                               DIA_TYPE_INTERACTIVE_RENDERER_INTERFACE,
                                               &irenderer_iface_info);
                  registered = TRUE;
                }
            }

            DiaRenderer *
            new_gdk_renderer(DDisplay *ddisp)
            {
              DiaGdkRenderer *renderer;

              dia_interactive_renderer_gdk_register_interface ();

              renderer = g_object_new (DIA_TYPE_GDK_RENDERER, NULL);
              renderer->transform = dia_transform_new (&ddisp->visible, &ddisp->zoom_factor);
              renderer->parent_instance.is_interactive = 1;
              renderer->gc = NULL;

              renderer->pixmap = NULL;
              renderer->clip_region = NULL;

              return DIA_RENDERER(renderer);
            }""")

            c = c.replace(old_func, new_func)
            with open("app/render_gdk.c", "w") as f: f.write(c)
            print("GLIB FIX COMPLETE")
            '


EOF

# =================================================
# Instalar runtime y SDK
# =================================================

echo
echo "[6/8] Instalando runtime y SDK..."

flatpak install \
    --user \
    -y \
    flathub \
    org.freedesktop.Platform//23.08 \
    org.freedesktop.Sdk//23.08

# =================================================
# Limpiar compilación anterior
# =================================================

echo
echo "Limpiando compilación anterior..."

chmod -R +w "$WORK/.flatpak-builder" 2>/dev/null || true
rm -rf \
    "$BUILD" \
    "$REPO" \
    "$WORK/.flatpak-builder"

mkdir -p \
    "$BUILD" \
    "$REPO"

# =================================================
# Compilar
# =================================================

echo
echo "[7/8] Compilando Dia..."
echo
echo "Esto puede tardar bastante."
echo

flatpak-builder \
    --user \
    --force-clean \
    --disable-rofiles-fuse \
    --state-dir="$WORK/.flatpak-builder" \
    --repo="$REPO" \
    "$BUILD" \
    "$MANIFEST"

# =================================================
# Crear bundle
# =================================================

echo
echo "[8/8] Creando bundle..."

rm -f "$BUNDLE"

flatpak build-bundle \
    "$REPO" \
    "$BUNDLE" \
    "$APP_ID"

# =================================================
# Resultado
# =================================================

echo
echo "==============================================="
echo "       CONSTRUCCIÓN FINALIZADA"
echo "==============================================="
echo
echo "Bundle generado:"
echo
echo "    $BUNDLE"
echo
echo "Tamaño:"
du -h "$BUNDLE" | awk '{print "    " $1}'
echo
echo "Para instalarlo:"
echo
echo "    flatpak --user install \"$BUNDLE\""
echo
echo "Para ejecutarlo:"
echo
echo "    flatpak run $APP_ID"
echo
echo "==============================================="
