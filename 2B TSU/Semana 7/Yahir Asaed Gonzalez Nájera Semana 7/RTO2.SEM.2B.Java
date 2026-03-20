import java.util.Scanner;

public class EjerciciosIngRicardo55 {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        
        String[][] nombres = new String[2][3];
        int[][] vidas = new int[2][3];
        int[][] ataquesPoder = new int[2][3];

        int opcionPrincipal = 0;

        while (opcionPrincipal != 3) {
            System.out.println("\n=== MENU POKEMON ===");
            System.out.println("1. Registrar Equipos");
            System.out.println("2. Iniciar Batalla");
            System.out.println("33. Salir");
            System.out.print("Selección: ");
            opcionPrincipal = leer.nextInt();

            switch (opcionPrincipal) {
                case 1:
                    for (int j = 0; j < 2; j++) {
                        System.out.println("\n--- REGISTRO ENTRENADOR " + (j + 1) + " ---");
                        for (int i = 0; i < 3; i++) {
                            System.out.print("Nombre del Pokemon " + (i + 1) + ": ");
                            nombres[j][i] = leer.next();
                            System.out.print("Vida (HP): ");
                            vidas[j][i] = leer.nextInt();
                            System.out.print("Ataque: ");
                            ataquesPoder[j][i] = leer.nextInt();
                        }
                    }
                    break;

                case 2:
                    System.out.print("\nJugador 1, elige tu pokemon inicial (0, 1 o 2): ");
                    int p1 = leer.nextInt();
                    System.out.print("Jugador 2, elige tu pokemon inicial (0, 1 o 2): ");
                    int p2 = leer.nextInt();

                    int vivos1 = 3, vivos2 = 3;
                    
                    while (vivos1 > 0 && vivos2 > 0) {
                        System.out.println("\n--- TURNO JUGADOR 1 ---");
                        System.out.println("Pokemon activo: " + nombres[0][p1] + " (HP: " + vidas[0][p1] + ")");
                        System.out.println("1. Atacar");
                        System.out.println("2. Capturar pokemon");
                        System.out.println("3. Huir");
                        System.out.print("Acción: ");
                        int accion = leer.nextInt();
                        
                        boolean turnoUsadoJ1 = true; 

                        if (accion == 1) {
                            System.out.println("¡" + nombres[0][p1] + " ataca!");
                            vidas[1][p2] -= ataquesPoder[0][p1];
                        } else if (accion == 2) {
                            System.out.println("No puedes capturar al pokemon enemigo, cuidado!");
                        } else if (accion == 3) {
                            System.out.println("No puedes huir de un combate de entrenador, no seas culo");
                        }
                        if (vidas[1][p2] <= 0) {
                            System.out.println("¡" + nombres[1][p2] + " ha sido derrotado!");
                            vivos2--;
                            if (vivos2 > 0) {
                                System.out.print("Jugador 2, elige al siguiente (0, 1 o 2): ");
                                p2 = leer.nextInt();
                                turnoUsadoJ1 = false; // El nuevo Pokémon entra; el J2 no ataca este turno
                            } else {
                                System.out.println("¡JUGADOR 1 GANA LA BATALLA!");
                                break;
                            }
                        }

                        if (turnoUsadoJ1 && vidas[1][p2] > 0) {
                            System.out.println("\n--- TURNO JUGADOR 2 ---");
                            System.out.println("¡" + nombres[1][p2] + " responde el ataque!");
                            vidas[0][p1] -= ataquesPoder[1][p2];
                            System.out.println("HP de " + nombres[0][p1] + " baja a: " + vidas[0][p1]);
                            
                            if (vidas[0][p1] <= 0) {
                                System.out.println("¡" + nombres[0][p1] + " ha sido derrotado!");
                                vivos1--;
                                if (vivos1 > 0) {
                                    System.out.print("Jugador 1, elige al siguiente (0, 1 o 2): ");
                                    p1 = leer.nextInt();
                                } else {
                                    System.out.println("¡JUGADOR 2 GANA LA BATALLA!");
                                    break;
                                }
                            }
                        }
                    }
                    break;
            }
        }
    }
}