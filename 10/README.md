# Proyecto 10 - CRUD Básico de Personas con Vehículos

Este proyecto amplía la lógica de menú para gestionar varios registros de personas y permitir buscar por posición o por RUN.

## ¿Qué hace?

La aplicación crea personas, agrega una dirección y un vehículo, y las almacena en una lista. Desde el menú se pueden listar todas las personas, buscar por índice o por RUN, y continuar interactuando con el sistema.

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

- `Menu` usa listas de `Persona` para registrar y consultar personas por posición o RUN.
- `Persona` agrega el atributo `vehiculo` y `fechaNacimiento`, y mantiene una relación con `Direccion`.
- `Vehiculo` es abstracta y sus clases hijas especializan el comportamiento por tipo de vehículo.
- `DateUtil` centraliza la lógica de fecha y edad, siendo una dependencia del modelo de persona.
