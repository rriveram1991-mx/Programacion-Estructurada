/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package archivoreq.sem6.pkg2b;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author jasun
 */
public class ArchivoREQSEM62B {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            File myObj = new File("fileInfoAlumno.txt");
            
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            }
            else {
                System.out.println("File already exists.");
                 }
            FileWriter myWriter = new FileWriter("fileInfoAlumno.txt");
            myWriter.write("Nombre: Joshue Angel Regalado Martinez\n");
            myWriter.write("Edad: 18\n");
            myWriter.write("Especialidad: DSM\n");
            myWriter.write("Escuela: UTT\n");
            myWriter.write("Lenguaje fav: java\n");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
}