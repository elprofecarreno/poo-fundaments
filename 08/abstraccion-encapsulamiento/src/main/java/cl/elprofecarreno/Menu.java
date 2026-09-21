/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cl.elprofecarreno;

import cl.profecarreno.dto.Direccion;
import cl.profecarreno.dto.Persona;
import java.util.Scanner;

/**
 *
 * @author ccarreno
 */
public class Menu {

    private int obtenerNumeroTeclado(String message, Scanner sc) {
        boolean flag = true;
        int value = 0;
        while (flag) {
            try {
                System.out.print(message + ": ");
                value = sc.nextInt();
                flag = false;
            } catch (Exception ex) {
                System.out.println("ERROR: el valor ingresado debe ser númerico.");
                sc.next();
            }
        }
        return value;
    }

    private String obtenerTextoTeclado(String message, Scanner sc) {
        System.out.print(message + ": ");
        String value = sc.next();
        return value;
    }

    public void menu() {

        int opcion = 0;

        Persona p = null;

        while (opcion != 3) {
            System.out.println("\t\t\t MENÚ");
            System.out.println("\n\n1- Crear Persona.");
            System.out.println("\n2- Listar Persona.");
            System.out.println("\n3- Salir.");
            Scanner sc = new Scanner(System.in);

            opcion = obtenerNumeroTeclado("Selecciona una opción", sc);

            switch (opcion) {
                case 1:
                    System.out.println("CREANDO PERSONA.");
                    System.out.print("Ingrese run sin dígito verificador: ");
                    int run = obtenerNumeroTeclado("Ingrese run sin dígito verificador", sc);
                    String dv = obtenerTextoTeclado("Ingrese dígito verificador", sc);
                    String nombres = obtenerTextoTeclado("Ingrese nombres", sc);
                    String apellidoPaterno = obtenerTextoTeclado("Apellido paterno", sc);
                    String apellidoMaterno = obtenerTextoTeclado("Apellido materno", sc);
                    System.out.println("CREANDO DIRECCIÓN.");
                    String calle = obtenerTextoTeclado("calle", sc);
                    String numero = obtenerTextoTeclado("número", sc);
                    String comuna = obtenerTextoTeclado("comuna", sc);
                    String region = obtenerTextoTeclado("región", sc);
                    
                    Direccion d = new Direccion(calle, numero, comuna, region);                    
                    p = new Persona(run, dv, nombres, apellidoPaterno,
                            apellidoMaterno, d, null);
                    break;
                case 2:
                    System.out.println("Mostrando Datos de la Persona.");
                    if (p == null) {
                        System.out.println("ERROR: Persona debe ser creada previamente.");
                    } else {
                        System.out.println(p.toString());
                    }
                    break;
                case 3:
                    System.out.println("Bye...");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }
}
