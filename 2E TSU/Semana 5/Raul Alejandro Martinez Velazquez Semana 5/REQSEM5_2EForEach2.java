/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package array2;
import java.util.Scanner;
/**
 *
 * @author pecha
 */
public class Array2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
             System.out.println("Ingrese las calificaciones de los 9 alumnos");
        Scanner sc = new Scanner(System.in);
        int[] calificaciones = new int [9];
        // TODO code application logic here
        for (int i = 0; i < calificaciones.length; i++){
calificaciones[i]= sc.nextInt();
}
        System.out.println("Promedio del grupo");
        int resultado = 0;
        for (int i = 0; i < calificaciones.length; i++){
            resultado += calificaciones[i];
        }
        resultado /= 9;
        System.out.println("El promedio de la calificacion del salon es de: " + resultado);
    } }
  
