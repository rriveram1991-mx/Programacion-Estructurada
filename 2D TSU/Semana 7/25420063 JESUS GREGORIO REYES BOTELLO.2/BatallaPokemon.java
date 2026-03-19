/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.batallapokemon;

import java.util.Scanner;

/**
 *
 * @author jessr
 */
public class BatallaPokemon {

    public static void main(String[] args) {
        Scanner leer = new Scanner (System.in);
        boolean usuario = false;
        String [][] POKEMONES = new String[2][3];
        
        
        int [][] Daño = new int[2][3];
        
        int [][] HP = new int[2][3];
        int PokemonMuerto1 = 0;
         int PokemonMuerto2 = 0;
        //En el primer for se pide a los jugadotres (Jugador 1 y Jugador 2)
        for (int i = 0; i < 2; i++){
            System.out.println("Jugador: " + (i+1));
        //En este for se pide al pokemon, Daño y el HP 3 de cada cosa
            for (int j = 0; j < 3; j++){
            System.out.print("Pokemon: " + (j+1));
            POKEMONES[i][j] = leer.next();
           
           System.out.println("Daño:");
           Daño[i][j] = leer.nextInt();
          
           System.out.println("Vida:");
          HP[i][j] = leer.nextInt();
           
        }
            System.out.println("");
        }
        
        while(PokemonMuerto1 < 3 || PokemonMuerto2 < 3){
            System.out.println("Selecciona el pokemon j1 0-2");
            int j1 = leer.nextInt();
            
            System.out.println("Selecciona el pokemon j2 0-2");
            int j2 = leer.nextInt();
            //En esta condicion se evalua que los pokemones esten vivos
            if(HP[0][j1] <= 0 || HP[1][j2] <= 0){
             System.out.println("Una de las criaturas ya está derrotada. Elige otra.");
              continue;
            }
            //En este while es para los turnos de los jugadores
            while(HP[0][j1] > 0 && HP[1][j2] > 0){
                //TURNO DEL JUGADOR 1
                //Seleccion del pokemon[jugador 1][pokemon escrito]
                System.out.println("Jugador NO.1 Ataca:" + POKEMONES[0][j1]);
                //vida escrita del pokemon del jugador 2 menos el daño escrito del pokemon del jugador 1
                HP[1][j2] -= Daño[0][j1];
                //El pokemon del jugador 2 pierde el daño causado del pokemon del jugador 1
                System.out.println(POKEMONES[1][j2] + " pierde " + Daño[0][j1] + " de vida");
                //vida restante del pokemon del jugador 2
                System.out.println("Vida restante: " + HP[1][j2]);
// si la vida del pokemon del jugador 2 es mnor o igual a 0 imprime ha sido derrotado
                if (HP[1][j2] <= 0) {
                    System.out.println(POKEMONES[1][j2] + " ha sido derrotado!");
                    PokemonMuerto2++;
                    break;
                }
                //TURNO DEL JUGADOR 2 es l mismo que el anterior pero al reves
                System.out.println("Jugador NO.2 Ataca:" + POKEMONES[1][j2]);
                HP[0][j1] -= Daño[1][j2];
                System.out.println(POKEMONES[0][j1] + " pierde " + Daño[1][j2] + " de vida");
                System.out.println("Vida restante: " + HP[0][j1]);

                if (HP[0][j1] <= 0) {
                    System.out.println(POKEMONES[1][j1] + " ha sido derrotado!");
                    PokemonMuerto1++;
                    break;
                }
                //CONDICION QUE COMPARA QUE SI LOS 3 POKEMONES DEL JUGADOR 1 MUEREN MUESTRE GANA JUGADOR 2 SINO JUGADOR 1
                if (PokemonMuerto1 == 3) {
            System.out.println("\nJugador 2 gana!");
        } else {
            System.out.println("\nJugador 1 gana!");
        }

                
            }
        
        }
       
         
    }
}
