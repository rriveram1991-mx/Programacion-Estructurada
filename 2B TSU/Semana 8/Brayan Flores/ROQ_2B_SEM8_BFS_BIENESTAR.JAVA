RTO_2B_SEM8_BFS_BIENESTAR
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rto_2b_sem8_bfs_bienestar;

import java.util.Scanner;


public class MindBalance {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] estadoAnimo = new int[7];

        String[][] actividades = new String[7][3];

        int opcion;
        int dia = 0;

        do {
            System.out.println("\n===== BIENESTAR =====");
            System.out.println("1. Registrar estado de animo");
            System.out.println("2. Registrar actividades");
            System.out.println("3. Ver resumen");
            System.out.println("4. Ver recomendacion");
            System.out.println("5. Salir");
            System.out.print("Elige una opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    if (dia < 7) {
                        System.out.print("Ingresa estado de ánimo (1-5): ");
                        int estado = sc.nextInt();

                        if (estado >= 1 && estado <= 5) {
                            estadoAnimo[dia] = estado;
                            System.out.println("Guardado para el día " + (dia + 1));
                        } else {
                            System.out.println("Valor inválido");
                        }
                    } else {
                        System.out.println("Ya registraste los 7 días");
                    }
                    break;

                case 2:
                    if (dia < 7) {
                        sc.nextLine(); // limpiar buffer
                        System.out.println("Día " + (dia + 1));

                        for (int i = 0; i < 3; i++) {
                            System.out.print("Actividad " + (i + 1) + ": ");
                            actividades[dia][i] = sc.nextLine();
                        }

                        dia++; // avanzamos al siguiente día
                    } else {
                        System.out.println("Ya registraste toda la semana");
                    }
                    break;

                case 3:
                    int suma = 0;
                    int contador = 0;

                    for (int i = 0; i < estadoAnimo.length; i++) {
                        if (estadoAnimo[i] != 0) {
                            suma += estadoAnimo[i];
                            contador++;
                        }
                    }

                    double promedio = (contador > 0) ? (double) suma / contador : 0;
                    System.out.println("Promedio de ánimo: " + promedio);

                    // Contar actividades
                    int totalActividades = 0;

                    for (String[] diaAct : actividades) {
                        for (String act : diaAct) {
                            if (act != null && !act.isEmpty()) {
                                totalActividades++;
                            }
                        }
                    }

                    System.out.println("Total de actividades: " + totalActividades);

                    // Nivel de bienestar
                    if (promedio < 3) {
                        System.out.println("Bienestar: BAJO");
                    } else if (promedio < 4) {
                        System.out.println("Bienestar: MEDIO");
                    } else {
                        System.out.println("Bienestar: ALTO");
                    }

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

                    double promedio2 = (contador2 > 0) ? (double) suma2 / contador2 : 0;

                    if (promedio2 < 3) {
                        System.out.println("Recomendación: Descansa y medita 🧘");
                    } else if (promedio2 < 4) {
                        System.out.println("Recomendación: Haz ejercicio 🏃");
                    } else {
                        System.out.println("¡Excelente! Sigue así 😄");
                    }

                    break;

                case 5:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida");
            }

        } while (opcion != 5);

    }
}