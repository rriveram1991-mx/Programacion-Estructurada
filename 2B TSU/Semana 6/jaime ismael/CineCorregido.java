/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication72;

import java.io.FileWriter;
import java.io.IOException;

public class CineCorregido {

    public static void main(String[] args) {

        int[][] asientos = {
            {1, 0, 0},
            {1, 1, 0},
            {0, 0, 0}
        };

        int ocupados = 0;
// Se cierra automaticamente
        try (FileWriter writer = new FileWriter("reporte_cine.txt")) {

            for (int i = 0; i < asientos.length; i++) {

                // se sale del arreglo con el igual
                for (int j = 0; j < asientos[i].length; j++) {

                    // Se pega la cadena vacía 
                    writer.write(asientos[i][j] + " ");

                    // esta asignando no comparando
                    if (asientos[i][j] == 1) {
                        ocupados++;
                    }
                }

                // falta punto y coma
                writer.write("\n"); 

            }

            writer.write("Asientos ocupados: " + ocupados + "\n");
            
            System.out.println("Reporte generado con éxito. Asientos ocupados: " + ocupados);

        } catch (IOException e) {
            System.out.println("Error al escribir el reporte: " + e.getMessage());
        }
    }
}