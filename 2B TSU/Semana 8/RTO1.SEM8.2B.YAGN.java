

import java.util.Scanner;

public class EjerciciosIngRicardo56 {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        // Registro de héroes
        String[][] nombres = new String[2][3];
        int[][] vida = new int[2][3];
        int[][] ataque = new int[2][3];
        int[][] magia = new int[2][3];
        int[][] energia = new int[2][3];
        boolean[][] vivo = new boolean[2][3];
        int[][] curaciones = new int[2][3];

        // Registro inicial
        for (int j = 0; j < 2; j++) {
            System.out.println("\n--- REGISTRO JUGADOR " + (j + 1) + " ---");
            for (int h = 0; h < 3; h++) {
                System.out.print("Nombre del Héroe " + (h + 1) + ": ");
                nombres[j][h] = leer.next();
                System.out.print("Vida inicial: ");
                vida[j][h] = leer.nextInt();
                System.out.print("Poder de Ataque: ");
                ataque[j][h] = leer.nextInt();
                System.out.print("Poder de Magia: ");
                magia[j][h] = leer.nextInt();
                System.out.print("Energía inicial: ");
                energia[j][h] = leer.nextInt();
                vivo[j][h] = true;
                curaciones[j][h] = 0;
            }
        }

        int turnoDe = 0; // 0 para Jugador 1, 1 para Jugador 2
        boolean juegoActivo = true;

        // Sistema de turnos
        while (juegoActivo) {
            int rival = (turnoDe == 0) ? 1 : 0;

            System.out.println("\n===============================");
            System.out.println("TURNO DEL JUGADOR " + (turnoDe + 1));
            
            // Elegir héroe activo (Solo vivos)
            System.out.println("Elige tu héroe para este turno (0, 1, 2):");
            for(int i=0; i<3; i++) {
                if(vivo[turnoDe][i]) System.out.println(i + ". " + nombres[turnoDe][i] + " (HP: " + vida[turnoDe][i] + ")");
            }
            int hSel = leer.nextInt();

            if (!vivo[turnoDe][hSel]) {
                System.out.println("¡Ese héroe está muerto! Pierdes el turno por menso.");
            } else {
                // Menú de acciones
                System.out.println("1. Ataque Físico | 2. Ataque Mágico | 3. Curarse | 4. Cambiar Héroe");
                int accion = leer.nextInt();

                // Elegir objetivo oponente
                
                System.out.println("¿A qué enemigo atacas? (0, 1, 2):");
                for(int i=0; i<3; i++) {
                    String estado = vivo[rival][i] ? "HP: " + vida[rival][i] : "MUERTO";
                    System.out.println(i + ". " + nombres[rival][i] + " [" + estado + "]");
                }
                int eSel = leer.nextInt();

                // Ver si el enemigo sigue vivo
                if (!vivo[rival][eSel] && (accion == 1 || accion == 2)) {
                    System.out.println("No puedes atacar a un cadáver. Turno perdido.");
                } else {
                    switch (accion) {
                        case 1: // Ataque físico
                            int dañoF = ataque[turnoDe][hSel];
                            // Probabilidad de golpe crítico
                            if ((int)(Math.random() * 100) < 20) {
                                dañoF *= 2;
                                System.out.println("¡GOLPE CRÍTICO!");
                            }
                            vida[rival][eSel] -= dañoF;
                            System.out.println(nombres[turnoDe][hSel] + " hace " + dañoF + " de daño a " + nombres[rival][eSel]);
                            break;

                        case 2: // Ataque mágico
                            if (energia[turnoDe][hSel] >= 10) {
                                vida[rival][eSel] -= magia[turnoDe][hSel];
                                energia[turnoDe][hSel] -= 10;
                                System.out.println("¡Magia devastadora! Daño: " + magia[turnoDe][hSel]);
                            } else {
                                System.out.println("No tienes energía suficiente (Mínimo 10).");
                            }
                            break;

                        case 3: // Curación
                            if (curaciones[turnoDe][hSel] < 2) {
                                vida[turnoDe][hSel] += 20;
                                curaciones[turnoDe][hSel]++;
                                System.out.println(nombres[turnoDe][hSel] + " se curó 20 HP. (Curaciones: " + curaciones[turnoDe][hSel] + "/2)");
                            } else {
                                System.out.println("Ya no puedes curarte más con este héroe.");
                            }
                            break;
                    }

                    // Sistema de muertos:
                    if (vida[rival][eSel] <= 0) {
                        vida[rival][eSel] = 0;
                        vivo[rival][eSel] = false;
                        System.out.println("¡" + nombres[rival][eSel] + " HA MUERTO!");
                    }
                }
            }

            // Cuando alguien gana:
            boolean j1Vivos = vivo[0][0] || vivo[0][1] || vivo[0][2];
            boolean j2Vivos = vivo[1][0] || vivo[1][1] || vivo[1][2];

            if (!j1Vivos) {
                System.out.println("\n¡EL JUGADOR 2 GANA LA BATALLA!");
                juegoActivo = false;
            } else if (!j2Vivos) {
                System.out.println("\n¡EL JUGADOR 1 GANA LA BATALLA!");
                juegoActivo = false;
            }

            // Cambiar turno
            if (turnoDe == 0) {
    turnoDe = 1;
} else {
    turnoDe = 0;
}
        }
    }
}