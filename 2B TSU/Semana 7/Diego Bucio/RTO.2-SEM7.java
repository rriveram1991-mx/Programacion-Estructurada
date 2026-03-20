import java.util.Scanner;

/**
 * Institución: Universidad Tecnológica de Torreón.
 * Carrera: Ingeniería en Desarrollo de Software.
 * Alumno: Juan Diego Arroyo Bucio.
 */
public class BatallaPokemon {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Matrices bidimensionales [Jugador(2)] [Puchamon(3)]
        String[][] nombres = new String[2][3];
        int[][] vida = new int[2][3];
        int[][] ataque = new int[2][3];

        System.out.println("=== BIENVENIDO AL ESTADIO POKEMON ===");

        // 2. Registro de pokemones con ciclos for anidados
        for (int i = 0; i < 2; i++) {
            System.out.println("\n--- JUGADOR " + (i + 1) + ", REGISTRA TU EQUIPO ---");
            for (int j = 0; j < 3; j++) {
                System.out.print("Nombre del pokemon " + (j + 1) + ": ");
                nombres[i][j] = sc.nextLine();

                System.out.print("Vida (HP) de " + nombres[i][j] + ": ");
                vida[i][j] = sc.nextInt();

                System.out.print("Puntos de Ataque de " + nombres[i][j] + ": ");
                ataque[i][j] = sc.nextInt();

                sc.nextLine(); // Limpiar el "Enter fantasma" de la memoria
            }
        }

        // Variables de control para la batalla
        int vivosJ1 = 3;
        int vivosJ2 = 3;
        int activoJ1 = 0; // Por defecto empiezan con el primer pokemon
        int activoJ2 = 0;

        System.out.println("\n=== ¡COMIENZA LA BATALLA! ===");
        System.out.println("Jugador 1 elige a: " + nombres[0][activoJ1]);
        System.out.println("Jugador 2 elige a: " + nombres[1][activoJ2]);

        // 3. Ciclo de batalla por turnos (Se repite mientras ambos tengan equipo vivo)
        while (vivosJ1 > 0 && vivosJ2 > 0) {

            System.out.println("\n--- TURNO JUGADOR 1 ---");
            System.out.println("¡" + nombres[0][activoJ1] + " ataca!");

            // Fórmula de daño usando los índices de la matriz
            vida[1][activoJ2] -= ataque[0][activoJ1];
            System.out.println(nombres[1][activoJ2] + " recibe " + ataque[0][activoJ1] + " de daño.");
            System.out.println("Vida restante de " + nombres[1][activoJ2] + ": " + Math.max(0, vida[1][activoJ2]));

            // Validar si el pokemon del J2 fue derrotado
            if (vida[1][activoJ2] <= 0) {
                System.out.println("¡" + nombres[1][activoJ2] + " ha sido derrotado!");
                vivosJ2--; // Le quitamos un pokemon vivo al J2

                if (vivosJ2 > 0) {
                    // J2 tiene que elegir a otro que siga vivo
                    System.out.println("\nJugador 2, elige tu siguiente pokemon:");
                    for (int j = 0; j < 3; j++) {
                        if (vida[1][j] > 0) {
                            System.out.println((j + 1) + ". " + nombres[1][j] + " (HP: " + vida[1][j] + ")");
                        }
                    }
                    System.out.print("Elige el número (1-3): ");
                    activoJ2 = sc.nextInt() - 1; // Le restamos 1 para cuadrar con el índice de la matriz
                } else {
                    break; // Si ya no le quedan vivos, se rompe el ciclo y se acaba la pelea
                }
            }

            System.out.println("\n--- TURNO JUGADOR 2 ---");
            System.out.println("¡" + nombres[1][activoJ2] + " ataca!");

            vida[0][activoJ1] -= ataque[1][activoJ2];
            System.out.println(nombres[0][activoJ1] + " recibe " + ataque[1][activoJ2] + " de daño.");
            System.out.println("Vida restante de " + nombres[0][activoJ1] + ": " + Math.max(0, vida[0][activoJ1]));

            // Validar si el pkemon del J1 fue derrotado
            if (vida[0][activoJ1] <= 0) {
                System.out.println("¡" + nombres[0][activoJ1] + " ha sido derrotado!");
                vivosJ1--;

                if (vivosJ1 > 0) {
                    System.out.println("\nJugador 1, elige tu siguiente pokemon:");
                    for (int j = 0; j < 3; j++) {
                        if (vida[0][j] > 0) {
                            System.out.println((j + 1) + ". " + nombres[0][j] + " (HP: " + vida[0][j] + ")");
                        }
                    }
                    System.out.print("Elige el número (1-3): ");
                    activoJ1 = sc.nextInt() - 1;
                }
            }
        }

        // 4. Declarar al ganador
        System.out.println("\n==================================");
        if (vivosJ1 > 0) {
            System.out.println("¡JUGADOR 1 GANA LA BATALLA!");
        } else {
            System.out.println("¡JUGADOR 2 GANA LA BATALLA!");
        }
        System.out.println("==================================");

        sc.close();
    }
}