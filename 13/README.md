# Proyecto 12 - Sistema Completo de Personas, Dirección, Fecha y Vehículos

Este proyecto representa la versión más completa del curso: el sistema gestiona personas con su dirección, fecha de nacimiento, vehículo asociado y operaciones de búsqueda e impresión.

## ¿Qué hace?

La aplicación permite ingresar múltiples personas desde un menú en consola, crear vehículos de tipo automóvil o motocicleta, asociarlos a la persona y realizar búsquedas por posición y por RUN. También se integra la lógica para determinar si una persona es menor de edad, usando utilidades de fecha.

## Diagrama de clases

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

    class Menu {
        +submenuVehiculo(): Vehiculo
        +menu(): void
    }

    class Main {
        +main(args: String[])$ void
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

- Este es el proyecto más completo del conjunto: incorpora herencia, asociación, dependencia y gestión de listas.
- `Vehiculo` define el comportamiento general y se especializa en `Automovil` y `Motocicleta`.
- `Persona` guarda `Direccion`, `fechaNacimiento` y `Vehiculo`, y depende de `DateUtil` para validar la edad.
- `Menu` orquesta la creación, búsqueda y listado de personas, mientras `Main` inicia la ejecución del sistema.
