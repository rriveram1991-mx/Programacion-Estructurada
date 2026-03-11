/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package caliestad.req.sem6.pkg2b;

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author jasun
 */
public class CaliEstadREQSEM62B {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        double [][] califs = new double [3][3];
        String [] materias = new String [3];
        double []promedios=new double [3];
        
        for(int i=0; i<3; i++) {
        System.out.println("Toma de calificaciones y materias");
        
        for (int j=0;j<3;j++) {
            System.out.println("Ingrese la materia a calificar: ");
            materias[j]=sc.next();
            while (materias[j].isEmpty()){
                    System.out.println("Error al ingresar la materia, ingreselo de nuevo");
                    materias[j]=sc.next();
                }
            for (i=0;i<3;i++) {
                System.out.println("\nAlumno "+(i+1));
                System.out.println("Ingrese la calificacion de "+materias[j]);
                califs[i][j]=sc.nextDouble();   
                while (califs[i][j]<0 || califs[i][j]>10) {
                    System.out.println("Calificacion no valida, ingresela de nuevo");
                    califs[i][j]=sc.nextDouble();
                }
            }
        }
    }
         System.out.println("\nCalificaciones registradas:");

        for (int i = 0; i < 3; i++) {
            System.out.print("Alumno " + (i + 1) + ": ");

            for (int j = 0; j < 3; j++) {
                System.out.print(materias[j] + "=" + califs[i][j] + "  ");
            }

            System.out.println();
        }
            for (int i = 0; i < 3; i++) {
                double suma = 0;

                for (int j = 0; j < 3; j++) {
                    suma = suma + califs[i][j];
                }

                promedios[i] = suma / 3;
                System.out.println("\nEl promedio del alumno " + (i+1) + " es: " + promedios[i]);
                if (promedios[i]>=9) {
                    System.out.println("Alumno destacado");
                }
                }
            try {
            File myObj = new File("Calificaciones.txt");
            
            if (myObj.createNewFile()) {
                System.out.println("\nFile created: " + myObj.getName());
            }
            else {
                System.out.println("File already exists.");
                 }
            FileWriter myWriter = new FileWriter("Calificaciones.txt");
            for (int i=0;i<3;i++) {
            myWriter.write("\nAlumno "+(i+1)+"\n");
            for (int j=0;j<3;j++) {
            myWriter.write("Calificaciones: "+califs[i][j]+"\n");
            }
            myWriter.write("Promedio: "+promedios[i]+"\n");
            for (int j=0;j<3;j++) {
            myWriter.write("Materias: "+materias[j]+"\n");
            }
            if (promedios[i]>=9) {
             myWriter.write("Alumno destacado\n");   
            }
            }
             myWriter.close();
             System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
                }

}
}
