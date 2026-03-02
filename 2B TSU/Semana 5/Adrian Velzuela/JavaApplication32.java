/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication32;

/**
 *
 * @author adrianvalenzuelaramirez
 */
public class JavaApplication32 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // base de datos de ids permitidos
        int[] idsAutorizados = {101, 105, 202, 305, 400, 550};
        
        // ids que intentan ingresar en este momento 
        int[] intentosIngreso = {101, 999, 305, 777, 550, 100};

        System.out.println("escaneo de credenciales");

        // recorremos cada intento de ingreso
        for (int idIntento : intentosIngreso) {
            boolean accesoValido = false;

            // comparamos el intento contra toda la base de datos autorizada
            for (int idReal : idsAutorizados) {
                if (idIntento == idReal) {
                    accesoValido = true;
                    break; // si lo encontramos, dejamos de buscar en la lista autorizada
                }
            }

            // resultado del escaneo para cada persona
            if (accesoValido) {
                System.out.println("id " + idIntento + ": acceso concedido, bienvenido.");
            } else {
                System.err.println("id " + idIntento + ": acceso denegado, intruso detectado.");
            }
        }
        
        System.out.println("\nescaneo finalizado. Registro guardado en el servidor.");
    }
}