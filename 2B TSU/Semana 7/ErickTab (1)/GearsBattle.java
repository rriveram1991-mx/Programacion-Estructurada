import java.util.Scanner;

public class pokemon {
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);

        // Cada jugador tendrá 3 puchamones con: nombre, vida, ataque
        String[][] tropa = new String[2][3];
        int[][] vida = new int[2][3];
        int[][] ataque = new int[2][3];

        System.out.println("------------- E-DAY ----------------");
        for (int player = 0; player < 2; player++) 
        {
            //roles de bando
            if (player == 0)
            {
                System.out.println("Your team is the COG");
            }
            else
            {
                System.out.println("Your team is the Locust Horde");
            }

            System.out.println("Player #" + (player + 1) + " :" );
            System.out.println("- Build your convoy -");
            for (int i = 0; i < 3; i++)
            {
                System.out.println("Troop #" + (i+1) + " :");
                System.out.print("Name :");
                tropa[player][i] = input.nextLine();

                System.out.print("HP :");
                vida[player][i] = input.nextInt();

                System.out.print("Damage :");
                ataque[player][i] = input.nextInt();
                input.nextLine();
            }
        }

        // tropa viva
        int turno1 = 0;
        int turno2 = 0;

        System.out.println("\n--- ¡who will have the domain in SERA! ---");
        System.out.println("Player 1 choose : " + tropa[0][turno1]);
        System.out.println("player 2 choose : " + tropa[1][turno2]);

        // Ciclo de combate
        while (true) 
        {
            //turno player1
            System.out.println("\n" + tropa[0][turno1] + " ATACK!");
            vida[1][turno2] -= ataque[0][turno1];
            System.out.println(tropa[1][turno2] + " LOSE " + ataque[0][turno1] + " HP POINTS.");
            System.out.println("Remaining life: " + Math.max(vida[1][turno2], 0));

            if (vida[1][turno1] <= 0) {
                System.out.println(tropa[1][turno2] + " HAS DIED!");
                turno2++;
                if (turno2 >= 3) {
                    System.out.println("¡Player 1 WIN!");
                    break;
                } else {
                    System.out.println("Player 2 choose : " + tropa[1][turno2]);
                }
            }

            //turno player2
            System.out.println("\n" + tropa[1][turno2] + " ATACK!");
            vida[0][turno1] -= ataque[1][turno2];
            System.out.println(tropa[0][turno1] + " LOSE " + ataque[1][turno2] + " HP POINTS.");
            System.out.println("Remaining life: " + Math.max(vida[0][turno1], 0));

            if (vida[0][turno1] <= 0) {
                System.out.println(tropa[0][turno1] + " HAS DIED!");
                turno1++;
                if (turno1 >= 3) 
                {
                     System.out.println("¡Player 2 WIN!");
                    break;
                } else 
                {
                    System.out.println("Player 1 WIN: " + tropa[0][turno1]);
                }
            }
        }

        input.close();
    }
}