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
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Motocicleta extends Vehiculo {
    
    private String tipoEmbreague;

    @Override
    public String imprimir() {
        return this.toString();
    }

    @Override
    public String toString() {
        
        return super.toString() + " - Motocicleta{" + "tipoEmbreague=" + tipoEmbreague + '}';
    }
        
}
