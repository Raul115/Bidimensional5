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
public class Hijo {

    /**
     * Propiedades privadas de la clase hijio
     */
    private final Date fNacimiento;
    private final float ingresos;

    /**
     * Constructor de Hijo
     *
     * @param fNacimiento Parametro para asignar fNacimiento a Hijo
     * @param ingresos Parametro para asignar ingresos a Hijo
     */
    public Hijo(Date fNacimiento, float ingresos) {
        this.fNacimiento = fNacimiento;
        this.ingresos = ingresos;
    }

    /**
     * Getter de propiedad privada que devuelve fNacimiento
     *
     * @return Devuelve la propiedad privada fNacimiento
     */
    public Date getfNacimiento() {
        return fNacimiento;
    }

    /**
     * Getter de propiedad privada que devuelve ingresos
     *
     * @return Devuelve la propiedad privada ingresos
     */
    public float getIngresos() {
        return ingresos;
    }
}
