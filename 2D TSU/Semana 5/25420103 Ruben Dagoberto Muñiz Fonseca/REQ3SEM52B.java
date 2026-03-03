/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package req3sem52b;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class REQ3SEM52B {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);

        ArrayList<String> jugadores = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            System.out.print("Ingresa el nombre del jugador: ");
            jugadores.add(sc.nextLine());
        }

        System.out.println("\nJugadores registrados:");

        for (String jugador : jugadores) {
            System.out.println(jugador);
        }
    }
}