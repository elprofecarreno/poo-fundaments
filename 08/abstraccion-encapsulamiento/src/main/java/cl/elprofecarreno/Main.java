/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package cl.elprofecarreno;

import cl.profecarreno.dto.Persona;
import cl.profecarreno.dto.Direccion;
import cl.elprofecarreno.util.DateUtil;
import java.text.ParseException;
import java.util.Date;

/**
 *
 * @author ccarreno
 */
public class Main {

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.menu();
        /*System.out.println("Abstracción y Encapsulamiento");
        
        Persona maria = new Persona();
        System.out.println("maria: " + maria.toString());
        maria.setRun(1);
        maria.setDv("9");
        maria.setNombres("Maria la del barrio");
        maria.setApellidoPaterno("Torrejón");
        maria.setApellidoMaterno("Torres");
        maria.setDireccion(new Direccion("Av. Libertador General Bernardo O' Higgins", "1920", "Santiago", "RM"));
        try{
            maria.setFechaNacimiento(DateUtil.stringToDate("15-06-2000", "dd-MM-yyyy"));
        }catch(ParseException | IllegalArgumentException e){
            System.out.println("Fecha de nacimiento para maria es invalida");
        }
        System.out.println("maria: " + maria.toString());
        
        Date fechaNacimientoDiego = null;
        try{
             fechaNacimientoDiego = DateUtil.stringToDate("01-01-2021", "dd-MM-yyyy");
        }catch(ParseException | IllegalArgumentException e){
            System.out.println("Fecha de nacimiento para diego es invalida");
        }        
        
        Persona diego = new Persona(1234678, "9", "Diego", "Alcantara", "Cabrera", new Direccion("Av. Pajarito", "1810", "Maipú", "RM"), fechaNacimientoDiego);
        System.out.println("diego: " + diego);
        
        System.out.println("maria es menor de edad: " + maria.isMenorEdad());
        System.out.println("diego es menor de edad: " + diego.isMenorEdad());*/
        
    }
}
