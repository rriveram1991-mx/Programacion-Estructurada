/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package req.sem6.pkg2b;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


/**
 *
 * @author jasun
 */
public class REQSEM62B {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            File myObj = new File("fileJoshue.txt");
            
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            }
            else {
                System.out.println("File already exists.");
                 }
            FileWriter myWriter = new FileWriter("fileJoshue.txt");
            myWriter.write("Hola Profe!\n");
            myWriter.write("Lo estoy vigilando\n");
            myWriter.write("Mire por su ventana\n");
            myWriter.write("Cierre bien sus puertas\n");
            myWriter.write("JEJEJEJE");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
}
