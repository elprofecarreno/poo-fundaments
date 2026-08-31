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
        System.out.println("maria: " + maria.toString());
        
        Persona diego = new Persona(1234678, "9", "Diego", "Alcantara", "Cabrera");
        System.out.println("diego: " + diego);
    }
}
