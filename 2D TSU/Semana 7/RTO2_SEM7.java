import java.util.Scanner;

public class RTO2_SEM7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[][] nombres = new String[2][3];
        int[][] stats = new int[2][3]; 
        
        int[][][] pokemonStats = new int[2][3][2];

        //REGISTRO DE DATOS 
        for (int i = 0; i < 2; i++) {
            System.out.println("\n--- REGISTRO JUGADOR " + (i + 1) + " ---");
            for (int j = 0; j < 3; j++) {
                System.out.print("Nombre del Pokémon " + (j + 1) + ": ");
                nombres[i][j] = sc.next();
                System.out.print("Vida (HP): ");
                pokemonStats[i][j][0] = sc.nextInt();
                System.out.print("Puntos de Ataque: ");
                pokemonStats[i][j][1] = sc.nextInt();
            }
        }

        System.out.println("\n¡QUE COMIENCE LA BATALLA!");

        int derrotadosP1 = 0, derrotadosP2 = 0;
        int p1Actual = 0, p2Actual = 0;

        //LÓGICA DE BATALLA 
        while (derrotadosP1 < 3 && derrotadosP2 < 3) {
            
            System.out.println("\n>>> ENFRENTAMIENTO: " + nombres[0][p1Actual] + " VS " + nombres[1][p2Actual]);

            // Turno Jugador 1
            int danioP1 = pokemonStats[0][p1Actual][1];
            pokemonStats[1][p2Actual][0] -= danioP1;
            System.out.println(nombres[0][p1Actual] + " ataca! Daño: " + danioP1);
            
            // Condición de vida 
            if (pokemonStats[1][p2Actual][0] <= 0) {
                System.out.println("¡" + nombres[1][p2Actual] + " ha sido derrotado!");
                derrotadosP2++;
                p2Actual++; 
            } else {
                // Turno Jugador 2 
                int danioP2 = pokemonStats[1][p2Actual][1];
                pokemonStats[0][p1Actual][0] -= danioP2;
                System.out.println(nombres[1][p2Actual] + " contraataca! Daño: " + danioP2);
                
                if (pokemonStats[0][p1Actual][0] <= 0) {
                    System.out.println("¡" + nombres[0][p1Actual] + " ha sido derrotado!");
                    derrotadosP1++;
                    p1Actual++; 
                } else {
                    System.out.println("HP Restante - " + nombres[0][p1Actual] + ": " + pokemonStats[0][p1Actual][0] + 
                                       " | " + nombres[1][p2Actual] + ": " + pokemonStats[1][p2Actual][0]);
                }
            }
        }

        // --- RESULTADO FINAL ---
        System.out.println("\n========================");
        if (derrotadosP1 == 3) {
            System.out.println("¡EL JUGADOR 2 ES EL GANADOR!");
        } else {
            System.out.println("¡EL JUGADOR 1 ES EL GANADOR!");
        }
        System.out.println("========================");
    }
}
