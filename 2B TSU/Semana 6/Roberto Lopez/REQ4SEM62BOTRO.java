/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package req4sem62botro;

import java.io.IOException;

import java.io.PrintWriter;

/**
 *
 * @author lopez
 */
public class REQ4SEM62BOTRO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                try {
            PrintWriter salida = new PrintWriter("mis_gustos.txt");

            salida.println("=== TEST DE PREFERENCIAS: ROBERTO ===");
            salida.println("");
            salida.println("1. ¿Dibujar o Ver Pelis? -> Dibujar");
            salida.println("2. ¿Marvel o DC? -> Marvel");
            salida.println("3. ¿Kenia OS o Kimberly l? -> Kenia OS");
            salida.println("4. ¿Perros o Gatos? -> Perros");
            salida.println("");
            salida.println("Archivo creado.");

            salida.close(); 
            System.out.println("Se guardaron tus gustos en mis_gustos.txt");

        } catch (IOException e) {
            System.out.println("Error al crear el archivo.");
        }

    }
    
}
