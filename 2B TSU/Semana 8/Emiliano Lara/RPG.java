/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rpg;

import java.util.Scanner;

/**
 *
 * @author emili
 */
public class RPG {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
Scanner read = new Scanner (System.in);
String[][] nombres = new String[2][3];
int[][] vida = new int[2][3];
int[][] ataque = new int[2][3];
int[][] magia = new int[2][3];
int[][] energia = new int[2][3];
boolean[][] vivo = new boolean[2][3];
int[][] curaciones = new int[2][3];
for (int j = 0; j < 2; j++) {
    System.out.println("JUGADOR " + (j + 1) );
    for (int i = 0; i < 3; i++) {
        System.out.println("Heroe"+(i+1));
        System.out.println("Nombre:");
        nombres[j][i]= read.next();
        System.out.println("Vida:");
        vida[j][i]= read.nextInt();
        System.out.println("Ataque:");
        ataque[j][i]= read.nextInt();
        System.out.println("Magia:");
        magia[j][i]=read.nextInt();
        System.out.println("Mana inicial:");
        energia[j][i]=read.nextInt();   
    }
}
int h1=0;
        int h2=0;
int turno=0;
int acc=0;
System.out.println("COMIENZA LA BATALLA!");
while (true) { 
    int atacante, enemigo, hAtacante, hEnemigo;
   if (turno == 1) {
        atacante = 0;  
        enemigo = 1;     
        hAtacante = h1;
        hEnemigo = h2;
    } else {
        atacante = 1;    
        enemigo = 0;     
        hAtacante = h2;
        hEnemigo = h1;
    }
  System.out.println("\nTURNO DEL JUGADOR " + turno);
    System.out.println("Héroe: " + nombres[atacante][hAtacante] + " (Vida: " + vida[atacante][hAtacante] + ")");
    System.out.println("Oponente: " + nombres[enemigo][hEnemigo] + " (Vida: " + vida[enemigo][hEnemigo] + ")");
    System.out.println("ACCION A REALIZAR:");
    System.out.println("1. Ataque físico\n2. Ataque mágico\n3. Curarse\n4. Cambiar héroe");
    acc = read.nextInt();
    boolean pastur = true;  
switch (acc) {
        case 1:
            int daño = ataque[atacante][hAtacante];
            // Evento aleatorio: Crítico (20%)
            int prob = (int)(Math.random() * 100);
            if (prob < 20) {
                daño = daño * 2;
                System.out.println("¡GOLPE CRÍTICO! El daño se duplica.");
            }       
            vida[enemigo][hEnemigo] -= daño;
            System.out.println("Has causado " + daño + " de daño físico.");
            break;
        case 2: 
            if (energia[atacante][hAtacante] >= 10) {
                int danoMagico = magia[atacante][hAtacante];
                vida[enemigo][hEnemigo] -= danoMagico;
                energia[atacante][hAtacante] -= 10;
                System.out.println("¡Ataque mágico! " + nombres[enemigo][hEnemigo] + " recibe " + danoMagico + " de daño.");
                System.out.println("Energía restante: " + energia[atacante][hAtacante]);
            } else {
                System.out.println("No tienes energía suficiente (mínimo 10).");
                pastur = false; // El jugador puede elegir otra acción
            }
            break;
        case 3:
            if (curaciones[atacante][hAtacante] < 2) {
                vida[atacante][hAtacante] += 20;
                curaciones[atacante][hAtacante]++;
                System.out.println("Te has curado 20 HP. Vida actual: " + vida[atacante][hAtacante]);
                System.out.println("Curaciones usadas: " + curaciones[atacante][hAtacante] + "/2");
            } else {
                System.out.println("Ya has usado el límite de 2 curaciones para este héroe.");
                pastur = false;
            }
            break;
        case 4: // CAMBIAR HÉROE
            System.out.println("Héroes disponibles (elige 1, 2 o 3):");
            for(int k=0; k<3; k++) {
                if(vida[atacante][k] > 0) {
                    System.out.println((k+1) + ". " + nombres[atacante][k] + " (Vida: " + vida[atacante][k] + ")");
                }
            }
            int eleccion = read.nextInt() - 1;
            if (eleccion >= 0 && eleccion < 3 && vida[atacante][eleccion] > 0) {
                if (turno == 1) {
                    h1 = eleccion;
                } else {
                    h2 = eleccion;
                }
                System.out.println("Cambiando a " + nombres[atacante][eleccion] + "...");
            } else {
                System.out.println("Héroe no válido o está muerto.");
                pastur = false;
            }
            break;
        default:
            System.out.println("Opción no válida.");
            pastur = false;
            break;
    }
    if (vida[enemigo][hEnemigo] <= 0) {
        vida[enemigo][hEnemigo] = 0;
        vivo[enemigo][hEnemigo] = false;
        System.out.println("¡" + nombres[enemigo][hEnemigo] + " ha caído derrotado!");
        // Verificamos si el jugador enemigo tiene más héroes vivos
        boolean equipoDerrotado = true;
        for (int i = 0; i < 3; i++) {
            if (vida[enemigo][i] > 0) {
                equipoDerrotado = false;
                // Si el que murió era el activo, forzamos el cambio al siguiente vivo
                if (enemigo == 1) h2 = i; else h1 = i;
                break; 
            }
        }
        if (equipoDerrotado) {
            System.out.println("\n**********************************");
            System.out.println("¡VICTORIA PARA EL JUGADOR " + turno + "!");
            System.out.println("**********************************");
            break; // Termina el juego
        }
    }
    if (pastur) {
        if (turno == 1) {
            turno = 2;
        } else {
            turno = 1;
        }
    }
}
    }
}



