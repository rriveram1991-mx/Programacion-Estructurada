import java.util.Scanner;
/**
 * Institución: Universidad Tecnológica de Torreón.
 * Carrera: Ingeniería en Desarrollo de Software.
 * Alumno: [Juan Diego Arroyo Bucio.]
 * Materia: Programación Estructurada.
 */
public class BatallaRPG {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Declaración de las 7 matrices paralelas [Jugador(2)][Héroe(3)]
        String[][] nombres = new String[2][3];
        int[][] vida = new int[2][3];
        int[][] ataque = new int[2][3];
        int[][] magia = new int[2][3];
        int[][] energia = new int[2][3];
        boolean[][] vivo = new boolean[2][3];
        int[][] curaciones = new int[2][3];

        System.out.println("=== BIENVENIDO AL COLISEO RPG ===");

        // 2. Registro de Héroes
        for (int i = 0; i < 2; i++) {
            System.out.println("\n--- JUGADOR " + (i + 1) + ", REGISTRA TUS 3 HÉROES ---");
            for (int j = 0; j < 3; j++) {
                System.out.print("Nombre del héroe " + (j + 1) + ": ");
                nombres[i][j] = sc.nextLine();

                System.out.print("Vida: ");
                vida[i][j] = sc.nextInt();

                System.out.print("Ataque físico: ");
                ataque[i][j] = sc.nextInt();

                System.out.print("Ataque mágico: ");
                magia[i][j] = sc.nextInt();

                System.out.print("Energía (Maná inicial): ");
                energia[i][j] = sc.nextInt();

                sc.nextLine(); // Limpiar el buffer

                // Valores por defecto
                vivo[i][j] = true;
                curaciones[i][j] = 0;
            }
        }

        // Variables de control del combate
        int[] vivos = {3, 3}; // vivos[0] es J1, vivos[1] es J2
        int activoJ1 = 0;
        int activoJ2 = 0;
        int turno = 0; // 0 para J1, 1 para J2

        System.out.println("\n=== ¡EMPIEZA LA BATALLA! ===");
        System.out.println("Jugador 1 inicia con: " + nombres[0][activoJ1]);
        System.out.println("Jugador 2 inicia con: " + nombres[1][activoJ2]);

