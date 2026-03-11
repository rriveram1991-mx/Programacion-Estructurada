/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication58;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author gl873
 */
public class CreateFile {

    public static void main(String[] args) {

        try {

            // Crear el objeto File
            File myObj = new File("filename.txt");

            // Intentar crear el archivo
            if (myObj.createNewFile()) {

                System.out.println("File created: " + myObj.getName());

            } else {

                System.out.println("File already exists.");

            }

            // Escribir texto en el archivo
            FileWriter myWriter = new FileWriter("filename.txt");

            myWriter.write("Hola Ricardo!\n");
            myWriter.write("Este archivo fue creado desde Java.\n");
            myWriter.write("Estamos practicando manejo de archivos.\n");

            // Cerrar el archivo
            myWriter.close();

            System.out.println("Successfully wrote to the file.");

        } catch (IOException e) {

            System.out.println("An error occurred.");
            e.printStackTrace();

        }

    }

}
