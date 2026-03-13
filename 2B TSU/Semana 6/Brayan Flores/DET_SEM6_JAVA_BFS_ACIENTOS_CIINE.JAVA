/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package asientoscine;

import java.io.FileWriter;
import java.io.IOException;

public class CineErrores {

    public static void main(String[] args) {

        int[][] asientos = {
            {1, 0, 0},
            {1, 1, 0},
            {0, 0, 0}
        };

        int ocupados = 0;

        // Implementación de try-with-resources para mayor seguridad
        try (FileWriter writer = new FileWriter("reporte_cine.txt")) {

            for (int i = 0; i < asientos.length; i++) {
                for (int j = 0; j < asientos[i].length; j++) { // Corregido: <

                    // Escribimos el valor como String seguido de un espacio
                    writer.write(asientos[i][j] + " ");

                    if (asientos[i][j] == 1) { // Corregido: == para comparar
                        ocupados++;
                    }
                }
                writer.write("\n"); // Corregido: se agregó ;
            }

            writer.write("\nAsientos ocupados: " + ocupados + "\n");
            System.out.println("Reporte generado con éxito.");

        } catch (IOException e) {
            System.out.println("Error al escribir el reporte: " + e.getMessage());
        }
    }
}