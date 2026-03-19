/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package puchamonesss;
import java.util.Scanner;
/**
 *
 * @author leidy
 */
public class Puchamonesss {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[][] nombres = new String[2][3];
        Scanner read=new Scanner(System.in);
        int[][] vida = new int[2][3];
        int[][] ataque = new int[2][3];
        
        // REGISTRO con FOR
        System.out.println("JUGADOR 1 - Tus 3 puchamones:");
        for (int i = 0; i < 3; i++) {
            System.out.print("Nombre: ");
            nombres[0][i] = read.next();
            System.out.print("Vida: ");
            vida[0][i] = read.nextInt();
            System.out.print("Ataque: ");
            ataque[0][i] = read.nextInt();
            System.out.println();
        }
        
        System.out.println("\nJUGADOR 2 - Tus 3 puchamones:");
        for (int i = 0; i < 3; i++) {
            System.out.print("Nombre: ");
            nombres[1][i] = read.next();
            System.out.print("Vida: ");
            vida[1][i] = read.nextInt();
            System.out.print("Ataque: ");
            ataque[1][i] = read.nextInt();
            System.out.println();
        }
        
        // COMBATE POR COMBATE con FOR
        int p1Actual = 0, p2Actual = 0;
        int p1Vivos = 3, p2Vivos = 3;
        
        for (int combate = 1; combate <= 3; combate++) {
            System.out.println("\n=== COMBATE " + combate + " ===");
            System.out.println(nombres[0][p1Actual] + " vs " + nombres[1][p2Actual]);
            
            // WHILE hasta que uno muera
            while (vida[0][p1Actual] > 0 && vida[1][p2Actual] > 0) {
                // Jugador 1 ataca
                vida[1][p2Actual] -= ataque[0][p1Actual];
                System.out.println(nombres[0][p1Actual] + " ataca! " + nombres[1][p2Actual] + 
                                 " pierde " + ataque[0][p1Actual] + " HP");
                System.out.println("Vida " + nombres[1][p2Actual] + ": " + vida[1][p2Actual]);
                
                if (vida[1][p2Actual] <= 0) break;
                
                // Jugador 2 ataca
                vida[0][p1Actual] -= ataque[1][p2Actual];
                System.out.println(nombres[1][p2Actual] + " ataca! " + nombres[0][p1Actual] + 
                                 " pierde " + ataque[1][p2Actual] + " HP");
                System.out.println("Vida " + nombres[0][p1Actual] + ": " + vida[0][p1Actual]);
            }
            
            // Verificar quién perdió
            if (vida[0][p1Actual] <= 0) {
                System.out.println(nombres[0][p1Actual] + " DERROTADO!");
                p1Vivos--;
                p1Actual++;
            }
            if (vida[1][p2Actual] <= 0) {
                System.out.println(nombres[1][p2Actual] + " DERROTADO!");
                p2Vivos--;
                p2Actual++;
            }
        }
        
        // Ganador// se muestran resultados de cual gana 
        if (p1Vivos == 0) {
            System.out.println("\nJUGADOR 2 GANA");
        } else {
            System.out.println("\nJUGADOR 1 GANA");
        }
    }
    
}
