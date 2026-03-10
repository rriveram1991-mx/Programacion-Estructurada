/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package archivos090326;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author ssjoa
 */
public class Archivos090326 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        try{
        Scanner leer = new Scanner(System.in);
        File myObj = new File("archivos.txt");
        
        if(myObj.createNewFile())
        {
        System.out.println("Archivo creado: "+myObj.getName());
            
        }else
        {
       System.out.println("Archivo ya existente");
        }
        
        System.out.println("Dame tu nombres");
        String nombre = leer.next();
        System.out.println("Dame tu edad");
        int edad = leer.nextInt();
        System.out.println("Dame tu especialidad");
        String especialidad = leer.next();
        System.out.println("Cual es el nombre de tu escuela");
        String escuela = leer.next();
        System.out.println("Cual es tu lenguaje favorito");
        String lenguaje = leer.next();
        
        FileWriter myWriter = new FileWriter("archivos.txt");
        myWriter.write("Hola "+nombre);
        myWriter.write("tu edad es: "+edad);
        myWriter.write("tu especialidad es: "+especialidad);
        myWriter.write("tu escuela es: "+escuela);
        myWriter.write("y tu lenguaje favorito es: "+lenguaje);
        myWriter.close();
        
        System.out.println("Archivo subido con excito");
        
        } catch (IOException e)
        {
         System.out.println("Error");
         e.printStackTrace();

        }
     }
 }
        
        
        
        
        
        
    
    
