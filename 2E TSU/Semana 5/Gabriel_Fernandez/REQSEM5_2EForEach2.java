/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package REQSEM5_2EForEach2;

/**
 *
 * @author gl873
 */
public class REQSEM5_2EForEach2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       int[] numeros = {2, 3, 4, 5, 6};
       int resultado = 1;

        for (int n : numeros) {
        resultado *= n;
        }

        System.out.println("El resultado de la multiplicación es: " + resultado);
    }
    
}
