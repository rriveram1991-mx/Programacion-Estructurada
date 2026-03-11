/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package req2.sem6.pkg2d.rcmc;

/**
 *
 * @author STAR KRIS
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class REQ2SEM62DRCMC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            File myObj = new File("BLACKPINK.txt");
            if (myObj.createNewFile()) {
                System.out.println("archivo creado " + myObj.getName());
                } else {
  System.out.println("el archivo ya existia");
}
            FileWriter myWriter = new FileWriter("BLACKPINK.txt");
            myWriter.write("Blackpink es un grupo surcoreano con 4 integrantes  \n");
            myWriter.write("Lisa, 28 anos y de origen tailandes \n");
            myWriter.write("Jennie, 30 anos, coreana\n  ");
            myWriter.write("Rose, 28 anos, neozelandesa \n");
            myWriter.write("Jisoo, 30 anos,coreano  \n");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
                System.out.println("An error occurred.");
            
            }
        
        
        }
    }
    

