/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package req1.sem6.pkg26.ezco;

import java.io.File; // permite crear y manejar archivos
import java.io.FileWriter; // permite escribir texto dentro de un archivo
import java.io.IOException; // maneja errores relacionados con archivos

/**
 *
 * @author Zoé
 */
public class REQ1SEM626EZCO {

    public static void main(String[] args) {

        try { // se usa para intentar ejecutar código que podría generar un error

            File archivo = new File("filename.txt");
            // creamos un objeto llamado archivo que representa el archivo filename.txt

            if (archivo.createNewFile()) { 
                // intenta crear el archivo
                // devuelve true si se creó y false si ya existe
                System.out.println("File created: " + archivo.getName());
            } else {
                System.out.println("File already exists");
            }

            FileWriter myWriter = new FileWriter("filename.txt");
            // se crea un objeto FileWriter para escribir dentro del archivo

            myWriter.write("El pulpo tiene 3 corazones\n");
            myWriter.write("La miel nunca se echa a perder\n");
            myWriter.write("Los tiburones existen antes que los arboles\n");
            myWriter.write("Las abejas pueden reconocer rostros humanos\n");
            myWriter.write("La Torre Eiffel puede crecer hasta 15 cm en verano por el calor\n");

            myWriter.close(); 
            // se cierra el archivo para guardar correctamente los cambios

            System.out.println("Successfully wrote to the file");

        } catch (IOException e) { 
            // catch captura cualquier error relacionado con archivos
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }
}