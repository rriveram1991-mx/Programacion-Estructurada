/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package req1.sem8.pkg2d.rcmc1;

import java.util.Scanner;

/**
 *
 * @author STAR KRIS
 */
public class REQ1SEM82DRCMC1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner leer = new Scanner(System.in);

        // registrar los arrays
        String[][] nombres = new String[2][3];
        int[][] vida = new int[2][3];
        int[][] ataque = new int[2][3];
        int[][] magia = new int[2][3];
        int[][] energia = new int[2][3];
        boolean[][] vivo = new boolean[2][3];
        int[][] curaciones = new int[2][3];

       
        for (int i = 0; i < 2; i++) {
            //registrar a los jugadores
            System.out.println("--- Registro Jugador " + (i + 1) + " ---");
            for (int j = 0; j < 3; j++) {
                System.out.print("Nombre héroe " + (j + 1) + ": ");
                //la vida ataques y magia y todo
                nombres[i][j] = leer.next();
                vida[i][j] = 100;
                ataque[i][j] = 15 + (int)(Math.random() * 10);
                magia[i][j] = 25;
                energia[i][j] = 30;
                vivo[i][j] = true;
                curaciones[i][j] = 0;
            }
        }

        int turnoJugador = 0; // 0 para Jugador 1, 1 para Jugador 2

        // Bucle principal de batalla
        while (tieneVivos(vivo, 0) && tieneVivos(vivo, 1)) {
            int enemigo = (turnoJugador == 0) ? 1 : 0;
            
            System.out.println("\n=== TURNO JUGADOR " + (turnoJugador + 1) + " ===");
            
           //decirle al jugador que cual escojera
            int hActivo = seleccionarHeroe(nombres, vivo, turnoJugador, leer);
            
            boolean turnoTerminado = false;
            while (!turnoTerminado) {
                System.out.println("\nHeroe: " + nombres[turnoJugador][hActivo] + " (HP: " + vida[turnoJugador][hActivo] + " | MP: " + energia[turnoJugador][hActivo] + ")");
                System.out.println("1. Ataque físico\n2. Ataque mágico\n3. Curarse\n4. Cambiar héroe");
                int opcion = leer.nextInt();

                switch (opcion) {
                    case 1 -> {
                        // Atacar
                        int hEnemigo = seleccionarObjetivo(nombres, vivo, enemigo, leer);
                        int daño = ataque[turnoJugador][hActivo];
                        
                        //hacer lo de los ataque3s aleatorio
                        if ((int)(Math.random() * 100) < 20) {
                            daño *= 2;
                            System.out.println("ufff q golpe pa");
                        }
                        
                        vida[enemigo][hEnemigo] -= daño;
                        System.out.println(nombres[turnoJugador][hActivo] + " hace " + daño + " de daño a " + nombres[enemigo][hEnemigo]);
                        verificarMuerte(vida, vivo, enemigo, hEnemigo, nombres);
                        turnoTerminado = true;
                    }

                    case 2 -> {
                        // Aatacr de la magia
                        if (energia[turnoJugador][hActivo] >= 10) {
                            int hEnemigoMag = seleccionarObjetivo(nombres, vivo, enemigo, leer);
                            vida[enemigo][hEnemigoMag] -= magia[turnoJugador][hActivo];
                            energia[turnoJugador][hActivo] -= 10;
                            System.out.println("hechizo hecho Daño: " + magia[turnoJugador][hActivo]);
                            verificarMuerte(vida, vivo, enemigo, hEnemigoMag, nombres);
                            turnoTerminado = true;
                        } else {
                            System.out.println("Tu energia no es suficiente jeje");
                        }
                    }

                    case 3 -> {
                        // Curar al personaje con un if ysi ya esta lleno ps no
                        if (curaciones[turnoJugador][hActivo] < 2) {
                            vida[turnoJugador][hActivo] += 20;
                            curaciones[turnoJugador][hActivo]++;
                            System.out.println(nombres[turnoJugador][hActivo] + " se curó 20 HP. (Usos: " + curaciones[turnoJugador][hActivo] + "/2)");
                            turnoTerminado = true;
                        } else {
                            System.out.println("limite alcanzado");
                        }
                    }

                    case 4 -> //para cambiar al heroe para elegir
                        hActivo = seleccionarHeroe(nombres, vivo, turnoJugador, leer);
                }
            }
            //cambiar el turno
            turnoJugador = enemigo;
        }

        //si gana entonces hay q mostrar
        if (tieneVivos(vivo, 0)) System.out.println("Gana el uno");
        else System.out.println(" gana el dos");
    }

  
    public static boolean tieneVivos(boolean[][] vivo, int jugador) {
        return vivo[jugador][0] || vivo[jugador][1] || vivo[jugador][2];
    }
//eleccion para los herores
    public static int seleccionarHeroe(String[][] nombres, boolean[][] vivo, int jugador, Scanner leer) {
        int eleccion;
        while (true) {
            System.out.println("Elige tu héroe"
                    + "");
            //si esta vivo
            for (int i = 0; i < 3; i++) {
                if (vivo[jugador][i]) System.out.println(i + ". " + nombres[jugador][i]);
            }
            //y si no. no dejar
            eleccion = leer.nextInt();
            if (eleccion >= 0 && eleccion < 3 && vivo[jugador][eleccion]) return eleccion;
            System.out.println("no. escpge otro hijo");
        }
    }

    public static int seleccionarObjetivo(String[][] nombres, boolean[][] vivo, int enemigo, Scanner leer) {
        int eleccion;
        while (true) {
            System.out.println("Elige el objetuve");
            for (int i = 0; i < 3; i++) {
                if (vivo[enemigo][i]) System.out.println(i + ". " + nombres[enemigo][i]);
            }
            eleccion = leer.nextInt();
            if (eleccion >= 0 && eleccion < 3 && vivo[enemigo][eleccion]) return eleccion;
        }
    }

    public static void verificarMuerte(int[][] vida, boolean[][] vivo, int j, int h, String[][] nombres) {
        if (vida[j][h] <= 0) {
            vida[j][h] = 0;
            vivo[j][h] = false;
            System.out.println("¡" + nombres[j][h] + " ha muerto!");
        } else {
            System.out.println("Vida restante de el jugador " + nombres[j][h] + ": " + vida[j][h]);
        }
    }
}

    
    

