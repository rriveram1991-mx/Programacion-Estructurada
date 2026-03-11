import java.util.Scanner;

public class Eje3estaciona {
    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        String[][] lugares = new String[4][5];

        // para llenar la matriz con lugares libres
        for (int i = 0; i < lugares.length; i++) {
            for (int m = 0; m < lugares[i].length; m++) {
                lugares[i][m] = "L";
            }
        }

        System.out.println("Bienvenido al sistema de estacionamiento");

        // para mostrar los lugares
        for (int i = 0; i < lugares.length; i++) {
            for (int m = 0; m < lugares[i].length; m++) {
                System.out.print(lugares[i][m] + " ");
            }
            System.out.println();
        }

        System.out.print("\nIngrese la fila del lugar (0-3): ");
        int fila = leer.nextInt();

        System.out.print("Ingrese la columna del lugar (0-4): ");
        int columna = leer.nextInt();

        // para verificar si el lugar esta dentro del rango
        if (fila >= 0 && fila < 4 && columna >= 0 && columna < 5) {

            // para verificar si el lugar esta libre
            if (lugares[fila][columna].equals("L")) {//libre
                lugares[fila][columna] = "O"; // ocupado
                System.out.println("Lugar ocupado correctamente");
            } else {
                System.out.println("Ese lugar ya esta ocupado");
            }

        } else {
            System.out.println("Lugar invalido");
        }

        // para mostrar como quedaron los lugares
        for (int i = 0; i < lugares.length; i++) {
            for (int m = 0; m < lugares[i].length; m++) {
                System.out.print(lugares[i][m] + " ");
            }
            System.out.println();
        }

        leer.close();
    }
}