/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication76;

import java.util.Scanner;

/**
 *
 * @author Jaime Ismael
 */
public class JavaApplication76 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        //declaracion de las variables
        String[][] nombres = new String[2][3];
         int[][] HP = new int[2][3];
         int[][] HPT = new int [2][3];
         int[][] ATK = new int[2][3];
         int[][] magic = new int[2][3];
         int[][] PC = new int[2][3];
         int[][] PCT = new int[2][3];
         boolean[][] vivo = new boolean[2][3];
         int[][] cura = new int[2][3];
         
         //registro de los datos 
         for (int x =0; x < 2; x++){
             System.out.println("equipo de el jugador "+ (x+1));   
             for (int y =0; y < 3; y++){
                 
                 System.out.println("dame el nombre de el heroe");
                 nombres[x][y] = leer.next();
                 
                 System.out.println("dame la vida de el heroe");
                 HP[x][y] = leer.nextInt();
                 HPT[x][y] = HP[x][y];
                 
                 System.out.println("dame el dano de el ataque fisico ");
                 ATK[x][y] = leer.nextInt();
                 
                 System.out.println("dame el dano de su ataque magico ");
                 magic[x][y] = leer.nextInt();
                 
                 System.out.println("dame los puntos de concentracion para el uso de la magia ");
                 PC[x][y] = leer.nextInt();
                 PCT[x][y] = PC[x][y];
                 
                 vivo[x][y] = true;
                 cura[x][y] = 2;
             }
         }
         
         boolean combate = true;
         //combate
         while (combate){
             //mostrar peladoresd dispomnibles a cada jugador
             System.out.println("jugador 1 heroes disponibles");
             for (int x = 0; x< 3; x++){
                 
                System.out.println("POKEMON: " + nombres[0][x]);
                System.out.println("| HP:  " + HP[0][x]);
                System.out.println("| ATK: " + ATK[0][x]);
            
                 
             }
             //seleccion de heroe
             System.out.println(" eligue un heroe");
             int hero1 = leer.nextInt();
             
             while (HP[0][hero1] <= 0){
                 System.out.println("heroe derrotado, eligue otro");   
                 hero1 = leer.nextInt();
             }
             System.out.println("jugador 2 heroes disponibles");
             for (int x = 0; x< 3; x++){
                 
                System.out.println("POKEMON: " + nombres[1][x]);
                System.out.println("| HP:  " + HP[1][x]);
                System.out.println("| ATK: " + ATK[1][x]);
            
                 
             }
             
             System.out.println(" eligue un heroe");
             int hero2 = leer.nextInt();
             
             while (HP[1][hero2] <= 0){
                 System.out.println("heroe derrotado, eligue otro");   
                 hero2 = leer.nextInt();
             }
             //combate termina cuando la vida de los heroes seleccionados al menos uno de ellos llega a 0
             while (HP[0][hero1] > 0 && HP[1][hero2] > 0){

    
                 System.out.println("que deberia hacer " + nombres[0][hero1]);
                 System.out.println("1. Atacar");
                 System.out.println("2. Ataque Magico");
                 System.out.println("3. Curar");
                 System.out.println("4. Cambiar Heroe");

                  int opcion1 = leer.nextInt();

             switch (opcion1){
//opciones de combate
                     case 1:
                      HP[1][hero2] -= ATK[0][hero1];
                      System.out.println("Ataque fisico!");
                     break;

                      case 2:
                        if (PC[0][hero1] > 0){
                        HP[1][hero2] -= magic[0][hero1];
                        PC[0][hero1]--;
                        System.out.println("Ataque magico!");
                      } else {
                         System.out.println("Sin puntos de magia!");
                        }
                     break;

                   case 3:
                     if (cura[0][hero1] > 0){
                     HP[0][hero1] += 20;
                     if (HP[0][hero1] > HPT[0][hero1]){
                     HP[0][hero1] = HPT[0][hero1];
                     }
                      cura[0][hero1]--;
                      System.out.println("Se curo!");
                     } else {
                     System.out.println("No quedan curaciones!");
                      }
                   break;

                 case 4:
                   System.out.println("Elige nuevo heroe:");
                   hero1 = leer.nextInt();

                   while (HP[0][hero1] <= 0){
                        System.out.println("Heroe derrotado, elige otro:");
                         hero1 = leer.nextInt();
                      }
                    break;
                      }

                     if (HP[1][hero2] < 0) HP[1][hero2] = 0;

                     if (HP[1][hero2] == 0){
                     System.out.println( nombres[1][hero2] + " fue derrotado!");
                    break;
                    }

   //opciones para jugador 2
                      System.out.println("Turno Jugador 2 - " + nombres[1][hero2]);
                      System.out.println("1. Atacar");
                      System.out.println("2. Ataque Magico");
                      System.out.println("3. Curar");
                      System.out.println("4. Cambiar Heroe");

                     int opcion2 = leer.nextInt();

                  switch (opcion2){

                  case 1:
                          HP[0][hero1] -= ATK[1][hero2];
                          System.out.println("Ataque fisico!");
                         break;

                  case 2:
                       if (PC[1][hero2] > 0){
                           HP[0][hero1] -= magic[1][hero2];
                           PC[1][hero2]--;
                           System.out.println("Ataque magico!");
                         } else {
                          System.out.println("Sin puntos de magia!");
                        }
                           break;

                  case 3:
                            if (cura[1][hero2] > 0){
                            HP[1][hero2] += 20;
                            if (HP[1][hero2] > HPT[1][hero2]){
                              HP[1][hero2] = HPT[1][hero2];
                            }
                         cura[1][hero2]--;
                  System.out.println("Se curo!");
                } else {
                    System.out.println("No quedan curaciones!");
             }
                     break;

                 case 4:
                     System.out.println("Elige nuevo heroe:");
                      hero2 = leer.nextInt();

                     while (HP[1][hero2] <= 0){
                   System.out.println("Heroe derrotado, elige otro:");
                      hero2 = leer.nextInt();
                           }
                      break;
                         }
                      //para decidir el ganador 
                 if (HP[0][hero1] < 0) HP[0][hero1] = 0;

                  if (HP[0][hero1] == 0){
                  System.out.println( nombres[0][hero1] + " fue derrotado!");
                      break;
    }
             }
         }
    }
}

             
             
             
             
            
            
         
         
      
    
    

