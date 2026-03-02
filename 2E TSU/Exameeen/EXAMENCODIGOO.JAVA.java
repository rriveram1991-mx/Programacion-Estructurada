/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examen.codigoo;

import java.util.Scanner;

/**
 *
 * @author pablo
 */
public class EXAMENCODIGOO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
    Scanner scanner = new Scanner(System.in);
    boolean repetir = true;

    while (repetir) {
      System.out.println("1. Calcular promedio");
      System.out.println("2. Salir");
      System.out.print("Ingrese una opción: ");
      int opcion = scanner.nextInt();

      if (opcion == 1) {
        System.out.print("¿Cuántas calificaciones? ");
        int numCalificaciones = scanner.nextInt();
        double suma = 0;

        for (int i = 1; i <= numCalificaciones; i++) {
          double calificacion;
          while (true) {
            System.out.print("Ingrese calificación " + i + ": ");
            calificacion = scanner.nextDouble();
            if (calificacion >= 0 && calificacion <= 100) {
              break;
            } else {
              System.out.println("Calificación inválida");
            }
          }
          suma += calificacion;
        }

        System.out.println("Promedio: " + (suma / numCalificaciones));
      } else if (opcion == 2) {
        repetir = false;
        System.out.println("Adiós");
      } else {
        System.out.println("Opción no válida");
      }
    }
  }
}

    

