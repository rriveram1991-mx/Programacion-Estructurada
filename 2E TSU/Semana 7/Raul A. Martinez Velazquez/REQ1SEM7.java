/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package req1sem7;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author pecha
 */
public class REQ1SEM7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       Scanner sc = new Scanner(System.in);
        int[][] lugar = new int[5][2];

        int opcion = 0;

        while (opcion != 5) {

            System.out.println("\n////// Estacionamientos //////");
            System.out.println("1. Ver estacionamiento");
            System.out.println("2. Estacionar auto");
            System.out.println("3. Retirar auto");
            System.out.println("4. Contar espacios ocupados");
            System.out.println("5. Salir");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1 -> {
                    System.out.println("Fila   Columna   Estado");

                    for (int y = 0; y < lugar.length; y++) {
                        for (int x = 0; x < lugar[y].length; x++) {

                            String estado = (lugar[y][x] == 0) ? "Libre" : "Ocupado";

                            System.out.println((y + 1) + "      " + (x + 1) + "      " + estado);
                        }
                    }
                }
                case 2 -> {
                    int f, col;
                    while (true) {
                        System.out.println("Elige la fila:");
                        f = sc.nextInt() - 1;

                        System.out.println("Elige la columna:");
                        col = sc.nextInt() - 1;

                        if (f < 0 || f >= lugar.length || col < 0 || col >= lugar[0].length) {
                            System.out.println("Valor no válido");
                        } else if (lugar[f][col] == 1) {
                            System.out.println("Lugar ocupado");
                        } else {
                            lugar[f][col] = 1;
                            System.out.println("Auto estacionado");
                      try {
                          File archivo = new File("estacionamiento.txt");
                          FileWriter fw = new FileWriter(archivo);

                          fw.write("Estacionado en el lugar: " + (f + 1) + "," + (col + 1) + "\n");
                          fw.write("Estado actual:\n");

                          for (int y = 0; y < lugar.length; y++) {
                          for (int x = 0; x < lugar[y].length; x++) {
                          fw.write(lugar[y][x] + " ");
                          }
                          fw.write("\n");
                          }
                          fw.close();
                          System.out.println("Lugar: " + (f + 1) + "," + (col + 1));
                          } catch (IOException e) {
                          System.out.println("Error al guardar archivo");
                          } 
                            break;
                        }
                    }
                }
               case 3 -> {
                    int f, col;
                    while (true) {
                        System.out.println("Elige la fila:");
                        f = sc.nextInt() - 1;

                        System.out.println("Elige la columna:");
                        col = sc.nextInt() - 1;

                        if (f < 0 || f >= lugar.length || col < 0 || col >= lugar[0].length) {
                            System.out.println("Valor no válido");
                        } else if (lugar[f][col] == 0) {
                            System.out.println("Lugar ya libre");
                        } else {
                            lugar[f][col] = 0;
                            System.out.println("Auto retirado");
                         try {
                         File archivo = new File("estacionamiento.txt");
                         FileWriter fw = new FileWriter(archivo);
                         fw.write("Acabas de retirar el auto del lugar: " + (f + 1) + "," + (col + 1) + "\n");
                         fw.write("Estado actual:\n");
                         for (int y = 0; y < lugar.length; y++) {
                         for (int x = 0; x < lugar[y].length; x++) {
                         fw.write(lugar[y][x] + " ");
                                     }
                         fw.write("\n");}
                         fw.close();
                         System.out.println("Acabas de retirar el auto del lugar: " + (f + 1) + "," + (col + 1));
                      } catch (IOException e) {
                      System.out.println("Error al guardar archivo");
                        }break;
                        }
                    }  }
                case 4 -> {
                    int contador = 0;

                    for (int y = 0; y < lugar.length; y++) {
                        for (int x = 0; x < lugar[y].length; x++) {
                            if (lugar[y][x] == 1) {
                                contador++;
                            }
                        }
                    }
                    System.out.println("Espacios ocupados: " + contador);
                }
                case 5 -> {
                    System.out.println("Saliendo...");
                }
                default -> {
                    System.out.println("Opción inválida");
                }
            }
        }
        sc.close();
    }
}
