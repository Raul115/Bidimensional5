/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biejercicio5;

import data.*;

/**
 *
 * @author Raúl Miguélez Domínguez
 */
public class Empleado {

    /**
     * Propiedades privadas de la clase empleado
     */
    private final String nombre;
    private final Date fAlta;
    private final int categoria;
    private Hijo[] datosHijos;

    /**
     * Constructor de Empleado
     *
     * @param nombre Parametro para asignar un nombre al empleado
     * @param fAlta Parametro para asignar una fecha de alta al empleado
     * @param categoria Parametro para asignar una categoria al empleado
     * @param hijos Parametro para asignar los hijos al empleado
     */
    public Empleado(String nombre, Date fAlta, int categoria, int hijos) {
        this.nombre = nombre;
        this.fAlta = fAlta;
        this.categoria = categoria;
        if (hijos != 0) {
            datosHijos = new Hijo[hijos];
        }
    }

    /**
     * Getter de la propiedad privada de nombre
     *
     * @return Devuelve el nombre del empleado
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Getter de la propiedad privada de fAlta
     *
     * @return Devuelve la fecha de alta del empleado
     */
    public Date getfAlta() {
        return fAlta;
    }

    /**
     * Getter de la propiedad privada de categoria
     *
     * @return Devuelve la categoria del empleado
     */
    public int getCategoria() {
        return categoria;
    }

    /**
     * Getter de la propiedad de datosHijos
     *
     * @return Devuelve el array de datosHijos
     */
    public Hijo[] getDatosHijos() {
        return datosHijos;
    }
}
