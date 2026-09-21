# Proyecto 02 - Abstracción y Encapsulamiento Básico

Este ejercicio introduce los conceptos de encapsulamiento en Java y la definición de una clase de dominio simple.

## ¿Qué hace?

Se crea una clase `Persona` con atributos privados, getters y setters, un constructor vacío, un constructor con parámetros y un método `toString()`. El programa principal instancia personas, les asigna valores y los imprime.

## Diagrama de clases

```mermaid
classDiagram
    class Persona {
        -run: int
        -dv: String
        -nombres: String
        -apellidoPaterno: String
        -apellidoMaterno: String
        +Persona()
        +Persona(run: int, dv: String, nombres: String, apellidoPaterno: String, apellidoMaterno: String)
        +getRun(): int
        +setRun(run: int): void
        +getDv(): String
        +setDv(dv: String): void
        +getNombres(): String
        +setNombres(nombres: String): void
        +getApellidoPaterno(): String
        +setApellidoPaterno(apellidoPaterno: String): void
        +getApellidoMaterno(): String
        +setApellidoMaterno(apellidoMaterno: String): void
        +toString(): String
    }

    class Main {
        +main(args: String[])$ void
    }

    Main ..> Persona : crea e imprime
```
