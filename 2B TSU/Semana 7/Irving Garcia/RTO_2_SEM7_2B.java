import java.util.Scanner;

public class RTO_2_SEM7_2B {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] jugadores = new String[2];
        String[][][] pokemones = new String[2][3][3];
        int[][] vida = new int[2][3];
        int[][] ataque = new int[2][3];
        int opcion = 0;

        int actualJ1 = 0;
        int actualJ2 = 0;

        System.out.println("================ BIENVENIDO ================");

        while (opcion != 3) {

            System.out.println("       1. Iniciar juego");
            System.out.println("       2. Instrucciones");
            System.out.println("       3. Salir del juego");
            System.out.println("============================================");
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                // REGISTRAR TUS DATOS
                case 1:
                    for (int p = 0; p < 2; p++) {
                    System.out.print("Ingrese el nombre del jugador " + (p + 1) + ": ");
                    jugadores[p] = sc.nextLine();
                    System.out.println("============================================");

                }
                // REGISTRAR POKEMONES
                for (int p = 0; p < 2; p++) {

                    System.out.println("\nJugador: " + jugadores[p]);

                    for (int a = 0; a < 3; a++) {

                        System.out.println("Pokemon " + (a + 1));

                        System.out.print("Nombre: ");
                        pokemones[p][a][0] = sc.nextLine();

                        System.out.print("Salud: ");
                        vida[p][a] = Integer.parseInt(sc.nextLine());

                        System.out.print("Ataque: ");
                        ataque[p][a] = Integer.parseInt(sc.nextLine());
                        System.out.println("============================================");
                    }
                }

                // Mostrar datos
                System.out.println("============= DATOS REGISTRADOS ============");

                for (int p = 0; p < 2; p++) {

                    System.out.println("\nJugador " + jugadores[p]);

                    for (int a = 0; a < 3; a++) {

                        System.out.println(
                            "Nombre: " + pokemones[p][a][0] +
                            " | Salud: " + vida[p][a] +
                            " | Ataque: " + ataque[p][a]
                        );
                    }
                    System.out.println("============================================");
                }

                // Sistema de combate
                while (true) {
                    // Turno jugador 1
                    System.out.println("Turno de " + jugadores[0]);
                    vida[1][actualJ2] -= ataque[0][actualJ1];
                    System.out.println("El pokemon enemigo ahora tiene: " + vida[1][actualJ2] + " de vida");
                    if (vida[1][actualJ2] <= 0) {
                        System.out.println("Pokemon de J2 derrotado");
                        actualJ2++;

                        if (actualJ2 >= 3) {
                            System.out.println("Gana Jugador 1");
                            break;
                        }
                    }

                    // Turno jugador 2
                    System.out.println("Turno de " + jugadores[1]);
                    vida[0][actualJ1] -= ataque[1][actualJ2];
                    System.out.println("El pokemon enemigo ahora tiene: " + vida[0][actualJ1] + " de vida");
                    if (vida[0][actualJ1] <= 0) {
                        System.out.println("Pokemon de J1 derrotado");
                        actualJ1++;

                        if (actualJ1 >= 3) {
                            System.out.println("Gana Jugador 2");
                            break;
                        }
                    }
                }
                break;
                case 2:
                    System.out.println("=========================================================");
                    System.out.println("                      INSTRUCCIONES");
                    System.out.println("                   Ingresar 2 jugadores");
                    System.out.println("             Ingresar 3 pokemones por jugador");
                    System.out.println("Si los 3 pokemones del otro rival se quedan si vida ganas");
                    System.out.println("=========================================================");
                    break;

                case 3:
                    System.out.println("=========================================");
                    System.out.println("        Gracias por jugar pokemon        ");
                    System.out.println("     PORFAVOR NINTENDO NO ME DEMANDES    ");
                    System.out.println("=========================================");
                    break;

                default:
                    System.out.println("Opción no reconocida");
                    break;
            }
        }
        sc.close();
    }
}