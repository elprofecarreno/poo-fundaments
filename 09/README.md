# Proyecto 09 - Vehículos y menú interactivo

Este proyecto combina la herencia de vehículos con un menú interactivo para crear personas y asociarles un vehículo.

## ¿Qué hace?

La clase `Menu` ofrece la posibilidad de seleccionar un tipo de vehículo, completar sus datos y asignarlo a una persona. El programa genera una sola persona a la vez, la guarda en memoria y la imprime en pantalla.

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

- `Menu` es el punto de entrada del sistema y gestiona la creación de `Persona` y su `Vehiculo`.
- `Vehiculo` representa la herencia del dominio y `Automovil`/`Motocicleta` agregan detalle específico.
- `Persona` mantiene una relación con `Direccion`, `DateUtil` y el vehículo asociado.
- El sistema combina herencia, composición y dependencia para modelar una persona con sus datos y transporte.
