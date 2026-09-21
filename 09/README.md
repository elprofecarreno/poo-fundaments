# Proyecto 09 - Vehículos y Menú de Gestión

Este ejercicio combina la herencia de vehículos con un menú interactivo para crear personas y asociarles un vehículo.

## ¿Qué hace?

La clase `Menu` ofrece la posibilidad de seleccionar un tipo de vehículo, completar sus datos y asignarlo a una persona. La aplicación permite gestionar personas que tienen dirección y vehículo, mostrando todo en consola.

## Diagrama de clases

```mermaid
classDiagram
    class Menu {
        -obtenerNumeroTeclado(message: String): int
        -obtenerTextoTeclado(message: String): String
        -obtenerBooleanTeclado(message: String): boolean
        +submenuVehiculo(): Vehiculo
        +menu(): void
    }

    class Vehiculo {
        <<abstract>>
        -modelo: String
        -marca: String
        -anio: int
        -permisoVigente: boolean
        -color: String
        -cantidadRuedas: int
        +imprimir() * String
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

    class Main {
        +main(args: String[])$ void
    }

    Vehiculo <|-- Automovil
    Vehiculo <|-- Motocicleta
    Persona --> Direccion : tiene
    Persona --> Vehiculo : posee
    Main ..> Menu : usa
    Menu ..> Persona : crea y lista
    Menu ..> Vehiculo : crea
```
