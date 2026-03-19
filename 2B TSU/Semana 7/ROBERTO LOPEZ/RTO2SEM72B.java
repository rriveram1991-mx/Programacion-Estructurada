/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rto2sem72b;

import java.util.Scanner;

/**
 *
 * @author lopez
 */
public class RTO2SEM72B {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner lr = new Scanner(System.in);
        String [][] nombres = new String[2][3];
     int[][] vida = new int [2][3];
     int [][] ataque = new int [2][3];
     for (int j=0; j<2; j++){
         System.out.println("Jugador " + (j + 1)+ ",registra  3 pokemones:");
         for (int c =0; c <3; c++){
             System.out.println("Nombre del Pokemon "+ (c+1)+": ");
             nombres[j][c] = lr.next();
             System.out.println("vida: ");
             vida[j][c] = lr.nextInt();
             System.out.println("Ataque: ");
             ataque[j][c] = lr.nextInt();
         }
     }
     int pokemonA1=0;
     int pokemonA2=0;
        System.out.println("\n============================");
        System.out.println("QUE COMIENCE LA BATALLA!");
        System.out.println("============================\n");
        
        while (pokemonA1 <3 && pokemonA2 <3) {
            System.out.println("¡"+ nombres[0][pokemonA1]+ "ataca!");
            vida[1][pokemonA2] -= ataque[0][pokemonA1];
            
         System.out.println(nombres[1][pokemonA2] + " pierde " + ataque[0][pokemonA1] + " de vida.");   
         System.out.println("Vida restante de " + nombres[1][pokemonA2] + ": " + Math.max(0, vida[1][pokemonA2]));
         System.out.println("----------------------------");
            
            if(vida[1][pokemonA2]<= 0){
             System.out.println("¡" + nombres[1][pokemonA2] + "ha sido derrotado!");
             pokemonA2++; 
                if (pokemonA2 == 3) break; 
                System.out.println("Jugador 2 saca a: " +nombres [1][pokemonA2]);  
                continue;
            }
            System.out.println("¡" + nombres[1][pokemonA2] + " ataca!");
            vida[0][pokemonA1] -= ataque[1][pokemonA2];
            
            System.out.println(nombres[0][pokemonA1] + " pierde " + ataque[1][pokemonA2] + " de vida.");
            System.out.println("Vida restante de " + nombres[0][pokemonA1] + ": " + Math.max(0, vida[0][pokemonA1]));
            System.out.println("----------------------------");
            
            if (vida[0][pokemonA1] <= 0) {
                System.out.println("¡" + nombres[0][pokemonA1] + " ha sido derrotado!");
                pokemonA1++;
                if (pokemonA1 == 3) break; // J2 Gana
                System.out.println("Jugador 1 saca a: " + nombres[0][pokemonA1]);
            }
        }
        System.out.println("\n\n***************************************");
        String ganador = (pokemonA1 < 3) ? "JUGADOR 1" : "JUGADOR 2";
        
        System.out.println("          ___________");
        System.out.println("         '._==_==_=_.'");
        System.out.println("         .-\\\\:      /-."); 
        System.out.println("        | (|:.     |) |");
        System.out.println("         '-|:.     |-'");
        System.out.println("           \\\\::.    /");
        System.out.println("            '::. .' ");
        System.out.println("              ) (");
        System.out.println("            _.' '._");
        System.out.println("           `-------` ");
        System.out.println("      FELICIDADES " + ganador + "!");
        System.out.println("      ERES EL MAESTRO POKEMON");
        System.out.println("***************************************");
        
        lr.close();
        }
    }
    
