/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package archivo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author OLguin21
 */
public class Archivo { 

    public static void main(String[] args) {
  
        try {
            
            File myObj = new File("filename.txt");

           
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }

           
            FileWriter myWriter = new FileWriter("filename.txt");

            myWriter.write("Nombre: Estefania Olguin Villa\n");
            myWriter.write("Edad: 19 años.\n");
            myWriter.write("Especialidad: Desarrollo de Software y Multiplataforma.\n");
            myWriter.write("Escuela: Universidad Tecnologica de Torreón.\n");
            myWriter.write("Lenguaje favorito: Java\n");

            myWriter.close();

            System.out.println("Successfully wrote to the file.");

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}