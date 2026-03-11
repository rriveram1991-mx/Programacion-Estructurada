/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package req1.sem6.pkg2d.rcmc;

/**i
 *
 * @author STAR KRIS
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class REQ1SEM62DRCMC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            File myObj = new File("datos.txt");
            if (myObj.createNewFile()) {
                System.out.println("archivo creado " + myObj.getName());
                } else {
  System.out.println("el archivo ya existia");
}
            FileWriter myWriter = new FileWriter("datos.txt");
            myWriter.write("Hola Cristina Medina \n");
            myWriter.write("Tiene 17 anos \n");
            myWriter.write("Es desarrolladora de software\n  ");
            myWriter.write("Universidad Tecnologica de Torreon\n");
            myWriter.write("ruso \n");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
                System.out.println("An error occurred.");
            
            }
        
        
        }
        
    }
    

