import java.util.Scanner;
public class Cine {
    public static void main(String[] args) {
        int opcion ;
        int [][] asientos = {
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };
        System.out.println("En que asiento le gustaria alojarse  (1,2,3,4,5,6,7,8,9)");
        Scanner scan = new Scanner(System.in);
        opcion = scan.nextInt();

        boolean encontrado = false;
        for (int i = 0; i < asientos.length; i++) {
            for (int j = 0; j < asientos[i].length; j++) {
                if (asientos[i][j] == opcion) {
                    System.out.println("Asiento " + opcion + " reservado con éxito en la fila " + (i + 1));
                    System.out.println("Estado actual de la sala:");
                    for (int[] fila : asientos) {
                        for (int asiento : fila) {
                            System.out.print((asiento == 0 ? "[X]" : "[" + asiento + "]") + " ");
                        }
                        System.out.println();
                    }
       asientos[i][j] = 0; // Marcar como ocupado
                    encontrado = true;
                    break;
                }
            }
            if (encontrado) break;

        }
scan.close();
    }
}

    

