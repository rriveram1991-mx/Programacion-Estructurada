/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package s6.sistemacalificaciones;
import java.io.FileWriter;
import java.io.IOException;

public class S6SistemaCalificaciones {


    public static void main(String[] args) {
        // Matriz de calificaciones
        // Filas = alumnos
        // Columnas = materias
        int[][] calificaciones = {
            {8,9,7},
            {10,9,9},
            {6,7,8}
        };

        // Materia principal de cada alumno
        String[] materias = {
            "Programacion",
            "Redes",
            "Bases de Datos"
        };

        try{

            // Crear archivo
            FileWriter archivo = new FileWriter("calificaciones.txt");

            // Recorrer alumnos
            for(int i = 0; i < calificaciones.length; i++){

                int suma = 0;

                System.out.println("Alumno " + (i+1));
                archivo.write("Alumno " + (i+1) + "\n");

                System.out.print("Calificaciones: ");
                archivo.write("Calificaciones: ");

                // Recorrer materias
                for(int j = 0; j < calificaciones[i].length; j++){

                    System.out.print(calificaciones[i][j] + " ");
                    archivo.write(calificaciones[i][j] + " ");

                    suma = suma + calificaciones[i][j];
                }

                System.out.println();
                archivo.write("\n");

                // Mostrar materia
                System.out.println("Materia: " + materias[i]);
                archivo.write("Materia: " + materias[i] + "\n");

                // Calcular promedio
                double promedio = suma / 3.0;

                System.out.println("Promedio: " + promedio);
                archivo.write("Promedio: " + promedio + "\n");

                // Condición para alumno destacado
                if(promedio >= 9){

                    System.out.println("Alumno destacado");
                    archivo.write("Alumno destacado\n");
                }
                System.out.println();
                archivo.write("\n");
            }
            // Cerrar archivo
            archivo.close();
            System.out.println("Archivo creado correctamente");
        }
        catch(IOException e){
            System.out.println("Error al crear el archivo");
        }
    }
}