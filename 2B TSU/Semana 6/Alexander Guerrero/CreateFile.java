/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package req_sem6_2b_java_1;

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Lex
 */
public class CreateFile { //REQ_SEM6_2B_JAVA_1 

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Scanner leer = new Scanner(System.in);
        
         try
        {
            File myObj = new File("filename.txt");

            if(myObj.createNewFile()){
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }

            FileWriter myWriter = new FileWriter("filename.txt");
            myWriter.write("Nombre del alumno: Alexander Guerrero\n");
            myWriter.write("Edad: f(x) = 5x-5 (x=5) \n");
            myWriter.write("Escuela: UTT\n");
            myWriter.write("Lenguaje favorito: Español\n");

            myWriter.close();
            System.out.println("Successfully wrote to the file.");

        } catch(IOException e){
            System.out.println("An error ocurred.");
            e.printStackTrace();
        }
    }
    
}
