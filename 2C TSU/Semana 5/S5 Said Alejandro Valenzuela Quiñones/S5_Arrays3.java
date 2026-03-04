/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package s5_arrays3;

import java.util.Scanner;

public class S5_Arrays3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        double[] calif = new double[7];
        double suma = 0, promedio;
        
        for(int i = 0; i < calif.length; i++){
            System.out.println("Ingresa la calificacion: ");
            calif[i] = sc.nextDouble();
            suma += calif[i];
        }
        
        promedio = suma / calif.length;
        System.out.println("Promedio: " + promedio);
    }
    
}
