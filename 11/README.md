# Proyecto 11 - Persona con dirección, fecha y vehículo

Este proyecto consolida la relación entre la persona y su contexto completo: dirección, fecha de nacimiento y vehículo asociado.

## ¿Qué hace?

La aplicación permite crear una persona con todos sus datos principales, seleccionar un tipo de vehículo desde un submenú, asignárselo y mostrar la información completa en consola. El menú es iterativo y se repite hasta que el usuario sale del sistema.

## Diagrama de clases

```mermaid
classDiagram
    class Main {
        +main(args: String[])$ void
    }

    class Menu {
        +menu(): void
        +submenuVehiculo(): Vehiculo
    }

    class Persona {
        -run: int
        -dv: String
        -nombres: String
        -apellidoPaterno: String
        -apellidoMaterno: String
        -direccion: Direccion
        -fechaNacimiento: Date
        -vehiculo: Vehiculo
        +toString(): String
    }

    class Direccion {
        -calle: String
        -numero: String
        -comuna: String
        -region: String
        +toString(): String
    }

    class Vehiculo {
        <<abstract>>
        -modelo: String
        -marca: String
        -anio: int
        -permisoVigente: boolean
        -color: String
        -cantidadRuedas: int
        +imprimir(): String
        +toString(): String
    }

    class Automovil {
        -mecanico: boolean
        +imprimir(): String
    }

    class Motocicleta {
        -tipoEmbreague: String
        +imprimir(): String
    }

    class DateUtil {
        +stringToDate(dateS: String, format: String)$ Date
        +calcularEdad(fechaNacimiento: Date, fechaActual: Date)$ int
    }

    Vehiculo <|-- Automovil
    Vehiculo <|-- Motocicleta
    Persona --> Direccion : tiene
    Persona --> Vehiculo : posee
    Main ..> Menu : usa
    Menu ..> Persona : crea
    Persona ..> DateUtil : usa
```

## Estructura de Clases y Relaciones

- `Menu` contiene el submenú de vehículos y valida la entrada del usuario mediante métodos auxiliares.
- `Persona` integra `Direccion`, `fechaNacimiento` y `Vehiculo` como parte del modelo de dominio.
- `Automovil` y `Motocicleta` representan dos especializaciones concretas del concepto general `Vehiculo`.
- `DateUtil` brinda soporte para manejar fechas, validaciones y cálculos relacionados con la edad.
