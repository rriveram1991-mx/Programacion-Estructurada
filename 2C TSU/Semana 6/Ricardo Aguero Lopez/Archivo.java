/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package archivo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author aguer
 */
public class Archivo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {

            File archivo = new File("DatosAlumno.txt");

            if (archivo.createNewFile()) {
                System.out.println("Archivo creado: " + archivo.getName());
            } else {
                System.out.println("El archivo ya existe");
            }

            FileWriter escribir = new FileWriter("DatosAlumno.txt");

            escribir.write("Alumno: Ricardo Aguero Lopez\n");
            escribir.write("Edad: 22 años\n");
            escribir.write("Especialidad: Desarrollo de software multiplataforma\n");
            escribir.write("Escuela: Universidad Tecnologica de Torreon\n");
            escribir.write("Lenguaje favorito: Java\n");

            escribir.close();

            System.out.println("Datos guardados correctamente");

        } catch (IOException e) {

            System.out.println("Ocurrio un error");
            e.printStackTrace();

        }
    }
    
}
