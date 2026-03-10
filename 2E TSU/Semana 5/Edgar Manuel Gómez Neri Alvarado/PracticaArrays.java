package PracticaArrays;
import java.util.Scanner;
import java.util.Arrays;
public class PracticaArrays {

    public static void main(String[] args) {
                Scanner output = new Scanner(System.in);
      // ---------------------------------------------------------------------------------------------------------------------

      /*
       0 = Libre
       1 = Ocupado
      */
       int valor;

      boolean finish = true;
      while (true == finish) {
          
          System.out.println("Fila: ");
          int n1 = output.nextInt();
          System.out.println("Columna: ");
          int n2 = output.nextInt();
          
               int[][] Asientos = {

          {1,0,0},
          {0,0,0},
          {0,0,0}
      };
        
       int valor1 = Asientos[n1][n2];
               if (valor1 == 0) {
                   System.out.println("Se ha seleccionado el asiento en la posicion: ("+n1+","+n2+")");
               Asientos[n1][n2] = 1;
               } else {
                   System.out.println("El asiento esta ocupado.");
                   System.out.println(valor1);
               }
               
               for (int i = 0; i < Asientos.length; i++) { // Filas

                   for (int j = 0; j < Asientos[i].length; j++) { // Columnas
              valor = Asientos[i][j];
              System.out.print(Asientos[i][j] + " ");
              
                   }
               System.out.println("");
               }
               System.out.println("Seleccionar otro asiento? (true/false)");
               finish = output.hasNext();
      } 
}}
