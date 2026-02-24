/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication39;

/**
 *
 * @author Oscar Sanchez JavaApplication39
 */
import java.util.Scanner;

public class JavaApplication39 {

    public static void main(String[] args) {
        // Objeto Scanner para capturar datos de consola
        Scanner sc = new Scanner(System.in);

        // --- INICIALIZACIÓN CORRECTA ---
        int opcion = 0;
        double total = 0;    // Se usa double para no perder decimales en la suma
        int contador = 0;    // Iniciamos en 0 para que el promedio sea exacto (n / n)

        System.out.println("=== SISTEMA DE EVALUACION ===");

        // El ciclo se mantiene mientras la opción no sea 4 (Salir)
        while (opcion != 4) {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Capturar 5 calificaciones");
            System.out.println("2. Mostrar promedio");
            System.out.println("3. Mostrar nivel");
            System.out.println("4. Salir");

            System.out.print("Seleccione opcion: ");
            
            // --- VALIDACIÓN DE TIPO DE DATO ---
            // Si el usuario ingresa una letra, el programa no "truena"
            if (!sc.hasNextInt()) {
                System.out.println("Error: Por favor, ingrese un número entero (1-4).");
                sc.next(); // Limpia el buffer del Scanner
                continue;  // Regresa al inicio del menú
            }
            
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    // --- REINICIO DE VARIABLES ---
                    // Limpiamos los acumuladores para que cada captura sea nueva
                    total = 0;
                    contador = 0;

                    // Eliminado el ';' que estaba después del for
                    for (int i = 1; i <= 5; i++) {
                        System.out.print("Ingrese calificacion " + i + " (0-10): ");
                        
                        // Capturamos la nota como double por si ingresan decimales (ej: 8.5)
                        double cal = sc.nextDouble();

                        // Bloque IF con llaves para asegurar que ambas líneas dependan del IF
                        if (cal >= 0 && cal <= 10) {
                            total = total + cal; // Acumula la suma
                            contador++;          // Cuenta solo si la nota es válida
                        } else {
                            System.out.println("Calificacion fuera de rango. No se sumará.");
                        }
                    }
                    break;

                case 2:
                    // --- CÁLCULO DE PROMEDIO ---
                    // Validación para evitar división por cero si no han capturado nada
                    if (contador == 0) {
                        System.out.println("No hay calificaciones registradas.");
                    } else {
                        // Al ser 'total' un double, el resultado mantiene los decimales
                        double promedio = total / contador;
                        // %.2f limita la salida a solo 2 decimales para que se vea limpio
                        System.out.printf("Promedio actual: %.2f%n", promedio);
                    }
                    break;

                case 3:
                    // --- EVALUACIÓN DE NIVEL ---
                    if (contador == 0) {
                        System.out.println("No hay datos para evaluar nivel.");
                    } else {
                        // Guardamos el promedio en una variable temporal para no recalcularlo
                        double promEval = total / contador;
                        
                        // Eliminados los ';' accidentales en los IF/ELSE
                        if (promEval >= 9) {
                            System.out.println("Nivel: Excelente");
                        } else if (promEval >= 8) {
                            System.out.println("Nivel: Bueno");
                        } else if (promEval >= 7) {
                            System.out.println("Nivel: Regular");
                        } else {
                            System.out.println("Nivel: Reprobado");
                        }
                    }
                    break;

                case 4:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida, intente de nuevo.");
            }
        }
        
        // Cerramos el recurso al terminar el programa
        sc.close();
    }
}
