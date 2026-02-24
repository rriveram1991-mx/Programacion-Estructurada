/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package s4;

import java.util.Scanner;

/**
 *
 * @author Windows 10
 */
public class S4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // TODO code application logic here
      
    
       Scanner sc = new Scanner(System.in);

        // 1se camba a doble el total
        double total = 0; 
        int cantidad = 0;
        boolean salir = false;

        System.out.println("=== SISTEMA DE CONTROL DE NOTAS ===");

        // 2.Corregir el salir
        while (!salir) { 

            System.out.println("\n1. Capturar notas");
            System.out.println("2. Mostrar promedio");
            System.out.println("3. Mostrar estadísticas");
            System.out.println("4. Reiniciar datos");
            System.out.println("5. Salir");

            System.out.print("Seleccione opción: ");
            
            // 3 faltaba validacion
            if (!sc.hasNextInt()) {
                System.out.println("Error: Ingrese solo números.");
                sc.next();
                continue;
            }
            
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> {
                    System.out.print("¿Cuántas notas desea capturar?: ");
                    int n = sc.nextInt();
                   
                    // 4 se captura una mas
                    // 5. se empieza del uno
                    for (int i = 1; i <= n; i++) {
                        System.out.print("Ingrese nota #" + i + " (0-10): ");
                        double nota = sc.nextDouble(); // 6 para permitir cal con decimales

                        // 7. se quita el ;
                        // 8 las llaves
                        if (nota >= 0 && nota <= 10) {
                            total += nota;
                            cantidad++;
                        } else {
                            // ya funciona el else ppr el punto y coma q quite
                            System.out.println("Nota inválida, no se guardó.");
                            i--; // 10 restar la nota falla
                        }
                    }break;
                    // 11 agg break
                }
                case 2 -> {
                    //  No se puede dividir  entre cero
                    if (cantidad == 0) {
                        System.out.println("No hay notas registradas.");
                    } else {
                        // 13 division exacra
                        double promedio = total / cantidad;
                        // 14. Uso opara dos decimas
                        System.out.printf("Promedio actual: %.2f\n", promedio);

                        if (promedio >= 9) System.out.println("Nivel: Excelente");
                        else if (promedio >= 8) System.out.println("Nivel: Bueno");
                        // 15.quitar el ;
                        else if (promedio >= 7) System.out.println("Nivel: Regular");
                        else System.out.println("Nivel: Reprobado");
                   break;
                    }
                    // 16.falta break
                }
                case 3 -> {
                    System.out.println("--- ESTADÍSTICAS ---");
                    // 17.eliminar el bucle infinito 
                  
                    // pse dice lo que capp
                    System.out.println("Total de notas válidas: " + cantidad);
                    System.out.println("Suma acumulada: " + total);
                    break;
                }

                case 4 -> {
                    total = 0;
                    cantidad = 0;
                    System.out.println("Datos reseteados.");
                    // 19. Agg break 
                    break;
                }
                case 5 -> {
                    salir = true;
                    System.out.println("Cerrando sistema...");
                    break;
                }
                

                default -> // 20. Mensaje de error si no eloige uno de esos
                    System.out.println("Opción no válida.");
            }
        }
        sc.close();
    }
}
