/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package archivo_2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author OLguin21
 */
public class Archivo_2 { 

    public static void main(String[] args) {
  
        try {
            
            File myObj = new File("filename.txt2");

           
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }

           
            FileWriter myWriter = new FileWriter("filename.txt");

            myWriter.write("Hola profe, aceptaría la humilde y amable propuesta de explicar como subir los archivos y trabajos de nuevo? :D.\n");
            myWriter.write("Hablo por los inocentes que aún se les complica subir sus trabajos (osea yo).\n");
            myWriter.write("Sin más que decir, Muchas gracias por su atención .\n");
          
            myWriter.close();

            System.out.println("Successfully wrote to the file.");

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
