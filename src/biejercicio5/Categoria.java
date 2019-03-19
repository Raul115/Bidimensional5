/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biejercicio5;

/**
 *
 * @author Raúl Miguélez Domínguez
 */
public class Categoria {

    /**
     * Propiedades privadas de la clase Categoria
     */
    private final String nombre;
    private final float sueldoBase;

    /**
     * Constructor de Categoria
     *
     * @param nombre Parametro para asignar el nombre a la categoria
     * @param sueldoBase Parametro para asignar el sueldo base a la categoria
     */
    public Categoria(String nombre, float sueldoBase) {
        this.nombre = nombre;
        this.sueldoBase = sueldoBase;
    }

    /**
     * Getter de la propiedad privada nombre
     *
     * @return Devuelve el nombre de la categoria
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Getter de la propieda privada sueldo base
     *
     * @return Devuelve el sueldo base de la categoria
     */
    public float getSueldoBase() {
        return sueldoBase;
    }
}
