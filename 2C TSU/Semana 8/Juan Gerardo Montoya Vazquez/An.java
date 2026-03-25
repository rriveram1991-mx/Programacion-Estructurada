/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package an;

import java.util.Scanner;

/**
 *
 * @author juang
 */
public class An {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        
        // 1. Array para el estado de ánimo (7 días)
        int[] estadosAnimo = new int[7];
        
        // 2. Array bidimensional para actividades (7 días x 3 actividades)
        int[][] actividades = new int[7][3];
        
        int opcion = 0;

        // 3. Menú interactivo (usar switch y do-while)
        do {
            System.out.println("\n--- Mi Balance ---");
            System.out.println("1. Registrar estado de ánimo");
            System.out.println("2. Registrar actividades");
            System.out.println("3. Ver resumen");
            System.out.println("4. Ver recomendación");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingresa el número de día (1 al 7): ");
                    int diaA = scanner.nextInt();
                    // Restamos 1 para que el usuario use 1-7 pero el array use 0-6
                    if (diaA >= 1 && diaA <= 7) {
                        System.out.println("Estado: 1:Muy mal, 2:Mal, 3:Neutral, 4:Bien, 5:Excelente");
                        estadosAnimo[diaA - 1] = scanner.nextInt();
                    } else {
                        System.out.println("Día no válido.");
                    }
                    break;

                case 2:
                    System.out.print("¿Para qué día (1 al 7) registrarás actividades?: ");
                    int diaAct = scanner.nextInt();
                    if (diaAct >= 1 && diaAct <= 7) {
                        System.out.print("¿Hizo ejercicio? (1=Sí, 0=No): ");
                        actividades[diaAct - 1][0] = scanner.nextInt();
                        System.out.print("¿Meditó? (1=Sí, 0=No): ");
                        actividades[diaAct - 1][1] = scanner.nextInt();
                        System.out.print("¿Hizo un hobby? (1=Sí, 0=No): ");
                        actividades[diaAct - 1][2] = scanner.nextInt();
                    } else {
                        System.out.println("Día no válido.");
                    }
                    break;

                case 3:
                    // 4. Resumen del usuario
                    double suma = 0;
                    int conteoDias = 0;
                    int peorDiaValor = 6; 

                    // Calcular promedio (usar for)
                    for (int i = 0; i < 7; i++) {
                        if (estadosAnimo[i] != 0) {
                            suma = suma + estadosAnimo[i];
                            conteoDias++;
                            // Reto opcional: Detectar peor día
                            if (estadosAnimo[i] < peorDiaValor) {
                                peorDiaValor = estadosAnimo[i];
                            }
                        }
                    }

                    if (conteoDias > 0) {
                        double promedio = suma / conteoDias;
                        System.out.println("\n--- RESUMEN ---");
                        System.out.println("Promedio de ánimo: " + promedio);
                        
                        // Determinar nivel de bienestar
                        if (promedio < 3) {
                            System.out.println("Bienestar: Bajo");
                        } else if (promedio >= 3 && promedio < 4) {
                            System.out.println("Bienestar: Medio");
                        } else {
                            System.out.println("Bienestar: Alto");
                        }

                        // Mostrar actividades (usar for-each)
                        int totalAct = 0;
                        for (int[] fila : actividades) {
                            for (int valor : fila) {
                                if (valor == 1) {
                                    totalAct++;
                                }
                            }
                        }
                        System.out.println("Actividades realizadas: " + totalAct);
                        System.out.println("Tu peor ánimo fue de nivel: " + peorDiaValor);
                    } else {
                        System.out.println("No hay datos registrados.");
                    }
                    break;

                case 4:
                    // 5. Recomendaciones automáticas (usar if)
                    double sumaR = 0;
                    int diasR = 0;
                    for (int i = 0; i < 7; i++) {
                        if (estadosAnimo[i] != 0) {
                            sumaR += estadosAnimo[i];
                            diasR++;
                        }
                    }

                    if (diasR > 0) {
                        double promR = sumaR / diasR;
                        if (promR < 3) {
                            System.out.println("Recomendación: Descanso y meditación.");
                        } else if (promR >= 3 && promR < 4) {
                            System.out.println("Recomendación: Hacer ejercicio.");
                        } else {
                            System.out.println("¡Felicidades por tu bienestar!");
                        }
                        // Mensaje motivacional (Reto opcional)
                        System.out.println("Mensaje: ¡Sigue esforzándote cada día!");
                    } else {
                        System.out.println("Registra datos primero.");
                    }
                    break;

                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 5);

        scanner.close();
    }
    
}
    
