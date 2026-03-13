/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication46;
import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author adrianvalenzuelaramirez
 */
public class JavaApplication46 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int[][] asientos = {
            {1, 0, 0},
            {1, 1, 0},
            {0, 0, 0}
        };

        int ocupados = 0;

        // se usa try-with-resources para asegurar el cierre del archivo (Mejora el Error #5)
        try (FileWriter writer = new FileWriter("reporte_cine.txt")) {

            for (int[] asiento : asientos) {
                // 1: se cambió '<=' por '<' para respetar los límites del arreglo
                for (int j = 0; j < asiento.length; j++) {
                    // 2: se concatena con String "" para que escriba el número como texto
                    writer.write(String.valueOf(asiento[j]) + " ");
                    // 3: se cambió '=' por '==' para realizar una comparación lógica
                    if (asiento[j] == 1) {
                        ocupados++;
                    }
                }
                // 4: se agregó el punto y coma (;) faltante
                writer.write("\n");
            }

            writer.write("--------------------------\n");
            writer.write("Asientos ocupados: " + ocupados + "\n");

            System.out.println("reporte de cine generado exitosamente.");
            System.out.println("total de ocupados: " + ocupados);

        } catch (IOException e) {
            System.out.println("error al crear el reporte: " + e.getMessage());
        }
    }
}