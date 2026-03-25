/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package controlbienestar;

import java.util.Scanner;

/**
 *
 * @author juanc
 */
public class ControlBienestar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);    
         int[] estadoAnimo = new int[7]; // Array para estado de ánimo
        String[][] actividades = new String[7][5]; // 7 días, 5 actividades por día

        int diaActual = 0;
        int opcion;

        do {
           
            System.out.println("1. Registrar estado de ánimo");
            System.out.println("2. Registrar actividades");
            System.out.println("3. Ver resumen");
            System.out.println("4. Ver recomendación");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    if (diaActual < 7) {
                        System.out.println("\nEstado de ánimo:");
                        System.out.println("1. Muy mal ");
                        System.out.println("2. Mal ");
                        System.out.println("3. Neutral ");
                        System.out.println("4. Bien ");
                        System.out.println("5. Excelente ");
                        System.out.print("Ingresa valor: ");
                        estadoAnimo[diaActual] = sc.nextInt();
                        System.out.println("Estado registrado para el día " + (diaActual + 1));
                    } else {
                        System.out.println("Ya registraste los 7 días.");
                    }
                    break;

                case 2:
                    if (diaActual < 7) {
                        sc.nextLine();
                        System.out.println("\nRegistrar hasta 5 actividades del día " + (diaActual + 1));
                        for (int i = 0; i < 5; i++) {
                            System.out.print("Actividad " + (i + 1) + " (o enter para omitir): ");
                            String act = sc.nextLine();
                            actividades[diaActual][i] = act;
                        }
                        diaActual++; // avanzar al siguiente día
                    } else {
                        System.out.println("Ya registraste todas las actividades de la semana.");
                    }
                    break;

                case 3:
                    // RESUMEN
                    int suma = 0;
                    int diasRegistrados = 0;

                    for (int i = 0; i < 7; i++) {
                        if (estadoAnimo[i] != 0) {
                            suma += estadoAnimo[i];
                            diasRegistrados++;
                        }
                    }

                    if (diasRegistrados > 0) {
                        double promedio = (double) suma / diasRegistrados;
                        System.out.println("\nPromedio de estado de ánimo: " + promedio);

                        if (promedio < 3) {
                            System.out.println("Nivel de bienestar: BAJO");
                        } else if (promedio < 4) {
                            System.out.println("Nivel de bienestar: MEDIO");
                        } else {
                            System.out.println("Nivel de bienestar: ALTO");
                        }
                    } else {
                        System.out.println("No hay datos registrados.");
                    }

                    // contar actividades
                    int totalActividades = 0;

                    for (String[] dia : actividades) {
                        for (String act : dia) {
                            if (act != null && !act.equals("")) {
                                totalActividades++;
                            }
                        }
                    }

                    System.out.println("Total de actividades realizadas: " + totalActividades);

                    break;

                case 4:
                    // RECOMENDACIONES
                    int sumaRec = 0;
                    int diasRec = 0;

                    for (int i = 0; i < 7; i++) {
                        if (estadoAnimo[i] != 0) {
                            sumaRec += estadoAnimo[i];
                            diasRec++;
                        }
                    }

                    if (diasRec > 0) {
                        double promedio = (double) sumaRec / diasRec;

                        if (promedio < 3) {
                            System.out.println("Recomendación: Descansa y practica meditación ");
                        } else if (promedio < 4) {
                            System.out.println("Recomendación: Realiza ejercicio físico ");
                        } else {
                            System.out.println("¡Excelente! Sigue así ");
                        }
                    } else {
                        System.out.println("No hay datos para dar recomendaciones.");
                    }

                    break;

                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida");
            }

        } while (opcion != 5);

        sc.close();
    }
    
}
