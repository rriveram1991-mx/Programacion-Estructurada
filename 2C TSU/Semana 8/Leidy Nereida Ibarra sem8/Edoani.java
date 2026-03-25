/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package edoani;
import java.util.Scanner; 
/**
 *
 * @author leidy
 */
public class Edoani {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Scanner read = new Scanner(System.in);
        int[] estadosAnimo = new int[7];          // Guarda el estado de ánimo por día
        int[][] actividades = new int[7][5];      // 7 días x 5 actividades
        int contadorDias = 0;                     // Cuántos días se han registrado
        int opcion;

        do {
            System.out.println("\n===== MIND BALANCE =====");
            System.out.println("1. Registrar estado de ánimo");
            System.out.println("2. Registrar actividades");
            System.out.println("3. Ver resumen");
            System.out.println("4. Ver recomendación");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            
            // Validar entrada del menú principal
            while (!read.hasNextInt()) {
                System.out.print("Entrada inválida. Elige una opción (1-5): ");
                read.next(); // Limpiar entrada inválida
            }
            opcion = read.nextInt();

            switch (opcion) {
                case 1:
                    if (contadorDias < 7) {
                        System.out.println("\nEstado de ánimo del día " + (contadorDias + 1));
                        System.out.println("1. Muy mal");
                        System.out.println("2. Mal");
                        System.out.println("3. Neutral");
                        System.out.println("4. Bien");
                        System.out.println("5. Excelente");
                        System.out.print("Ingresa tu estado: ");
                        
                        // Validar entrada del estado de ánimo
                        while (!read.hasNextInt()) {
                            System.out.print("Entrada inválida (1-5): ");
                            read.next();
                        }
                        int estado = read.nextInt();

                        if (estado >= 1 && estado <= 5) {
                            estadosAnimo[contadorDias] = estado;
                            contadorDias++;
                            System.out.println("✓ Estado registrado correctamente.");
                        } else {
                            System.out.println("✗ Valor inválido. Debe ser 1-5.");
                        }
                    } else {
                        System.out.println("✗ Ya registraste los 7 días.");
                    }
                    break;

                case 2:
                    if (contadorDias == 0) {
                        System.out.println("✗ Primero registra al menos un estado de ánimo.");
                        break;
                    }
                    int dia = contadorDias - 1;

                    System.out.println("\nActividades del día " + (dia + 1));
                    System.out.println("Ingresa 1 (SÍ) o 0 (NO):");

                    // Validar cada actividad
                    System.out.print("1. Meditación: ");
                    while (!read.hasNextInt() || (actividades[dia][0] = read.nextInt()) < 0 || actividades[dia][0] > 1) {
                        System.out.print("Solo 0 o 1: ");
                        read.next();
                        System.out.print("1. Meditación: ");
                    }

                    System.out.print("2. Ejercicio: ");
                    while (!read.hasNextInt() || (actividades[dia][1] = read.nextInt()) < 0 || actividades[dia][1] > 1) {
                        System.out.print("Solo 0 o 1: ");
                        read.next();
                        System.out.print("2. Ejercicio: ");
                    }

                    System.out.print("3. Lectura: ");
                    while (!read.hasNextInt() || (actividades[dia][2] = read.nextInt()) < 0 || actividades[dia][2] > 1) {
                        System.out.print("Solo 0 o 1: ");
                        read.next();
                        System.out.print("3. Lectura: ");
                    }

                    System.out.print("4. Hidratación: ");
                    while (!read.hasNextInt() || (actividades[dia][3] = read.nextInt()) < 0 || actividades[dia][3] > 1) {
                        System.out.print("Solo 0 o 1: ");
                        read.next();
                        System.out.print("4. Hidratación: ");
                    }

                    System.out.print("5. Tiempo al aire libre: ");
                    while (!read.hasNextInt() || (actividades[dia][4] = read.nextInt()) < 0 || actividades[dia][4] > 1) {
                        System.out.print("Solo 0 o 1: ");
                        read.next();
                        System.out.print("5. Tiempo al aire libre: ");
                    }

                    System.out.println("✓ Actividades registradas correctamente.");
                    break;

                case 3:
                    if (contadorDias == 0) {
                        System.out.println("✗ No hay datos registrados.");
                        break;
                    }

                    // Calcular promedio
                    double suma = 0;
                    for (int i = 0; i < contadorDias; i++) {
                        suma += estadosAnimo[i];
                    }
                    double promedio = suma / contadorDias;

                    // Contar actividades solo de días registrados
                    int totalActividades = 0;
                    for (int i = 0; i < contadorDias; i++) {
                        for (int j = 0; j < 5; j++) {
                            if (actividades[i][j] == 1) {
                                totalActividades++;
                            }
                        }
                    }

                    System.out.println("\n===== RESUMEN =====");
                    System.out.printf("Días registrados: %d/7\n", contadorDias);
                    System.out.printf("Promedio estado de ánimo: %.2f\n", promedio);
                    System.out.printf("Actividades saludables: %d/%d\n", totalActividades, contadorDias * 5);

                    // Nivel de bienestar
                    if (promedio < 3) {
                        System.out.println("Bienestar: 🔴 BAJO");
                    } else if (promedio < 4) {
                        System.out.println("Bienestar: 🟡 MEDIO");
                    } else {
                        System.out.println("Bienestar: 🟢 ALTO");
                    }
                    break;

                case 4:
                    if (contadorDias == 0) {
                        System.out.println("✗ No hay datos registrados.");
                        break;
                    }

                    suma = 0;
                    for (int i = 0; i < contadorDias; i++) {
                        suma += estadosAnimo[i];
                    }
                    double promedio2 = suma / contadorDias;

                    System.out.println("\n===== RECOMENDACIÓN PERSONALIZADA =====");
                    System.out.printf("Tu promedio: %.2f\n", promedio2);

                    if (promedio2 < 3) {
                        System.out.println("💡 RECOMENDACIÓN: Descansa más y prueba meditación diaria (5-10 min).");
                    } else if (promedio2 < 4) {
                        System.out.println("💡 RECOMENDACIÓN: Incorpora ejercicio moderado (30 min/día).");
                    } else {
                        System.out.println("🎉 ¡EXCELENTE! Mantén tus hábitos saludables.");
                    }
                    break;

                case 5:
                    System.out.println("\n¡Gracias por usar Mind Balance! 🌟");
                    System.out.println("Sigue cuidando tu bienestar mental.");
                    break;

                default:
                    System.out.println("✗ Opción inválida. Elige 1-5.");
                    break;
            }
            
            if (opcion != 5) {
                System.out.println("\nPresiona Enter para continuar...");
                read.nextLine(); // Esperar Enter
            }
        } while (opcion != 5);

    }
    
}
