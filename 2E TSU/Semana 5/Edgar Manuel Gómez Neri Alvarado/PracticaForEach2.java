package PracticaForEach;

import java.util.ArrayList; // Linea creada para el Uso del ArrayList

import java.util.Scanner;
public class PracticaForEach2 {

    public static void main(String[] args) {
                Scanner output = new Scanner(System.in);
      // ---------------------------------------------------------------------------------------------------------------------

      ArrayList<Integer> n = new ArrayList<>();
      n.add(1);
      n.add(2);
      n.add(3);
      n.add(4);
      
        for (int n0 : n) { // Ciclo forEach - Se repite por cada elemento de la tabla dada. (No permite cambiar el elemento de la lista.)
                    if (n0 % 2 == 0) {
                        System.out.println(n0);
                        }
        }

      
      
    }
}
