/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quickorder2.Registro.Herramientas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

/**
 *
 * @author Mauro
 */
public class Validaciones {

    public static boolean validarEmail(String email) {
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        return pattern.matcher(email).matches();
    }
    
    public static boolean validarFecha(String fecha, String formato) {
        if (fecha == null) {
            return false;
        }

        SimpleDateFormat sdf = new SimpleDateFormat(formato);
        sdf.setLenient(false);

        try {

            //if not valid, it will throw ParseException
            Date date = sdf.parse(fecha);
            System.out.println(date);

        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
