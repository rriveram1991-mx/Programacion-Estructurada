/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package req.sem5.pkg2d.pkg2;

import java.util.Scanner;

/**
 *
 * @author STAR KRIS
 */
public class REQSEM52D2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        


        Scanner leer = new Scanner(System.in);

        // Creamos un array de tamaño 5
        int[] numeros = new int[5];

        // Pedimos al usuario que ingrese los valores
        System.out.println("Ingresa 5 números enteros:");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            numeros[i] = leer.nextInt();
        }

        // Usamos for-each para recorrer el array
        System.out.println("\nLos números ingresados son:");
        for (int numero : numeros) {
            System.out.println(numero);
        }

        // Ejemplo adicional: calcular la suma con for-each
        int suma = 0;
        for (int numero : numeros) {
            suma += numero;
        }
        System.out.println("\nLa suma de los números es: " + suma);

        leer.close();
    }
}

    
