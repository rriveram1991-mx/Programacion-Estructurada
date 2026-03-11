/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package genarchivo;
 import java.io.File; // Importa la clase File de la librería java.io para crear, leer o manipular archivos y carpetas [cite: 3, 4, 5]
import java.io.FileWriter; // Importa la clase FileWriter para escribir texto dentro de un archivo [cite: 6, 7, 8]
import java.io.IOException; // Importa la clase IOException para manejar errores relacionados con archivos [cite: 9, 10, 11]
/**
 *
 * @author ASUS
 */
public class Genarchivo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        try { // try significa intentar ejecutar este código porque trabajar con archivos puede generar errores 

            // --- 1. CREACIÓN DEL ARCHIVO PRINCIPAL ---
            File myObj = new File("filename.txt"); // Crea un objeto archivo que representa un archivo llamado filename.txt
            if (myObj.createNewFile()) { // createNewFile intenta crear el archivo físicamente; devuelve true si el archivo se creó 
                System.out.println("File created: " + myObj.getName()); // Imprime en consola y obtiene el nombre del archivo 
            } else {
                System.out.println("File already exists."); // Si el archivo ya estaba creado, se ejecuta else y lo imprime 
            }

            // Escribir texto en el archivo 
            FileWriter myWriter = new FileWriter("filename.txt"); // Se crea un objeto FileWriter que será usado para escribir en el archivo 
            myWriter.write("Hola Ricardo!\n"); // Escribe texto en el archivo, donde \n significa salto de línea 
            myWriter.write("Este archivo fue creado desde Java.\n"); // Escribe la segunda línea 
            myWriter.write("Estamos practicando manejo de archivos."); // Escribe la tercera línea 
            myWriter.close(); // Cierra el archivo después de escribir, lo que evita errores o pérdida de datos 
            System.out.println("Successfully wrote to the file."); // Muestra en consola mensaje de éxito 

            // --- 2. CREACIÓN DEL ARCHIVO ALEATORIO ---
            // Generamos un número aleatorio para que el nombre del archivo siempre sea diferente
            int numeroAleatorio = (int)(Math.random() * 1000);
            String randomFileName = "registro_pacientes_" + numeroAleatorio + ".txt";

            File randomFile = new File(randomFileName);
            if (randomFile.createNewFile()) {
                System.out.println("Random file created: " + randomFile.getName());
            } else {
                System.out.println("Random file already exists.");
            }

            FileWriter randomWriter = new FileWriter(randomFileName);
            randomWriter.write("Práctica de Programación Estructurada y Desarrollo de Software Multiplataforma.\n");
            randomWriter.write("ID de registro generado: " + numeroAleatorio + "\n");
            randomWriter.write("Validación de datos mediante arreglos completada exitosamente.");
            randomWriter.close();
            System.out.println("Successfully wrote to the random file.");

        } catch (IOException e) { // catch captura errores del try y detecta errores relacionados con archivos 
            System.out.println("An error occurred."); // Si ocurre un error imprime este texto 
            e.printStackTrace(); // Muestra información detallada del error y sirve para depuración
        } // Estos cierran el catch 
    } // Estos cierran el main 
} // Estos cierran la class 
    
    

