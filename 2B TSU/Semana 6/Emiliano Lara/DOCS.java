/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package docs;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class DOCS {

    public static void main(String[] args) {
       try {
           File myObj=new File("care.txt");
           if (myObj.createNewFile()) {
               System.out.println("File created: " + myObj.getName());
           }else
           {
                 System.out.println("File already exists.");
           }
           FileWriter myWriter = new FileWriter("care.txt");
           myWriter.write("Emiliano Lara Dominguez!\n");
           myWriter.write("Edad: 18 años\n");
           myWriter.write("DSM\n");
           myWriter.write("UTT\n");
           myWriter.write("Java");
           myWriter.close();
           System.out.println("Successfully wrote to the file.");
           System.out.println("El archivo se creará en: " + new File("care.txt").getAbsolutePath());
           } catch (IOException e) {
               System.out.println("An error occurred.");
               e.printStackTrace();
        
           }
    }
    }
    

