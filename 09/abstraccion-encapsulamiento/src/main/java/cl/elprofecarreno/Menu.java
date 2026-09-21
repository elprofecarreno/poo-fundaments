/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cl.elprofecarreno;

import cl.elprofecarreno.util.DateUtil;
import cl.profecarreno.dto.Automovil;
import cl.profecarreno.dto.Direccion;
import cl.profecarreno.dto.Motocicleta;
import cl.profecarreno.dto.Persona;
import cl.profecarreno.dto.Vehiculo;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author ccarreno
 */
public class Menu {

    private int obtenerNumeroTeclado(String message) {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        int value = 0;
        while (flag) {
            try {
                System.out.print(message + ": ");
                value = sc.nextInt();
                flag = false;
            } catch (Exception ex) {
                System.out.println("ERROR: el valor ingresado debe ser númerico.");
            }
        }
        return value;
    }

    private String obtenerTextoTeclado(String message) {
        Scanner sc = new Scanner(System.in);
        System.out.print(message + ": ");
        String value = sc.next();
        return value;
    }
    
    private String obtenerTextoLineaTeclado(String message) {
        Scanner sc = new Scanner(System.in);
        System.out.print(message + ": ");
        String value = sc.nextLine();
        return value;
    }
    
    private boolean obtenerBooleanTeclado(String message) {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        boolean value = false;
        while (flag) {
            try {
                System.out.print(message + ": ");
                value = sc.nextBoolean();
                flag = false;
            } catch (Exception ex) {
                System.out.println("ERROR: el valor ingresado debe ser un true o false.");
            }
        }
        return value;
    }
    
    private double obtenerDecimalTeclado(String message) {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        double value = 0;
        while (flag) {
            try {
                System.out.print(message + ": ");
                value = sc.nextDouble();
                flag = false;
            } catch (Exception ex) {
                System.out.println("ERROR: el valor ingresado debe ser un true o false.");
            }
        }
        return value;
    }
    
    private Date obtenerDateTeclado(String message) {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        Date value = null;
        while (flag) {
            try {
                System.out.print(message + ": ");
                String valueS = sc.next();
                value = DateUtil.stringToDate(valueS, "dd/MM/yyyy");
                flag = false;
            } catch (Exception ex) {
                System.out.println("ERROR: fecha inválida debe tener el formato dd/mm/yyyy");
            }
        }
        return value;
    }
    
    public Vehiculo submenuVehiculo(){
        int opcion = 0;
        boolean flag = true;

        Vehiculo v = null;

        while (flag) {
            System.out.println("\t\t\t SELECCIONAR TIPO VEHÍCULO");
            System.out.println("\n\n1- Automovil.");
            System.out.println("\n2- Motocicleta.");
            opcion = obtenerNumeroTeclado("Ingrese una opción");
            switch (opcion) {
                case 1:
                    boolean isMecanico = obtenerBooleanTeclado("Es mécanico");
                    v = new Automovil(isMecanico);
                    int anio = obtenerNumeroTeclado("Ingresar Año Fabricación");
                    v.setAnio(anio);
                    int cantidadPuertas = obtenerNumeroTeclado("Ingresar Cantidad Puertas");
                    v.setCantidadRuedas(cantidadPuertas);
                    String color = obtenerTextoTeclado("Ingresar Color");
                    v.setColor(color);
                    String marca = obtenerTextoTeclado("Ingresar Marca");
                    v.setMarca(marca);
                    String modelo = obtenerTextoTeclado("Ingresar Modelo");
                    v.setMarca(modelo);
                    flag = false;
                    break;
                case 2:
                    v = new Motocicleta();      
                    flag = false;
                    break;                

                default:
                    System.out.println("OPCIÓN INVALIDA.");
            }
        }
        
        return v;
    }

    public void menu() {

        int opcion = 0;

        Persona p = null;

        while (opcion != 3) {
            System.out.println("\t\t\t MENÚ");
            System.out.println("\n\n1- Crear Persona.");
            System.out.println("\n2- Listar Persona.");
            System.out.println("\n3- Salir.");

            opcion = obtenerNumeroTeclado("Selecciona una opción");

            switch (opcion) {
                case 1:
                    System.out.println("CREANDO PERSONA.");
                    System.out.print("Ingrese run sin dígito verificador: ");
                    int run = obtenerNumeroTeclado("Ingrese run sin dígito verificador");
                    String dv = obtenerTextoTeclado("Ingrese dígito verificador");
                    String nombres = obtenerTextoTeclado("Ingrese nombres");
                    String apellidoPaterno = obtenerTextoTeclado("Apellido paterno");
                    String apellidoMaterno = obtenerTextoTeclado("Apellido materno");
                    System.out.println("CREANDO DIRECCIÓN.");
                    String calle = obtenerTextoTeclado("calle");
                    String numero = obtenerTextoTeclado("número");
                    String comuna = obtenerTextoTeclado("comuna");
                    String region = obtenerTextoTeclado("región");
                    Date fechaNacimiento = obtenerDateTeclado("Ingrese la fecha de nacimiento (dd/mm/yyyy)");
                    Direccion d = new Direccion(calle, numero, comuna, region);              
                    Vehiculo v = submenuVehiculo();
                    
                    p = new Persona(run, dv, nombres, apellidoPaterno,
                            apellidoMaterno, d, fechaNacimiento, v);
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
