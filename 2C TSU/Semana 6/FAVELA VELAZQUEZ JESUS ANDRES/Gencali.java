/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gencali;
import java.io.File; // Se usa para crear, leer o manipular archivos 
import java.io.FileWriter; // Sirve para escribir texto dentro de un archivo 
import java.io.IOException; // Se usa para manejar errores relacionados con archivos 
/**
 *
 * @author ASUS
 */
public class Gencali {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        // Matriz de calificaciones definida en el requerimiento
        int[][] calificaciones = {
            {8, 9, 7},
            {10, 9, 9},
            {6, 7, 8}
        };

        // Arreglo de materias para asignar nombres a cada fila
        String[] nombresMaterias = {"Programacion", "Redes", "Bases de Datos"};

        try { // Bloque try para intentar ejecutar el código de archivos 
            
            File archivo = new File("calificaciones.txt"); // Crea el objeto archivo 
            
            // Intenta crear el archivo físicamente
            if (archivo.createNewFile()) {
                System.out.println("Archivo creado: " + archivo.getName()); // Imprime si se creó 
            } else {
                System.out.println("El archivo ya existe."); // Mensaje si ya existía 
            }

            FileWriter escritor = new FileWriter("calificaciones.txt"); // Objeto para escribir en el archivo 

            // Ciclo for para recorrer los 3 alumnos (filas de la matriz)
            for (int i = 0; i < calificaciones.length; i++) {
                
                // Escribir "Alumno X"
                escritor.write("Alumno " + (i + 1) + "\n"); // \n para el salto de línea 
                
                // Escribir las calificaciones de la fila actual
                escritor.write("Calificaciones: ");
                int suma = 0;
                for (int j = 0; j < calificaciones[i].length; j++) {
                    escritor.write(calificaciones[i][j] + " "); // Escribe cada nota de la matriz
                    suma += calificaciones[i][j]; // Acumula la suma para el promedio
                }
                escritor.write("\n"); // Salto de línea después de las notas

                // Calcular el promedio del alumno actual
                double promedio = suma / 3.0;

                // Estructura específica por alumno según el ejemplo
                if (i == 0) { // Alumno 1
                    escritor.write("Materia: " + nombresMaterias[0] + "\n");
                    escritor.write("Promedio: " + (int)promedio + "\n");
                } 
                else if (i == 1) { // Alumno 2
                    escritor.write("Promedio: " + String.format("%.1f", promedio) + "\n");
                    escritor.write("Materia: " + nombresMaterias[1] + "\n");
                    if (promedio >= 9) { // Regla de alumno destacado
                        escritor.write("Alumno destacado\n");
                    }
                } 
                else { // Alumno 3
                    escritor.write("Materia: " + nombresMaterias[2] + "\n");
                    escritor.write("Promedio: " + (int)promedio + "\n");
                }
            }

            escritor.close(); // Cierra el archivo para asegurar que los datos se guarden 
            System.out.println("Successfully wrote to the file."); // Mensaje de éxito en consola 

        } catch (IOException e) { // Captura errores en caso de fallas 
            System.out.println("An error occurred."); // Mensaje de error
            e.printStackTrace(); // Muestra el detalle del error para depuración 
        }
    }
}    
    

