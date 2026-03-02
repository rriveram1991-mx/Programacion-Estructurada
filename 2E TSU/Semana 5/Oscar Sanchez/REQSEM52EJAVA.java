/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package req.sem5.pkg2e.java;

/**
 *
 * @author Oscar Sanchez
 */
public class REQSEM52EJAVA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] numeros = {10, 20, 30, 40, 50}; // Definimos un arreglo de enteros
        int total = 0; // Variable para ir acumulando la suma

        // El for-each dice: "Por cada entero 'n' que exista dentro de 'numeros'..."
        for (int n : numeros) { 
            total += n; // Sumamos el valor de 'n' al total actual
        }

        System.out.println("La suma total es: " + total); // Mostramos el resultado final
    }
}