# Proyecto 05 - Persona con Dirección

Este ejercicio refuerza la relación entre entidades del dominio: una `Persona` ahora incluye la clase `Direccion` como atributo.

## ¿Qué hace?

El programa crea personas con datos básicos y asocia a cada una una dirección. Se observa la composición de objetos: una persona tiene una dirección, y la representación en consola muestra la información completa.

## Diagrama de clases

```mermaid
classDiagram
    class Direccion {
        -calle: String
        -numero: String
        -comuna: String
        -region: String
        +Direccion()
        +Direccion(calle: String, numero: String, comuna: String, region: String)
        +toString(): String
    }

    class Persona {
        -run: int
        -dv: String
        -nombres: String
        -apellidoPaterno: String
        -apellidoMaterno: String
        -direccion: Direccion
        +Persona()
        +Persona(run: int, dv: String, nombres: String, apellidoPaterno: String, apellidoMaterno: String, direccion: Direccion)
        +toString(): String
    }

    class Main {
        +main(args: String[])$ void
    }

    Persona --> Direccion : tiene
    Main ..> Persona : crea e imprime
```
