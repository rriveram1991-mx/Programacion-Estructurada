
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package array;
import java.util.Scanner;
/**
 *
 * @author pecha
 */
public class Array {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Ingrese las horas trabajadas de lunes a viernes (por dia)");
        Scanner sc = new Scanner(System.in);
        int[] horas = new int [5];
        // TODO code application logic here
        for (int i = 0; i < horas.length; i++){
horas[i]= sc.nextInt();
}
        System.out.println("Sueldo de la semana");
        int resultado = 0;
        for (int i = 0; i < horas.length; i++){
            resultado += horas[i];
        }
        resultado *= 63;
        System.out.println("El sueldo semanal por tus horas trabajadas es de: $" + resultado);
    }
    
    
}
