/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package req1_sem8_amgg_2b_java;

import java.util.Scanner;

/**
 *
 * @author Lex
 */
public class REQ1_SEM8_AMGG_2B_JAVA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        int[] estadosAnimo = new int[7]; // array de 7 días
        int[][] actividades = new int[7][3]; // 7 días, 3 actividades por día
        int diaActual = 0;
        int opcion;

        do {
            System.out.println("============ MIND BALANCE ============");
            System.out.println("\n--- CONTROL DE BIENESTAR MENTAL ---");
            System.out.println("1. Registrar estado de ánimo");
            System.out.println("2. Registrar actividades saludables");
            System.out.println("3. Ver resumen");
            System.out.println("4. Ver recomendación");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    if (diaActual < 7) {
                        System.out.println("Ingresa tu estado de ánimo (1-5): ");
                        System.out.println("1=Muy mal | 2=Mal | 3=Neutral | 4=Bien | 5=Excelente");
                        int estado = sc.nextInt();
                        if (estado >= 1 && estado <= 5) {
                            estadosAnimo[diaActual] = estado;
                            System.out.println("Estado guardado para el día " + (diaActual + 1));
                        } else {
                            System.out.println("Valor inválido.");
                        }
                    } else {
                        System.out.println("Ya registraste los 7 días.");
                    }
                    break;
                case 2:
                    if (diaActual < 7) {
                        System.out.println("Registro de actividades del día " + (diaActual + 1));
                        for (int i = 0; i < 3; i++) {
                            System.out.print("Actividad " + (i + 1) + " realizada? (1=Sí, 0=No): ");
                            actividades[diaActual][i] = sc.nextInt();
                        }
                        diaActual++; // avanzar al siguiente día
                    } else {
                        System.out.println("Ya registraste los 7 días.");
                    }
                    break;
                case 3:
                    if (diaActual == 0) {
                        System.out.println("No hay datos aún.");
                        break;
                    }
                    // Promedio estado de ánimo
                    int suma = 0;
                    for (int i = 0; i < diaActual; i++) {
                        suma += estadosAnimo[i];
                    }
                    double promedio = (double) suma / diaActual;
                    System.out.println("Promedio de estado de ánimo: " + promedio);
                    // Contar actividades (for-each)
                    int totalActividades = 0;
                    for (int[] dia : actividades) {
                        for (int act : dia) {
                            if (act == 1) {
                                totalActividades++;
                            }
                        }
                    }

                    System.out.println("Total de actividades saludables: " + totalActividades);
                    // Clasificación
                    if (promedio < 3) {
                        System.out.println("Nivel de bienestar: BAJO");
                    } else if (promedio < 4) {
                        System.out.println("Nivel de bienestar: MEDIO");
                    } else {
                        System.out.println("Nivel de bienestar: ALTO");
                    }
                    break;
                case 4:
                    if (diaActual == 0) {
                        System.out.println("No hay datos para recomendar.");
                        break;
                    }
                    int sumaRec = 0;
                    for (int i = 0; i < diaActual; i++) {
                        sumaRec += estadosAnimo[i];
                    }
                    double promedioRec = (double) sumaRec / diaActual;
                    if (promedioRec < 3) {
                        System.out.println("Recomendación: Descansa y prueba meditación");
                    } else if (promedioRec < 4) {
                        System.out.println("Recomendación: Realiza ejercicio físico");
                    } else {
                        System.out.println("¡Excelente! Sigue así");
                    }
                    break;
                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 5);
        sc.close();
    }
    
}
