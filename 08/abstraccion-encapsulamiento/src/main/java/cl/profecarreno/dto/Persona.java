/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cl.profecarreno.dto;

import cl.profecarreno.dto.Direccion;
import cl.elprofecarreno.util.DateUtil;
import java.util.Date;
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
public class Persona {
    
    private int run;
    private String dv;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Direccion direccion;
    private Date fechaNacimiento;
    
    public boolean isMenorEdad(){
    
        int edad = DateUtil.calcularEdad(this.fechaNacimiento, new Date());
        
        if(edad < 18){
            return true;
        } else{
            return false;
        }
    }

    @Override
    public String toString() {
        return "Persona{" + "run=" + run + ", dv=" + dv + ", nombres=" + nombres + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", direccion=" + direccion + ", fechaNacimiento=" + fechaNacimiento + '}';
    }

            
}
