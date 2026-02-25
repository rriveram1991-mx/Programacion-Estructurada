/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication45;
  import java.util.Scanner;
/**
 *
 * @author artur
 */
public class JavaApplication45 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try ( // TODO code application logic here
                Scanner sc = new Scanner(System.in)) {
            int opcion = 0;
            
            System.out.println("=== SISTEMA DE EVALUACION ===");
            
            while (opcion != 4) {
                // Mostrar menú
                System.out.println("\n1. Capturar calificaciones");
                System.out.println("2. Mostrar promedio");
                System.out.println("3. Mostrar nivel");
                System.out.println("4. Salir");
                System.out.print("Seleccione opcion: ");
                
                // Validar entrada de opción
                if (!sc.hasNextInt()) {
                    System.out.println("Entrada invalida: debe ingresar un numero entero.");
                    sc.next(); // Limpiar buffer
                    continue;
                }
                opcion = sc.nextInt();
                
                // Variables locales para cada captura de calificaciones
                int total = 0;
                int contadorValidos = 0;
                
                switch (opcion) {
                    case 1 -> {
                        System.out.println("\n--- CAPTURA DE 5 CALIFICACIONES VALIDAS (0-10) ---");
                        int calificacionesNecesarias = 5;
                        while (contadorValidos < calificacionesNecesarias) {
                            System.out.print("Ingrese calificacion " + (contadorValidos + 1) + ": ");
                            // Validar que la calificación sea entera
                            if (!sc.hasNextInt()) {
                                System.out.println("Entrada invalida: debe ingresar un numero entero entre 0 y 10.");
                                sc.next(); // Limpiar buffer
                                continue;
                            }
                            int cal = sc.nextInt();
                            if (cal >= 0 && cal <= 10) {
                                total += cal;
                                contadorValidos++;
                            } else {
                                System.out.println("Calificacion invalida: " + cal + ". Debe estar entre 0 y 10.");
                            }
                        }
                        System.out.println("Se capturaron " + contadorValidos + " calificaciones validas.");
                    }
                        
                    case 2 -> {
                        if (contadorValidos == 0) {
                            System.out.println("\nNo se han capturado calificaciones validas aun.");
                            break;
                        }
                        double promedio = (double) total / contadorValidos;
                        System.out.printf("\nPromedio: %.2f%n", promedio); // Mostrar 2 decimales
                    }
                        
                    case 3 -> {
                        if (contadorValidos == 0) {
                            System.out.println("\nNo se han capturado calificaciones validas aun.");
                            break;
                        }
                        double promedioNivel = (double) total / contadorValidos;
                        System.out.print("\nNivel: ");
                        if (promedioNivel >= 9) {
                            System.out.println("Excelente");
                        } else if (promedioNivel >= 8) {
                            System.out.println("Bueno");
                        } else if (promedioNivel >= 7) {
                            System.out.println("Regular");
                        } else {
                            System.out.println("Reprobado");
                        }
                    }
                        
                    case 4 -> System.out.println("\nSaliendo...");
                        
                    default -> System.out.println("\nOpcion incorrecta: debe seleccionar un numero entre 1 y 4.");
                }
            }
        }
    }
}
    