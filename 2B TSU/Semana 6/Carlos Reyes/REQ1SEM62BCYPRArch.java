/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package req.pkg1.sem6.pkg2bcypr.arch;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author juanc
 */
public class REQ1SEM62BCYPRArch {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
       try {
           File myObj=new File("ponoma.txt");
           if (myObj.createNewFile()) {
               System.out.println("Archivo creado: " + myObj.getName());
           }else
           {
                 System.out.println("El archivo ya existe.");
           }
           FileWriter myWriter = new FileWriter("ponoma.txt");
           myWriter.write("Carlos Yahel!\n");
           myWriter.write("Edad: 17 años\n");
           myWriter.write("Desarrollo de Software Multiplataforma\n");
           myWriter.write("UTT\n");
           myWriter.write("Java");
           myWriter.close();
           System.out.println("El archivo se escribió correctamente.");
           System.out.println("El archivo se creará en: " + new File("ponoma.txt").getAbsolutePath());
           } catch (IOException e) {
               System.out.println("Ha ocurrido un error.");
               e.printStackTrace();
        
           }
    }
    }


