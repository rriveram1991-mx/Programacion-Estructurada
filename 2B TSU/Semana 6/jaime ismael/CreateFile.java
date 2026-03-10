/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication69;

import java.io.File;           
import java.io.FileWriter;     
import java.io.IOException;    


import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class CreateFile {

    public static void main(String[] args) {
        // Cambiamos el nombre del Scanner a "leer"
        Scanner leer = new Scanner(System.in);
        
        try {
            // Pedimos los datos usando la nueva variable
            System.out.print("Nombre del alumno: ");
            String nombre = leer.nextLine();

            System.out.print("Edad: ");
            String edad = leer.nextLine();

            System.out.print("Especialidad: ");
            String especialidad = leer.nextLine();

            System.out.print("Escuela: ");
            String escuela = leer.nextLine();

            System.out.print("Lenguaje favorito: ");
            String lenguaje = leer.nextLine();

            System.out.print("Inicial de Pokemon favorito: ");
            String pokemon = leer.nextLine();

            // Creamos el escritor de archivos
            FileWriter myWriter = new FileWriter("datos_usuario.txt");

            // Escribimos las variables capturadas
            myWriter.write("Nombre del alumno: " + nombre + "\n");
            myWriter.write("Edad: " + edad + "\n");
            myWriter.write("Especialidad: " + especialidad + "\n");
            myWriter.write("Escuela: " + escuela + "\n");
            myWriter.write("Lenguaje favorito: " + lenguaje + "\n");
            myWriter.write("Inicial de Pokemon favorito: " + pokemon + "\n");

            // Cerramos los recursos
            myWriter.close();
            leer.close(); // Cerramos el scanner "leer"

            System.out.println("\nSe han guardado los datos exitosamente.");

        } catch (IOException e) {
            System.out.println("Ocurrió un error al procesar el archivo.");
            e.printStackTrace();
        }
    }
}