        // 3. Sistema de Turnos (Loop principal)
        while (vivos[0] > 0 && vivos[1] > 0) {

            // Definir quién ataca y quién defiende en este turno
            int atk = turno;          // Si turno es 0, atk es 0 (J1)
            int def = 1 - turno;      // Si turno es 0, def es 1 (J2)

            int heroeAtk = (atk == 0) ? activoJ1 : activoJ2;
            int heroeDef = (def == 0) ? activoJ1 : activoJ2;

            System.out.println("\n==================================");
            System.out.println("TURNO DEL JUGADOR " + (atk + 1) + " | Héroe activo: " + nombres[atk][heroeAtk]);
            System.out.println("HP: " + vida[atk][heroeAtk] + " | Energía: " + energia[atk][heroeAtk] + " | Curaciones disp: " + (2 - curaciones[atk][heroeAtk]));
            System.out.println("----------------------------------");
            System.out.println("1. Ataque físico");
            System.out.println("2. Ataque mágico (Cuesta 10 energía)");
            System.out.println("3. Curarse (+20 HP)");
            System.out.println("4. Cambiar héroe");
            System.out.print("Elige una acción: ");

            int accion = sc.nextInt();
            boolean turnoValido = true; // Para saber si hizo algo válido y podemos pasar el turno

            switch (accion) {
                case 1: // ATAQUE FÍSICO
                    int dañoFisico = ataque[atk][heroeAtk];

                    // Evento Crítico (20% probabilidad)
                    int probFis = (int)(Math.random() * 100);
                    if (probFis < 20) {
                        dañoFisico *= 2;
                        System.out.println("¡GOLPE CRÍTICO!");
                    }

                    vida[def][heroeDef] -= dañoFisico;
                    System.out.println(nombres[atk][heroeAtk] + " usa ataque físico y hace " + dañoFisico + " de daño.");
                    break;

                case 2: // ATAQUE MÁGICO
                    if (energia[atk][heroeAtk] >= 10) {
                        int danioMagico = magia[atk][heroeAtk];

                        // Evento Crítico Mágico
                        int probMag = (int)(Math.random() * 100);
                        if (probMag < 20) {
                            danioMagico *= 2;
                            System.out.println("¡CRÍTICO MÁGICO!");
                        }

                        vida[def][heroeDef] -= danioMagico;
                        energia[atk][heroeAtk] -= 10;
                        System.out.println(nombres[atk][heroeAtk] + " lanza magia y hace " + danioMagico + " de daño. (Energía restante: " + energia[atk][heroeAtk] + ")");
                    } else {
                        System.out.println("¡No tienes energía suficiente! Pierdes el turno por dudar.");
                    }
                    break;

                case 3: // CURARSE
                    if (curaciones[atk][heroeAtk] < 2) {
                        vida[atk][heroeAtk] += 20;
                        curaciones[atk][heroeAtk]++;
                        System.out.println(nombres[atk][heroeAtk] + " se ha curado 20 HP. (Vida actual: " + vida[atk][heroeAtk] + ")");
                    } else {
                        System.out.println("¡Ya no te quedan curaciones con este héroe! Pierdes el turno.");
                    }
                    break;

                case 4: // CAMBIAR HÉROE
                    System.out.println("Elige un héroe vivo:");
                    for (int j = 0; j < 3; j++) {
                        if (vivo[atk][j]) {
                            System.out.println((j + 1) + ". " + nombres[atk][j] + " (HP: " + vida[atk][j] + ")");
                        }
                    }
                    System.out.print("Opción: ");
                    int nuevoHeroe = sc.nextInt() - 1;

                    if (nuevoHeroe >= 0 && nuevoHeroe < 3 && vivo[atk][nuevoHeroe]) {
                        if (atk == 0) activoJ1 = nuevoHeroe;
                        else activoJ2 = nuevoHeroe;
                        System.out.println("Has cambiado a " + nombres[atk][nuevoHeroe] + ".");
                    } else {
                        System.out.println("Selección inválida. Mantienes a tu héroe actual.");
                    }
                    break;

                default:
                    System.out.println("Opción no válida. Pierdes el turno.");
                    break;
            }
            // 4. Sistema de Muerte (Revisar si el defensor murió tras el ataque)
            if (vida[def][heroeDef] <= 0 && vivo[def][heroeDef]) {
                vida[def][heroeDef] = 0;
                vivo[def][heroeDef] = false;
                vivos[def]--; // Reducir el contador de héroes vivos del defensor

                System.out.println("\n☠️ ¡" + nombres[def][heroeDef] + " ha sido derrotado!");

                // Si el defensor aún tiene héroes vivos, debe elegir otro forzosamente
                if (vivos[def] > 0) {
                    System.out.println("\nJUGADOR " + (def + 1) + ", elige tu siguiente héroe:");
                    for (int j = 0; j < 3; j++) {
                        if (vivo[def][j]) {
                            System.out.println((j + 1) + ". " + nombres[def][j] + " (HP: " + vida[def][j] + ")");
                        }
                    }
                    System.out.print("Opción: ");
                    int relevo = sc.nextInt() - 1;
                    // Pequeña validación rápida para asegurar que elige a uno vivo
                    while (relevo < 0 || relevo >= 3 || !vivo[def][relevo]) {
                        System.out.print("¡Ese héroe no puede pelear! Elige otro: ");
                        relevo = sc.nextInt() - 1;
                    }

                    if (def == 0) activoJ1 = relevo;
                    else activoJ2 = relevo;
                }
            } else if (accion == 1 || accion == 2) {
                // Mostrar vida restante si el ataque no lo mató
                System.out.println("Vida restante de " + nombres[def][heroeDef] + ": " + vida[def][heroeDef]);
            }

            // Cambiar el turno al otro jugador (0 a 1, o 1 a 0)
            turno = 1 - turno;
        }

        // 5. Condición de Victoria
        System.out.println("\n==================================");
        if (vivos[0] == 0) {
            System.out.println("🏆 ¡TODOS LOS HÉROES DEL JUGADOR 1 ESTÁN MUERTOS!");
            System.out.println("🏆 ¡GANA EL JUGADOR 2!");
        } else {
            System.out.println("🏆 ¡TODOS LOS HÉROES DEL JUGADOR 2 ESTÁN MUERTOS!");
            System.out.println("🏆 ¡GANA EL JUGADOR 1!");
        }
        System.out.println("==================================");
        sc.close();
    }
}