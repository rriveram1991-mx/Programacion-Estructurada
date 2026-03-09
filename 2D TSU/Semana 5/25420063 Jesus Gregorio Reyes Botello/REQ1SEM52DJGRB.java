/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.req.sem5.d.jgrb;

import java.util.Scanner;

/**
 *
 * @author jessr
 */
public class REQ1SEM52DJGRB {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Scanner leer = new Scanner (System.in);
        int [] edad = new int [5];
        String[] name = new String [5];
         int contadorMenores = 0;
         int contadorMAyores = 0;
         int contadorAnciano = 0;
        for (int i = 0; i < 5; i++){
           System.out.println("Ingrese su nombre" + (i+1) + ":");
            name[i] = leer.nextLine();
            System.out.println("Ingrese su edad " + name[i] + ":");
            edad[i] = leer.nextInt();
            leer.nextLine();
            while (edad[i] < 0 || edad[i] > 120){
            if (edad[i] < 0 || edad[i] > 120){
                System.out.println("Edad invalida vuelva a intentarlo");
            }
                System.out.println("Ingrese su edad: ");
                edad[i]= leer.nextInt();
                break;
            }
            if (edad[i] < 18){
                  contadorMenores++;
        }
            if(edad[i] >= 18 && edad[i] <=59){
            contadorMAyores++;
            }
            if(edad[i] > 60){
            contadorAnciano++;
            }
        }
         System.out.println("\nDatos capturados:");

        for (int i = 0; i < 5; i++) {
            System.out.println("Nombre: " + name[i] + " - Edad: " + edad[i]);
              
        }
         System.out.println("MENORES DE EDAD: " + contadorMenores);
         System.out.println("MAYORES DE EDAD: " + contadorMAyores);  
         System.out.println("MAYORES DE 60 O MAS: " + contadorAnciano + "Paciente Prioritario");  
    }
}
