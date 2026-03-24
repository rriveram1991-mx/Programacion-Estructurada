/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sistemaemocional7;

import java.util.Scanner;

/**
 *
 * @author jessr
 */
public class SIstemaEmocional7 {

    public static void main(String[] args) {
        Scanner leer = new Scanner (System.in);
      int[] estadoAnimo = new int[7]; 
        String[][] actividades = new String[7][3]; 

        int dias = 0;
        int opcion;

        do {
            System.out.println("\n--- MIND BALANCE ---");
            System.out.println("1. Registrar estado de ánimo");
            System.out.println("2. Registrar actividades");
            System.out.println("3. Ver resumen");
            System.out.println("4. Ver recomendación");
            System.out.println("5. Salir");
            System.out.print("Opción: ");
            opcion = leer.nextInt();
            leer.nextLine();

            switch (opcion) {

                case 1:
                    if (dias < 7) {
                        System.out.println("\n1.Muy mal   2.Mal   3.Neutral   4.Bien   5.Excelente ");
                        System.out.print("Ingresa tu estado: ");
                        int estado = leer.nextInt();

                        
                        if (estado >= 1 && estado <= 5) {
                            //sirve para guardar el estado de animo en el dia correspondiente
                            estadoAnimo[dias] = estado;
                            System.out.println("Guardado correctamente.");
                        } else {
                            System.out.println("Valor inválido.");
                        }
                    } else {
                        System.out.println("Ya registraste los 7 días.");
                    }
                    break;

                case 2:
                    if (dias < 7) {
                        System.out.println("\nIngresa 3 actividades saludables:");
                         //For para ingresar las 3 actividades
                         //Actividad 1:
                         //Actividad 2:
                         //Actividad 3:
                        for (int i = 0; i < 3; i++) {
                            System.out.print("Actividad " + (i + 1) + ": ");
                            //sirve para guardar los datos en el arrgelo dias=1,2,3,4,5,6,7 y i= a la actividad echa ese dia
                            actividades[dias][i] = leer.nextLine();
                        }

                        System.out.println("Actividades guardadas.");
                        dias++; 
                    } else {
                        System.out.println("Ya registraste los 7 días.");
                    }
                    break;

                case 3:
                    //si no hay dias registrados mostrara no hay datos
                    if (dias == 0) {
                        System.out.println("No hay datos.");
                        break;
                    }

                    int suma = 0;

                    //for para sumar los estados de animo
                    for (int i = 0; i < dias; i++) {
                        suma += estadoAnimo[i];
                    }
                   //Calcular el promedio del animo
                    double promedio = (double) suma / dias;
                    System.out.println("\nPromedio: " + promedio);

                  
                    int totalActividades = 0;
                   //Este for recorre arreglos y el string[dia] toma una fila entera, dia es un arreglo de actividades
                    for (String[] dia : actividades) {
                        for (String act : dia) {
                            //act comprueba que si exista y act.isEmpty asegura que no haiga texto vacio
                            if (act != null && !act.isEmpty()) {
                                totalActividades++;
                            }
                        }
                    }

                    System.out.println("Total de actividades: " + totalActividades);

                    //if para mostrar el estado actual del usuario
                    if (promedio < 3) {
                        System.out.println("Bienestar: BAJO");
                    } else if (promedio < 4) {
                        System.out.println("Bienestar: MEDIO");
                    } else {
                        System.out.println("Bienestar: ALTO");
                    }

                  
                    int peorDia = 0;
                    for (int i = 1; i < dias; i++) {
                        //estadoAnimo es el dia actual y estadoAnimo es para ubicar el peor dia
                        if (estadoAnimo[i] < estadoAnimo[peorDia]) {
                            //actualiza el peor dia si es que encuentra uno
                            peorDia = i;
                        }
                    }

                    System.out.println("Peor día: Día " + (peorDia + 1));

                    break;

                case 4:
                    if (dias == 0) {
                        System.out.println("No hay datos.");
                        break;
                    }

                    int total = 0;
                    for (int i = 0; i < dias; i++) {
                        total += estadoAnimo[i];
                    }

                    double prom = (double) total / dias;

                    System.out.println("\n--- RECOMENDACIÓN ---");

                    //if para recomendar alguna solucion
                    if (prom < 3) {
                        System.out.println("Descansa más y practica meditación");
                    } else if (prom >= 3 && prom < 4) {
                        System.out.println("Haz ejercicio regularmente");
                    } else {
                        System.out.println("¡Excelente! Sigue así");
                    }
                    break;

                case 5:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 5);

        leer.close();
        
    }
}
