import java.util.Scanner;

public class FF {

    static String[][][] nomAtaque   = new String[2][3][1];
    static int[][][]    danioAtaque = new int[2][3][1];
    static String[][][] nomMagia    = new String[2][3][1];
    static int[][][]    danioMagia  = new int[2][3][1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[][] nombres   = new String[2][3];
        int[][]    vida      = new int[2][3];
        int[][]    vidaMax   = new int[2][3];
        int[][]    mana      = new int[2][3];
        int[][]    costeMana = new int[2][3];
        int[][]    curaciones = new int[2][3]; 

        // Jugador 1
        nombres[0][0] = "Spider-Man"; vida[0][0] = 100; vidaMax[0][0] = 100;
        nombres[0][1] = "Iron-Man";   vida[0][1] = 95;  vidaMax[0][1] = 95;
        nombres[0][2] = "Hulk";       vida[0][2] = 150; vidaMax[0][2] = 150;

        nomAtaque[0][0][0] = "Derechazo";   danioAtaque[0][0][0] = 30;
        nomMagia[0][0][0]  = "Red de Arana"; danioMagia[0][0][0] = 35; costeMana[0][0] = 40;
        mana[0][0] = 100; curaciones[0][0] = 2;

        nomAtaque[0][1][0] = "Embestida";  danioAtaque[0][1][0] = 15;
        nomMagia[0][1][0]  = "Repulsor";   danioMagia[0][1][0] = 50; costeMana[0][1] = 70;
        mana[0][1] = 100; curaciones[0][1] = 2;

        nomAtaque[0][2][0] = "Aplastar";   danioAtaque[0][2][0] = 40;
        nomMagia[0][2][0]  = "Furia";      danioMagia[0][2][0] = 20; costeMana[0][2] = 20;
        mana[0][2] = 100; curaciones[0][2] = 2;

        // Jugador 2
        nombres[1][0] = "Superman";     vida[1][0] = 120; vidaMax[1][0] = 120;
        nombres[1][1] = "Batman";       vida[1][1] = 80;  vidaMax[1][1] = 80;
        nombres[1][2] = "Wonder Woman"; vida[1][2] = 100; vidaMax[1][2] = 100;

        nomAtaque[1][0][0] = "Velocidad Sonica"; danioAtaque[1][0][0] = 25;
        nomMagia[1][0][0]  = "Luz Solar";        danioMagia[1][0][0] = 30; costeMana[1][0] = 30;
        mana[1][0] = 100; curaciones[1][0] = 2;

        nomAtaque[1][1][0] = "Batarang"; danioAtaque[1][1][0] = 35;
        nomMagia[1][1][0]  = "Gadgets";  danioMagia[1][1][0] = 30; costeMana[1][1] = 30;
        mana[1][1] = 100; curaciones[1][1] = 2;

        nomAtaque[1][2][0] = "Fuerza Amazona"; danioAtaque[1][2][0] = 25;
        nomMagia[1][2][0]  = "Lazo de Verdad"; danioMagia[1][2][0] = 40; costeMana[1][2] = 40;
        mana[1][2] = 100; curaciones[1][2] = 2;

        // Pantalla de inicio
        System.out.println("════════════════════════════════════════════════════════");
        System.out.println("      BATALLA HEROES  -  DC vs MARVEL!!!");
        System.out.println("════════════════════════════════════════════════════════\n");

        for (int j = 0; j < 2; j++) {
            System.out.println("Jugador " + (j + 1) + ":");
            for (int p = 0; p < 3; p++) {
                System.out.printf("  [%d] %-14s  HP: %-4d  MP: %d%n",
                        p + 1, nombres[j][p], vida[j][p], mana[j][p]);
            }
            System.out.println();
        }

        int[] seleccion = new int[2];
        for (int j = 0; j < 2; j++) {
            seleccion[j] = elegirHeroe(sc, j, nombres);
        }

        int turno = 0;

        while (hayHeroes(vida, 0) && hayHeroes(vida, 1)) {

            int atacante = turno;
            int defensor = 1 - turno;
            int pa = seleccion[atacante];
            int pd = seleccion[defensor];

            System.out.println("\n════════════════════════════════════════");
            System.out.printf("  J%d: %-14s  HP: %-4d  MP: %-4d  Curas: %d%n",
                    atacante+1, nombres[atacante][pa], vida[atacante][pa],
                    mana[atacante][pa], curaciones[atacante][pa]);
            System.out.printf("  J%d: %-14s  HP: %-4d  MP: %-4d  Curas: %d%n",
                    defensor+1, nombres[defensor][pd], vida[defensor][pd],
                    mana[defensor][pd], curaciones[defensor][pd]);
            System.out.println("════════════════════════════════════════");

            int accion = menuCombate(sc, atacante, pa, nombres, mana, costeMana, curaciones);

            // ── Cambiar heroe 
            if (accion == 0) {
                if (contarDisponibles(vida, atacante) <= 1) {
                    System.out.println("  No tienes otros heroes disponibles!");
                    continue;
                }
                seleccion[atacante] = elegirHeroe(sc, atacante, nombres, vida);
                pa = seleccion[atacante];
                System.out.println("  Jugador " + (atacante+1) + " envia a "
                        + nombres[atacante][pa]
                        + "  HP: " + vida[atacante][pa]
                        + "  MP: " + mana[atacante][pa]);
                turno = 1 - turno;
                continue;
            }

            // ── Curacion 
            if (accion == 3) {
                if (curaciones[atacante][pa] <= 0) {
                    System.out.println("  No te quedan curaciones!");
                    continue;
                }
                int curado = 20;
                vida[atacante][pa] += curado;
                curaciones[atacante][pa]--;
                System.out.println("\n  " + nombres[atacante][pa]
                        + " se cura 20 de vida!  HP: " + vida[atacante][pa]
                        + "  (Curas restantes: " + curaciones[atacante][pa] + ")");
                turno = 1 - turno;
                continue;
            }

            // ── Ataque fisico o magico 
            int danio;
            String nombreAtq;

            if (accion == 1) {
                danio     = danioAtaque[atacante][pa][0];
                nombreAtq = nomAtaque[atacante][pa][0];
                System.out.println("\n  " + nombres[atacante][pa] + " usa " + nombreAtq + "!");
            } else {
                if (mana[atacante][pa] < costeMana[atacante][pa]) {
                    System.out.println("\n  Sin Mana suficiente! (necesitas "
                            + costeMana[atacante][pa] + " MP)");
                    System.out.println("  El turno se pierde...");
                    turno = 1 - turno;
                    continue;
                }
                danio     = danioMagia[atacante][pa][0];
                nombreAtq = nomMagia[atacante][pa][0];
                mana[atacante][pa] -= costeMana[atacante][pa];
                System.out.println("\n  " + nombres[atacante][pa]
                        + " lanza " + nombreAtq
                        + "!  (MP restante: " + mana[atacante][pa] + ")");
            }

            // ── Golpe critico 
            int prob = (int)(Math.random() * 100);
            if (prob < 20) {
                danio *= 2;
                System.out.println("  *** GOLPE CRITICO! ***");
            }

            vida[defensor][pd] -= danio;
            if (vida[defensor][pd] < 0) vida[defensor][pd] = 0;

            System.out.println("  " + nombres[defensor][pd] + " pierde " + danio + " de vida.");
            System.out.println("  Vida restante de " + nombres[defensor][pd]
                    + ": " + vida[defensor][pd]);

            // ── Heroe derrotado ───────────────────────────────────────────────
            if (vida[defensor][pd] <= 0) {
                System.out.println("\n  * " + nombres[defensor][pd] + " ha sido derrotado!");

                if (siguienteHeroe(vida, defensor) == -1) {
                    System.out.println("\n════════════════════════════════════════");
                    System.out.println("  Todos los heroes del Jugador "
                            + (defensor+1) + " cayeron!");
                    System.out.printf("       *** Jugador %d GANA! ***%n", atacante+1);
                    System.out.println("════════════════════════════════════════");
                    sc.close();
                    return;
                }

                System.out.println("  Jugador " + (defensor+1) + " debe elegir otro heroe.");
                seleccion[defensor] = elegirHeroe(sc, defensor, nombres, vida);
            }

            turno = 1 - turno;
        }

        sc.close();
    }

