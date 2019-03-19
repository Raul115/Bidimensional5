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
public class Empresa {

    Empleado[] empleados;
    Categoria[] categorias;
    float[] limites;
    float[][] IRPF;

    /**
     * Constructor de Empresa
     *
     * @param nEmpleados Parametro del numero de empleados de la empresa
     */
    public Empresa(int nEmpleados) {
        categorias = new Categoria[]{
            new Categoria("Administrativo", 1000f),
            new Categoria("Programador", 1200f),
            new Categoria("Analista", 1500f),
            new Categoria("Analista-Programador", 1800f),
            new Categoria("Jefe-Junior", 2100f),
            new Categoria("Jefe-Senior", 2200f)
        };
        empleados = new Empleado[nEmpleados];
        limites = new float[]{1000f, 1300f, 1600f, 2000f, Float.MAX_VALUE};
        IRPF = new float[][]{
            {0.08f, 0.10f, 0.16f, 0.21f, 0.30f},
            {0.06f, 0.08f, 0.14f, 0.19f, 0.25f},
            {0.04f, 0.05f, 0.12f, 0.17f, 0.21f},
            {0.03f, 0.04f, 0.10f, 0.15f, 0.20f}
        };
    }

    /**
     * Metodo para cargar los datos de los empleados
     */
    public void datosEmpleados() {
        String nombre;
        Date fAlta;
        int categoria;
        int nHijos;
        for (int i = 0; i < empleados.length; i++) {
            nombre = Data.askForString("Introduce el nombre del empleado: ");
            fAlta = Data.askForDate("Introduce la fecha de alta <yyyy/mm/dd>: ");
            categoria = pedirCategoria("Introduce el nombre de la categoria: ");
            nHijos = Data.askForNumberInt("Introduce el numero de hijos :", 0);
            empleados[i] = new Empleado(nombre, fAlta, categoria, nHijos);
        }
    }

    /**
     * Metodo para cargar los datos de los hijos de los empleados
     */
    public void datosHijos() {
        Date fNac;
        float ingresos;
        for (int i = 0; i < empleados.length; i++) {
            if (empleados[i].getDatosHijos() != null) {
                System.out.println("Introduce los hijos de: " + empleados[i].getNombre());
                for (int j = 0; j < empleados[i].getDatosHijos().length; j++) {
                    fNac = Data.askForDate("Introduce la fecha de nacimiento <yyyy/mm/dd>: ");
                    ingresos = Data.askForNumberFloat("Introduce los ingresos: ", 0);
                    empleados[i].getDatosHijos()[j] = new Hijo(fNac, ingresos);
                }
            }
        }
    }

    /**
     * Metodo para visualizar el informe
     */
    public void informe() {
        float sueldoBase;
        float retencion;
        float sueldoNeto;
        int hijosComputables;
        int hijos;
        System.out.println("Nombre" + "\t"
                + "Fecha de alta" + "\t"
                + "Hijos" + "\t"
                + "Computan" + "\t"
                + "Categoria" + "\t"
                + "Sueldo base" + "\t"
                + "IRPF a aplicar" + "\t"
                + "Sueldo neto"
        );
        for (int i = 0; i < empleados.length; i++) {
            sueldoBase = categorias[empleados[i].getCategoria()].getSueldoBase();
            hijos = empleados[i].getDatosHijos().length;
            hijosComputables = calcularHijosComputables(empleados[i].getDatosHijos());
            retencion = buscarIRPF(sueldoBase, hijosComputables);
            sueldoNeto = sueldoBase * (1 - retencion);
            System.out.println(empleados[i].getNombre() + "\t"
                    + empleados[i].getfAlta().completeDate() + "\t"
                    + hijos + "\t"
                    + hijosComputables + "\t\t"
                    + empleados[i].getCategoria() + "\t\t"
                    + sueldoBase + "\t\t"
                    + retencion + "\t\t"
                    + sueldoNeto
            );
        }
    }

    /**
     * Metodo para pedir la categoria del empleado
     *
     * @param mensaje Parametro para darle un mensaje
     * @return Devuelve un numero segun la categoria
     */
    private int pedirCategoria(String mensaje) {
        String categoria;
        int resultado;
        categoria = Data.askForString(mensaje);
        resultado = buscarCategoria(categoria);
        while (resultado == -1) {
            System.out.println("Campo obligatorio. Categoria no existe.");
            categoria = Data.askForString(mensaje);
            resultado = buscarCategoria(categoria);
        }
        return resultado;
    }

    /**
     * Metodo para buscar la posicion de la categoria segun el nombre de ella
     *
     * @param categoria Parametro a comprobar si existe
     * @return Devuelve la posicion de la categoria
     */
    private int buscarCategoria(String categoria) {
        int i = 0;
        boolean encontrado = false;
        while (!encontrado && i < categorias.length) {
            if (categoria.trim().equalsIgnoreCase(categorias[i].getNombre())) {
                encontrado = true;
            } else {
                i++;
            }
        }
        if (!encontrado) {
            i = -1;
        }
        return i;
    }

    /**
     * Metodo para buscar la posicion de una columna segun el sueldo base del
     * empleado
     *
     * @param sueldoBase Parametro del sueldo base del empleado
     * @return Devuelve la posicion de la columna
     */
    public int buscarColumna(float sueldoBase) {
        int columna = 0;
        int i = 0;
        boolean encontrado = false;
        while (!encontrado && i < limites.length) {
            if (sueldoBase <= limites[i]) {
                encontrado = true;
                columna = i;
            } else {
                i++;
            }
        }
        return columna;
    }

    /**
     * Metodo para calcular los hijos computables del empleado segun los
     * criterios si son menores de 25 y sus ingresos son menores de 8000
     *
     * @param datosHijos Parametro de la cantidad de hijos del empleado
     * @return Devuelve el dato de hijos computables
     */
    public int calcularHijosComputables(Hijo[] datosHijos) {
        int resultado = 0;
        int calculoEdad;
        if (datosHijos == null) {
            resultado = 0;
        } else {
            for (int i = 0; i < datosHijos.length; i++) {
                calculoEdad = calcularEdad(datosHijos[i].getfNacimiento());
                if (calculoEdad < 24 && datosHijos[i].getIngresos() < 8000) {
                    resultado++;
                }
            }
        }
        return resultado;
    }

    /**
     * Metodo para buscar el IRPF a aplicar segun el sueldoBase y el nHijos del
     * empleado. En las columnas va el sueldoBase y en las filas los
     * hijosComputables
     *
     * @param sueldoBase Parametro del sueldo base del empleado
     * @param nHijos Parametro del numero de hijos computables
     * @return Devuelve el porcentaje a aplicar de IRPF segun los parametros
     */
    public float buscarIRPF(float sueldoBase, int nHijos) {
        int fila;
        if (nHijos >= 3) {
            fila = 3;
        } else {
            fila = nHijos;
        }
        int columna = buscarColumna(sueldoBase);
        float result = IRPF[fila][columna];
        return result;
    }

    /**
     * Metodo para calcular la edad de una persona partiendo de su fecha de
     * nacimiento. Se calcula la distancia en dias entre la fecha de hoy y la de
     * nacimiento y el resultado se divide entre 365
     *
     * @param fNac Parametro que se pasa al metodo para saber la fecha de
     * nacimiento
     * @return Devuelve los años
     */
    public int calcularEdad(Date fNac) {
        int resultado;
        Date fHoy = new Date();
        resultado = fHoy.distanceInDays(fNac) / 365;
        return resultado;
    }
}
