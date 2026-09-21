# Proyecto 13 - Búsqueda y eliminación de personas

Este proyecto representa la versión más avanzada del manejo de personas con datos completos, búsqueda por parámetros y eliminación por RUN.

## ¿Qué hace?

El sistema permite registrar varias personas, listarlas, buscar una por posición, buscarla por RUN y eliminarla si corresponde. La estructura combina herencia para vehículos, composición para dirección y utilidades para fechas.

## Diagrama de clases

```mermaid
classDiagram
    class Main {
        +main(args: String[])$ void
    }

    class Menu {
        +menu(): void
        +submenuVehiculo(): Vehiculo
        +findByRun(run: int, personas: List~Persona~): Persona
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

- `Menu` incorpora la lógica de interacción con la lista de personas y resuelve búsquedas por `RUN` mediante un método auxiliar.
- `Persona` agrupa `Direccion`, `fechaNacimiento` y `Vehiculo` en una sola entidad del dominio.
- `Vehiculo` ofrece la base abstracta y sus derivaciones concretas representan el tipo de transporte.
- `DateUtil` facilita la manipulación de fechas y el cálculo de edad, siendo una dependencia del modelo de personas.
