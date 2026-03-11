import java.util.Scanner;

public class Eje2cine {
    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        String[][] asientos = new String[4][5];

        // para llenar la matriz con asientos libres
        for (int i = 0; i < asientos.length; i++) {
            for (int m = 0; m < asientos[i].length; m++) {
                asientos[i][m] = "L";
            }
        }

        System.out.println("Sistema de reservacion de asientos");

        // para mostrar los asientos
        for (int i = 0; i < asientos.length; i++) {
            for (int m = 0; m < asientos[i].length; m++) {
                System.out.print(asientos[i][m] + " ");
            }
            System.out.println();
        }

        System.out.print("\nIngrese el numero de fila (0-3): ");
        int fila = leer.nextInt();

        System.out.print("Ingrese el numero de columna (0-4): ");
        int columna = leer.nextInt();

        // para verificar si el asiento esta dentro del rango
        if (fila >= 0 && fila < 4 && columna >= 0 && columna < 5) {

            // para verificar si el asiento esta libre
            if (asientos[fila][columna].equals("L")) {//libre
                asientos[fila][columna] = "R";// ocupado
                System.out.println("El asiento ha sido reservado exitosamente");
            } else {
                System.out.println("Ese asiento ya esta reservado:)");
            }

        } else {
            System.out.println("Asiento invalido");
        }

        // para mostrar como quedaron los asientos
        for (int i = 0; i < asientos.length; i++) {
            for (int m = 0; m < asientos[i].length; m++) {
                System.out.print(asientos[i][m] + " ");
            }
            System.out.println();
        }

        leer.close();
    }
}