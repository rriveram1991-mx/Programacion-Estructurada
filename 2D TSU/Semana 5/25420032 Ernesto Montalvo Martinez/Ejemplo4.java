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
public class Ejemplo4 {
    
public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] edades = new int[5];

        for (int i = 0; i < edades.length; i++) {
            System.out.print("Ingrese una edad: ");
            edades[i] = sc.nextInt();
        }

        System.out.println("\nEdades ingresadas:");
        for (int i = 0; i < edades.length; i++) {
            System.out.println(edades[i]);
        }

        int suma = 0;
        for (int i = 0; i < edades.length; i++) {
            suma += edades[i];
        }

        double promedio =(double) suma/edades.length;
        System.out.println("\nPromedio: " + promedio);

    }
}
