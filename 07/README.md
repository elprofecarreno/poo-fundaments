# Proyecto 07 - Menú y Registro de Personas

Este ejercicio agrega interacción con el usuario mediante un menú en consola para crear y listar personas.

## ¿Qué hace?

La clase `Menu` permite ingresar los datos de una persona, crear su dirección y almacenarla en memoria para luego mostrarla. El programa se apoya en una estructura de persona con dirección y en la capa de utilidades para manejar fechas.

## Diagrama de clases

```mermaid
classDiagram
    class Menu {
        -obtenerNumeroTeclado(message: String, sc: Scanner): int
        -obtenerTextoTeclado(message: String, sc: Scanner): String
        +menu(): void
    }

    class Persona {
        -run: int
        -dv: String
        -nombres: String
        -apellidoPaterno: String
        -apellidoMaterno: String
        -direccion: Direccion
        +Persona(...)
        +toString(): String
    }

    class Direccion {
        -calle: String
        -numero: String
        -comuna: String
        -region: String
        +Direccion(...)
        +toString(): String
    }

    class DateUtil {
        +stringToDate(dateS: String, format: String)$ Date
        +calcularEdad(fechaNacimiento: Date, fechaActual: Date)$ int
    }

    class Main {
        +main(args: String[])$ void
    }

    Main ..> Menu : usa
    Menu ..> Persona : crea y muestra
    Menu --> Direccion : crea
    Persona --> Direccion : tiene
    Persona ..> DateUtil : usa
```

## Estructura de Clases y Relaciones

- `Menu` es la clase que coordina la interacción con el usuario y orquesta la creación de objetos.
- `Persona` y `Direccion` forman una asociación de composición lógica: cada persona tiene una dirección.
- `DateUtil` actúa como clase de utilidad que respalda operaciones relacionadas con fechas.
- `Main` depende de `Menu` para iniciar la ejecución del programa.
