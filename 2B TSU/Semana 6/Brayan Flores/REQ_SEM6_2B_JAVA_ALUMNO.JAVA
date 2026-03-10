REQ_SEM6_2B_JAVA_ALUMNO


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package create.file;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
/**
 *
 * @author Brayan
 */
public class CREATEFILE {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try{ File archivo = new File ("Alumno.txt");
        
        archivo.createNewFile();
        
        FileWriter escribir = new FileWriter("Alumno.txt");
        escribir.write("Nombre: Brayan Flores Sanchez\n");
        escribir.write("Edad: 21 Años\n");
        escribir.write("Especialidad: DSM\n");
        escribir.write("Escuela: UTT\n");
        escribir.write("Lenguaje favorito: java\n");
        escribir.close();
        
        } catch(IOException e){
            System.out.println("Prueba del texto");
        }
    }
    
}

