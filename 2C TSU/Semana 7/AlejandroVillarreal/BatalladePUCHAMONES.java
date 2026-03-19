/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package batalladepuchamones;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class BatalladePUCHAMONES {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
            Scanner sc = new Scanner(System.in);

        //  CATÁLOGO 
        String[] catalogoNombres = {"Pikachu", "Charizar", "Bulbasor", "Squirt", "Gengon", "Mewton"};
        int[] catalogoHP = {100, 150, 120, 130, 90, 200};
        int[] catalogoAtaque = {30, 40, 25, 28, 45, 50};

        // Datos de los jugadores 
        String[][] nombres = new String[2][3];
        int[][] hp = new int[2][3];
        int[][] ataque = new int[2][3];

        //  SELECCIÓN DE EQUIPO
        for (int i = 0; i < 2; i++) {
            System.out.println("\n JUGADOR " + (i + 1) + ": ELIGE 3 PUCHAMONES ");
    
            for (int k = 0; k < 6; k++) {
                System.out.println(k + ". " + catalogoNombres[k] + " (HP: " + catalogoHP[k] + ", ATQ: " + catalogoAtaque[k] + ")");
            }

            for (int j = 0; j < 3; j++) {
                System.out.print("Elige el número del puchamon " + (j + 1) + ": ");
                int seleccion = sc.nextInt();
                
               
                nombres[i][j] = catalogoNombres[seleccion];
                hp[i][j] = catalogoHP[seleccion];
                ataque[i][j] = catalogoAtaque[seleccion];
            }
        }

        //  BATALLA
        int p1Activo = 0, p2Activo = 0;
        System.out.println("\n¡INICIA EL COMBATE!");

        // Mientras ambos tengan puchamones con vida
        while (p1Activo < 3 && p2Activo < 3) {
            
            // ATAQUE JUGADOR 1
            System.out.println("\n" + nombres[0][p1Activo] + " (J1) ataca a " + nombres[1][p2Activo] + " (J2)");
            hp[1][p2Activo] -= ataque[0][p1Activo];
            
            if (hp[1][p2Activo] < 0) hp[1][p2Activo] = 0; // Evitar números negativos sin Math.max
            System.out.println("Daño: " + ataque[0][p1Activo] + " | Vida restante J2: " + hp[1][p2Activo]);

            if (hp[1][p2Activo] <= 0) {
                System.out.println("¡" + nombres[1][p2Activo] + " ha caído!");
                p2Activo++; // Siguiente puchamon de J2
            }

            // ATAQUE JUGADOR 2 (Solo si el de J2 no murió y J1 aún tiene vivos)
            if (p2Activo < 3 && p1Activo < 3) {
                System.out.println("\n" + nombres[1][p2Activo] + " (J2) ataca a " + nombres[0][p1Activo] + " (J1)");
                hp[0][p1Activo] -= ataque[1][p2Activo];
                
                if (hp[0][p1Activo] < 0) hp[0][p1Activo] = 0;
                System.out.println("Daño: " + ataque[1][p2Activo] + " | Vida restante J1: " + hp[0][p1Activo]);

                if (hp[0][p1Activo] <= 0) {
                    System.out.println("¡" + nombres[0][p1Activo] + " ha caído!");
                    p1Activo++; // Siguiente puchamon de J1
                }
            }
        }

    
        if (p1Activo == 3) {
            System.out.println("\n¡EL JUGADOR 2 HA GANADO ");
        } else {
            System.out.println("\n¡EL JUGADOR 1 HA GANADO ");
        }
    }
    
}
