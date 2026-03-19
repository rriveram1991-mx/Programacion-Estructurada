import java.util.Scanner;

public class Pokemon {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Object[][] Pokemon = new Object[2][3];
        String jugador1, jugador2;

        System.out.println("Ingrese tu nombre jugador 1");
        jugador1 = scan.nextLine();
        System.out.println("Ingrese tu nombre jugador 2");
        jugador2 = scan.nextLine();
        for (int i = 0; i < Pokemon.length; i++) {
            String jugadorActual = (i == 0) ? jugador1 : jugador2;
            System.out.println("\n--- Turno de " + jugadorActual + " ---");

            for (int j = 0; j < Pokemon[i].length; j++) {
                System.out.println(jugadorActual + " ingresa los datos del Pokemon " + (j + 1));
                System.out.println("Ingrese el nombre del Pokemon");
                String nombre = scan.nextLine();
                System.out.println("Ingrese la vida del Pokemon");
                int vida = scan.nextInt();
                System.out.println("Ingrese el ataque del Pokemon");
                int ataque = scan.nextInt();
                scan.nextLine(); // Limpiar el buffer

                Pokemon[i][j] = new Object[] { nombre, vida, ataque };
            }
        }

        System.out.println("\n¡COMIENZA LA BATALLA!");
        int indiceP1 = 0, indiceP2 = 0;
        int victoriasP1 = 0, victoriasP2 = 0;

        while (indiceP1 < 3 && indiceP2 < 3) {
            Object[] datosP1 = (Object[]) Pokemon[0][indiceP1];
            Object[] datosP2 = (Object[]) Pokemon[1][indiceP2];

            int vida1 = (int) datosP1[1];
            int ataque1 = (int) datosP1[2];
            int vida2 = (int) datosP2[1];
            int ataque2 = (int) datosP2[2];

            System.out.println("\n--- Enfrentamiento: " + datosP1[0] + " vs " + datosP2[0] + " ---");

            while (vida1 > 0 && vida2 > 0) {
                vida2 -= ataque1;
                System.out.println(datosP1[0] + " ataca! " + datosP2[0] + " queda con " + Math.max(0, vida2) + " HP");
                if (vida2 <= 0) break;

                vida1 -= ataque2;
                System.out.println(datosP2[0] + " ataca! " + datosP1[0] + " queda con " + Math.max(0, vida1) + " HP");
            }

            if (vida1 <= 0) {
                System.out.println("¡" + datosP1[0] + " de " + jugador1 + " ha caído!");
                indiceP1++;
                victoriasP2++;
            } else {
                System.out.println("¡" + datosP2[0] + " de " + jugador2 + " ha caído!");
                indiceP2++;
                victoriasP1++;
            }
        }

        System.out.println("\n=============================================");
        System.out.println("            RESULTADO FINAL");
        System.out.println("=============================================");
        if (victoriasP1 > victoriasP2) {
            System.out.println("¡EL GANADOR ES " + jugador1.toUpperCase() + "!");
        } else if (victoriasP2 > victoriasP1) {
            System.out.println("¡EL GANADOR ES " + jugador2.toUpperCase() + "!");
        } else {
            System.out.println("¡EMPATE!");
        }
        System.out.println("Marcador: " + jugador1 + " [" + victoriasP1 + "] - [" + victoriasP2 + "] " + jugador2);
        
        System.out.println("\n¡FELICIDADES AL CAMPEÓN!");
        System.out.println("      _______________ ");
        System.out.println("     |@@@@@@@@@@@@@@@|");
        System.out.println("     |@@___________@@|");
        System.out.println("     |@@|         |@@|");
        System.out.println("     |@@|  [ 8 ]  |@@|");
        System.out.println("     |@@|_________|@@|");
        System.out.println("     |@@@@@@@@@@@@@@@|");
        System.out.println("     \\@@@@@@@@@@@@@@@/");
        System.out.println("      \\@@@@@@@@@@@@@/ ");
        System.out.println("       \\@@@@@@@@@@@/  ");
        System.out.println("        \\@@@@@@@@@/   ");
        System.out.println("         \\@@@@@@@/    ");
        System.out.println("          \\@@@@@/     ");
        System.out.println("           \\@@@/      ");
        System.out.println("            \\@/       ");
        System.out.println("             V        ");
        System.out.println( );

        scan.close();
    }
    
}
