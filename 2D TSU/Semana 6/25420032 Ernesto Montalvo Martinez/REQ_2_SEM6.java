/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package semana.pkg6;

import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Ernesto Montalvo
 */

public class REQ_2_SEM6 {

        public static void main(String[] args) {

        int[][] calificaciones = {
                {8,9,7},
                {10,9,9},
                {6,7,8}
        };

        String[] materias = {"Programacion","Redes","Bases de Datos"};

        try {

            FileWriter archivo = new FileWriter("calificaciones.txt");

            for(int i = 0; i < 3; i++){

                System.out.println("Alumno " + (i+1));
                archivo.write("Alumno " + (i+1) + "\n");

                System.out.print("Calificaciones: ");
                archivo.write("Calificaciones: ");

                int suma = 0;

                for(int j = 0; j < 3; j++){

                    System.out.print(calificaciones[i][j] + " ");
                    archivo.write(calificaciones[i][j] + " ");

                    suma = suma + calificaciones[i][j];
                }

                System.out.println();
                archivo.write("\n");

                float promedio=(float) (suma/3.0);

                System.out.println("Materia: " + materias[i]);
                archivo.write("Materia: " + materias[i] + "\n");

                System.out.println("Promedio: " + promedio);
                archivo.write("Promedio: " + promedio + "\n");

                if(promedio >= 9){
                    System.out.println("Alumno destacado");
                    archivo.write("Alumno destacado\n");
                }

                System.out.println();
                archivo.write("\n");

            }

            archivo.close();

        } catch(IOException e){
            System.out.println("Error al guardar el archivo");
        }

    }

}