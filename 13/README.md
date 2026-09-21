# Proyecto de Gestión de Personas y Vehículos

Este proyecto es una aplicación Java orientada a objetos que permite gestionar personas, sus direcciones y los vehículos asociados a ellas (automóviles o motocicletas).

## Diagrama de Clases UML

A continuación se presenta el diagrama de clases que describe la estructura y las relaciones del sistema:

```mermaid
classDiagram
    class DateUtil {
        -DateUtil()
        +stringToDate(dateS: String, format: String)$ Date
        +dateToString(date: Date, format: String)$ String
        +calcularEdad(fechaNacimiento: Date, fechaActual: Date)$ int
    }

    class Direccion {
        -calle: String
        -numero: String
        -comuna: String
        -region: String
        +toString() String
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
        +isMenorEdad() boolean
        +toString() String
    }

    class Vehiculo {
        <<abstract>>
        -modelo: String
        -marca: String
        -anio: int
        -permisoVigente: boolean
        -color: String
        -cantidadRuedas: int
        +imprimir()* String
        +toString() String
    }

    class Automovil {
        -mecanico: boolean
        +imprimir() String
        +toString() String
    }

    class Motocicleta {
        -tipoEmbreague: String
        +imprimir() String
        +toString() String
    }

    class Menu {
        -obtenerNumeroTeclado(message: String) int
        -obtenerTextoTeclado(message: String) String
        -obtenerTextoLineaTeclado(message: String) String
        -obtenerBooleanTeclado(message: String) boolean
        -obtenerDecimalTeclado(message: String) double
        -obtenerDateTeclado(message: String) Date
        +submenuVehiculo() Vehiculo
        +findByRun(run: int, personas: List~Persona~) Persona
        +menu() void
    }

    class Main {
        +main(args: String[])$ void
    }

    %% Relaciones de Herencia
    Vehiculo <|-- Automovil
    Vehiculo <|-- Motocicleta

    %% Relaciones de Asociación / Composición
    Persona "1" --> "1" Direccion : tiene
    Persona "1" --> "0..1" Vehiculo : posee

    %% Relaciones de Dependencia
    Main ..> Menu : usa
    Menu ..> Persona : gestiona
    Menu ..> Vehiculo : crea
    Persona ..> DateUtil : usa
```

## Estructura de Clases y Relaciones

- **Herencia**: `Automovil` y `Motocicleta` heredan de la clase abstracta `Vehiculo`.
- **Asociación**: La clase `Persona` contiene referencias a `Direccion` y a `Vehiculo`.
- **Utilidades**: `DateUtil` provee métodos estáticos para la manipulación y formateo de fechas.
- **Interacción**: La clase `Menu` gestiona el flujo de entrada de datos y las operaciones CRUD básicas sobre las personas registradas.