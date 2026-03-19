/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rto.pkg2.sem7.mhlf;

import java.util.Scanner;

/**
 *
 * @author Lair ☆
 */
public class RTO2SEM7MHLF {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
   Scanner leer = new Scanner(System.in);
     
        String [][] nom = new String [2] [3];
        double [] [] dano = new double [2] [3];
        double [] [] vida = new double [2] [3];
        boolean r=false;
        boolean b=false;
        
        while(!r){
            for(int i=0;i<2;i++){
                System.out.println("ingresa nombre del pokemon del juador "+(i+1));
                for(int f=0;f<3;f++){
                    System.out.println("ingresa el nombre del pokemon "+(f+1));
                    nom[i][f] = leer.nextLine();
                } 
            }
            for(int i=0;i<2;i++){
                System.out.println("Dano del jugador "+(i+1));
                for(int f=0;f<3;f++){
                    System.out.println("ingresa el dano del pokemon "+(f+1));
                    dano[i][f] = leer.nextDouble();
                } 
            }
            for(int i=0;i<2;i++){
                System.out.println("ingresa vida del pokemon del juagor "+(i+1));
                for(int f=0;f<3;f++){
                    System.out.println("ingresa la vida del pokemon "+(f+1)+" del jugador "+i);
                    vida[i][f] = leer.nextDouble();
                } 
            }    
            leer.nextLine();
            int d1=0;
            int d2=0;
            
            while(!b){
                int pok1,pok2;
                System.out.println("jugador 1 escoje tu pokemon");
                System.out.println("pokemon 1: "+nom[0][0]+" pokemon 2: "+nom[0][1]+" pokemon 3: "+nom[0][2]);
                pok1 = leer.nextInt()-1;
                leer.nextLine();
                
                System.out.println("jugador 2 escoje tu pokemon"); 
                System.out.println("pokemon 1: "+nom[1][0]+" pokemon 2: "+nom[1][1]+" pokemon 3: "+nom[1][2]);
                pok2 = leer.nextInt()-1;
                leer.nextLine();
                
                boolean t=false;
                while(!t){
                    System.out.println("\njugador 1 escoje a "+nom[0][pok1]);
                    System.out.println("jugador 2 escoje a "+nom[1][pok2]);
      
                    System.out.println("\n"+nom[0][pok1]+" ataca a "+nom [1][pok2]);
                    vida[1][pok2]-=dano[0][pok1];
                    System.out.println("jugador 2 pierde "+dano[0][pok1]+" de vida");
                    double vr2 = (vida[1][pok2] < 0) ? 0 : vida[1][pok2];// se usa para no dejar un 0 
                    System.out.println("vida restante "+vr2);
                    
                    if(vida[1][pok2] <= 0){
                        System.out.println(nom[1][pok2]+" fuera de combate");
                        d2++;
                        t=true;
                    } else {
                        System.out.println("\nturno de jugador 2");
                        System.out.println(nom[1][pok2]+" ataca");
                        vida[0][pok1]-=dano[1][pok2];

                        double vr1 = (vida[0][pok1] < 0) ? 0 : vida[0][pok1];
                        System.out.println("vida restante "+vr1);
                  
                        if(vida[0][pok1] <= 0){
                            System.out.println("\n" + nom[0][pok1] + " pokemon ha sido derrotado");
                            d1++;
                            t=true;
                        }
                    }
                }
                
                if(d1==3 || d2==3){
                    b=true;
                }
            }
            
            if(d2 == 3) {
                System.out.println("\nJugador 1 gana!");
            } else {
                System.out.println("\nJugador 2 gana!");
            }
            r = true;
        }
    }
}
    

