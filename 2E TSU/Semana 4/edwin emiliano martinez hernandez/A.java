/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package a;

import java.util.Scanner;

/**
 *
 * @author edwin
 */
public class A {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

    
Scanner sc = new Scanner(System.in);

        int opcion = 0;
        int total = 0;
        int cantidad = 0;
        boolean salir = false;

        System.out.println("=== SISTEMA DE CONTROL DE NOTAS ===");

        while (!salir) {

            System.out.println("\n1. Capturar notas");
            System.out.println("2. Mostrar promedio");
            System.out.println("3. Mostrar estadisticas");
            System.out.println("4. Reiniciar datos");
            System.out.println("5. Salir");

            System.out.print("Seleccione opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {

                case 1:

                    System.out.print("Cuantas notas desea capturar: ");
                    int n = sc.nextInt();

                    for (int i = 1; i <= n; i++) {

                        System.out.print("Ingrese nota #" + i + ": ");
                        int nota = sc.nextInt();

                        if (nota >= 0 && nota <= 10) {
                            total += nota;
                            cantidad++;
                        } else {
                            System.out.println("Nota invalida");
                        }
                    }
                    break;

                case 2:

                    if (cantidad == 0) {
                        System.out.println("No hay notas");
                        break;
                    }

                    double promedio = (double) total / cantidad;
                    System.out.println("Promedio: " + promedio);

                    if (promedio >= 9)
                        System.out.println("Excelente");
                    else if (promedio >= 8)
                        System.out.println("Bueno");
                    else if (promedio >= 7)
                        System.out.println("Regular");
                    else
                        System.out.println("Reprobado");

                    break;

                case 3:

                    if (cantidad == 0) {
                        System.out.println("No hay notas");
                        break;
                    }

                    if ((double) total / cantidad >= 7) {
                        System.out.println("Aprobados: " + cantidad);
                        System.out.println("Reprobados: 0");
                    } else {
                        System.out.println("Aprobados: 0");
                        System.out.println("Reprobados: " + cantidad);
                    }
                    break;

                case 4:

                    total = 0;
                    cantidad = 0;
                    System.out.println("Datos reiniciados");
                    break;

                case 5:

                    salir = true;
                    System.out.println("Saliendo del sistema");
                    break;

                default:
                    System.out.println("Opcion no valida");
            }
        }

        sc.close();
    }
    }
   
    

