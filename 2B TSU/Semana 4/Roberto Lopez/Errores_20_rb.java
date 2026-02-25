/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package errores_20_rb;

import java.util.Scanner;

/**
 *Alumno: Roberto Carlos Lopez Flores"2,B"
 * 
 */
public class Errores_20_rb {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Creamos el objeto Scanner

        // Declaración de variables iniciales
        double total = 0; // Acumulador de las notas ingresadas
        int cantidad = 0; // Contador de cuántas notas son válidas
        int aprobados = 0; // Contador para alumnos con nota >= 7
        int reprobados = 0; // Contador para alumnos con nota < 7
        boolean salir = false; // Bandera para controlar el ciclo principal

        System.out.println("=== SISTEMA DE CONTROL DE NOTAS ===");

        while (!salir) { // Ciclo que mantiene el programa activo
            System.out.println("\n1. Capturar notas\n2. Mostrar promedio\n3. Mostrar estadisticas\n4. Reiniciar datos\n5. Salir");
            System.out.print("Seleccione opcion: ");
            int opcion = sc.nextInt(); // Leemos la opción del menú
            sc.nextLine(); // Limpiamos el búfer para evitar errores en la siguiente lectura

            switch (opcion) {
                case 1 -> { // Opción para ingresar nuevas notas
                    System.out.print("Cuantas notas desea capturar: ");
                    int n = sc.nextInt();
                    sc.nextLine(); // Limpieza de búfer tras leer entero
                    
                    for (int i = 0; i < n; i++) { // Bucle para capturar N cantidad de notas
                        System.out.print("Ingrese nota #" + (i + 1) + ": ");
                        double nota = Double.parseDouble(sc.nextLine()); // Convertimos la entrada a double
                        
                        if (nota >= 0 && nota <= 10) { // Validamos que la nota sea real
                            total += nota; // Sumamos al total
                            cantidad++; // Incrementamos el contador
                            if (nota >= 7) aprobados++; // Clasificamos como aprobado
                            else reprobados++; // Clasificamos como reprobado
                        } else {
                            System.out.println("Nota invalida. Intente de nuevo.");
                            i--; // Restamos 1 al índice para repetir la captura de esta nota
                        }
                    }
                }
                case 2 -> { // Opción para calcular y mostrar el promedio
                    if (cantidad > 0) {
                        double promedio = total / cantidad; // Cálculo matemático
                        System.out.println("Promedio: " + promedio);
                    } else System.out.println("No hay notas registradas.");
                }
                case 3 -> { // Opción para ver conteo de aprobados/reprobados
                    System.out.println("Aprobados: " + aprobados + "\nReprobados: " + reprobados);
                }
                case 4 -> { // Opción para limpiar todas las variables
                    total = 0; cantidad = 0; aprobados = 0; reprobados = 0;
                    System.out.println("Datos Reiniciados.");
                }
                case 5 -> { // Opción para terminar el programa
                    salir = true;
                    System.out.println("Saliendo...");
                }
                default -> System.out.println("Opcion no valida.");
            }
        }
        sc.close(); // Cerramos el Scanner al finalizar
    }
}
