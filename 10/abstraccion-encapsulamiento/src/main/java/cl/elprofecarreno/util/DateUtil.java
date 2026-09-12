/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cl.elprofecarreno.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

/**
 *
 * @author ccarreno
 */
public class DateUtil {

    private DateUtil() {
        throw new UnsupportedOperationException("Esta es una clase utilitaria y no puede ser instanciada.");
    }

    public static Date stringToDate(String dateS, String format) throws ParseException, IllegalArgumentException {

        SimpleDateFormat formatter = new SimpleDateFormat(format);
        return formatter.parse(dateS);
    }

    public static int calcularEdad(Date fechaNacimiento, Date fechaActual) {
        if (fechaNacimiento == null || fechaActual == null) {
            throw new IllegalArgumentException("Las fechas no pueden ser nulas");
        }

        // Convertir java.util.Date a java.time.LocalDate
        LocalDate nacimiento = fechaNacimiento.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        LocalDate referencia = fechaActual.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        // Calcular los años de diferencia
        return Period.between(nacimiento, referencia).getYears();
    }

}
