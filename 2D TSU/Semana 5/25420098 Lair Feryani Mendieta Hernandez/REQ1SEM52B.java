/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package req1.sem5.pkg2b;

import java.util.Scanner;

/**
 *
 * @author Lair ☆
 */
public class REQ1SEM52B {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        double [] compras = new double[5];
        for (int i = 0; i < compras.length; i++){ 
            System.out.println("ingrese el gasto de sus compras: ");
            compras[i] = leer.nextDouble();
        }
        System.out.println("compras hechas:");
        for(int i= 0; i< compras.length; i++){
            System.out.println(compras[i]);
        
        }
        }
        
    }
    

