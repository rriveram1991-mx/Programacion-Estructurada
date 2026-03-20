/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication75;

import java.util.Scanner;

/**
 *
 * @author Jaime Ismael
 */
public class JavaApplication75 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     
        Scanner leer = new Scanner(System.in);
        
        String[][] nombres = new String [2][3];
        int[][] HP = new int [2][3];
        int[][] HPT = new int [2][3];
        int[][] ATK = new int [2][3];
        
        //registro de pokemon por jugador
        for (int x = 0; x < nombres.length; x++){
            System.out.println("equipo de el jugador " + (x+1));
            for (int y = 0; y < 3; y++){
                
                System.out.println("dame el nombre de el pokemon " + (y+1));
                nombres[x][y] = leer.next();
                
                System.out.println("dame la vida de el pokemon " + (y+1));
                HP[x][y] = leer.nextInt();
                HPT[x][y]= HP[x][y];
                System.out.println("dame el ataque de el pokemon " + (y+1));
                ATK[x][y] = leer.nextInt();
              
            } 
        }
        //combate
            boolean combate = true;
        while (combate){
            //menu de entrenadores
            System.out.println("----Equipo de entrenador 1 ----");
            for (int x = 0; x < 3; x++){
                System.out.println("POKEMON: " + nombres[0][x]);
                System.out.println("| HP:  " + HP[0][x]);
                System.out.println("| ATK: " + ATK[0][x]);
            }
                System.out.println("eligue pokemon: ");
                int poke1 = leer.nextInt();
                
                          while (HP[0][poke1] < 0){
                    System.out.println("Pokemon derrotado!!!");
                    System.out.println("eligue otro pokemon");
                    
                    poke1= leer.nextInt();
                }
             System.out.println("----Equipo de entrenador 2----");       
             for (int x = 0; x < 3; x++){
                System.out.println("POKEMON: " + nombres[1][x]);
                System.out.println("| HP:  " + HP[1][x]);
                System.out.println("| ATK: " + ATK[1][x]);
            }
                System.out.println("eligue pokemon: ");
                int poke2 = leer.nextInt();
                
                while (HP[1][poke2] < 0){
                    System.out.println("Pokemon derrotado!!!");
                    System.out.println("eligue otro pokemon");
                    
                    poke2= leer.nextInt(); 
                 
             } //combate por turnos
                 while (HP[0][poke1] > 0 && HP[1][poke2] > 0){

                  int barraTotal = 10;

    
                  HP[1][poke2] -= ATK[0][poke1];
                    if (HP[1][poke2] < 0){
                     HP[1][poke2] = 0;
                     }

                      System.out.println("\n" + nombres[0][poke1] + " ataca!!!");

   
                     int llenos2 = (HP[1][poke2] * barraTotal) / HPT[1][poke2];

                      System.out.print(nombres[1][poke2] + " ");
                      //sistema de barras de vida 
                      System.out.print("HP: " + HP[1][poke2] + "/" + HPT[1][poke2] + " [");

                      for (int x = 0; x < llenos2; x++){
                        System.out.print("=");
                        }
                      for (int x = llenos2; x < barraTotal; x++){
                         System.out.print("-");
                           }
                         System.out.println("]");

                       if (HP[1][poke2] == 0){
                           System.out.println("Pokemon derrotado!");
                       break;
                        }

    
                         HP[0][poke1] -= ATK[1][poke2];
                          if (HP[0][poke1] < 0){
                          HP[0][poke1] = 0;
                           }

                           System.out.println("\n" + nombres[1][poke2] + " ataca!!!");

                           //variable para medir el total de la barra de vida
                          int llenos1 = (HP[0][poke1] * barraTotal) / HPT[0][poke1];

                           System.out.print(nombres[0][poke1] + " ");
                              System.out.print("HP: " + HP[0][poke1] + "/" + HPT[0][poke1] + " [");
                               //la barra solo se imprime hasta la cantidad de vida que tiene 
                           for (int x = 0; x < llenos1; x++){
                               System.out.print("=");
                              }//la vida faltante se imprime como "-"
                           for (int x = llenos1; x < barraTotal; x++){
                              System.out.print("-");
                               }
                              System.out.println("]");

                            if (HP[0][poke1] == 0){
                             System.out.println(" Pokemon derrotado!");
                              break;
                              }

                             System.out.println("\n----------------------");
                             }
                 
                 //decidir el ganador con un arreglo que recorra la vida de los tres pokemones de cada uno
                          int vivos1 = 0;
                          int vivos2 = 0;

                         for (int x = 0; x < 3; x++){
                           if (HP[0][x] > 0) vivos1++;
                           if (HP[1][x] > 0) vivos2++;
                           }
//el que tenga sus tres pokemones sin vida pierde 
                          if (vivos1 == 0){
                         System.out.println("GANA JUGADOR 2");
                     combate = false;
                           }
                         else if (vivos2 == 0){
                           System.out.println("GANA JUGADOR 1");
                            combate = false;
                            } 
                
                    
                    
                        }
                  }
                
                //mi programa favorito hasta ahora 
    // recorde por que amo esta carrera 
             }
            
        
        
    
    

