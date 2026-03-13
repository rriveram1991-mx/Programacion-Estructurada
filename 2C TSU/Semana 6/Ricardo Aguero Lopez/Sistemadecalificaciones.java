/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemadecalificaciones;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author aguer
 */
public class Sistemadecalificaciones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Scanner leer = new Scanner(System.in);

        int[][] calificaciones = new int[3][3];
        String[] materias = {"Programacion", "Redes", "Bases de Datos"};

        // Pedir calificaciones
        for (int i = 0; i < 3; i++) {

            System.out.println("Alumno " + (i + 1));

            for (int j = 0; j < 3; j++) {

                System.out.print("Ingrese calificacion de " + materias[j] + ": ");
                calificaciones[i][j] = leer.nextInt();

            }
        }

        try {

            FileWriter archivo = new FileWriter("calificaciones.txt");

            for (int i = 0; i < 3; i++) {

                int suma = 0;
                int mayor = calificaciones[i][0];
                int posicion = 0;

                System.out.println("\nAlumno " + (i + 1));
                archivo.write("Alumno " + (i + 1) + "\n");

                System.out.print("Calificaciones: ");
                archivo.write("Calificaciones: ");

                for (int j = 0; j < 3; j++) {

                    System.out.print(calificaciones[i][j] + " ");
                    archivo.write(calificaciones[i][j] + " ");

                    suma += calificaciones[i][j];

                    if (calificaciones[i][j] > mayor) {
                        mayor = calificaciones[i][j];
                        posicion = j;
                    }
                }

                double promedio = suma / 3.0;

                System.out.println("\nMateria: " + materias[posicion]);
                System.out.println("Promedio: " + promedio);

                archivo.write("\nMateria: " + materias[posicion]);
                archivo.write("\nPromedio: " + promedio);

                // Regla adicional
                if (promedio >= 9) {
                    System.out.println("Alumno destacado");
                    archivo.write("\nAlumno destacado");
                }

                System.out.println();
                archivo.write("\n\n");
            }

            archivo.close();
            System.out.println("Archivo guardado correctamente.");

        } catch (IOException e) {
            System.out.println("Error al guardar el archivo");
        }
    }
    
}

