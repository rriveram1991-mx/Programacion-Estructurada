/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rto.pkg2.sem7.pkg2d.rcmc;

import java.util.Scanner;

/**
 *
 * @author STAR KRIS
 */
public class RTO2SEM72dRCMC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner leer=new Scanner(System.in);
        //crear arrays bidemensionales para los nombres, los ataques y la vida
        String[][] nombresdepokemon=new String [2][3];
        int[][] vidadpkmn=new int[2][3];
        int[][]ataque=new int [2][3];
        //para ver si es derrotado o no
        boolean[][]derrota=new boolean [2][3];
        //empezar a registrar los datros con el for each
        for(int j=0;j<2;j++){
            System.out.println("Jugador: "+(j+1)+"..");
            //ciclo para cada jugador
            for(int c=0;c<3;c++){
                System.out.println("Nombre de el pokemon: "+(c+1)+": ");
                nombresdepokemon[j][c]=leer.next();
                System.out.println("Vida (hp): ");
                vidadpkmn[j][c] = leer.nextInt();
                System.out.print("Puntos de Ataque: ");
                ataque[j][c] = leer.nextInt();
                derrota[j][c] = false;
            }
        }
System.out.println("La batalla comienza ahora");

        int derrotasJ1 = 0, derrotasJ2 = 0;

        // usar while para las batallas
        // El ciclo sigue hasra q tengan solo un pokemon
        while (derrotasJ1 < 3 && derrotasJ2 < 3) {
            
            // escoger criqaturas
            System.out.println("seleccionar");
            System.out.println("Jugador 1, elige tu pokemon (0, 1, 2):");
            int c1 = leer.nextInt();
            while(derrota[0][c1]) {
                System.out.println("Esa pokemon ya se murio. Elige otra:");
                c1 = leer.nextInt();
            }
             //para el 2
             System.out.println("Jugador 2, elige tu pokemon (0, 1, 2):");
            int c2 = leer.nextInt();
            while(derrota[1][c2]) {
                System.out.println("Eseb pokemon ya se murio. Elige otro we:");
                c2 = leer.nextInt();
            }
    System.out.println("" + nombresdepokemon[0][c1] + " vs " + nombresdepokemon[1][c2]);

            // compwtir 
            while (vidadpkmn[0][c1] > 0 && vidadpkmn[1][c2] > 0) {
                // Atacar jugador 1
                System.out.println("\n" + nombresdepokemon[0][c1] + " atacar ya ");
                vidadpkmn[1][c2] -= ataque[0][c1];
                System.out.println(nombresdepokemon[1][c2] + " pierde " + ataque[0][c1] + " de vida. Restante: " + Math.max(0, vidadpkmn[1][c2]));

                if (vidadpkmn[1][c2] <= 0) {
                    System.out.println(nombresdepokemon[1][c2] + " has perdido");
                    derrota[1][c2] = true;
                    derrotasJ2++;
                    break; //salir del combate
                }
           // Ataque del jugador dos
                System.out.println("" + nombresdepokemon[1][c2] + " ataca ya");
                vidadpkmn[0][c1] -= ataque[1][c2];
                System.out.println(nombresdepokemon[0][c1] + " pierdeeeeeeeeee " + ataque[1][c2] + " de vida te queda. sobrante: " + Math.max(0, vidadpkmn[0][c1]));

                if (vidadpkmn[0][c1] <= 0) {
                    System.out.println(nombresdepokemon[0][c1] + " ha sido derrotado!");
                    derrota[0][c1] = true;
                    derrotasJ1++;
                }
            }
        }
        // mostrar los resultados de quien ha ganado y asi
        if (derrotasJ2 == 3) {
            System.out.println("Los pokemnone del jugador dow ya se murieron. nimodo ");
            System.out.println("gana el jugador uno");
        } else {
            System.out.println("los pokemones del jugador uno ya se murieron. bye bye looser");
            System.out.println("gana el jugador dos");
        }
        
        leer.close();
    }
} 
    
