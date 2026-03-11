/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package req.pkg2.sem6.pkg2e.agfl.calf;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author gl873
 */
public class REQ2SEM62EAGFLCalf {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner Leer = new Scanner(System.in);
        // TODO code application logic here
        String[] materias = new String[3];
        double[] promedios = new double[3];
 
        int [][] cal= {
        {8,9,7},
        {10,9,9},
        {6,7,8}
        };

         // calcular promedios
         for(int i = 0; i < 3; i++){
         promedios[i] = (cal[i][0] + cal[i][1] + cal[i][2]) / 3.0;
         }

         // pedir materias
         for(int i = 0; i < 3; i++){
         System.out.println("Ingrese la materia " + (i+1) + ":");
         materias[i] = Leer.nextLine();
         }

          // mostrar resultados
         for(int i = 0; i < 3; i++) {

            System.out.println("Alumno " + (i+1));
            System.out.println("Calificaciones: " + cal[i][0] + " " + cal[i][1] + " " + cal[i][2]);
            System.out.println("Materia: " + materias[i]);
            System.out.println("El promedio del alumno es: " + promedios[i]);
            
            if(promedios[i] >= 9){
              System.out.println("Alumno destacado");
            }
           }
        
        
        try {

            File calf = new File("calificaciones.txt");

            if (calf.createNewFile()) {
                System.out.println("Archivo creado: " + calf.getName());
            } else {
                System.out.println("El archivo ya esta en existencia.");
            }

            FileWriter escribir = new FileWriter("calificaciones.txt");


           for(int i = 0; i < cal.length; i++) {

           escribir.write("Alumno " + (i+1) + "\n");

           escribir.write("Calificaciones: " 
           + cal[i][0] + " " 
           + cal[i][1] + " " 
           + cal[i][2] + "\n");

           escribir.write("Materia: " + materias[i] + "\n");
           escribir.write("El promedio del alumno es: " + promedios[i] + "\n\n");
           if(promedios[i] >= 9){
           escribir.write("Alumno destacado \n\n");
           }
}

            escribir.close();

            System.out.println("Se completo escribir correctamente en el archivo");

        } catch (IOException e) {

            System.out.println("Ocurrio un error.");
            e.printStackTrace();

        }
    }
    
}
