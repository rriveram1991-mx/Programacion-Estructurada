/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mindbalance;

import java.util.Scanner;

/**
 *
 * @author miguelgu
 */
public class MINDBALANCE {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] estadoAnimo = new int[7]; // 7 días
        String[][] actividades = new String[7][3]; // 3 actividades por día

        int diaActual = 0;
        int opcion = 0;

        while (opcion != 5) {

            System.out.println("\n===== MIND BALANCE =====");
            System.out.println("1. Registrar estado de ánimo");
            System.out.println("2. Registrar actividades");
            System.out.println("3. Ver resumen");
            System.out.println("4. Ver recomendación");
            System.out.println("5. Salir");

            opcion = input.nextInt();

            switch (opcion) {

                case 1:
                    if (diaActual < 7) {
                        System.out.println("Día " + (diaActual + 1));
                        System.out.println("1.Muy mal   2.Mal   3.Neutral   4.Bien   5.Excelente ");
                        int estado = input.nextInt();

                        if (estado >= 1 && estado <= 5) {
                            estadoAnimo[diaActual] = estado;
                            System.out.println("Estado guardado.");
                        } else {
                            System.out.println("Valor inválido.");
                        }
                    } else {
                        System.out.println("Ya registraste los 7 días.");
                    }
                    break;

                case 2:
                    if (diaActual < 7) {
                        input.nextLine(); // limpia el buffer

                        System.out.println("Ingresa 3 actividades saludables:");

                        for (int i = 0; i < 3; i++) {
                            System.out.print("Actividad " + (i + 1) + ": ");
                            actividades[diaActual][i] = input.nextLine();
                        }

                        System.out.println("Actividades guardadas.");
                        diaActual++;
                    } else {
                        System.out.println("Ya registraste los 7 días.");
                    }
                    break;

                case 3:
                    int suma = 0;
                    int contadorDias = 0;

                    for (int i = 0; i < estadoAnimo.length; i++) {
                        if (estadoAnimo[i] != 0) {
                            suma += estadoAnimo[i];
                            contadorDias++;
                        }
                    }

                    if (contadorDias > 0) {
                        double promedio = (double) suma / contadorDias;
                        System.out.println("Promedio de ánimo: " + promedio);

                        // Clasificaciones
                        if (promedio < 3) {
                            System.out.println("Bienestar: Bajo");
                        } else if (promedio < 4) {
                            System.out.println("Bienestar: Medio");
                        } else {
                            System.out.println("Bienestar: Alto");
                        }
                    } else {
                        System.out.println("No hay datos aún.");
                    }

                    // Contar actividades
                    int totalActividades = 0;

                    for (String[] dia : actividades) {
                        for (String act : dia) {
                            if (act != null) {
                                totalActividades++;
                            }
                        }
                    }

                    System.out.println("Total de actividades: " + totalActividades);

                    break;

                case 4:
                    int suma2 = 0;
                    int contador2 = 0;

                    for (int i = 0; i < estadoAnimo.length; i++) {
                        if (estadoAnimo[i] != 0) {
                            suma2 += estadoAnimo[i];
                            contador2++;
                        }
                    }

                    if (contador2 > 0) {
                        double promedio = (double) suma2 / contador2;

                        if (promedio < 3) {
                            System.out.println("Recomendación: Descansa y medita.");
                        } else if (promedio < 4) {
                            System.out.println("Recomendación: Haz ejercicio.");
                        } else {
                            System.out.println("¡Felicidades! Sigue así.");
                        }
                    } else {
                        System.out.println("No hay datos suficientes.");
                    }

                    break;

                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
}
    
    

