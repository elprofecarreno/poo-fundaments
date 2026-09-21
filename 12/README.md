# Proyecto 12 - Listado y búsqueda de personas

Este proyecto refuerza la gestión de varias personas con un menú que permite crearlas, listarlas y buscarlas por posición o RUN.

## ¿Qué hace?

El programa usa una lista de personas para almacenar múltiples registros. El usuario puede ingresar datos de una persona, asociarle una dirección y un vehículo, consultar todos los registros o buscar un elemento específico según su ubicación o run.

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
        +isMenorEdad(): boolean
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
        +dateToString(date: Date, format: String)$ String
        +calcularEdad(fechaNacimiento: Date, fechaActual: Date)$ int
    }

    Vehiculo <|-- Automovil
    Vehiculo <|-- Motocicleta
    Persona --> Direccion : tiene
    Persona --> Vehiculo : posee
    Main ..> Menu : usa
    Menu ..> Persona : gestiona
    Persona ..> DateUtil : usa
```

## Estructura de Clases y Relaciones

- `Menu` gestiona una colección de `Persona` y permite navegar por los registros de forma interactiva.
- `Persona` contiene `Direccion`, `fechaNacimiento` y `Vehiculo`, consolidando los conceptos de composición y asociación.
- `Vehiculo` define la jerarquía general, mientras `Automovil` y `Motocicleta` representan especializaciones del dominio.
- `DateUtil` actúa como apoyo para fechas y cálculos asociados a la edad de la persona.
