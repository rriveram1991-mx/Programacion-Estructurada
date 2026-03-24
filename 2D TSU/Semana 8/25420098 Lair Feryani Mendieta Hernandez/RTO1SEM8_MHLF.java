/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rto.pkg1.sem8_mhlf;

import java.util.Scanner;

/**
 *
 * @author Lair ☆
 */
public class RTO1SEM8_MHLF {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        String[][] nombres = new String[2][3];
int[][] vida = new int[2][3];
int[][] ataque = new int[2][3];
int[][] magia = new int[2][3];
int[][] energia = new int[2][3];
boolean[][] vivo = new boolean[2][3];
int[][] curaciones = new int[2][3];

      for(int i=0;i<2;i++){
          System.out.println("--ingresa nombre del heroe del jugador "+(i+1)+"--");
          for(int j=0;j<3;j++){
              System.out.println("ingresa nombre del heroe "+(j+1));
              nombres[i][j] = leer.nextLine();
          }
      }
      for(int i=0;i<2;i++){
          System.out.println("--ingresa vida del heroe del jugador "+(i+1)+"--");
          for(int j=0;j<3;i++){
              System.out.println("ingresa vida del heroe "+nombres[i][j]);
              vida[i][j] = leer.nextInt();
              }
      }
      for(int i=0;i<2;i++){
          System.out.println("--ingresa ataque del heroe del jugador "+(i+1)+"--");
          for(int j=0;j<3;i++){
              System.out.println("ingresa ataque del heroe "+(j+1));
              ataque[i][j] = leer.nextInt();
              }
      }
      
      
    }
    
}
