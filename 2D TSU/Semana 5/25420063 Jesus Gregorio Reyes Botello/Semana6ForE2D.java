/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.semana6.fore.d;

import java.util.Scanner;

/**
 *
 * @author jessr
 */
public class Semana6ForE2D {

    public static void main(String[] args) {
        Scanner leer = new Scanner (System.in);
        int edad[] = {7,18,14,45,19,17};
        for(int mayor : edad){
        if (mayor >= 18){
          System.out.println("Eres mayor de edad: " + edad);
        }
        }
    }
}
