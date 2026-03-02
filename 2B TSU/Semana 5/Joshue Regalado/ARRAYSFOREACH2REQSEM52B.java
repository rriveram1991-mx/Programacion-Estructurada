/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arrays.pkgfor.each.pkg2.req.sem5.pkg2b;

import java.util.Scanner;
/**
 *
 * @author jasun
 */
public class ARRAYSFOREACH2REQSEM52B {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        // Pedir cuantos numeros va a ingresar
        System.out.print("Cuantos numeros quieres sumar? ");
        int cantidad = sc.nextInt();
        
        // Crear el array con ese tamaño
        int[] numeros = new int[cantidad];
        
        // Llenar el array con los números que ingresa el usuario
        for (int i = 0; i < cantidad; i++) {
            System.out.print("Ingresa el numero #" + (i + 1) + ": ");
            numeros[i] = sc.nextInt();
        }
        
         // Sumar los numeros usando for-each
        int suma = 0;
        for (int n : numeros) {
            suma += n;
        }
        System.out.println("La suma total es: " + suma);
    }
}
