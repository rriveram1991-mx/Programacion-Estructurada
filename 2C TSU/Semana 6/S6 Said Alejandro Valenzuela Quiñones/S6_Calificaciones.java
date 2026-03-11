/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package s6_calificaciones;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class S6_Calificaciones {
    
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        
        String[] alumnos = {"Alumno 1", "Alumno 2", "Alumno 3"};
        String[] materias = {"Redes", "Programacion", "Sistemas"};
        
        double[][] notas = new double[3][3];
        
        for (int i = 0; i < 3; i++) {
            System.out.println("--- Registro de: " + alumnos[i] + " ---");
            for (int j = 0; j < 3; j++) {
                double calificacion;
                do {
                    System.out.print("Ingrese nota de " + materias[j] + " (0-10): ");
                    calificacion = leer.nextDouble();
                    
                    if (calificacion < 0 || calificacion > 10) {
                        System.out.println("Error: La calificacion debe estar entre 0 y 10.");
                    }
                } while (calificacion < 0 || calificacion > 10);
                
                notas[i][j] = calificacion;
            }
            System.out.println();
        }

        System.out.println("======= REPORTE DE CALIFICACIONES =======");
        for (int i = 0; i < 3; i++) {
            double suma = 0;
            System.out.println("\nResultados de " + alumnos[i] + ":");
            
            for (int j = 0; j < 3; j++) {
                System.out.println("- " + materias[j] + ": " + notas[i][j]);
                suma += notas[i][j];
            }
            
            double promedio = suma / 3;
            
            System.out.printf("Promedio Final: %.2f\n", promedio);
            if (promedio >= 9){
                System.out.println("Alumno destacado");
            }
            System.out.println("-----------------------------------------");
                      
        }
        
        try {
    FileWriter myWriter = new FileWriter("calificaciones.txt");
    
    myWriter.write("======= REPORTE DE CALIFICACIONES =======\n\n");

    for (int i = 0; i < 3; i++) {
        double suma = 0;
        myWriter.write("Alumno: " + alumnos[i] + "\n");
        
        for (int j = 0; j < 3; j++) {
            myWriter.write("- " + materias[j] + ": " + notas[i][j] + "\n");
            suma += notas[i][j];
        }
        
        double promedio = suma / 3;
        myWriter.write(String.format("Promedio Final: %.2f\n", promedio));
        myWriter.write("-----------------------------------------\n");
    }

    myWriter.close();
    System.out.println("Los datos se han guardado exitosamente en 'calificaciones.txt'");

} catch (IOException e) {
    System.out.println("Ocurrió un error al escribir el archivo.");
    e.printStackTrace();
}
    }
}
    

