/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package cl.elprofecarreno;

/**
 *
 * @author ccarreno
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Abstracción y Encapsulamiento");
        
        Persona maria = new Persona();
        System.out.println("maria: " + maria.toString());
        maria.setRun(1);
        maria.setDv("9");
        maria.setNombres("Maria la del barrio");
        maria.setApellidoPaterno("Torrejón");
        maria.setApellidoMaterno("Torres");
        maria.setDireccion(new Direccion("Av. Libertador General Bernardo O' Higgins", "1920", "Santiago", "RM"));
        System.out.println("maria: " + maria.toString());
                
        Persona diego = new Persona(1234678, "9", "Diego", "Alcantara", "Cabrera", new Direccion("Av. Pajarito", "1810", "Maipú", "RM"));
        System.out.println("diego: " + diego);
    }
}
