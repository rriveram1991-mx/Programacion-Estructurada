import java.util.Scanner;
public class Estacionamiento {
    public static void main(String[] args) {

        int opcion ;
        int [][] asientos = {
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };
        Scanner scan = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("\nEstado actual del estacionamiento :");
            for (int[] fila : asientos) {
                for (int asiento : fila) {
                    System.out.print((asiento == 0 ? "[X]" : "[" + asiento + "]") + " ");
                }
                System.out.println();
            }

            System.out.println("¿En qué lugar se ocupará? (1-9):");
            opcion = scan.nextInt();

            boolean encontrado = false;
            for (int i = 0; i < asientos.length; i++) {
                for (int j = 0; j < asientos[i].length; j++) {
                    if (asientos[i][j] == opcion && opcion != 0) {
                        asientos[i][j] = 0; // Marcar como ocupado
                        System.out.println("Lugar " + opcion + " ocupado con éxito en la fila " + (i + 1));
                        encontrado = true;
                        break;
                    }
                }
                if (encontrado) break;
            }

            if (!encontrado) {
                System.out.println("Lugar no disponible ");
            }

            System.out.println("¿Desea ocupar otro lugar? (1: Sí / 2: No)");
            int respuesta = scan.nextInt();
            if (respuesta != 1) {
                continuar = false;
            }
        }

        scan.close();
    }
}
