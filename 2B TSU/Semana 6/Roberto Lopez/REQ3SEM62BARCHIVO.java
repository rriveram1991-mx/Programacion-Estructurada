/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package req3sem62barchivo;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


/**
 *
 * @author lopez
 */
public class REQ3SEM62BARCHIVO {

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
                System.out.println(" Archivo existe.");
                 }
                try (FileWriter myWriter = new FileWriter("fileInfoAlumno.txt")) {
                    myWriter.write("Nombre: Roberto Carlos Lopez Flores\n");
                    myWriter.write("Edad: 19\n");
                    myWriter.write("Especialidad: DSM\n");
                    myWriter.write("Escuela: UTT\n");
                    myWriter.write("Lenguaje fav: java\n");
                }
            System.out.println("Se escribio correctamente en el archivo.");
        }
        catch (IOException e) {
            System.out.println("Ocurrio un Error.");
        }
    }
    
}