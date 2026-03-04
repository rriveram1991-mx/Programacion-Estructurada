/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package s5_arrays2;

import java.util.Scanner;

public class S5_Arrays2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        double[] n = new double[5];
        double suma = 0;
        
        for(int i = 0; i < n.length; i++){
            System.out.println("Ingresa un numero:");
            n[i] = sc.nextDouble();
            suma += n[i];
        }
        
        System.out.println("La suma es: " + suma);
    }
    
}
