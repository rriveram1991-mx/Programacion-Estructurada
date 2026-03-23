package batallarpg;
import java.util.Scanner;
public class BatallaPorTurnos {
    static String[][] nombres = new String[2][3];
    static int[][] vida = new int[2][3];
    static int[][] ataque = new int[2][3];
    static int[][] magia = new int[2][3];
    static int[][] energia = new int[2][3];
    static boolean[][] vivo = new boolean[2][3];
    static int[][] curaciones = new int[2][3];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int j = 0; j < 2; j++) {
            System.out.println("Jugador " + (j + 1) + " registra sus héroes:");
            for (int h = 0; h < 3; h++) {
                System.out.print("Nombre del héroe " + (h + 1) + ": ");
                nombres[j][h] = sc.nextLine();
                vida[j][h] = 100;
                ataque[j][h] = 15;
                magia[j][h] = 25;
                energia[j][h] = 30;
                vivo[j][h] = true;
                curaciones[j][h] = 0;
            }}
        int turno = 0;
        while (hayVivos(0) && hayVivos(1)) {
            System.out.println("\n--- Turno del Jugador " + (turno + 1) + " ---");
            mostrarHeroes(turno);

            System.out.print("Elige héroe (0-2): ");
            int h = sc.nextInt();
            if (!vivo[turno][h]) {
                System.out.println("Ese héroe está muerto. Pierdes turno.");
                turno = 1 - turno;
                continue;
            }
            System.out.println("Acciones: 1) Ataque físico  2) Ataque mágico  3) Curarse  4) Cambiar héroe");
            int accion = sc.nextInt();
            switch (accion) {
                case 1 -> ataqueFisico(turno, h);
                case 2 -> ataqueMagico(turno, h);
                case 3 -> curarse(turno, h);
                case 4 -> {
                    System.out.println("Cambio de héroe permitido.");
                    continue;
                }
                default -> System.out.println("Acción inválida.");
            }
            turno = 1 - turno;
        }
        if (!hayVivos(0)) {
            System.out.println("¡Jugador 2 gana!");
        } else {
            System.out.println("¡Jugador 1 gana!");
        }}
    static void ataqueFisico(int jugador, int h) {
        int enemigo = 1 - jugador;
        int objetivo = elegirObjetivo(enemigo);
        int daño = ataque[jugador][h];

        int prob = (int)(Math.random() * 100);
        if (prob < 20) {
            daño *= 2;
            System.out.println("¡Golpe crítico!");
        }
        vida[enemigo][objetivo] -= daño;
        System.out.println(nombres[jugador][h] + " ataca físicamente a " + nombres[enemigo][objetivo] + " causando " + daño + " de daño.");
        validarMuerte(enemigo, objetivo);
    }
    static void ataqueMagico(int jugador, int h) {
        if (energia[jugador][h] < 10) {
            System.out.println("No tienes suficiente energía.");
            return;
        }
        int enemigo = 1 - jugador;
        int objetivo = elegirObjetivo(enemigo);
        int daño = magia[jugador][h];
        energia[jugador][h] -= 10;

        int prob = (int)(Math.random() * 100);
        if (prob < 20) {
            daño *= 2;
            System.out.println("¡Golpe crítico!");
        }
        vida[enemigo][objetivo] -= daño;
        System.out.println(nombres[jugador][h] + " lanza magia contra " + nombres[enemigo][objetivo] + " causando " + daño + " de daño.");
        validarMuerte(enemigo, objetivo);
    }
    static void curarse(int jugador, int h) {
        if (curaciones[jugador][h] >= 2) {
            System.out.println("Este héroe ya no puede curarse más.");
            return;
        }
        vida[jugador][h] += 20;
        curaciones[jugador][h]++;
        System.out.println(nombres[jugador][h] + " se cura 20 puntos de vida. Vida actual: " + vida[jugador][h]);
    }
    static void validarMuerte(int jugador, int h) {
        if (vida[jugador][h] <= 0) {
            vida[jugador][h] = 0;
            vivo[jugador][h] = false;
            System.out.println(nombres[jugador][h] + " ha muerto.");
        } else {
            System.out.println("Vida restante de " + nombres[jugador][h] + ": " + vida[jugador][h]);
        }}
    static boolean hayVivos(int jugador) {
        for (int h = 0; h < 3; h++) {
            if (vivo[jugador][h]) return true;
        }
        return false;
    }
    static void mostrarHeroes(int jugador) {
        for (int h = 0; h < 3; h++) {
            System.out.println(h + ") " + nombres[jugador][h] + " - Vida: " + vida[jugador][h] + " - Energía: " + energia[jugador][h] + " - Vivo: " + vivo[jugador][h]);
        }}
    static int elegirObjetivo(int jugador) {
        Scanner sc = new Scanner(System.in);
        mostrarHeroes(jugador);
        System.out.print("Elige objetivo (0-2): ");
        int obj = sc.nextInt();
        if (!vivo[jugador][obj]) {
            System.out.println("Ese héroe está muerto. Se elige automáticamente otro.");
            for (int h = 0; h < 3; h++) {
                if (vivo[jugador][h]) return h;
            }}
        return obj;
    }}