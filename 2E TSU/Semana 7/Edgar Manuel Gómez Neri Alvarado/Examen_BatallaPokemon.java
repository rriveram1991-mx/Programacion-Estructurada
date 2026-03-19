import java.util.Scanner;
import java.util.Random;

public class Examen_BatallaPokemon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        String[][] nombres = new String[2][3];
        int[][] hp = new int[2][3];
        int[][] hpMax = new int[2][3]; // Para no curar más del máximo
        int[][] ataque = new int[2][3];
        boolean[][] derrotado = new boolean[2][3];
        
        int[] pociones = {3, 3}; // 3 curaciones por jugador
        boolean[] defendiendo = {false, false};
        int[] activos = {-1, -1};
        int[] derrotas = {0, 0};
        int turno = 0;

        // 1. REGISTRO
        for (int j = 0; j < 2; j++) {
            System.out.println("\n--- Equipo Jugador " + (j + 1) + " ---");
            for (int p = 0; p < 3; p++) {
                System.out.print("Nombre Pokémon " + (p + 1) + ": ");
                nombres[j][p] = sc.next();
                System.out.print("HP: ");
                hp[j][p] = sc.nextInt();
                hpMax[j][p] = hp[j][p];
                System.out.print("Ataque: ");
                ataque[j][p] = sc.nextInt();
            }
        }

        // 2. COMBATE
        while (derrotas[0] < 3 && derrotas[1] < 3) {
            int rival = (turno == 0) ? 1 : 0;

            // Pokémon activo
            if (activos[turno] == -1 || derrotado[turno][activos[turno]]) {
                System.out.println("\n[JUGADOR " + (turno + 1) + "] ¡Saca un Pokémon!");
                for (int i = 0; i < 3; i++) {
                    if (!derrotado[turno][i]) System.out.println(i + ". " + nombres[turno][i] + " (HP: " + hp[turno][i] + ")");
                }
                activos[turno] = sc.nextInt();
            }

            // Forzar al rival a tener uno activo
            if (activos[rival] == -1) {
                System.out.println("\n[JUGADOR " + (rival + 1) + "] ¡Elige tu primer Pokémon!");
                for (int i = 0; i < 3; i++) System.out.println(i + ". " + nombres[rival][i]);
                activos[rival] = sc.nextInt();
            }

            System.out.println("\n>> TURNO: " + nombres[turno][activos[turno]] + " (J" + (turno + 1) + ")");
            System.out.println("Enemigo: " + nombres[rival][activos[rival]] + " (HP: " + hp[rival][activos[rival]] + ")");
            System.out.println("Pociones restantes: " + pociones[turno]);
            System.out.println("1. Atacar | 2. Defender | 3. Curar | 4. Cambiar Pokémon");
            int accion = sc.nextInt();

            if (accion == 1) { // Ataque
                if (rand.nextInt(100) < 15) { // 15% de fallo
                    System.out.println("¡El ataque de " + nombres[turno][activos[turno]] + " falló!");
                } else {
                    int danio = ataque[turno][activos[turno]];
                    if (defendiendo[rival]) {
                        danio /= 2;
                        System.out.println("¡Rival defendido! Daño reducido.");
                        defendiendo[rival] = false;
                    }
                    hp[rival][activos[rival]] -= danio;
                    System.out.println("¡" + nombres[turno][activos[turno]] + " quita " + danio + " HP!");
                    
                    if (hp[rival][activos[rival]] <= 0) {
                        hp[rival][activos[rival]] = 0;
                        derrotado[rival][activos[rival]] = true;
                        derrotas[rival]++;
                        System.out.println("¡" + nombres[rival][activos[rival]] + " cayó!");
                    }
                }
            } 
            else if (accion == 2) { // Defender
                defendiendo[turno] = true;
                System.out.println(nombres[turno][activos[turno]] + " se defiende.");
            } 
            else if (accion == 3) { // Curarse
                if (pociones[turno] > 0) {
                    int cura = 20; // Valor de curación fijo
                    hp[turno][activos[turno]] = Math.min(hp[turno][activos[turno]] + cura, hpMax[turno][activos[turno]]);
                    pociones[turno]--;
                    System.out.println("¡Curaste a " + nombres[turno][activos[turno]] + "! (HP: " + hp[turno][activos[turno]] + ")");
                } else {
                    System.out.println("¡No te quedan pociones! Pierdes el turno por distraído.");
                }
            } 
            else if (accion == 4) { // Cambio de pokemon
                System.out.println("Selecciona nuevo Pokémon:");
                for (int i = 0; i < 3; i++) {
                    if (!derrotado[turno][i] && i != activos[turno]) 
                        System.out.println(i + ". " + nombres[turno][i] + " (HP: " + hp[turno][i] + ")");
                }
                activos[turno] = sc.nextInt();
                System.out.println("¡Adelante " + nombres[turno][activos[turno]] + "!");
            }

            turno = rival; // Cambio de turno
        }

        System.out.println("\n=== ¡Fin del juego! GANADOR JUGADOR " + (derrotas[0] == 3 ? "2" : "1") + " ===");
    }
}