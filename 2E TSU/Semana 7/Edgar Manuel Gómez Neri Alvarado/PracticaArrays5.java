package PracticaArrays;
import java.util.Scanner;
import java.util.Arrays;
import java.io.FileWriter;
import java.io.IOException;
public class PracticaArrays5 {

    public static void main(String[] args) {
                Scanner output = new Scanner(System.in);
      // ---------------------------------------------------------------------------------------------------------------------

 /*
       0 = Libre
       8 = Ocupado
      */
       int valor;

                 int[][] Asientos = {
          {0,0,0,0,0},
          {0,0,0,0,0}
      };
                 
      boolean finish = true;
      while (true == finish) {
          

          System.out.println("""
                             1. Ver estacionamiento
                             2. Estacionar auto
                             3. Retirar auto
                             4. Contar espacios ocupados
                             5. Salir                
                             """);
            System.out.println("Opc: ");
          int n0 = output.nextInt();
          
          switch (n0) {
              case 1 ->  { System.out.println(""" 
                                              > Estado del Estacionamiento: 
                                                 0 - Lugar Libre.
                                                 1 - Lugar Ocupado.
                                              """);  // ---------------------------------------------------------------------------------------------------------------
              for (int i = 0; i < Asientos.length; i++) { // Filas

                   for (int j = 0; j < Asientos[i].length; j++) { // Columnas
              valor = Asientos[i][j];
              System.out.print(" "+Asientos[i][j] );
              }System.out.println("");}}
              case 2 -> { // -----------------------------------------------------------------------------------------------------------------------------------
                  System.out.println("> Estacionar auto");
                            System.out.println("\nFila: ");
          int n1 = output.nextInt();
          System.out.println("Columna: ");
          int n2 = output.nextInt();
 
       int valor1 = Asientos[n1][n2];
               if (valor1 == 0) {
                   System.out.println("Se ha seleccionado el estacionamiento en la posicion: ("+n1+","+n2+")");
               Asientos[n1][n2] = 1;
               } else {
                   System.out.println("El sitio esta ocupado.");
                   System.out.println(valor1);
               }
              }
              case 3 ->  { // -----------------------------------------------------------------------------------------------------------------------------------
                  System.out.println("> Retirar auto");
                            System.out.println("\nFila: ");
          int n1 = output.nextInt();
          System.out.println("Columna: ");
          int n2 = output.nextInt();
 
       int valor1 = Asientos[n1][n2];
               if (valor1 == 1) {
                   System.out.println("Se ha seleccionado el estacionamiento en la posicion: ("+n1+","+n2+")");
               Asientos[n1][n2] = 0;
               } else {
                   System.out.println("El sitio ya estaba libre.");
                   System.out.println(valor1);
               }
              }
              case 4 ->  { // -----------------------------------------------------------------------------------------------------------------------------------
                  System.out.println("> Contar espacios ocupados\n");
                  int valor1 = 0;
                             for (int i = 0; i < Asientos.length; i++) { // Filas
                   for (int j = 0; j < Asientos[i].length; j++) { // Columnas
                       if (Asientos[i][j] == 1) {
                       valor1 += 1;
                       }}}
              if (valor1 != 0) {
                           System.out.println(" - Cantidad de espacio ocupados: "+valor1);
                       }else { 
                           System.out.println(" - No hay vehiculos.");
                       }}
               case 5 ->{  System.out.println(">  Salir"); // ----------------------------------------------------------------------------------------------
               finish = false;
               }
              default ->  System.out.println("Error, Opcion no reconocida.");  // ----------------------------------------------------------------------
          }
          System.out.println("");
      } 
              try (FileWriter escritor = new FileWriter("Estacionamiento.txt")) {
                  escritor.write(""" 
                                              > Estado del Estacionamiento: 
                                                 0 - Lugar Libre.
                                                 1 - Lugar Ocupado.
                                 
                                              """);
                  for (int i = 0; i < Asientos.length; i++) { // Filas

                   for (int j = 0; j < Asientos[i].length; j++) { // Columnas
              valor = Asientos[i][j];
              escritor.write(" "+Asientos[i][j] );
              }escritor.write("\n");}
            // escritor.write
            
            System.out.println("¡Archivo creado con éxito!");
        } catch (IOException e) {
            System.out.println("Hubo un error al escribir: " + e.getMessage());
        }
}}
