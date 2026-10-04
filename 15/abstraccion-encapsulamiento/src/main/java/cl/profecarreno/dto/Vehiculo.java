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
        StringBuilder sb = new StringBuilder();
        sb.append("\nVehículo")
                .append("\n\nModelo: ").append(modelo)
                .append("\nMarca: ").append(marca)
                .append("\nAño: ").append(anio)
                .append("\nPermiso Vigente: ").append(permisoVigente)
                .append("\nColor: ").append(color)
                .append("\nCantidad de Rueds: ").append(cantidadRuedas);

        return sb.toString();
    }
}
