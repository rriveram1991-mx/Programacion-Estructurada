import java.util.Scanner;

public class RTO_1_SEM8_2B {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[][] nombres = new String[2][3];
        int[][] vida = new int[2][3];
        int[][] ataque = new int[2][3];
        int[][] magia = new int[2][3];
        int[][] energia = new int[2][3];
        boolean[][] vivo = new boolean[2][3];
        int[][] curaciones = new int[2][3];
        int opcion = 0;

        int actualJ1 = 0;
        int actualJ2 = 0;

        String[] heroes = {
            "Thoran", "Lyra", "Zephir", 
            "Kael", "Aldric", "Sylva"
        };

        int[] vidaBase = {150, 100, 80, 90, 130, 110};
        int[] ataqueBase = {40, 35, 20, 45, 30, 20};
        int[] magiaBase = {10, 15, 50, 10, 25, 40};
        int[] energiaBase = {20, 30, 100, 25, 50, 80};

        System.out.println("                 BIENVENIDO  ");

        while (opcion != 3) {

            System.out.println("============================================");
            System.out.println("       1. Iniciar juego");
            System.out.println("       2. Instrucciones");
            System.out.println("       3. Salir del juego");
            System.out.println("============================================");
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    // REGISTRO DE HÉROES
                    for (int jugador = 0; jugador < 2; jugador++) {
                        System.out.println("\nJugador " + (jugador + 1));

                        for (int i = 0; i < 3; i++) {
                            System.out.println("\nSelecciona un heroe:");

                            for (int j = 0; j < heroes.length; j++) {
                                System.out.println(j + ". " + heroes[j]);
                            }

                            int seleccion = sc.nextInt();

                            nombres[jugador][i] = heroes[seleccion];
                            vida[jugador][i] = vidaBase[seleccion];
                            ataque[jugador][i] = ataqueBase[seleccion];
                            magia[jugador][i] = magiaBase[seleccion];
                            energia[jugador][i] = energiaBase[seleccion];

                            vivo[jugador][i] = true;
                            curaciones[jugador][i] = 0;
                        }
                    }

                    // MOSTRAR DATOS
                    System.out.println("\n=== HEROES REGISTRADOS ===");

                    for (int jugador = 0; jugador < 2; jugador++) {
                        System.out.println("\nJugador " + (jugador + 1));

                        for (int i = 0; i < 3; i++) {
                            System.out.println("Heroe: " + nombres[jugador][i]);
                            System.out.println("Vida: " + vida[jugador][i]);
                            System.out.println("Ataque: " + ataque[jugador][i]);
                            System.out.println("Magia: " + magia[jugador][i]);
                            System.out.println("Energia: " + energia[jugador][i]);
                            System.out.println("Vivo: " + vivo[jugador][i]);
                            System.out.println("Curaciones: " + curaciones[jugador][i]);
                            System.out.println("============================");
                        }
                    }

                    // Sistema de combate
                    while (true) {

                        // TURNO JUGADOR 1
                        System.out.println("\nTurno Jugador 1 - " + nombres[0][actualJ1]);
                        System.out.println("Vida: " + vida[0][actualJ1] + " | Energia: " + energia[0][actualJ1]);

                        System.out.println("1. Atacar");
                        System.out.println("2. Magia");
                        System.out.println("3. Curarse");
                        System.out.println("4. Cambiar heroe");
                        int accion = sc.nextInt();

                        switch (accion) {
                            case 1:
                                int daño = ataque[0][actualJ1];
                                int prob = (int)(Math.random() * 100);
                                if (prob < 20) {
                                    daño *= 2;
                                    System.out.println("GOLPE CRITICO");
                                }
                                vida[1][actualJ2] -= daño;
                                System.out.println("Ataque realizado!");
                            break;

                            case 2:
                                if (energia[0][actualJ1] >= 10) {
                                    int dañoMagia = magia[0][actualJ1];
                                    int prob2 = (int)(Math.random() * 100);
                                    if (prob2 < 20) {
                                        dañoMagia *= 2;
                                        System.out.println("GOLPE CRITICO");
                                    }
                                    vida[1][actualJ2] -= dañoMagia;
                                    energia[0][actualJ1] -= 10;
                                    System.out.println("Ataque magico!");
                                } else {
                                    System.out.println("No tienes energia suficiente");
                                }
                            break;

                            case 3:
                                if (curaciones[0][actualJ1] < 2) {
                                    vida[0][actualJ1] += 20;
                                    curaciones[0][actualJ1]++;
                                    System.out.println("Te curaste");
                                } else {
                                    System.out.println("Ya no tienes curaciones");
                                }
                            break;

                            case 4:
                                System.out.println("Elige heroe:");
                                for (int i = 0; i < 3; i++) {
                                    if (vivo[0][i]) {
                                        System.out.println(i + ". " + nombres[0][i]);
                                    }
                                }
                                int cambio = sc.nextInt();
                                if (cambio >= 0 && cambio < 3 && vivo[0][cambio]) {
                                    actualJ1 = cambio;
                                    System.out.println("Cambio realizado!");
                                } else {
                                    System.out.println("Seleccion invalida");
                                }
                            break;
                        }

                        // Verificar si muere J2
                        if (vida[1][actualJ2] <= 0) {
                            System.out.println(nombres[1][actualJ2] + " ha sido derrotado");
                            vivo[1][actualJ2] = false;
                            actualJ2++;

                            if (actualJ2 >= 3) {
                                System.out.println("Gana Jugador 1");
                                break;
                            }
                        }

                        // TURNO JUGADOR 2
                        System.out.println("\nTurno Jugador 2 - " + nombres[1][actualJ2]);
                        System.out.println("Vida: " + vida[1][actualJ2] + " | Energia: " + energia[1][actualJ2]);

                        System.out.println("1. Atacar");
                        System.out.println("2. Magia");
                        System.out.println("3. Curarse");
                        System.out.println("4. Cambiar heroe");
                        accion = sc.nextInt();

                        switch (accion) {
                            case 1:
                                int daño = ataque[1][actualJ2];
                                int prob = (int)(Math.random() * 100);
                                if (prob < 20) {
                                    daño *= 2;
                                    System.out.println("GOLPE CRITICO");
                                }
                                vida[0][actualJ1] -= daño;
                                System.out.println("Ataque realizado");
                            break;

                            case 2:
                                if (energia[1][actualJ2] >= 10) {
                                    int dañoMagia = magia[1][actualJ2];
                                    int prob2 = (int)(Math.random() * 100);
                                    if (prob2 < 20) {
                                        dañoMagia *= 2;
                                        System.out.println("GOLPE CRITICO");
                                    }
                                    vida[0][actualJ1] -= dañoMagia;
                                    energia[1][actualJ2] -= 10;
                                    System.out.println("Ataque magico");
                                } else {
                                    System.out.println("No tienes energia suficiente");
                                }
                            break;

                            case 3:
                                if (curaciones[1][actualJ2] < 2) {
                                    vida[1][actualJ2] += 20;
                                    curaciones[1][actualJ2]++;
                                    System.out.println("Te curaste");
                                } else {
                                    System.out.println("Ya no tienes curaciones");
                                }
                            break;

                            case 4:
                                System.out.println("Elige heroe:");
                                for (int i = 0; i < 3; i++) {
                                    if (vivo[1][i]) {
                                        System.out.println(i + ". " + nombres[1][i]);
                                    }
                                }
                                int cambio = sc.nextInt();
                                if (cambio >= 0 && cambio < 3 && vivo[1][cambio]) {
                                    actualJ2 = cambio;
                                    System.out.println("Cambio realizado!");
                                } else {
                                    System.out.println("Seleccion invalida");
                                }
                            break;
                        }

                        // Verificar si muere J1
                        if (vida[0][actualJ1] <= 0) {
                            System.out.println(nombres[0][actualJ1] + " ha sido derrotado");
                            vivo[0][actualJ1] = false;
                            actualJ1++;

                            if (actualJ1 >= 3) {
                                System.out.println("Gana Jugador 2");
                                break;
                            }
                        }
                    }
                break;

                case 2:
                    System.out.println("                      INSTRUCCIONES");
                    System.out.println("=========================================================");
                    System.out.println("               Cada jugador elige 3 heroes");
                    System.out.println("                 El juego es por turnos");
                    System.out.println("=========================================================");
                    System.out.println("            Opciones por turno:");
                    System.out.println("            1. Atacar daño normal");
                    System.out.println("            2. Magia mas daño pero gasta energia");
                    System.out.println("            3. Curarse recupera vida (max 2 veces)");
                    System.out.println("            4. Cambiar heroe solo si esta vivo");
                    System.out.println("=========================================================");
                    System.out.println("        Existe probabilidad de golpe critico (20%)");
                    System.out.println("        Gana quien derrote a los 3 heroes enemigos");
                    System.out.println("=========================================================");
                break;

                case 3:
                    System.out.println("=========================================");
                    System.out.println("            Gracias por jugar            ");
                    System.out.println("=========================================");
                break;

                default:
                    System.out.println("Opcion no reconocida");
                break;
            }
        }

        sc.close();
    }
}