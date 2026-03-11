/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unidad2;

/**
 *
 * @author Guillermo
 */

 import java.io.FileWriter;
import java.io.IOException;
public class Crear_Archivo_Nombre {
    public static void main(String[] args) {
        try {
            FileWriter archivo = new FileWriter("alumno.txt");

            archivo.write("Nombre del alumno: Guillermo Botello Regalado\n");
            archivo.write("Edad: 18\n");
            archivo.write("Especialidad: Desarrollo de software multiplataforma\n");
            archivo.write("Escuela: Universidad Tecnologica de Torreon\n");
            archivo.write("Lenguaje favorito: C#\n");

            archivo.close();

            System.out.println("Archivo creado.");

        } catch (IOException e) {

            System.out.println("Ocurrio un error al crear el archivo.");

        }
    }
}   