    static int menuCombate(Scanner sc, int jugador, int pa,
        String[][] nombres, int[][] mana,
        int[][] costeMana, int[][] curaciones) {
        System.out.println("\n  Turno de Jugador " + (jugador+1)
                + " (" + nombres[jugador][pa] + ")"
                + "  MP: " + mana[jugador][pa]
                + "  Curas: " + curaciones[jugador][pa]
                + "  - Elige accion:");
        System.out.println("  ─────────────────────────────────────");
        System.out.printf("  [1] %-16s  DMG: %d%n",
                nomAtaque[jugador][pa][0], danioAtaque[jugador][pa][0]);
        System.out.printf("  [2] %-16s  DMG: %d  (costo: %d MP)%n",
                nomMagia[jugador][pa][0], danioMagia[jugador][pa][0], costeMana[jugador][pa]);
        System.out.println("  [3] Curarse            +20 HP  (quedan: "
                + curaciones[jugador][pa] + ")");
        System.out.println("  [4] Cambiar heroe");
        System.out.println("  ─────────────────────────────────────");

        int opcion = 0;
        while (opcion < 1 || opcion > 4) {
            System.out.print("  Opcion: ");
            if (sc.hasNextInt()) {
                opcion = sc.nextInt();
                if (opcion < 1 || opcion > 4)
                    System.out.println("  Opcion invalida. Elige 1-4.");
            } else {
                sc.next();
            }
        }
        // 4=cambiar devuelve 0, 3=curar devuelve 3, 1 y 2 se devuelven igual
        return (opcion == 4) ? 0 : opcion;
    }

