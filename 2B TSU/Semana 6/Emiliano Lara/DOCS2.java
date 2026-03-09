/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package docs2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class DOCS2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
           File myObj=new File("bush.txt");
           if (myObj.createNewFile()) {
               System.out.println("File created: " + myObj.getName());
           }else
           {
                 System.out.println("File already exists.");
           }
           FileWriter myWriter = new FileWriter("bush.txt");
           myWriter.write("Animal favorito:Búho\n");
           myWriter.write("Signo zodiacal:Cancer\n");
           myWriter.write("Ruta de camión fav:Dorada Normal\n");
           myWriter.write("Colonia:Las Fuentes\n");
           myWriter.write("Comida favorita:Chilaquiles verdes");
           myWriter.close();
           System.out.println("Successfully wrote to the file.");
           System.out.println("El archivo se creará en: " + new File("bush.txt").getAbsolutePath());
           } catch (IOException e) {
               System.out.println("An error occurred.");
               e.printStackTrace();
        
           }
    }
    }
        