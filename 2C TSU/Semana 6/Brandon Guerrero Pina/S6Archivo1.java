/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package s6.archivo1;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author UTT
 */
public class S6Archivo1 {
    public static void main(String[] args) {
        // Se utiliza un bloque try porque al trabajar con archivos pueden ocurrir errores
        // El codigo dentro del try se ejecutara normalmente, pero si ocurre un error
        // sera capturado posteriormente en el bloque catch
        try {
            // Crear objeto File
            // Se crea un objeto de la clase File llamado myObj
            // Este objeto representa un archivo llamado "alumno.txt"
            // Aquii solo se define el archivo, todavia no se crea fisicamente
            File myObj = new File("alumno.txt");
            // Crear el archivo
            // Se intenta crear el archivo en el sistema
            // El metodo createNewFile() devuelve true si el archivo se cre correctamente
            // y devuelve false si el archivo ya existia
            if (myObj.createNewFile()) {
                // Si el archivo se creo correctamente se muestra un mensaje en consola
                // getName() obtiene el nombre del archivo creado
                System.out.println("File created: " + myObj.getName());
            } else {
                // Si el archivo ya existia, se muestra este mensaje
                System.out.println("File already exists.");
            }
            // Crear FileWriter para escribir en el archivo
            // Se crea un objeto FileWriter llamado myWriter
            // Este objeto permite escribir informacion dentro del archivo alumno.txt
            FileWriter myWriter = new FileWriter("alumno.txt");
            // Se escribe la primera línea de texto dentro del archivo
            // \n se utiliza para hacer un salto de linea
            myWriter.write("Nombre del alumno: Brandon Guerrero\n");
            myWriter.write("Edad: 20\n");// Escribe la edad del alumno en el archivo
            myWriter.write("Especialidad: Desarrollo de Software\n");    // Escribe la especialidad o carrera del alumno
            myWriter.write("Escuela: Universidad Tecnologica\n");    // Escribe la escuela del alumno
            myWriter.write("Lengu aje favorito: Java\n");    // Escribe el lenguaje de programacin favorito
            // Se cierra el archivo despues de escribir
            // Esto es importante para guardar correctamente la informacion
            myWriter.close();
            // Se muestra un mensaje indicando que la escritura en el archivo fue exitosa
            System.out.println("Successfully wrote to the file .");  
        } 
        // Si ocurre algun error durante la creacion o escritura del archivo
        // el programa entrara en este bloque catch
        catch (IOException e) {
            System.out.println("An error occurred.");    // Muestra un mensaje indicando que ocurrio un error
            e.printStackTrace();
            // printStackTrace() muestra informacion detallada del error
            // Esto ayuda a identificar el problema en el codigo
        }
    }
}