    static int elegirHeroe(Scanner sc, int jugador, String[][] nombres) {
        System.out.println("Jugador " + (jugador+1) + ", elige tu heroe (1-3):");
        for (int p = 0; p < 3; p++)
            System.out.println("  [" + (p+1) + "] " + nombres[jugador][p]);
        int opcion = 0;
        while (opcion < 1 || opcion > 3) {
            System.out.print("  Opcion: ");
            if (sc.hasNextInt()) opcion = sc.nextInt();
            else sc.next();
        }
        System.out.println("  > " + nombres[jugador][opcion-1] + " al campo de batalla!\n");
        return opcion - 1;
    }

    static int elegirHeroe(Scanner sc, int jugador, String[][] nombres, int[][] vida) {
        int disponibles = 0, unico = -1;
        for (int p = 0; p < 3; p++)
            if (vida[jugador][p] > 0) { disponibles++; unico = p; }

        if (disponibles == 1) {
            System.out.println("  > " + nombres[jugador][unico] + " entra automaticamente!\n");
            return unico;
        }

        System.out.println("  Jugador " + (jugador+1) + ", elige heroe disponible:");
        for (int p = 0; p < 3; p++)
            if (vida[jugador][p] > 0)
                System.out.println("  [" + (p+1) + "] " + nombres[jugador][p]
                        + "  HP: " + vida[jugador][p]);

        int opcion = 0;
        boolean valido = false;
        while (!valido) {
            System.out.print("  Opcion: ");
            if (sc.hasNextInt()) {
                opcion = sc.nextInt();
                if (opcion >= 1 && opcion <= 3 && vida[jugador][opcion-1] > 0)
                    valido = true;
                else
                    System.out.println("  No disponible, intenta de nuevo.");
            } else sc.next();
        }
        System.out.println("  > " + nombres[jugador][opcion-1] + " entra a la batalla!\n");
        return opcion - 1;
    }

    static boolean hayHeroes(int[][] vida, int jugador) {
        for (int p = 0; p < 3; p++)
            if (vida[jugador][p] > 0) return true;
        return false;
    }

    static int siguienteHeroe(int[][] vida, int jugador) {
        for (int p = 0; p < 3; p++)
            if (vida[jugador][p] > 0) return p;
        return -1;
    }

    static int contarDisponibles(int[][] vida, int jugador) {
        int c = 0;
        for (int p = 0; p < 3; p++)
            if (vida[jugador][p] > 0) c++;
        return c;
    }
}
