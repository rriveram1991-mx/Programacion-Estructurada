/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package req.sem5.pkg2b.java.pkg02.pkg03.pkg26;

import java.util.Scanner;

/**
 *
 * @author Lex
 */
public class REQSEM52BJAVA020326 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Scanner leer = new Scanner(System.in);
        int[] numeros = new int[5]; //defino el array
        //llenar el array
        for (int i = 0; i<numeros.length; i++){
            System.out.println("Ingrese un numero: ");
            numeros[i] = leer.nextInt();
        }
        //mostrar el array
        System.out.println("Numeros ingresados: ");
        for (int i = 0; i < numeros.length; i++){
            System.out.println(numeros[i]);
        }
    }
    
}
