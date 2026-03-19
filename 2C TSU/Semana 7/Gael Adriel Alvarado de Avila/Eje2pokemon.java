import java.util.Scanner;

public class Eje2pokemon {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        
        String[][] nombre = new String[2][3];
        int[][] vida = new int[2][3];
        int[][] ataque = new int[2][3];

        int derrotadasJ1 = 0;
        int derrotadasJ2 = 0;

        for (int j = 0; j < 2; j++) {
            System.out.println("Jugador " + (j + 1));

            for (int i = 0; i < 3; i++) {
                System.out.println("Criatura " + (i + 1));

                System.out.print("Nombre: ");
                nombre[j][i] = sc.next();

                System.out.print("Vida: ");
                vida[j][i] = sc.nextInt();

                System.out.print("Ataque: ");
                ataque[j][i] = sc.nextInt();
            }
        }

        System.out.println("Jugador 1 elige criatura (0-2): ");
        int c1 = sc.nextInt();

        System.out.println("Jugador 2 elige criatura (0-2): ");
        int c2 = sc.nextInt();

        while (derrotadasJ1 < 3 && derrotadasJ2 < 3) {

            while (vida[0][c1] > 0 && vida[1][c2] > 0) {

                vida[1][c2] -= ataque[0][c1];
                System.out.println(nombre[0][c1] + " ataca");
                System.out.println("Vida restante: " + vida[1][c2]);

                if (vida[1][c2] <= 0) {
                    System.out.println(nombre[1][c2] + " ha sido derrotado");
                    derrotadasJ2++;

                    if (derrotadasJ2 < 3) {
                        System.out.println("Jugador 2 elige otra criatura:");
                        c2 = sc.nextInt();
                    }
                    break;
                }

                vida[0][c1] -= ataque[1][c2];
                System.out.println(nombre[1][c2] + " ataca");
                System.out.println("Vida restante: " + vida[0][c1]);

                if (vida[0][c1] <= 0) {
                    System.out.println(nombre[0][c1] + " a sido derrotado!");
                    derrotadasJ1++;

                    if (derrotadasJ1 < 3) {
                        System.out.println("Jugador 1 elige otra criatura:");
                        c1 = sc.nextInt();
                    }
                    break;
                }
            }
        }

        if (derrotadasJ1 == 3) {
            System.out.println("Jugador 2 gano");
        } else {
            System.out.println("Jugador 1 gano");
        }

    }
}