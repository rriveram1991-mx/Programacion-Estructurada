/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication40;

import java.util.Scanner;

/**
 *
 * @author lalit
 */
public class JavaApplication40 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

        int opcion = 0;
        int total = 0;
        int contador = 0;

        System.out.println("=== SISTEMA DE EVALUACION ===");

        while (opcion != 4) {

            System.out.println("1. Capturar calificaciones");
            System.out.println("2. Mostrar promedio");
            System.out.println("3. Mostrar nivel");
            System.out.println("4. Salir");

            System.out.print("Seleccione opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    for (int i = 1; i <= 5; i++) {
                        System.out.print("Ingrese calificacion " + i + ": ");
                        int cal = sc.nextInt();

                        if (cal >= 0 && cal <= 10) {
                            total = total + cal;
                            contador++;
                        } else {
                            System.out.println("Calificacion invalida");
                        }
                    }
                    break;

                case 2:
                    if (contador > 0) {
                        double promedio = (double) total / contador;
                        System.out.println("Promedio: " + promedio);
                    } else {
                        System.out.println("No hay calificaciones");
                    }
                    break;

                case 3:
                    if (contador > 0) {
                        double promedio = (double) total / contador;

                        if (promedio >= 9)
                            System.out.println("Excelente");
                        else if (promedio >= 8)
                            System.out.println("Bueno");
                        else if (promedio >= 7)
                            System.out.println("Regular");
                        else
                            System.out.println("Reprobado");
                    } else {
                        System.out.println("No hay calificaciones");
                    }
                    break;

                case 4:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opcion incorrecta");
            }
        }

        sc.close();
    }
}