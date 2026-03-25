/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject38;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Mavenproject38 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] animo = new int[7];
        String[][] act = new String[7][3];
        int diaActual = 0;
        int opcion = 0;
        while (opcion != 5) {
            //menu
            System.out.println("1. Registrar estado de ánimo");
            System.out.println("2. Registrar actividades");
            System.out.println("3. Ver resumen");
            System.out.println("4. Ver recomendación");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    //estado de animo
                    if (diaActual < 7) {
                        System.out.print("Ingresa estado de ánimo (1-5): ");
                        animo[diaActual] = sc.nextInt();
                        System.out.println("Registrado para el día " + (diaActual + 1));
                    } else {
                        System.out.println("Ya registraste los 7 días.");
                    }
                    break;

                case 2:
                    //actividades
                    if (diaActual < 7) {
                        sc.nextLine();
                        System.out.println("Ingresa 3 actividades saludables:");
                        for (int j = 0; j < 3; j++) {
                            System.out.print("Actividad " + (j + 1) + ": ");
                            act[diaActual][j] = sc.nextLine();
                        }
                        diaActual++; // avanzar día
                    } else {
                        System.out.println("Ya registraste los 7 días.");
                    }
                    break;

                case 3:
                    //resumen
                    int suma = 0;
                    int dias = 0;
                    for (int i = 0; i < animo.length; i++) {
                        if (animo[i] != 0) {
                            suma += animo[i];
                            dias++;
                        }
                    }
                    if (dias > 0) {
                        double promedio = (double) suma / dias;
                        System.out.println("Promedio: " + promedio);

                        if (promedio < 3) {
                            System.out.println("Bienestar: Bajo");
                        } else if (promedio < 4) {
                            System.out.println("Bienestar: Medio");
                        } else {
                            System.out.println("Bienestar: Alto");
                        }
                    }
                    int Tact = 0;
                    for (String[] dia : act) {
                        for (String acts : dia) {
                            if (act != null) {
                                Tact++;
                            }
                        }
                    }
                    System.out.println("Total actividades: " + Tact);
                    break;

                case 4:
                    //recomendacion
                    int suma2 = 0;
                    int dias2 = 0;
                    for (int i = 0; i < animo.length; i++) {
                        if (animo[i] != 0) {
                            suma2 += animo[i];
                            dias2++;
                        }
                    }
                    if (dias2 > 0) {
                        double promedio = (double) suma2 / dias2;
                        if (promedio < 3) {
                            System.out.println("Recomendación: Descansa y medita 🧘");
                        } else if (promedio < 4) {
                            System.out.println("Recomendación: Haz ejercicio 🏃");
                        } else {
                            System.out.println("¡Felicidades! Sigue así 😄");
                        }
                    } else {
                        System.out.println("Primero registra datos.");
                    }
                    break;

                case 5:
                    //salir xd
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }

        sc.close();
        //se acabo unu
    
       
    }
}
