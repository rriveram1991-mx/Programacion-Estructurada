/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rc;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author juang
 */
public class Rc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
         Scanner sc = new Scanner(System.in);

        int[][] calificaciones = new int[3][3];

        String[] materias = {"Programacion", "Redes", "Bases de Datos"};

        try {

            FileWriter archivo = new FileWriter("calificaciones.txt");

            // Ingresar calificaciones
            for (int i = 0; i < 3; i++) {

                System.out.println("Alumno " + (i + 1));
                archivo.write("Alumno " + (i + 1) + "\n");

                int suma = 0;

                System.out.print("Calificaciones: ");
                archivo.write("Calificaciones: ");

                for (int j = 0; j < 3; j++) {

                    System.out.print("Ingrese calificacion materia " + (j + 1) + ": ");
                    calificaciones[i][j] = sc.nextInt();

                    archivo.write(calificaciones[i][j] + " ");
                    suma += calificaciones[i][j];
                }

                double promedio = (double) suma / 3;

                System.out.println("Materia: " + materias[i]);
                archivo.write("\nMateria: " + materias[i] + "\n");

                System.out.println("Promedio: " + promedio);
                archivo.write("Promedio: " + promedio + "\n");

                if (promedio >= 9) {
                    System.out.println("Alumno destacado");
                    archivo.write("Alumno destacado\n");
                }

                System.out.println();
                archivo.write("\n");
            }

            archivo.close();
            System.out.println("Archivo guardado correctamente");

        } catch (IOException e) {
            System.out.println("Error al escribir el archivo");
        }

    }
}