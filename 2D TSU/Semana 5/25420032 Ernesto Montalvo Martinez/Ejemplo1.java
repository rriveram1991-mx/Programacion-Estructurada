/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arreglo_for_each;

import java.util.Scanner;

/**
 *
 * @author Ernesto Montalvo
 */
public class Ejemplo1 {
    public static void main(String[]args){
        Scanner sc=new Scanner (System.in);
        
        int[] numeros = {5, 8, 12, 3, 9};
        for (int i = 0; i < numeros.length; i++) {
    System.out.println(numeros[i]);
    int suma = 0;
        for (int num : numeros) {
            suma += num;
        }
        System.out.println("Suma total: " + suma);
        
        double promedio = (double) suma/numeros.length;
        System.out.println("Promedio: " + promedio);
  
    }
}
    }

