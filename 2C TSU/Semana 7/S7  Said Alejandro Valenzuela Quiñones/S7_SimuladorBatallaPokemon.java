/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package s7_simuladorbatallapokemon;

import java.util.Scanner;

public class S7_SimuladorBatallaPokemon {

    public static void main(String[] args) {
        // Scanner
        Scanner sc = new Scanner(System.in);
        
        // Arrays
        String[][] nombres = new String[2][3];
        int[][] vida = new int[2][3];
        int[][] ataque = new int[2][3];
        
        for(int jugador = 0; jugador < 2; jugador++){
            System.out.println("=== REGISTRO JUGADOR " + (jugador + 1) + " ===");
            
            for(int i = 0; i < 3; i++){
                System.out.println("Pokemon " + (i + 1) + ":");
                nombres[jugador][i] = sc.nextLine();
            
                System.out.println("HP:");
                vida[jugador][i] = sc.nextInt();
                
                System.out.println("Ataque:");
                ataque[jugador][i] = sc.nextInt();
                sc.nextLine();
            }
        }
        
        int derrotadosJ1 = 0;
        int derrotadosJ2 = 0;
        
        while(derrotadosJ1 < 3 && derrotadosJ2 < 3){
            System.out.println("\nJugador 1 elige Pokemon:");
            for(int i = 0; i < 3; i++){
                if(vida[0][i] > 0){
                    System.out.println(i + " - " + nombres[0][i] + " (HP: " + vida[0][i] + ")");
                }
                else{
                    System.out.println(i + " - " + nombres[0][i] + "(Derrotado)");
                }
            }
            
            int c1 = sc.nextInt();
            
            if(vida[0][c1] <= 0){
                System.out.println("Pokemon derrotado");
                continue;
            }
            
            System.out.println("\nJugador 2 elige Pokemon:");
            for(int i = 0; i < 3; i++){
                if(vida[1][i] > 0){
                    System.out.println(i + " - " + nombres[1][i] + " (HP: " + vida[1][i] + ")");
                }
                else{
                    System.out.println(i + " - " + nombres[1][i] + " (Derrotado)");
                }
            }
            
            int c2 = sc.nextInt();
                   
            if(vida[1][c2] <= 0){
                System.out.println("Pokemon derrotado");
                continue;
            }
            
            System.out.println("=== INICIA LA BATALLA ===");
            System.out.println(nombres[0][c1] + " VS " + nombres[1][c2]);
            
            while(vida[0][c1] > 0 && vida[1][c2] > 0){
                // Jugador 1
                vida[1][c2] -= ataque[0][c1];
                System.out.println("\n" + nombres[0][c1] + " ataca y hace " + ataque[0][c1] + " de daño");
                
                if(vida[1][c2] <= 0){
                    System.out.println("\n" + nombres[1][c2] + " fue derrotado");
                    derrotadosJ2++;
                    break;
                }
                
                System.out.println("Vida restante de " + nombres[1][c2] + ": " + vida[1][c2]);
                
                // Jugador 2
                vida[0][c1] -= ataque[1][c2];
                System.out.println("\n" + nombres[1][c2] + " ataca y hace " + ataque[1][c2] + " de daño");
                
                if(vida[0][c1] <= 0){
                    System.out.println("\n" + nombres[0][c1] + " fue derrotado");
                    derrotadosJ1++;
                    break;
                }
                
                System.out.println("Vida restante de " + nombres[0][c1] + ": " + vida[0][c1]);
            }
        }
        
        if(derrotadosJ1 == 3){
            System.out.println("\n Jugador 2 gana");
        }
        else{
            System.out.println("\n Jugador 1 gana");
        }
        
    }
    
}
