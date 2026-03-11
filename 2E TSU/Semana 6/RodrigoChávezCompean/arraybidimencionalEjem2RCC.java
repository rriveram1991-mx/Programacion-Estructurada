import java.util.Scanner;

public class arraybidimencionalEjem2RCC {
    public static void main(String[] args) {Scanner sc = new Scanner(System.in);
        String[][] lugares = new String[3][3];

        for (int fila = 0; fila < 3; fila++) {
            for (int columna = 0; columna < 3; columna++) {
                lugares[fila][columna] = "L";
            }
        }

        mostrarMapa(lugares);

        System.out.print("Ingresa la fila (0-2): ");
        int fila = sc.nextInt();
        System.out.print("Ingresa la columna (0-2): ");
        int columna = sc.nextInt();

        if (lugares[fila][columna].equals("L")) {
            lugares[fila][columna] = "X";
            System.out.println("¡Has estacionado tu coche!");
        } else {
            System.out.println("Ese lugar ya está ocupado.");
        }

        mostrarMapa(lugares);
        sc.close();
    }

    public static void mostrarMapa(String[][] lugares) {
        System.out.println("Mapa del estacionamiento:");
        for (int fila = 0; fila < lugares.length; fila++) {
            for (int columna = 0; columna < lugares[fila].length; columna++) {
                System.out.print(lugares[fila][columna] + " ");
            }
            System.out.println();
        }
    }
}
