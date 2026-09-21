/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cl.profecarreno.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 *
 * @author ccarreno
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class Automovil extends Vehiculo {
    
    private boolean mecanico;
    
    @Override
    public String imprimir() {
        return this.toString();
    }

    @Override
    public String toString() {
        return super.toString() + " - Automovil{" + "isMecanico=" + mecanico + '}';
    }
    
    
}
