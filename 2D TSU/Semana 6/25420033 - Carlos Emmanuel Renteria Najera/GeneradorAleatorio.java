/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package generadoraleatorio;

/**
 *
 * @author Memer
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GeneradorAleatorio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            File myObj = new File("MiHome.txt");
            if (myObj.createNewFile()) {
                System.out.println("File create: " + myObj.getName());
            }
            else{
                System.out.println("File already exists");
            }
            FileWriter myWriter = new FileWriter("filename.txt");
            myWriter.write("JUEGUITOS QUE ME GUSTAN\n");
            myWriter.write("KINGDOM HEARTS\n");
            myWriter.write("SAGA SOULSBORNE SEKIRO ELDEN RING\n");
            myWriter.write("MINECRAFT\n");
            myWriter.write("terraria\n");
            myWriter.write("SKYRIM");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        }catch(IOException e){
            System.out.println("An Error Occurred");
            e.printStackTrace();
        }
    }
    
}
