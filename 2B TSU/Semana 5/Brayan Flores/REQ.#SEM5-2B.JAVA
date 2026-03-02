/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package array;

import java.util.Scanner;

public class Promedio {
    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        System.out.println("====================");
        double[] notas = new double[5];
        double suma = 0;

        for (int i = 0; i < notas.length; i++) {
            System.out.println("Ingrese la nota:");
            notas[i] = leer.nextDouble();
            suma += notas[i];
        }

        double promedio = suma / notas.length;
        System.out.println("El promedio es: " + promedio);
    }
}