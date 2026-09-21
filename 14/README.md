# Proyecto 14 - Búsqueda y eliminación por RUN

Este proyecto continúa la evolución del sistema con una lógica de menú más completa. La clave del ejercicio es buscar personas por RUN y permitir eliminarlas del listado activo.

## ¿Qué hace?

La aplicación gestiona una lista de personas con dirección, fecha, vehículo y búsqueda. El usuario puede crear registros, listarlos, buscar por posición, buscar por RUN, eliminar por RUN y salir del programa.

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

- `Menu` coordina el flujo completo del sistema y encapsula la lógica de búsqueda y eliminación.
- `findByRun` permite localizar una persona dentro de la lista sin depender de la posición del elemento.
- `Persona` modela el estado completo del dominio, incluyendo atributos de ubicación, vehículo y fecha de nacimiento.
- `DateUtil` se usa para transformar strings en `Date` y calcular la edad cuando se requiere.
