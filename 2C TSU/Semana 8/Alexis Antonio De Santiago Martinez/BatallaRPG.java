import java.util.Scanner;

public class BatallaRPG {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[][] nombres = new String[2][3];
        int[][] vida = new int[2][3];
        int[][] ataque = new int[2][3];
        int[][] magia = new int[2][3];
        int[][] energia = new int[2][3];
        boolean[][] vivo = new boolean[2][3];
        int[][] curaciones = new int[2][3];

        // REGISTRO
        for (int i = 0; i < 2; i++) {
            System.out.println("Jugador " + (i + 1));

            for (int j = 0; j < 3; j++) {
                System.out.println("Heroe " + j);

                System.out.print("Nombre: ");
                nombres[i][j] = sc.next();

                System.out.print("Vida (maximo 100): ");
                vida[i][j] = sc.nextInt();

                if (vida[i][j] > 100) vida[i][j] = 100;

                System.out.print("Ataque: ");
                ataque[i][j] = sc.nextInt();

                System.out.print("Magia: ");
                magia[i][j] = sc.nextInt();

                System.out.print("Energia: ");
                energia[i][j] = sc.nextInt();

                vivo[i][j] = true;
                curaciones[i][j] = 0;
            }
        }

        int turno = 0;

        while (tieneVivos(vivo, 0) && tieneVivos(vivo, 1)) {

            int jugador = turno % 2;
            int enemigo = (jugador == 0) ? 1 : 0;

            System.out.println("\nTurno del Jugador " + (jugador + 1));

            int heroe;

            while (true) {
                mostrarHeroes(nombres, vida, energia, vivo, jugador);
                System.out.print("Elige heroe (0-2): ");
                heroe = sc.nextInt();

                if (heroe >= 0 && heroe < 3 && vivo[jugador][heroe]) {
                    break;
                }
                System.out.println("Seleccion inválida.");
            }

            boolean accionRealizada = false;

            while (!accionRealizada) {

                System.out.println("\n1. Ataque físico");
                System.out.println("2. Ataque mágico");
                System.out.println("3. Curarse");
                System.out.println("4. Realizar cambio de héroe");
                System.out.print("Opción: ");
                int opcion = sc.nextInt();

                int objetivo;
                int daño = 0;

                switch (opcion) {

                    case 1: // ATAQUE FISICO
                        objetivo = seleccionarObjetivo(sc, nombres, vida, energia, vivo, enemigo);

                        daño = ataque[jugador][heroe];

                        daño = aplicarCritico(daño);

                        vida[enemigo][objetivo] -= daño;

                        System.out.println(nombres[jugador][heroe] + " usó un ATAQUE FÍSICO e hizo " + daño + " de daño.");

                        procesarVida(nombres, vida, vivo, enemigo, objetivo);
                        accionRealizada = true;
                        break;

                    case 2: // ATAQUE MAGICO
                        if (energia[jugador][heroe] < 10) {
                            System.out.println("No tienes energía suficiente.");
                            break;
                        }

                        objetivo = seleccionarObjetivo(sc, nombres, vida, energia, vivo, enemigo);

                        daño = magia[jugador][heroe];
                        energia[jugador][heroe] -= 10;

                        daño = aplicarCritico(daño);

                        vida[enemigo][objetivo] -= daño;

                        System.out.println(nombres[jugador][heroe] + " usó un ATAQUE MÁGICO e infligio " + daño + " de daño.");
                        System.out.println("Energía restante: " + energia[jugador][heroe]);

                        procesarVida(nombres, vida, vivo, enemigo, objetivo);
                        accionRealizada = true;
                        break;

                    case 3: // CURARSE
                        if (curaciones[jugador][heroe] >= 2) {
                            System.out.println("Ya no puedes curarte más.");
                            break;
                        }

                        vida[jugador][heroe] += 20;

                        if (vida[jugador][heroe] > 100) {
                            vida[jugador][heroe] = 100;
                        }

                        curaciones[jugador][heroe]++;

                        System.out.println(nombres[jugador][heroe] + " El heroe a sido curado. Vida actual: " + vida[jugador][heroe]);

                        accionRealizada = true;
                        break;

                    case 4: // CAMBIAR HEROE
                        System.out.println("Elige otro héroe:");
                        while (true) {
                            mostrarHeroes(nombres, vida, energia, vivo, jugador);
                            heroe = sc.nextInt();

                            if (heroe >= 0 && heroe < 3 && vivo[jugador][heroe]) {
                                break;
                            }
                            System.out.println("Selección inválida.");
                        }
                        break;

                    default:
                        System.out.println("Opción inválida.");
                }
            }

            turno++;
        }

        if (!tieneVivos(vivo, 0)) {
            System.out.println("\n Gana Jugador 2");
        } else {
            System.out.println("\n Gana Jugador 1");
        }
    }

    // FUNCIONES AUXILIARES

    public static int seleccionarObjetivo(Scanner sc, String[][] nombres, int[][] vida, int[][] energia, boolean[][] vivo, int enemigo) {
        int objetivo;

        while (true) {
            mostrarHeroes(nombres, vida, energia, vivo, enemigo);
            System.out.print("Elige enemigo: ");
            objetivo = sc.nextInt();

            if (objetivo >= 0 && objetivo < 3 && vivo[enemigo][objetivo]) {
                return objetivo;
            }
            System.out.println("Selección inválida.");
        }
    }

    public static int aplicarCritico(int daño) {
        int prob = (int)(Math.random() * 100);

        if (prob < 20) {
            System.out.println("¡Golpe crítico!");
            daño *= 2;
        }

        return daño;
    }

    public static void procesarVida(String[][] nombres, int[][] vida, boolean[][] vivo, int jugador, int heroe) {
        if (vida[jugador][heroe] <= 0) {
            vida[jugador][heroe] = 0;
            vivo[jugador][heroe] = false;
            System.out.println(nombres[jugador][heroe] + " ha muerto.");
        } else {
            System.out.println("Vida restante: " + vida[jugador][heroe]);
        }
    }

    public static boolean tieneVivos(boolean[][] vivo, int jugador) {
        for (int i = 0; i < 3; i++) {
            if (vivo[jugador][i]) return true;
        }
        return false;
    }

    public static void mostrarHeroes(String[][] nombres, int[][] vida, int[][] energia, boolean[][] vivo, int jugador) {
        for (int i = 0; i < 3; i++) {
            System.out.println(i + ". " + nombres[jugador][i] +
                    " | Vida: " + vida[jugador][i] +
                    " | Energia: " + energia[jugador][i] +
                    " | " + (vivo[jugador][i] ? "Vivo" : "Muerto"));
        }
    }
}
