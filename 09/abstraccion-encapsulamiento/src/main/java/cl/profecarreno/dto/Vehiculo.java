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
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public abstract class Vehiculo {
    
  private String modelo;
  private String marca;
  private int anio;
  private boolean permisoVigente;
  private String color;
  private int cantidadRuedas;
  
  public abstract String imprimir();

    @Override
    public String toString() {
        return "Vehiculo{" + "modelo=" + modelo + ", marca=" + marca + ", anio=" + anio + ", permisoVigente=" + permisoVigente + ", color=" + color + ", cantidadRuedas=" + cantidadRuedas + '}';
    }
}
