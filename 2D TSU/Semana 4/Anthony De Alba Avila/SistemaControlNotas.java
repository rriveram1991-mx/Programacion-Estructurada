package anthonydealbaavila;
import java.util.Scanner;

public class SistemaControlNotas {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Cambiado total a double para no perder decimales en la suma
        double total = 0; 
        int cantidad = 0;
        boolean salir = false;

        System.out.println("=== SISTEMA DE CONTROL DE NOTAS ===");

        // 2. Corregido: "!salir" en lugar de "salir = false" (que era una asignación)
        while (!salir) { 

            System.out.println("\n1. Capturar notas");
            System.out.println("2. Mostrar promedio");
            System.out.println("3. Mostrar estadísticas");
            System.out.println("4. Reiniciar datos");
            System.out.println("5. Salir");

            System.out.print("Seleccione opción: ");
            
            // 3. Validación básica: verificar si el usuario ingresó un número
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

                    // 4. Corregido: i < n (si pones <= n capturas una nota de más)
                    // 5. Corregido: i empieza en 1 para que el mensaje al usuario sea "Nota #1"
                    for (int i = 1; i <= n; i++) { 
                        System.out.print("Ingrese nota #" + i + " (0-10): ");
                        double nota = sc.nextDouble(); // 6. Permitir notas con decimales (ej: 8.5)

                        // 7. Corregido: Eliminado el ";" después del IF
                        // 8. Agregadas llaves {} para agrupar las instrucciones
                        if (nota >= 0 && nota <= 10) {
                            total += nota;
                            cantidad++;
                        } else {
                            // 9. Corregido: Ahora el else sí funciona al quitar el ";" del IF
                            System.out.println("Nota inválida, no se guardó.");
                            i--; // 10. Restar al contador para repetir la nota fallida
                        }
                    }
                    break; // 11. Corregido: Agregado break (antes se pasaba al caso 2 solo)

                case 2:
                    // 12. Validación: No dividir entre cero si cantidad es 0
                    if (cantidad == 0) {
                        System.out.println("No hay notas registradas.");
                    } else {
                        // 13. Corregido: La división ahora es precisa porque total es double
                        double promedio = total / cantidad;
                        // 14. Uso de printf para mostrar solo 2 decimales
                        System.out.printf("Promedio actual: %.2f\n", promedio);

                        if (promedio >= 9) System.out.println("Nivel: Excelente");
                        else if (promedio >= 8) System.out.println("Nivel: Bueno");
                        // 15. Corregido: Eliminado ";" que causaba que siempre imprimiera "Regular"
                        else if (promedio >= 7) System.out.println("Nivel: Regular");
                        else System.out.println("Nivel: Reprobado");
                    }
                    break; // 16. Break obligatorio

                case 3:
                    System.out.println("--- ESTADÍSTICAS ---");
                    // 17. Corregido: Eliminado el bucle while(i < cantidad); que causaba bucle infinito
                    // 18. Lógica: Sin un Array no se pueden contar aprobados individuales, 
                    // pero mostramos el resumen de lo capturado.
                    System.out.println("Total de notas válidas: " + cantidad);
                    System.out.println("Suma acumulada: " + total);
                    break;

                case 4:
                    total = 0;
                    cantidad = 0;
                    System.out.println("Datos reseteados.");
                    break; // 19. Agregado break para no entrar al caso 5 y salir

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
