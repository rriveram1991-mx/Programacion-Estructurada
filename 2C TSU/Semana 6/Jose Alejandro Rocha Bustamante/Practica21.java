import java.util.Scanner;
public class Practica21 {
     public static void main(String[]args){
  Scanner leer = new Scanner(System.in);

        String[][] estacionamiento = new String[6][8];

        for(int i = 0; i < estacionamiento.length; i++){
            for(int m = 0; m < estacionamiento[i].length; m++){
                estacionamiento[i][m] = "L"; // L para libre
            }
        }

    System.out.println("Bienvenido al sistema de reservación de estacionamiento");
    for(int i = 0; i < estacionamiento.length; i++){
       for(int m = 0; m < estacionamiento[i].length; m++){
        System.out.print(estacionamiento[i][m] + " ");
       }
      System.out.println();
    }
    System.out.print(" \nIngrese el numero de asiento de la fila: ");
    int fila = leer.nextInt();
    System.out.print("\nIngrese el numero de asiento de la columna: ");
    int columna = leer.nextInt();

    estacionamiento[fila][columna] = "O"; // O para ocupado
    System.out.println("El lugar ha sido ocupado exitosamente");
    for(int i = 0; i < estacionamiento.length; i++){
        for(int m = 0; m < estacionamiento[i].length; m++){
         System.out.print(estacionamiento[i][m] + " ");
        }
        System.out.println();
     }

     leer.close();
}
}
