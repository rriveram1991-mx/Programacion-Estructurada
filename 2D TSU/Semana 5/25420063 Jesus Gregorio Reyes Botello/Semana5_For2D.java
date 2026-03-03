/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.semana5_for2d;

import java.util.Scanner;

/**
 *
 * @author jessr
 */
public class Semana5_For2D {

    public static void main(String[] args) {
        Scanner leer = new Scanner (System.in);
        int num[] = {0,10,7,100,78};
        boolean valido = false;
        System.out.println("Ingrese un numero: ");
        int N = leer.nextInt();
        for (int n : num){
        if (n == N){
         valido = true;
         break;
        }
        }
        if (valido){
            System.out.println("El numero esta en la lista");
        }else{
            System.out.println("El numero no esta en la lista");
        }
    }
}
