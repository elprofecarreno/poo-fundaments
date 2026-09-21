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

    public void menu() {

        int opcion = 0;

        Persona p = null;

        while (opcion != 3) {
            
        System.out.println("\t\t\t MENÚ");
        System.out.println("\n\n1- Crear Persona.");
        System.out.println("\n2- Listar Persona.");
        System.out.println("\n3- Salir.");
        Scanner sc = new Scanner(System.in);
        opcion = sc.nextInt();
        
            switch (opcion) {
                case 1:
                    System.out.println("CREANDO PERSONA.");
                    System.out.print("Ingrese run sin dígito verificador: ");
                    int run = sc.nextInt();
                    System.out.println("Ingrese dígito verificador");
                    String dv = sc.next();
                    System.out.println("Ingrese nombres");
                    String nombres = sc.next();
                    System.out.println("Apellido paterno");
                    String apellidoPaterno = sc.next();
                    System.out.println("Apellido materno");
                    String apellidoMaterno = sc.next();

                    p = new Persona(run, dv, nombres, apellidoPaterno,
                            apellidoMaterno, null, null);
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
