/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemcalifsstats;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author juanc
 */
public class Sistemcalifsstats {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner Writer = new Scanner(System.in);
        

        // Matriz de calificaciones (3 alumnos x 3 materias)
        int[][] calificaciones = {
            {8, 9, 7},
            {10, 9, 9},
            {6, 7, 8}
        };

        // Nombre de materias (una por alumno para el ejemplo pedido)
        String[] materias = {"Programacion", "Redes", "Bases de Datos"};

        try {

            // Crear el archivo donde se guardarán los resultados
            FileWriter writer = new FileWriter("calificaciones.txt");

            // Recorrer alumnos
            for (int i = 0; i < calificaciones.length; i++) {

                int suma = 0;

                System.out.println("Alumno " + (i + 1));
                writer.write("Alumno " + (i + 1) + "\n");

                System.out.print("Calificaciones: ");
                writer.write("Calificaciones: ");

                // Recorrer materias
                for (int j = 0; j < calificaciones[i].length; j++) {

                    System.out.print(calificaciones[i][j] + " ");
                    writer.write(calificaciones[i][j] + " ");

                    suma += calificaciones[i][j];
                }

                // Calcular promedio
                double promedio = (double) suma / calificaciones[i].length;

                System.out.println();
                writer.write("\n");

                System.out.println("Materia: " + materias[i]);
                writer.write("Materia: " + materias[i] + "\n");

                System.out.println("Promedio: " + promedio);
                writer.write("Promedio: " + promedio + "\n");

                // Verificar si es alumno destacado
                if (promedio >= 9) {
                    System.out.println("Alumno destacado");
                    writer.write("Alumno destacado\n");
                }

                System.out.println();
                writer.write("\n");
            }

            writer.close();

            System.out.println("Datos guardados en calificaciones.txt");

        } catch (IOException e) {
            System.out.println("Error al escribir el archivo.");
            e.printStackTrace();
        }
    }
}
    
    

