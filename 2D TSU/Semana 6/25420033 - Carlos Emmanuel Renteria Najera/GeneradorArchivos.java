/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package generadorarchivos;

/**
 *
 * @author Memer
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class GeneradorArchivos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            File myObj = new File("Teamo.txt");
            if (myObj.createNewFile()) {
                System.out.println("File create: " + myObj.getName());
            }
            else{
                System.out.println("File already exists");
            }
            FileWriter myWriter = new FileWriter("filename.txt");
            myWriter.write("Nombre: Carlos Emmanuel Renteria Najera\n");
            myWriter.write("Edad: 21\n");
            myWriter.write("Especialidad: Desarrollo de software\n");
            myWriter.write("Escuela: Univerdad tecnologica de torreon\n");
            myWriter.write("Lenguaje favorito: Java, por el momento\n");
            myWriter.write("Aleatorio: me gusta\n");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        }catch(IOException e){
            System.out.println("An Error Occurred");
            e.printStackTrace();
        }
    }
    
}
