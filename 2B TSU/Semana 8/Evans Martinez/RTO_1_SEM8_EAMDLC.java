import java.util.Scanner;

public class RTO_1_SEM8_EAMDLC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[][] nombres = new String[2][3];
        int[][] vida = new int[2][3];
        int[][] ataque = new int[2][3];
        int[][] magia = new int[2][3];
        int[][] energia = new int[2][3];
        boolean[][] vivo = new boolean[2][3];
        int[][] curaciones = new int[2][3];

        // Inicializar héroes para cada jugador
        for (int j = 0; j < 2; j++) {
            for (int k = 0; k < 3; k++) {
                nombres[j][k] = "Heroe" + (k + 1);
                vida[j][k] = 100;
                ataque[j][k] = 20;
                magia[j][k] = 30;
                energia[j][k] = 50;
                vivo[j][k] = true;
                curaciones[j][k] = 0;
            }
        }

        int jugador = 0; // 0 = jugador1, 1 = jugador2
        int[] activo = {0, 0};

        while (hayVivos(vivo, 0) && hayVivos(vivo, 1)) {
            System.out.println("\n--- Estado actual ---");
            imprimirEstado(nombres, vida, energia, vivo);

            System.out.println("\nTurno del Jugador " + (jugador + 1));
            activo[jugador] = elegirHeroe(sc, nombres, vivo, jugador);
            int enemigo = 1 - jugador;
            int heroeActual = activo[jugador];
            int heroeEnemigo = activo[enemigo];

            boolean terminoTurno = false;
            while (!terminoTurno) {
                System.out.println("Elige acción:");
                System.out.println("1) Ataque físico");
                System.out.println("2) Ataque mágico");
                System.out.println("3) Curarse");
                System.out.println("4) Cambiar héroe");
                System.out.print("Opción: ");
                int opcion = sc.nextInt();

                switch (opcion) {
                    case 1:
                        int danio = ataque[jugador][heroeActual];
                        if (critico()) {
                            danio *= 2;
                            System.out.println("¡Golpe crítico!");
                        }
                        vida[enemigo][heroeEnemigo] -= danio;
                        System.out.println(nombres[jugador][heroeActual] + " ataca físicamente a " + nombres[enemigo][heroeEnemigo] + " y causa " + danio + " de daño.");
                        terminoTurno = true;
                        break;
                    case 2:
                        if (energia[jugador][heroeActual] < 10) {
                            System.out.println("No tienes suficiente energía para ataque mágico.");
                            break;
                        }
                        danio = magia[jugador][heroeActual];
                        if (critico()) {
                            danio *= 2;
                            System.out.println("¡Golpe crítico!");
                        }
                        energia[jugador][heroeActual] -= 10;
                        vida[enemigo][heroeEnemigo] -= danio;
                        System.out.println(nombres[jugador][heroeActual] + " usa magia contra " + nombres[enemigo][heroeEnemigo] + " y causa " + danio + " de daño.");
                        System.out.println("Energía restante: " + energia[jugador][heroeActual]);
                        terminoTurno = true;
                        break;
                    case 3:
                        if (curaciones[jugador][heroeActual] >= 2) {
                            System.out.println("Este héroe ya se curó 2 veces.");
                            break;
                        }
                        vida[jugador][heroeActual] += 20;
                        if (vida[jugador][heroeActual] > 100) {
                            vida[jugador][heroeActual] = 100;
                        }
                        curaciones[jugador][heroeActual]++;
                        System.out.println(nombres[jugador][heroeActual] + " se cura y ahora tiene " + vida[jugador][heroeActual] + " de vida.");
                        terminoTurno = true;
                        break;
                    case 4:
                        heroeActual = elegirHeroe(sc, nombres, vivo, jugador);
                        activo[jugador] = heroeActual;
                        System.out.println("Cambiado a " + nombres[jugador][heroeActual] + ".");
                        terminoTurno = true;
                        break;
                    default:
                        System.out.println("Opción inválida.");
                }

                if (vida[enemigo][heroeEnemigo] <= 0) {
                    vivo[enemigo][heroeEnemigo] = false;
                    vida[enemigo][heroeEnemigo] = 0;
                    System.out.println(nombres[enemigo][heroeEnemigo] + " ha muerto.");
                    if (!hayVivos(vivo, enemigo)) {
                        break;
                    }
                    heroeEnemigo = elegirHeroe(sc, nombres, vivo, enemigo);
                    activo[enemigo] = heroeEnemigo;
                }
            }

            // Mostrar estado breve al final de turno
            System.out.println("Vida jugador1/2: " + totalVida(vivo, vida, 0) + " / " + totalVida(vivo, vida, 1));
            jugador = 1 - jugador;
        }

        if (!hayVivos(vivo, 0)) {
            System.out.println("\n¡Jugador 2 gana!");
        } else {
            System.out.println("\n¡Jugador 1 gana!");
        }

        sc.close();
    }

    static boolean hayVivos(boolean[][] vivo, int jugador) {
        for (int i = 0; i < vivo[jugador].length; i++) {
            if (vivo[jugador][i]) return true;
        }
        return false;
    }

    static int elegirHeroe(Scanner sc, String[][] nombres, boolean[][] vivo, int jugador) {
        while (true) {
            System.out.println("Jugador " + (jugador + 1) + ": elige héroe vivo:");
            for (int i = 0; i < nombres[jugador].length; i++) {
                System.out.println((i + 1) + ") " + nombres[jugador][i] + " " + (vivo[jugador][i] ? "[VIVO]" : "[MUERTO]"));
            }
            System.out.print("Número: ");
            int sel = sc.nextInt() - 1;
            if (sel >= 0 && sel < 3 && vivo[jugador][sel]) {
                return sel;
            }
            System.out.println("Selección invalida. Intenta otra vez.");
        }
    }

    static boolean critico() {
        int prob = (int) (Math.random() * 100);
        return prob < 20;
    }

    static int totalVida(boolean[][] vivo, int[][] vida, int jugador) {
        int total = 0;
        for (int i = 0; i < vida[jugador].length; i++) {
            total += vida[jugador][i];
        }
        return total;
    }

    static void imprimirEstado(String[][] nombres, int[][] vida, int[][] energia, boolean[][] vivo) {
        for (int j = 0; j < 2; j++) {
            System.out.println("Jugador " + (j + 1));
            for (int k = 0; k < 3; k++) {
                System.out.println("  " + nombres[j][k] + " Vida=" + vida[j][k] + " Energía=" + energia[j][k] + " " + (vivo[j][k] ? "VIVO" : "MUERTO"));
            }
        }
    }
}
