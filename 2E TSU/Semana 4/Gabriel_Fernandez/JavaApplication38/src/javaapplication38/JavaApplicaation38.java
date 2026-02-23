/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication38;

import java.util.Scanner;
import java.util.ArrayList;

public class JavaApplicaation38 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> notas = new ArrayList<>();
        boolean salir = false;

        System.out.println("=== SISTEMA DE CONTROL DE NOTAS ===");

        while (!salir) {

            System.out.println("\n1. Capturar notas");
            System.out.println("2. Mostrar promedio");
            System.out.println("3. Mostrar estadísticas");
            System.out.println("4. Reiniciar datos");
            System.out.println("5. Salir");
            System.out.print("Seleccione opcion: ");

            int opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    System.out.print("¿Cuántas notas desea capturar?: ");
                    int cantidad = sc.nextInt();

                    for (int i = 0; i < cantidad; i++) {
                        System.out.print("Ingrese nota #" + (i + 1) + ": ");
                        int nota = sc.nextInt();

                        if (nota >= 0 && nota <= 10) {
                            notas.add(nota);
                        } else {
                            System.out.println("Nota inválida. Debe estar entre 0 y 10.");
                            i--; // repetir esa posición
                        }
                    }
                    break;

                case 2:
                    if (notas.isEmpty()) {
                        System.out.println("No hay notas registradas.");
                        break;
                    }

                    double total = 0;
                    for (int nota : notas) {
                        total += nota;
                    }

                    double promedio = total / notas.size();
                    System.out.println("Promedio: " + promedio);

                    if (promedio >= 9) {
                        System.out.println("Excelente");
                    } else if (promedio >= 8) {
                        System.out.println("Bueno");
                    } else if (promedio >= 7) {
                        System.out.println("Regular");
                    } else {
                        System.out.println("Reprobado");
                    }
                    break;

                case 3:
                    if (notas.isEmpty()) {
                        System.out.println("No hay datos para mostrar estadísticas.");
                        break;
                    }

                    int aprobados = 0;
                    int reprobados = 0;

                    for (int nota : notas) {
                        if (nota >= 7) {
                            aprobados++;
                        } else {
                            reprobados++;
                        }
                    }

                    System.out.println("Aprobados: " + aprobados);
                    System.out.println("Reprobados: " + reprobados);
                    break;

                case 4:
                    notas.clear();
                    System.out.println("Datos reiniciados correctamente.");
                    break;

                case 5:
                    salir = true;
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        }

        sc.close();
    }
}