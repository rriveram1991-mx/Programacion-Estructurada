/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.batallarpg;

import java.util.Scanner;

/**
 *
 * @author jessr
 */
public class BatallaRPG {

    public static void main(String[] args) {
        Scanner leer = new Scanner (System.in);
        String[][] nombres = new String[2][3];
        int[][] vida = new int[2][3];
        int[][] ataque = new int[2][3];
        int[][] magia = new int[2][3];
        int[][] energia = new int[2][3];
        boolean[][] vivo = new boolean[2][3];
        int[][] curaciones = new int[2][3];
        
        int HeroeM1 = 0;
        int HeroeM2 = 0;
        int HeroeM3 = 0;
        
        int menu;
        int j1 = 0, j2 = 0;
        
        for (int i = 0; i < 2; i++){
         System.out.println("Jugador: " + (i+1));
        for (int j = 0; j < 3; j++){
          System.out.println("Ingresa el nombre de tu Heroe: " + (j+1));
          nombres[i][j] = leer.next();
          
          System.out.println("Ingresa la vida de tu Heroe: ");
          vida[i][j] = leer.nextInt();
          
          System.out.println("Ingresa el daño fisico de tu Heroe");
          ataque[i][j] = leer.nextInt();
          
          System.out.println("Ingresa el daño Magico de tu heroe");
          magia[i][j] = leer.nextInt();
          
          System.out.println("Ingrese el mana inicial de tu Heroe");
          energia[i][j] = leer.nextInt();
          
          vivo[i][j] = true;
        }
         System.out.println("");
        }
        
        while(HeroeM1 < 3 || HeroeM2 < 3 ){
            System.out.println("Seleccione el Heroe del jugador no.1 (0-2)");
            j1 = leer.nextInt();
            
            System.out.println("Seleccione el Heroe del jugadoe no.2 (0-2)");
            j2 = leer.nextInt();
            
            while(vida[0][j1] > 0 && vida[1][j2] > 0 ){
                System.out.println("------------MENU-----------");
                System.out.println("Escoga cualquier opcion");
                menu = leer.nextInt();
                System.out.println("1.Ataque fisico");
                System.out.println("2.Ataque magico");
                System.out.println("3.Curarse");
                System.out.println("4.Cambiar Heroe");
                
                switch (menu){
                    case 1 :
                        if(vivo[0][j1]){
                            System.out.println("El heroe del jugador no.1 esta vivo");
                            System.out.println("Ataca:" + nombres[0][j1]);   
                            vida[1][j2] -= ataque[0][j1];
                            System.out.println(nombres[1][j2] + " pierde:" + ataque[0][j1] + " de vida ");
                            System.out.println("Vida restante del Heroe del jugador No.2:" + vida[1][j2]);
                            if(vivo[0][j1]){
                            int daño = ataque[0][j1];
                            int prob = (int)(Math.random()* 100);
                            if(prob < 20){
                            daño *= 2;
                                System.out.println("Golpe critico");
                            }
                             vida[1][j2] -= daño;
                             if(vida[1][j2] <= 0){
                            vivo[1][j2] = false;
                                 System.out.println(nombres[1][j2] + " Ha sido derrotado");
                            }
                            }
                        }else{
                            System.out.println("El heroe esta tieso asi como los 43 de ayotzinapa");
                        }
                        
                        if (vida[1][j2] <= 0) {
                        vivo[1][j2] = false;
                        System.out.println(nombres[1][j2] + " ha sido derrotado!");
                        HeroeM2++;
                        break;
                      }
                        
                        
                       if(vivo[1][j2]){
                            System.out.println("El heroe del jugador no.2 esta vivo");
                            System.out.println("Ataca:" + nombres[1][j2]); 
                            System.out.println(nombres[0][j1] + "pierde:" + ataque[1][j2] + " de vida ");
                            vida[0][j1] -= ataque[1][j2];
                            System.out.println("Vida restante del Heroe del jugador No.1: " + vida[0][j1]);
                             if(vivo[0][j1]){
                            int daño = ataque[0][j1];
                            int prob = (int)(Math.random()* 100);
                            if(prob < 20){
                            daño *= 2;
                                System.out.println("Golpe critico");
                            }
                             vida[1][j2] -= daño;
                             if(vida[1][j2] <= 0){
                            vivo[1][j2] = false;
                                 System.out.println(nombres[1][j2] + " Ha sido derrotado");
                            }
                            }
                       }else{
                           System.out.println("El heore esta muerto asi como la gente de israel e irak");
                       }
                       
                         if (vida[0][j1] <= 0) {
                        vivo[0][j1] = false;
                        System.out.println(nombres[0][j1] + " ha sido derrotado!");
                        HeroeM1++;
                        break;
                      }
                         
                          if (HeroeM1 == 3) {
                              System.out.println("\nJugador 2 gana!");
                           } else {
                              System.out.println("\nJugador 1 gana!");
                           }
                    break;
                    
                    case 2:
                        if(energia[0][j1] >= 10){
                        System.out.println("Jugador No.1 ataca con un Ataque Magico:" + nombres[0][j1]);   
                        System.out.println(nombres[1][j2] + " pierde " + magia[0][j1] + "de vida");
                        vida[1][j2] -= magia[0][j1];
                        System.out.println("Vida restante del Heroe del jugador No.2:" + vida[1][j2]);
                        energia[0][j1] -= 10; 
                        System.out.println("Energia restante del Heroe del jugador NO.1:" + energia[0][j1]);
                        if(vivo[0][j1]){
                            int daño = ataque[0][j1];
                            int prob = (int)(Math.random()* 100);
                            if(prob < 20){
                            daño *= 2;
                                System.out.println("Golpe critico");
                            }
                             vida[1][j2] -= daño;
                             if(vida[1][j2] <= 0){
                            vivo[1][j2] = false;
                                 System.out.println(nombres[1][j2] + " Ha sido derrotado");
                            }
                            }
                        }
                      if (vida[1][j2] <= 0) {
                        System.out.println(nombres[1][j2] + " ha sido derrotado!");
                        HeroeM2++;
                        break;
                      }
                        
                        
                        
                      if(energia[1][j2] >= 10){
                       System.out.println("Jugador No.2 ataca con un Ataque Magico:" + nombres[1][j2]);   
                       System.out.println(nombres[0][j1] + " pierde " + magia[1][j2] + "de vida");
                       vida[0][j1] -= magia[1][j2];
                       System.out.println("Vida restante del Heroe del jugador No.1:" + vida[0][j1]);
                       energia[1][j2] -= 10;
                       System.out.println("Energia restante del Heroe del jugador NO.2:" + energia[1][j2]);
                       if(vivo[0][j1]){
                            int daño = ataque[0][j1];
                            int prob = (int)(Math.random()* 100);
                            if(prob < 20){
                            daño *= 2;
                                System.out.println("Golpe critico");
                            }
                             vida[1][j2] -= daño;
                             if(vida[1][j2] <= 0){
                            vivo[1][j2] = false;
                                 System.out.println(nombres[1][j2] + " Ha sido derrotado");
                            }
                            } 
                      }
                      
                       if (vida[0][j1] <= 0) {
                        System.out.println(nombres[0][j1] + " ha sido derrotado!");
                        HeroeM1++;
                        break;
                      }  
                      
                            if (HeroeM1 == 3) {
                              System.out.println("\nJugador 2 gana!");
                           } else {
                              System.out.println("\nJugador 1 gana!");
                           }
                      break;
                      
                    case 3:
                        System.out.println("¿Deseas que tu Heroe recupere vida jugador No.1? (True or False)");
                        boolean DeseoVidaj1 = leer.nextBoolean();
                        if (DeseoVidaj1 == true){
                         if(curaciones[0][j1] < 2){
                         vida [0][j1] += 20;
                         System.out.println("El jugador NO.1 a recuperado 20 de vida");
                         curaciones[0][j1]++;
                         }else{
                             System.out.println("El jugador No.1 a usado el maximo de curaciones disponibles");
                         }
                        }
                        
                        System.out.println("¿Deseas que tu Heroe recupere vida jugador No.2? (True or False)");
                        boolean DeseoVidaj2 = leer.nextBoolean();
                        if(DeseoVidaj2 == true){
                            if(curaciones[1][j2] < 2){
                            vida [0][j1] += 20;
                            System.out.println("El jugador NO.2 a recuperado 20 de vida");
                            curaciones[1][j2]++;
                            }else{
                                System.out.println("El jugador No.2 a usado el maximo de curaciones disponibles");
                            }
                        }
                        break;
                        
                    case 4:
                        System.out.println("¿El jugador No.1 desea cambiar de heroe?");
                        boolean cambio1 = leer.nextBoolean();
                        if(cambio1 == true){
                             for (int i = 0; i < 3; i++) {
                              System.out.println(i + ". " + nombres[0][i] + " Vida: " + vida[0][i]);
                             }

                             int nuevo = leer.nextInt();

                             if (vivo[0][nuevo]) {
                              j1 = nuevo;
                               System.out.println("Has cambiado a: " + nombres[0][j1]);
                            } else {
                               System.out.println("Ese héroe no está disponible");
                            }
                        }
                        
                        System.out.println("¿El jugador No.2 desea cambiar de heroe?");
                        boolean cambio2 = leer.nextBoolean();
                        if(cambio2 == true){
                         for (int i = 0; i < 3; i++) {
                              System.out.println(i + ". " + nombres[0][i] + " Vida: " + vida[0][i]);
                             }

                             int nuevo = leer.nextInt();

                             if (vivo[0][nuevo]) {
                              j1 = nuevo;
                               System.out.println("Has cambiado a: " + nombres[0][j1]);
                            } else {
                               System.out.println("Ese héroe no está disponible");
                            }
                        }
                        break;
                    default:
                       
                      
            }
                
            }
        }
    }
}
