import java.util.Scanner;
public class SimuladorPockemon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Arrays bidimensionales: [jugador][criatura]
        String[][] nombres = new String[2][3];
        int[][] hp = new int[2][3];
        int[][] ataque = new int[2][3];
        boolean[][] activo = new boolean[2][3]; // true si la criatura aún puede luchar

        // Registro de criaturas
        for (int jugador = 0; jugador < 2; jugador++) {
            System.out.println("Jugador " + (jugador + 1) + ", registra tus 3 criaturas:");
            for (int i = 0; i < 3; i++) {
                System.out.print("Nombre de la criatura " + (i + 1) + ": ");
                nombres[jugador][i] = scanner.nextLine();

                System.out.print("Vida (HP) de " + nombres[jugador][i] + ": ");
                hp[jugador][i] = Integer.parseInt(scanner.nextLine());

                System.out.print("Ataque(valor del ataque) de " + nombres[jugador][i] + ": ");
                ataque[jugador][i] = Integer.parseInt(scanner.nextLine());

                activo[jugador][i] = true;
            }
            System.out.println();
        }

        // Selección inicial de criaturas
        System.out.println("¡Comienza la batalla!");
        System.out.print("Jugador 1, elige tu criatura inicial (1-3): ");
        int c1 = Integer.parseInt(scanner.nextLine()) - 1;

        System.out.print("Jugador 2, elige tu criatura inicial (1-3): ");
        int c2 = Integer.parseInt(scanner.nextLine()) - 1;

        int turno = 0; // 0 = Jugador 1 ataca, 1 = Jugador 2 ataca
        boolean juegoActivo = true;

        // Combate por turnos
        while (juegoActivo) {
            int atacante = turno % 2;
            int oponente = 1 - atacante;
            int criaturaAtacante = (atacante == 0) ? c1 : c2;
            int criaturaOponente = (oponente == 0) ? c1 : c2;

            // Ataque
            hp[oponente][criaturaOponente] -= ataque[atacante][criaturaAtacante];
            System.out.println(nombres[atacante][criaturaAtacante] + " ataca a " + 
                nombres[oponente][criaturaOponente] + " por " + 
                ataque[atacante][criaturaAtacante] + " puntos de daño.");

            // Verificar derrota
            if (hp[oponente][criaturaOponente] <= 0) {
                System.out.println(nombres[oponente][criaturaOponente] + " ha sido derrotado.");
                activo[oponente][criaturaOponente] = false;

                // Verificar si el oponente aún tiene criaturas
                boolean tieneVivas = false;
                for (int i = 0; i < 3; i++) {
                    if (activo[oponente][i]) {
                        tieneVivas = true;
                        break;
                    }
                }

                if (!tieneVivas) {
                    System.out.println("¡Jugador " + (atacante + 1) + " gana la batalla!");
                    juegoActivo = false;
                } else {
                    // Elegir nueva criatura
                    while (true) {
                        System.out.print("Jugador " + (oponente + 1) + 
                            ", elige una criatura activa (1-3): ");
                        int nueva = Integer.parseInt(scanner.nextLine()) - 1;
                        if (activo[oponente][nueva]) {
                            if (oponente == 0) c1 = nueva;
                            else c2 = nueva;
                            break;
                        }
                        System.out.println("Criatura no disponible. Elige otra.");
                    }
                }
            } else {
                System.out.println(nombres[oponente][criaturaOponente] + 
                    " tiene " + hp[oponente][criaturaOponente] + " HP restantes.");
            }

            // Cambiar turno
            turno++;
        }
        scanner.close();
    }
}   
