/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package array2;

import java.util.Scanner;

public class ARRAY2 {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int[] numero = new int[5];                
        
        System.out.println("==================================================");                
        System.out.println("Cuantos ingenieros se necesitan para cambiar una bombilla? ");                

        for (int i = 0; i < numero.length; i++) {
            System.out.print("grupo de ingenieros: " + (i + 1) + ": ");
            
            numero[i] = leer.nextInt();
        }                

        System.out.println("¡Eh flipao!");
    }
}