/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biejercicio5;

import java.io.IOException;
import numeros.Numero;

/**
 *
 * @author Raúl Miguélez Domínguez
 */
public class Principal {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        int nEmpleados = Numero.pedirNumero("Introduce el numero de empleados: ", 0);
        Empresa empresa = new Empresa(nEmpleados);
        empresa.datosEmpleados();
        empresa.datosHijos();
        empresa.informe();
    }
}
