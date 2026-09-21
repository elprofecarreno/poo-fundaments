# Proyecto 03 - Encapsulamiento con Lombok

Este proyecto continúa con la práctica de clases y encapsulamiento, pero usando anotaciones de Lombok para generar automáticamente getters, setters, constructores y el método `toString()`.

## ¿Qué hace?

La clase `Persona` guarda datos personales y permite crear instancias con una sintaxis más limpia. El programa principal demuestra la creación y la impresión de objetos de tipo `Persona`.

## Diagrama de clases

```mermaid
classDiagram
    class Persona {
        -run: int
        -dv: String
        -nombres: String
        -apellidoPaterno: String
        -apellidoMaterno: String
        +Persona()
        +Persona(run: int, dv: String, nombres: String, apellidoPaterno: String, apellidoMaterno: String)
        +toString(): String
    }

    class Main {
        +main(args: String[])$ void
    }

    Main ..> Persona : crea e imprime
```
