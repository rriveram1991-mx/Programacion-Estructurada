/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gen.archivos;

/**
 *
 * @author Admin
 */
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GENARCHIVOS {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            try (FileWriter archivo = new FileWriter("alumnos.txt")) {
                for (int i = 1; i <= 3; i++) {
                    
                    System.out.println("Alumno " + i);
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Edad: ");
                    int edad = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Especialidad: ");
                    String especialidad = sc.nextLine();
                    System.out.print("Escuela: ");
                    String escuela = sc.nextLine();
                    System.out.print("Lenguaje favorito: ");
                    String lenguaje = sc.nextLine();
                    
                    archivo.write("Nombre: " + nombre + "\n");
                    archivo.write("Edad: " + edad + "\n");
                    archivo.write("Especialidad: " + especialidad + "\n");
                    archivo.write("Escuela: " + escuela + "\n");
                    archivo.write("Lenguaje favorito: " + lenguaje + "\n");
                    
                }
            }
            System.out.println("Datos guardados en el archivo.");

        } catch (IOException e) {
            System.out.println("Error al escribir el archivo");
        }

    }
}
