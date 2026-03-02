/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject29;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Mavenproject29 {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int[] num =new int [5];
            for (int i = 0; i < num.length; i++) {
            System.out.print("Ingresa el num: ");
            num[i]=leer.nextInt();
}
        System.out.print("Numeros ");
        for (int i = 0; i < num.length; i++) {
    System.out.println(num[i]);
}

    }
}
