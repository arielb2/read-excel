/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fuentesjava.pruebas;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String arg[]) {
        try {
            ProcesarDatosHoja hoja = new ProcesarDatosHoja();

            List datos = hoja.cargarDatos("/home/ariel/blog/fuentesjava/excel-POI/Libro1.xls", 0);
            for (int f = 0; f < datos.size(); f++) {
                Usuarios u = (Usuarios) datos.get(f);
                System.out.println(f + 1);
                System.out.println("    Nombre==>       " + u.getNombre());
                System.out.println("    Apellido==>     " + u.getApellido());
                System.out.println("    Edad==>         " + u.getEdad());
                if (u.getFecha() != null) {
                    SimpleDateFormat sdf;
                    sdf = new SimpleDateFormat("dd/MM/yyyy");
                    System.out.println("    Fecha==>        " + sdf.format(u.getFecha()));
                }
                System.out.println();
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FormatoUsuariosException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ProcesarDatosHoja.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
