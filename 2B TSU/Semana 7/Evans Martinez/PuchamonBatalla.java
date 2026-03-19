import java.util.Scanner;

public class PuchamonBatalla {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Simulador de Batalla de Puchamon (Consola) ===");
        System.out.println("Cada jugador registra 3 puchamones diferentes.");
        System.out.println();

        // 0 = Jugador 1 / 1 = Jugador 2
        String[][] nombres = new String[2][3];
        int[][] vida = new int[2][3];
        int[][] ataque = new int[2][3];

        // Registrar datos con for
        for (int jugador = 0; jugador < 2; jugador++) {
            System.out.println("Jugador " + (jugador + 1) + ", registra tus 3 puchamones:");
            for (int i = 0; i < 3; i++) {
                System.out.print("  Nombre puchamon " + (i + 1) + ": ");
                nombres[jugador][i] = sc.nextLine().trim();
                if (nombres[jugador][i].isEmpty()) {
                    nombres[jugador][i] = "Puchamon" + (i + 1);
                }
                while (true) {
                    System.out.print("    Vida (HP) -> ");
                    String sVida = sc.nextLine().trim();
                    try {
                        vida[jugador][i] = Integer.parseInt(sVida);
                        if (vida[jugador][i] <= 0) {
                            System.out.println("    La vida debe ser mayor a 0. Intenta otra vez.");
                            continue;
                        }
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("    Entrada inválida. Ingresa un número entero.");
                    }
                }
                while (true) {
                    System.out.print("    Ataque -> ");
                    String sAtaque = sc.nextLine().trim();
                    try {
                        ataque[jugador][i] = Integer.parseInt(sAtaque);
                        if (ataque[jugador][i] <= 0) {
                            System.out.println("    El ataque debe ser mayor a 0. Intenta otra vez.");
                            continue;
                        }
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("    Entrada inválida. Ingresa un número entero.");
                    }
                }
                System.out.println();
            }
        }

        System.out.println("\n=== ¡Comienza la batalla de puchamones! ===");

        int jugadorActual = 0; // 0 = Jugador 1, 1 = Jugador 2
        int[] activo = { -1, -1 }; // índice del puchamon activo de cada jugador

        // Elegir el puchamon inicial para cada jugador
        for (int jugador = 0; jugador < 2; jugador++) {
            activo[jugador] = elegirPuchamonVivo(sc, jugador, nombres, vida);
        }

        // Batalla por turnos (while)
        while (tienePuchamonVivo(vida, 0) && tienePuchamonVivo(vida, 1)) {
            int defensor = 1 - jugadorActual;
            String atacanteNombre = nombres[jugadorActual][activo[jugadorActual]];
            String defensorNombre = nombres[defensor][activo[defensor]];
            int dano = ataque[jugadorActual][activo[jugadorActual]];

            System.out.println();
            System.out.println("Jugador " + (jugadorActual + 1) + " elige a " + atacanteNombre + " para atacar.");
            System.out.println(atacanteNombre + " ataca! (dano: " + dano + ")");

            vida[defensor][activo[defensor]] -= dano;
            if (vida[defensor][activo[defensor]] < 0) {
                vida[defensor][activo[defensor]] = 0;
            }

            System.out.println(defensorNombre + " pierde " + dano + " de vida.");
            System.out.println("Vida restante de " + defensorNombre + ": " + vida[defensor][activo[defensor]]);

            // Revisar si el puchamon defensor está derrotado
            if (vida[defensor][activo[defensor]] <= 0) {
                System.out.println();
                System.out.println(defensorNombre + " ha sido derrotado!");

                // Si el defensor aún tiene puchamones vivos, pide elegir uno
                if (tienePuchamonVivo(vida, defensor)) {
                    System.out.println("Jugador " + (defensor + 1) + ", elige otro puchamon:");
                    activo[defensor] = elegirPuchamonVivo(sc, defensor, nombres, vida);
                }
            }

            // Cambiar turno al siguiente jugador
            jugadorActual = defensor;
        }

        int ganador = tienePuchamonVivo(vida, 0) ? 0 : 1;
        System.out.println();
        System.out.println("=== Fin de la batalla ===");
        System.out.println("Jugador " + (ganador + 1) + " gana! (¡puchamones de vete a la versh!)");

        sc.close();
    }

    private static boolean tienePuchamonVivo(int[][] vida, int jugador) {
        for (int i = 0; i < vida[jugador].length; i++) {
            if (vida[jugador][i] > 0) {
                return true;
            }
        }
        return false;
    }

    private static int elegirPuchamonVivo(Scanner sc, int jugador, String[][] nombres, int[][] vida) {
        while (true) {
            System.out.println("Puchamones disponibles del Jugador " + (jugador + 1) + ":");
            for (int i = 0; i < nombres[jugador].length; i++) {
                String nombre = nombres[jugador][i];
                int hp = vida[jugador][i];
                String estado = hp > 0 ? "(Vivo)" : "(Derrotado)";
                System.out.println("  " + (i + 1) + ". " + nombre + " - HP: " + hp + " " + estado);
            }
            System.out.print("Selecciona el número del puchamon: ");
            String seleccion = sc.nextLine().trim();

            try {
                int idx = Integer.parseInt(seleccion) - 1;
                if (idx < 0 || idx >= nombres[jugador].length) {
                    System.out.println("  Selección inválida. Debe ser un número entre 1 y " + nombres[jugador].length + ".\n");
                    continue;
                }
                if (vida[jugador][idx] <= 0) {
                    System.out.println("  Ese puchamon ya está derrotado. Elige otro.\n");
                    continue;
                }
                return idx;
            } catch (NumberFormatException e) {
                System.out.println("  Entrada inválida. Ingresa un número.\n");
            }
        }
    }
}
