# Proyecto 10 - Creación de persona con Lombok Builder

Este proyecto corrige y refuerza el flujo de creación de una persona usando lombok para construir los objetos y asociarles un vehículo.

## ¿Qué hace?

La aplicación crea una persona con dirección, fecha de nacimiento y vehículo, usando `@Builder` en las clases de dominio para simplificar la construcción de los objetos del sistema.

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

- `Menu` trabaja con una `List<Persona>` para registrar varias personas en memoria.
- `Persona` incorpora `fechaNacimiento` y `vehiculo`, además de una asociación hacia `Direccion`.
- `Vehiculo` es abstracta y se especializa en `Automovil` y `Motocicleta` según la clasificación del dominio.
- `DateUtil` sirve como dependencia auxiliar para convertir fechas y calcular la edad de la persona.
