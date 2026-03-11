/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication43;
import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author adrianvalenzuelaramirez
 */
public class JavaApplication43 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
         // matriz de calificaciones
        int[][] calificaciones = {
            {8, 9, 7},
            {10, 9, 9},
            {6, 7, 8}
        };

        // arreglo auxiliar para los nombres de las materias según el ejemplo
        String[] materias = {"programacion", "redes", "bases de Datos"};
        String nombreArchivo = "calificaciones.txt";

        // bloque try-catch para el manejo de archivos
        try (FileWriter escritor = new FileWriter(nombreArchivo)) {
            
            System.out.println("=== procesando calificaciones ===");

            // uso de ciclo for para recorrer los alumnos (filas)
            for (int i = 0; i < calificaciones.length; i++) {
                double suma = 0;
                String lineaCalificaciones = "";

                // escribir y mostrar encabezado del alumno
                String encabezado = "alumno " + (i + 1);
                escritor.write(encabezado + "\n");
                System.out.println(encabezado);

                // ciclo for anidado para obtener calificaciones y calcular promedio
                for (int j = 0; j < calificaciones[i].length; j++) {
                    int nota = calificaciones[i][j];
                    suma += nota;
                    lineaCalificaciones += nota + " ";
                }

                double promedio = suma / calificaciones[i].length;

                // escritura de datos según el formato solicitado
                escritor.write("calificaciones: " + lineaCalificaciones.trim() + "\n");
                escritor.write("materia: " + materias[i] + "\n");
                // usamos String.format para mostrar un decimal como en el ejemplo (9.3)
                escritor.write("promedio: " + String.format("%.1f", promedio) + "\n");

                // 6. Regla adicional: Alumno destacado (if)
                if (promedio >= 9) {
                    escritor.write("alumno destacado\n");
                    System.out.println("alumno destacado detectado.");
                }

                escritor.write("\n"); // espacio entre alumnos
                
                // Mostrar en consola para verificar
                System.out.println("materia: " + materias[i] + " | promedio: " + String.format("%.1f", promedio));
                System.out.println("---------------------------------");
            }

            System.out.println("proceso terminadoatos, datos guardados en: " + nombreArchivo);

        } catch (IOException e) {
            // manejo de errores técnicos
            System.err.println("error al escribir en el archivo: " + e.getMessage());
        }
    }
}