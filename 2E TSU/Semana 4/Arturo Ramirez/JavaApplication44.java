/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication44;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author artur
 */
public class JavaApplication44 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
                List<Integer> notasRegistradas = new ArrayList<>();
        boolean salir = false;

        System.out.println("=== SISTEMA DE CONTROL DE NOTAS ===");

        while (!salir) {
            System.out.println("\n1. Capturar notas");



        Scanner sc = new Scanner(System.in);
        int opcion = 0;

            System.out.println("2. Mostrar promedio");
            System.out.println("3. Mostrar estadisticas");
            System.out.println("4. Reiniciar datos");
            System.out.println("5. Salir");
            System.out.print("Seleccione opcion: ");

            while (!sc.hasNextInt()) {
                System.out.println("Entrada inválida. Ingrese un número entre 1 y 5.");
                sc.next();
            }
            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> {
                    System.out.print("¿Cuántas notas desea capturar?: ");
                    while (!sc.hasNextInt()) {
                        System.out.println("Entrada inválida. Ingrese un número positivo.");
                        sc.next();
                    }
                    int cantidadNotasACapturar = sc.nextInt();

                    if (cantidadNotasACapturar <= 0) {
                        System.out.println("Debe ingresar al menos 1 nota.");
                        break;
                    }

                    int notasInvalidas = 0;
                    for (int i = 1; i <= cantidadNotasACapturar; i++) {
                        System.out.print("Ingrese nota #" + i + " (0-10): ");
                        while (!sc.hasNextInt()) {
                            System.out.println("Entrada inválida. Ingrese un número entre 0 y 10.");
                            sc.next();
                        }
                        int nota = sc.nextInt();

                        if (nota >= 0 && nota <= 10) {
                            notasRegistradas.add(nota);
                        } else {
                            System.out.println("Nota inválida (debe estar entre 0 y 10). No se registró.");
                            notasInvalidas++;
                        }
                    }
                    System.out.println("Captura finalizada. Notas válidas registradas: " + notasRegistradas.size() + ". Notas inválidas: " + notasInvalidas);
                        }

                case 2 -> {
                    if (notasRegistradas.isEmpty()) {
                        System.out.println("No hay notas registradas para calcular el promedio.");
                        break;
                    }
                    double sumaTotal = 0.0;
                    for (int nota : notasRegistradas) {
                        sumaTotal += nota;
                    }
                    double promedio = sumaTotal / notasRegistradas.size();
                    System.out.printf("Promedio: %.2f%n", promedio);

                    if (promedio >= 9) {
                        System.out.println("Excelente");
                    } else if (promedio >= 8) {
                        System.out.println("Bueno");
                    } else if (promedio >= 7) {
                        System.out.println("Regular");
                    } else {
                        System.out.println("Reprobado");
                    }   }

                case 3 -> {
                    if (notasRegistradas.isEmpty()) {
                        System.out.println("No hay notas registradas para mostrar estadísticas.");
                        break;
                    }
                    int aprobados = 0;
                    int reprobados = 0;
                    int notaMaxima = Integer.MIN_VALUE;
                    int notaMinima = Integer.MAX_VALUE;

                    for (int nota : notasRegistradas) {
                        if (nota >= 7) {
                            aprobados++;
                        } else {
                            reprobados++;
                        }
                        if (nota > notaMaxima) notaMaxima = nota;
                        if (nota < notaMinima) notaMinima = nota;
                    }

                    System.out.println("Estadísticas de notas:");
                    System.out.println("- Aprobados: " + aprobados);
                    System.out.println("- Reprobados: " + reprobados);
                    System.out.println("- Nota máxima: " + notaMaxima);
                    System.out.println("- Nota mínima: " + notaMinima);
                        }

                case 4 -> {
                    notasRegistradas.clear();
                    System.out.println("Datos reiniciados correctamente. No hay notas registradas.");
                        }

                case 5 -> {
                    salir = true;
                    System.out.println("Saliendo del sistema. ¡Hasta pronto!");
                        }

                default -> {
                    System.out.println("Opción no válida. Ingrese un número entre 1 y 5.");
                    
                    if (sc != null) 
                    
                       

        
