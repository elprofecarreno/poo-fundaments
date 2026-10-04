/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cl.profecarreno.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author ccarreno
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Direccion {

    private String calle;
    private String numero;
    private String comuna;
    private String region;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nCalle: ").append(calle)
                .append("\nNúmero: ").append(numero)
                .append("\nComuna: ").append(comuna)
                .append("\nRegión: ").append(region);
        return sb.toString();
    }

}
