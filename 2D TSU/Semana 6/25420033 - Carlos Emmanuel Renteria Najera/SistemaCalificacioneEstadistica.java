/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemacalificacioneestadistica;
import java.io.File;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;


/**
 *
 * @author Memer
 */
public class SistemaCalificacioneEstadistica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //declaro mis variables, junto a mi escaner
        Scanner lr = new Scanner (System.in);
        
        String[] nombresMaterias = {"Programacion", "Redes", "Bases de Datos"};
        int[][] calificaciones = new int [3][3];
        
        int input = 0;
        double suma = 0; 
        //creo que un bloque try, para capturar algun error en caso que haya un error
        try{
            //creo mi objeto File, para hacer mi archivo
            File myObj = new File("calificaciones.txt");
            
            //pido calificaciones de cada alumno
        for (int i = 0; i < calificaciones.length; i++) {
            System.out.println("--- Alumno " + (i+1)+ "---");
            for (int j = 0; j < calificaciones[i].length; j++) {
                System.out.print("Ingrese la calificacion de la materia: " + (j + 1) + ": ");
                input = lr.nextInt();
                while (input < 0 || input > 10) {
                    System.out.println("Calificacion incorrecta. Debe ser entre 0 y 10.");
                    System.out.print("Intente de nuevo: ");
                    input = lr.nextInt();
                }
                calificaciones[i][j] = input;   
            }  
        }
            //creo finalmente mi archivo .txt
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            }
            else{
                System.out.println("File already exists.");
            }
            
            //muestra mi matriz
        for (int[] f : calificaciones) {
            
            for (int c : f) {
                System.out.print(c + " ");
            }
            
            System.out.println();
        }
        
        
        // creo mi escritor, con el voy a escribir el en .txt 
        FileWriter myWriter = new FileWriter("calificaciones.txt");
        
        
        //finalmente, creo la estructura que va ver tanto en la consola como en el archivo
            for (int i = 0; i < 3; i++) {
            System.out.println("\nAlumno: " + (i+1));
            myWriter.write("\nAlumno: " + (i+1));
            
            System.out.print("Calificaciones: ");
            myWriter.write("\nCalificaciones: ");
            suma = 0;
            
                for (int j = 0; j < 3; j++) {
                    System.out.print(calificaciones[i][j] + " ");
                    myWriter.write(calificaciones[i][j] + " ");
                    suma += calificaciones[i][j];
                
                }
            
                System.out.println("\n" +nombresMaterias[i] + " ");
                myWriter.write("\n" +nombresMaterias[i] + " ");
            
                double promedio = suma / 3.0;
            
                System.out.println("Promedio: " + promedio);
                myWriter.write("\nPromedio: " + promedio);
                
                if (promedio > 9) {
                System.out.println("Alumno destacado");
                myWriter.write("\nAlumno destcado");
                }
                
                myWriter.write("\n");
            }
            
            //cierro mi objeto Writer
           myWriter.close();
        } catch (IOException e){ //captura el error y le informa al usuario
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        
        
        
        
        
    }
    
}
