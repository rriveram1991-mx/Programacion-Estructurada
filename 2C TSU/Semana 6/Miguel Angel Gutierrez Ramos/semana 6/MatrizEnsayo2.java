/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package matriz.ensayo2;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author miguelgu
 */
public class MatrizEnsayo2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int calificaciones[][];
        String nombres[] = new String [3];
        String materia[] = new String [3];
        
        for (int i=0;i<3;i++){
             System.out.println("Ingrese nombre del alumno #"+(i+1));
             nombres[i] = input.nextLine();
        }
        for (int i=0;i<3;i++){
             System.out.println("Ingrese materia #"+(i+1));
             materia[i] = input.nextLine();
        }
        
        calificaciones = new int[3][3];
        
        for (int i=0;i<3;i++){
            System.out.println("Calificaciones de "+nombres[i]);

            for (int j=0; j<3; j++){
                System.out.print("Calificacion de "+materia[j]+":");
                calificaciones[i][j] = input.nextInt();
                input.nextLine();
            }
            
            
        }
        for (int i = 0; i<3; i++){
                double suma = 0;
                
                for(int j=0; j<3;j++){
                    suma+= calificaciones[i][j];
                }
                double promedio = suma /3;
                System.out.println("Promedio de "+nombres[i]+" :"+promedio);
                
                if (promedio>=9){
                    System.out.println("Alumno destacado");
                }
                
            }
        
        try {
            FileWriter archivo = new FileWriter("calificaciones.txt");
            for (int i=0; i<3; i++){
                double suma = 0;
                
                for (int j=0; j<3; j++){
                    suma += calificaciones[i][j];
                    
                }
                double promedio = suma/3;
                
                
                
                
                archivo.write("Alumno "+nombres[i]+"\n");
                archivo.write("Promedio "+promedio+"\n");
                
                if (promedio >= 9){
                    archivo.write("Alumno destacado\n");
                }
                archivo.write("/n");
            }
            archivo.close();
            
            
        } catch (IOException e){
            System.out.println("Error al escribir el archivo");
            
        }
        
    }
    
}
