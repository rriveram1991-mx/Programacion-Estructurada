/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practica29;

import java.util.Scanner;

/**
 *
 * @author crist
 */
public class Practica29 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
 Scanner sc = new Scanner(System.in);

        // 1. Cambie el total a double para no perder decimales.
        double total = 0; 
        int cantidad = 0;
        boolean salir = false;

        System.out.println("=== SISTEMA DE CONTROL DE NOTAS ===");

        // 2. Cambie "!salir" en lugar de "salir = false" (que era una asignación)
        while (!salir) { 

            System.out.println("\n1. Capturar notas");
            System.out.println("2. Mostrar promedio");
            System.out.println("3. Mostrar estadísticas");
            System.out.println("4. Reiniciar datos");
            System.out.println("5. Salir");

            System.out.print("Seleccione opción: ");
            
            // 3. verifique que el usuarip aiga ingresado un numero
            if (!sc.hasNextInt()) {
                System.out.println("Error: Ingrese solo números.");
                sc.next(); // Limpiar el buffer
                continue;
            }
            
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("¿Cuántas notas desea capturar?: ");
                    int n = sc.nextInt();

                    // 4. Corregi: i < n para no capturar una nota de mas.
                    // 5. Corregi i empieza en 1 para que el mensaje al usuario sea "Nota #1"
                    for (int i = 1; i <= n; i++) { 
                        System.out.print("Ingrese nota #" + i + " (0-10): ");
                        double nota = sc.nextDouble(); // 6. Permitir notas con decimales (ej: 8.5)

                        // 7. elimine ; al terminar el if
                        // 8. Agregue los {}
                        if (nota >= 0 && nota <= 10) {
                            total += nota;
                            cantidad++;
                        } else {
                            // 9. Ahora el else sí funciona al quitar el ";" del IF
                            System.out.println("Nota inválida, no se guardó.");
                            i--; // 10. Restar al contador para repetir la nota fallida
                        }
                    }
                    break; // 11. Agregue un breake en el case 2

                case 2:
                    // 12. Validación: No dividir entre cero si cantidad es 0
                    if (cantidad == 0) {
                        System.out.println("No hay notas registradas.");
                    } else {
                        // 13. La division es correcta porque ahora es double
                        double promedio = total / cantidad;
                        // 14. Uso de printf para mostrar solo 2 decimales
                        System.out.printf("Promedio actual: %.2f\n", promedio);

                        if (promedio >= 9) System.out.println("Nivel: Excelente");
                        else if (promedio >= 8) System.out.println("Nivel: Bueno");
                        // 15. Elimine ";" que causaba que siempre imprimiera regular
                        else if (promedio >= 7) System.out.println("Nivel: Regular");
                        else System.out.println("Nivel: Reprobado");
                    }
                    break; // 16. Break obligatorio

                case 3:
                    System.out.println("--- ESTADÍSTICAS ---");
                    // 17. Elimine el bucle while(i < cantidad); que causaba bucle infinito
                    // 18. Sin un Array no se pueden contar aprobados individuales, 
                    // pero mostramos el resumen de lo capturado.
                    System.out.println("Total de notas válidas: " + cantidad);
                    System.out.println("Suma acumulada: " + total);
                    break;

                case 4:
                    total = 0;
                    cantidad = 0;
                    System.out.println("Datos reseteados.");
                    break; // 19. Agregue un breake
                case 5:
                    salir = true;
                    System.out.println("Cerrando sistema...");
                    break;

                default:
                    // 20. Mensaje de error para opciones fuera de 1-5
                    System.out.println("Opción no válida.");
                    break;
            }
        }
        sc.close();
    }
}
   
    

