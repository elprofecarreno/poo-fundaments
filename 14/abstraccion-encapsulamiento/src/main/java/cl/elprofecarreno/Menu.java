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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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

    public Vehiculo submenuVehiculo() {
        int opcion = 0;
        boolean flag = true;

        Vehiculo v = null;
        String modelo = "";
        String marca = "";
        int anio = 0;
        boolean permisoVigente = false;
        String color = "";
        int cantidadRuedas = 0;

        while (flag) {
            System.out.println("\t\t\t SELECCIONAR TIPO VEHÍCULO");
            System.out.println("\n\n1- Automovil.");
            System.out.println("\n2- Motocicleta.");
            opcion = obtenerNumeroTeclado("Ingrese una opción");
            switch (opcion) {
                case 1:
                    modelo = obtenerTextoTeclado("Ingresar Modelo");
                    marca = obtenerTextoTeclado("Ingresar Marca");
                    anio = obtenerNumeroTeclado("Ingresar Año Fabricación");
                    permisoVigente = obtenerBooleanTeclado("¿Está vigente el permiso?");
                    color = obtenerTextoTeclado("Ingresar Color");
                    cantidadRuedas = obtenerNumeroTeclado("Ingresar Cantidad Ruedas");
                    boolean mecanico = obtenerBooleanTeclado("Es mécanico");

                    v = Automovil.builder().modelo(modelo).marca(marca)
                            .anio(anio).permisoVigente(permisoVigente).color(color)
                            .cantidadRuedas(cantidadRuedas).mecanico(mecanico).build();

                    flag = false;
                    break;
                case 2:

                    modelo = obtenerTextoTeclado("Ingresar Modelo");
                    marca = obtenerTextoTeclado("Ingresar Marca");
                    anio = obtenerNumeroTeclado("Ingresar Año Fabricación");
                    permisoVigente = obtenerBooleanTeclado("¿Está vigente el permiso?");
                    color = obtenerTextoTeclado("Ingresar Color");
                    cantidadRuedas = obtenerNumeroTeclado("Ingresar Cantidad Ruedas");
                    String tipoEmbreague = obtenerTextoLineaTeclado("Ingrese tipo embreague");

                    v = (Vehiculo) Motocicleta.builder().modelo(modelo).marca(marca)
                            .anio(anio).permisoVigente(permisoVigente).color(color)
                            .cantidadRuedas(cantidadRuedas).tipoEmbreague(tipoEmbreague).build();

                    flag = false;
                    break;

                default:
                    System.out.println("OPCIÓN INVALIDA.");
            }
        }

        return v;
    }

    public Persona findByRun(int run, List<Persona> personas) {
        Persona aux = null;
        boolean flag = true;
        int i = 0;
        while(flag && i < personas.size()){
             if (personas.get(i).getRun() == run) {
                aux = personas.get(i);
                flag = false;
            }
             i++;
        }
        return aux;
    }

    public void menu() {

        int opcion = 0;
        List<Persona> personas = new ArrayList<>();
        Persona p = null;

        while (opcion != 6) {
            System.out.println("\t\t\t MENÚ");
            System.out.println("\n\n1- Crear Persona.");
            System.out.println("\n2- Imprimir Datos Persona.");
            System.out.println("\n3- Buscar Datos Persona por posición.");
            System.out.println("\n4- Buscar Datos Persona por run.");
            System.out.println("\n5- Buscar Persona por run y Borrar.");
            System.out.println("\n6- Salir.");

            opcion = obtenerNumeroTeclado("Selecciona una opción");

            switch (opcion) {
                case 1:
                    System.out.println("CREANDO PERSONA.");
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
                    personas.add(p);
                    break;
                case 2:
                    System.out.println("LISTADO DE PERSONAS");
                    System.out.println("CANTIDAD: " + personas.size());

                    for (int i = 0; i < personas.size(); i++) {
                        System.out.println("Posición: " + i);
                        System.out.println(personas.get(i));
                    }
                    break;

                case 3:
                    int posicion = obtenerNumeroTeclado("Ingresar posición para buscar persona");

                    if (posicion < 0) {
                        System.out.println("ERROR: la posición debe ser positiva");
                    } else if (posicion >= personas.size()) {
                        System.out.println("ERROR: no existen elementos en esa posición, posición va entre 0 y " + (personas.size() - 1));
                    } else {
                        System.out.println(personas.get(posicion).toString());
                    }

                    break;
                case 4:
                    int runFind = obtenerNumeroTeclado("Ingrese run para buscar");
                    Persona aux = findByRun(runFind, personas);

                    if (aux == null) {
                        System.out.println("ERROR: Persona no existe en la lista.");
                    } else {
                        System.out.println("Los datos de la persona con run " + runFind + " son: ");
                        System.out.println(aux);
                    }

                    break;
                case 5:
                    int runRemove = obtenerNumeroTeclado("Ingrese run para buscar");
                    Persona auxRemove = findByRun(runRemove, personas);
                    
                    if (auxRemove == null) {
                        System.out.println("ERROR: Persona no existe en la lista.");
                    } else {
                        personas.remove(auxRemove);
                        System.out.println("Persona run: " + runRemove + " eliminada del sistema.");
                    }                    
                    
                    break;                    
                case 6:
                    System.out.println("Bye...");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }
}
