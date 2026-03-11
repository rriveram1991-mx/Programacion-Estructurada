/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication59;

/**
 *
 * @author gl873
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreateFile1 {

    public static void main(String[] args) {

        try {

            File myObj = new File("datosAlumno.txt");

            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }

            FileWriter myWriter = new FileWriter("datosAlumno.txt");

            myWriter.write("Nombre del alumno: Angel Gabriel Fernández López\n");
            myWriter.write("Edad: 18\n");
            myWriter.write("Especialidad: Desarrollo de Software multiplataforma\n");
            myWriter.write("Escuela: UTT\n");
            myWriter.write("Lenguaje favorito: Java\n");

            myWriter.close();

            System.out.println("Successfully wrote to the file.");

        } catch (IOException e) {

            System.out.println("An error occurred.");
            e.printStackTrace();

        }

    }

}
