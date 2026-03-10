REQ_SEM6_2B_JAVA_FILE2
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package req_sem6_2b_java_file2;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
        
        
public class REQ_SEM6_2B_JAVA_FILE2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        try { File archivo = new File ("personajes DBZ .txt");
        
                archivo.createNewFile();
                
                FileWriter escribir = new FileWriter(archivo);
                escribir.write("Nivel de poder:\n");
                escribir.write("Gohan Bestia\n");
                escribir.write("Goku Ultra instinto\n");
                escribir.write("Vegeta Ultra Ego\n");
                escribir.write("Broly ssj Legendario\n");
                escribir.write("Picoro Orange\n");
                escribir.close();
                
         
        }  catch (IOException e) {
        } 
    }
    