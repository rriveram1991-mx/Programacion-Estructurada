import java.util.Scanner;

public class Pokemon {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[][] nombres = new String[2][3];
        int[][] vida = new int[2][3];
        int[][] ataque = new int[2][3];
        boolean[][] viva = new boolean[2][3];

        // REGISTRO
        for (int j = 0; j < 2; j++) {
            System.out.println("\n=== Entrenador pokemon " + (j + 1)+" ===");

            for (int i = 0; i < 3; i++) {
                System.out.println("Pokemon " + (i + 1));

                System.out.print("Nombre: ");
                nombres[j][i] = sc.next();
                System.out.println("Estadisticas");

                do {
                    System.out.print("Puntos de salud (HP): ");
                    vida[j][i] = sc.nextInt();
                } while (vida[j][i] <= 0);

                do {
                    System.out.print("Puntos de Ataque: ");
                    ataque[j][i] = sc.nextInt();
                } while (ataque[j][i] <= 0);

                viva[j][i] = true;
            }
        }

        int c1 = elegirCriatura(sc, nombres, viva, 0);
        int c2 = elegirCriatura(sc, nombres, viva, 1);

        // BATALLA
        while (hayVivas(viva, 0) && hayVivas(viva, 1)) {

            // Turno Jugador 1
            System.out.println("\n" + nombres[0][c1] + " ataca!");
            vida[1][c2] -= ataque[0][c1];

            System.out.println(nombres[1][c2] + " pierde " + ataque[0][c1] + " puntos de vida");
            System.out.println("Vida restante: " + Math.max(vida[1][c2], 0));

            if (vida[1][c2] <= 0) {
                viva[1][c2] = false;
                System.out.println(nombres[1][c2] + " ha sido derrotado!");

                if (!hayVivas(viva, 1)) break;

                c2 = elegirCriatura(sc, nombres, viva, 1);
            }

            // Turno Jugador 2
            System.out.println("\n" + nombres[1][c2] + " ataca!");
            vida[0][c1] -= ataque[1][c2];

            System.out.println(nombres[0][c1] + " pierde " + ataque[1][c2] + " de vida");
            System.out.println("Vida restante: " + Math.max(vida[0][c1], 0));

            if (vida[0][c1] <= 0) {
                viva[0][c1] = false;
                System.out.println(nombres[0][c1] + " ha sido derrotado!");

                if (!hayVivas(viva, 0)) break;

                c1 = elegirCriatura(sc, nombres, viva, 0);
            }
        }

        // RESULTADO
        if (hayVivas(viva, 0)) {
            System.out.println("\n El entrenador 1 gana!");
        } else {
            System.out.println("\n El entrenador 2 gana!");
        }

        sc.close();
    }

    
    public static int elegirCriatura(Scanner sc, String[][] nombres, boolean[][] viva, int jugador) {
        int opcion;

        do {
            System.out.println("\nJugador " + (jugador + 1) + " elige criatura:");

            for (int i = 0; i < 3; i++) {
                if (viva[jugador][i]) {
                    System.out.println(i + " - " + nombres[jugador][i]);
                }
            }

            opcion = sc.nextInt();

            if (opcion < 0 || opcion > 2 || !viva[jugador][opcion]) {
                System.out.println("⚠️ Opción inválida, intenta de nuevo.");
            }

        } while (opcion < 0 || opcion > 2 || !viva[jugador][opcion]);

        return opcion;
    }

    // Verifica si quedan criaturas vivas
    public static boolean hayVivas(boolean[][] viva, int jugador) {
        for (int i = 0; i < 3; i++) {
            if (viva[jugador][i]) return true;
        }
        return false;
    }
}