import java.util.Scanner;

public class AsientosCine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] cine = new char[5][5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                cine[i][j] = 'L';
            }
        }

        cine[2][2] = 'O';
        cine[0][4] = 'O';

        System.out.println("Pantalla");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print("[" + cine[i][j] + "] ");
            }
            System.out.println();
        }

        System.out.print("Fila (0-4): ");
        int fila = sc.nextInt();
        System.out.print("Asiento (0-4): ");
        int asiento = sc.nextInt();

        if (cine[fila][asiento] == 'L') {
            cine[fila][asiento] = 'O';
            System.out.println("Asiento reservado");
        } else {
            System.out.println("Asiento ocupado");
        }

        sc.close();
    }
}

import java.util.Scanner;

public class Estacionamiento {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] lugares = new int[4][4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                lugares[i][j] = 0;
            }
        }

        lugares[1][1] = 1;
        lugares[3][2] = 1;

        System.out.println("Estacionamiento (0=Libre, 1=Ocupado)");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print("[" + lugares[i][j] + "] ");
            }
            System.out.println();
        }

        System.out.print("Ingresar auto en piso (0-3): ");
        int piso = sc.nextInt();
        System.out.print("Ingresar auto en lugar (0-3): ");
        int lugar = sc.nextInt();

        if (lugares[piso][lugar] == 0) {
            lugares[piso][lugar] = 1;
            System.out.println("Auto estacionado");
        } else {
            System.out.println("Lugar no disponible");
        }

        sc.close();
    }
}