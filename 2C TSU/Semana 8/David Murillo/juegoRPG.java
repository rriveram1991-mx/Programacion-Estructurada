import java.util.Scanner;
public class juegoRPG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Matrices para almacenar los datos de los héroes
        String[][] nombres = new String[2][3];
        int[][] vida = new int[2][3];
        int[][] ataque = new int[2][3];
        int[][] magia = new int[2][3];
        int[][] energia = new int[2][3];
        boolean[][] vivo = new boolean[2][3];
        int[][] curaciones = new int[2][3];
        // Registro de héroes
        System.out.println("REGISTRO DE HÉROES");
        for (int jugador = 0; jugador < 2; jugador++) {
            System.out.println("Jugador " + (jugador + 1) + ", ingresa los datos de tus 3 héroes:");
            for (int i = 0; i < 3; i++) {
                System.out.println("Héroe " + (i + 1) + ":");
                System.out.print("Nombre: ");
                nombres[jugador][i] = sc.nextLine();

                System.out.print("Vida: ");
                vida[jugador][i] = sc.nextInt();

                System.out.print("Ataque: ");
                ataque[jugador][i] = sc.nextInt();

                System.out.print("Magia: ");
                magia[jugador][i] = sc.nextInt();

                System.out.print("Energía inicial: ");
                energia[jugador][i] = sc.nextInt();

                vivo[jugador][i] = true;
                curaciones[jugador][i] = 0;
                sc.nextLine(); // Limpiar buffer
            }
            System.out.println();
        }

        // Turno actual (0 = jugador 1, 1 = jugador 2)
        int turno = 0;
        int heroeActual[] = {0, 0}; // Índice del héroe activo por jugador

        // Bucle principal del juego
        while (tieneVivos(vivo, 0) && tieneVivos(vivo, 1)) {
            int jugador = turno % 2;
            int enemigo = 1 - jugador;

            System.out.println("\n TURNO DEL JUGADOR " + (jugador + 1));
            System.out.println("Héroe activo: " + nombres[jugador][heroeActual[jugador]]);

            // Seleccionar héroe activo (si está muerto, cambiar)
            if (!vivo[jugador][heroeActual[jugador]]) {
                heroeActual[jugador] = elegirHeroeVivo(sc, nombres[jugador], vivo[jugador], jugador);
                if (heroeActual[jugador] == -1) break; // No hay héroes vivos
            }

            // Mostrar menú de acciones
            System.out.println("\nAcciones disponibles:");
            System.out.println("1. Ataque físico");
            System.out.println("2. Ataque mágico");
            System.out.println("3. Curarse");
            System.out.println("4. Cambiar héroe");

            System.out.print("Elige una acción: ");
            int accion = sc.nextInt();

            // Validar acción
            if (accion < 1 || accion > 4) {
                System.out.println("Acción inválida. Pierdes el turno.");
                turno++;
                continue;
            }

            // Ejecutar acción
            switch (accion) {
                case 1: // Ataque físico
                    System.out.println(nombres[jugador][heroeActual[jugador]] + " usa Ataque físico.");
                    int danioFisico = ataque[jugador][heroeActual[jugador]];
                    // Golpe crítico (20%)
                    if (esCritico()) {
                        danioFisico *= 2;
                        System.out.println("¡Golpe crítico!");
                    }
                    vida[enemigo][heroeActual[enemigo]] -= danioFisico;
                    System.out.println("Daño: " + danioFisico);
                    System.out.println("Vida restante de " + nombres[enemigo][heroeActual[enemigo]] + ": " + Math.max(0, vida[enemigo][heroeActual[enemigo]]));
                    break;

                case 2: // Ataque mágico
                    if (energia[jugador][heroeActual[jugador]] < 10) {
                        System.out.println("No tienes suficiente energía. Pierdes el turno.");
                        turno++;
                        continue;
                    }
                    System.out.println(nombres[jugador][heroeActual[jugador]] + " usa Ataque mágico.");
                    int danioMagico = magia[jugador][heroeActual[jugador]];
                    if (esCritico()) {
                        danioMagico *= 2;
                        System.out.println("¡Golpe crítico!");
                    }
                    vida[enemigo][heroeActual[enemigo]] -= danioMagico;
                    energia[jugador][heroeActual[jugador]] -= 10;
                    System.out.println("Daño: " + danioMagico);
                    System.out.println("Energía restante: " + energia[jugador][heroeActual[jugador]]);
                    System.out.println("Vida restante de " + nombres[enemigo][heroeActual[enemigo]] + ": " + Math.max(0, vida[enemigo][heroeActual[enemigo]]));
                    break;

                case 3: // Curarse
                    if (curaciones[jugador][heroeActual[jugador]] >= 2) {
                        System.out.println("Ya has usado el máximo de curaciones. Pierdes el turno.");
                        turno++;
                        continue;
                    }
                    System.out.println(nombres[jugador][heroeActual[jugador]] + " se cura.");
                    vida[jugador][heroeActual[jugador]] += 20;
                    curaciones[jugador][heroeActual[jugador]]++;
                    System.out.println("Vida recuperada: 20. Curaciones usadas: " + curaciones[jugador][heroeActual[jugador]]);
                    break;

                case 4: // Cambiar héroe
                    heroeActual[jugador] = elegirHeroeVivo(sc, nombres[jugador], vivo[jugador], jugador);
                    if (heroeActual[jugador] == -1) {
                        System.out.println("No hay héroes vivos para cambiar.");
                    } else {
                        System.out.println("Héroe cambiado a: " + nombres[jugador][heroeActual[jugador]]);
                    }
                    break;
            }

            // Verificar muerte del héroe enemigo
            if (vida[enemigo][heroeActual[enemigo]] <= 0) {
                vida[enemigo][heroeActual[enemigo]] = 0;
                vivo[enemigo][heroeActual[enemigo]] = false;
                System.out.println(nombres[enemigo][heroeActual[enemigo]] + " ha sido derrotado.");
            }

            // Cambiar turno
            turno++;
        }

        // Determinar ganador
        if (!tieneVivos(vivo, 0)) {
            System.out.println("\n¡Jugador 2 gana la batalla!");
        } else {
            System.out.println("\n¡Jugador 1 gana la batalla!");
        }

        sc.close();
    }

    // Verifica si un jugador tiene héroes vivos
    public static boolean tieneVivos(boolean[][] vivo, int jugador) {
        for (int i = 0; i < 3; i++) {
            if (vivo[jugador][i]) return true;
        }
        return false;
    }

    // Elige un héroe vivo
    public static int elegirHeroeVivo(Scanner sc, String[] nombres, boolean[] vivo, int jugador) {
        System.out.println("Elige un héroe vivo:");
        for (int i = 0; i < 3; i++) {
            if (vivo[i]) {
                System.out.println((i + 1) + ". " + nombres[i] + " (Vida: " + (vivo[i] ? "vivo" : "muerto") + ")");
            }
        }
        System.out.print("Opción: ");
        int opcion = sc.nextInt() - 1;
        if (opcion >= 0 && opcion < 3 && vivo[opcion]) {
            return opcion;
        } else {
            System.out.println("Opción inválida. Seleccionando primer héroe vivo...");
            for (int i = 0; i < 3; i++) {
                if (vivo[i]) return i;
            }
            return -1; // No hay héroes vivos
        }
    }

    // Verifica si ocurre un golpe crítico (20% de probabilidad)
    public static boolean esCritico() {
        int prob = (int) (Math.random() * 100);
        return prob < 20;
    }
}   