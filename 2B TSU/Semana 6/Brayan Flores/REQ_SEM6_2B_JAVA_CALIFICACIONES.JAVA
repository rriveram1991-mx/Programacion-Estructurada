/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package calificaciones.matriz;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SistemaCalificaciones {
    public static void main(String[] args) {
        int[][] calificaciones = {
            {8, 9, 7},
            {10, 9, 9},
            {6, 7, 8}
        };

        String[] materias = {"Matemáticas", "Historia", "Ciencias"};
        String nombreArchivo = "calificaciones.txt";

        try (FileWriter fw = new FileWriter(nombreArchivo);
             PrintWriter pw = new PrintWriter(fw)) {

            System.out.println("CALIFICACIONES: ");
            pw.println("CALIFICACIONES: ");

            for (int i = 0; i < calificaciones.length; i++) {
                double suma = 0;
                String alumnoHeader = "\nAlumno " + (i + 1) + ":";
                System.out.println(alumnoHeader);
                pw.println(alumnoHeader);

                for (int j = 0; j < calificaciones[i].length; j++) {
                    int nota = calificaciones[i][j];
                    suma += nota;

                    String detalle = " - " + materias[j] + ": " + nota;
                    System.out.println(detalle);
                    pw.println(detalle);
                }

                double promedio = suma / calificaciones[i].length;
                String resultadoPromedio = "Promedio Final: " + String.format("%.2f", promedio);
                
                if (promedio >= 9) {
                    resultadoPromedio += " (Excelente desempeño)";
                }

                System.out.println(resultadoPromedio);
                pw.println(resultadoPromedio);
            }


        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}