/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fuentesjava.pruebas;

import java.io.Serializable;
import java.util.Date;

public class Usuarios implements Serializable {
    
    private String nombre;
    private String apellido;
    private int edad;
    private Date fecha;

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        StringBuilder b=new StringBuilder();
        b.append("nombre=");
        b.append(nombre );
        b.append("\n");
        b.append("apellido=");
        b.append(apellido);
        b.append("\n");
        b.append("edad=");
        b.append(edad);
        b.append("\n");
        b.append("fecha=");
        b.append(fecha);
        return null;
    }
    
}
