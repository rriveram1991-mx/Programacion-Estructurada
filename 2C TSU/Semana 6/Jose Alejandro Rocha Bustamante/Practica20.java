import java.util.Scanner;

public class Practica20 {
  public static void main(String[]args){
  Scanner leer = new Scanner(System.in);

        String[][] asientos = new String[4][5];

        for(int i = 0; i < asientos.length; i++){
            for(int m = 0; m < asientos[i].length; m++){
                asientos[i][m] = "L"; // L para libre
            }
        }

    System.out.println("Bienvenido al sistema de reservación de asientos");
    for(int i = 0; i < asientos.length; i++){
       for(int m = 0; m < asientos[i].length; m++){
        System.out.print(asientos[i][m] + " ");
       }
      System.out.println();
    }
    System.out.print(" \nIngrese el numero de asiento de la fila: ");
    int fila = leer.nextInt();
    System.out.print("\nIngrese el numero de asiento de la columna: ");
    int columna = leer.nextInt();

    asientos[fila][columna] = "R"; // R para reservado
    System.out.println("El asiento ha sido reservado exitosamente");
    for(int i = 0; i < asientos.length; i++){
        for(int m = 0; m < asientos[i].length; m++){
         System.out.print(asientos[i][m] + " ");
        }
        System.out.println();
     }

     leer.close();
  }  
}
