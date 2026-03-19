/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rto.pkg2.sem7.pkg2d.sra;

import java.util.Scanner;

/**
 *
 * @author crist
 */
public class RTO2SEM72DSRA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     

  
        Scanner LEER = new Scanner(System.in);
         // Estas son matrices bidimensionales para guardar los datos de ambos jugadores
        String[][] nombres = new String[2][3]; // Nombres de puchamones
        int[][] vida = new int[2][3];          // Vida de cada puchamon
        int[][] ataque = new int[2][3];        // Ataque de cada puchamon

     

       // Este es un  registro que lleva los puchamones usando for
        for (int j = 0; j < 2; j++) { // El for me ayuda a recorre los 2 jugadores
            System.out.println("Jugador" + (j + 1) + "=");

            for (int i = 0; i < 3; i++) {     //Aqui a Cada jugador se registra 3 puchamones
                System.out.print("Nombre: ");
                nombres[j][i] = LEER.next(); // Guarda el nombre del usuario

                System.out.print("Vida: ");
                vida[j][i] = LEER.nextInt(); // Guarda la vida 

                System.out.print("Ataque: ");
                ataque[j][i] = LEER.nextInt(); //y  guarda el ataque
            
           
            }
        }
  // Variables para controlar qué puchamon está activo
        int actualJ1 = 0;
        int actualJ2 = 0;
 // Contadores de puchamones derrotados
        int derrotadosJ1 = 0;
        int derrotadosJ2 = 0;

         // while principal: se ejecuta hasta que un jugador pierda todos
        while (derrotadosJ1 < 3 && derrotadosJ2 < 3) {

          
            if (vida[0][actualJ1] <= 0) {
                derrotadosJ1++;
                actualJ1++;
                if (actualJ1 < 3) {
                    System.out.println("Jugador 1 envía a " + nombres[0][actualJ1]);
                }
                continue;
            }
  // Si el puchamon del jugador 1 ya murió
            if (vida[1][actualJ2] <= 0) {
                derrotadosJ2++;   // Aumenta derrotados
                actualJ1++;           // Cambia al siguiente puchamon
                if (actualJ2 < 3) {
                    System.out.println("Jugador 2 envía a " + nombres[1][actualJ2]);
                }
                continue;
            }

           // Mostrar qué puchamones están peleando
            System.out.println("Jugador 1 elige: " + nombres[0][actualJ1]);
            System.out.println("Jugador 2 elige: " + nombres[1][actualJ2]);
            System.out.println();
       // Turno del jugador 1
            System.out.println(nombres[0][actualJ1] + " Ataca");
            vida[1][actualJ2] -= ataque[0][actualJ1];

            System.out.println(nombres[1][actualJ2] + " Pierde " + ataque[0][actualJ1] + " De vida");
        
            if (vida[1][actualJ2] <= 0) {
                System.out.println(nombres[1][actualJ2] + " Ha sido derrotado");
                continue;
            } else {
                System.out.println("Vida restante: " + vida[1][actualJ2]);
            }

            System.out.println(); //Este esta aqui porque va a imprimir la vida por decir del pokemon

            // Turno del jugador 2
            System.out.println(nombres[1][actualJ2] + " ataca");
            vida[0][actualJ1] -= ataque[1][actualJ2];

            System.out.println(nombres[0][actualJ1] + " pierde " + ataque[1][actualJ2] + " de vida");

            if (vida[0][actualJ1] <= 0) {
                System.out.println(nombres[0][actualJ1] + " ha sido derrotado");
            } else {
                System.out.println("Vida restante: " + vida[0][actualJ1]);
            }

            System.out.println();
        }

                // Determinar ganador final  
        if (derrotadosJ1 == 3) {
            System.out.println("Jugador 2 gana");
        } else {
            System.out.println("Jugador 1 gana");
        }

        
    }
}

