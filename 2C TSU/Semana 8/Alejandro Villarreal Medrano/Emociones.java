/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package emociones;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class Emociones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         Scanner sc = new Scanner(System.in);

        int[] estados = new int[7];
        String[][] actividades = new String[7][3];

        int diaEstado = 0;
        int diaActividad = 0;

        int opcion;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Registrar estado de animo");
            System.out.println("2. Registrar actividades");
            System.out.println("3. Ver resumen");
            System.out.println("4. Ver recomendacion");
            System.out.println("5. Salir");
            System.out.print("Opcion: ");

            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    if (diaEstado < 7) {
                        int valor;
                        do {
                            System.out.print("Ingresa estado (1-5): ");
                            valor = sc.nextInt();
                        } while (valor < 1 || valor > 5);

                        estados[diaEstado] = valor;
                        diaEstado++;
                    } else {
                        System.out.println("Limite de dias alcanzado");
                    }
                    break;

                case 2:
                    if (diaActividad < 7) {
                        sc.nextLine();
                        for (int i = 0; i < actividades[diaActividad].length; i++) {
                            System.out.print("Actividad " + (i + 1) + ": ");
                            String act;
                            do {
                                act = sc.nextLine();
                            } while (act.isEmpty());
                            actividades[diaActividad][i] = act;
                        }
                        diaActividad++;
                    } else {
                        System.out.println("Limite de dias alcanzado");
                    }
                    break;

                case 3:
                    int suma = 0;
                    int contador = 0;

                    for (int i = 0; i < estados.length; i++) {
                        if (estados[i] != 0) {
                            suma += estados[i];
                            contador++;
                        }
                    }

                    if (contador == 0) {
                        System.out.println("Sin datos");
                        break;
                    }

                    double promedio = (double) suma / contador;
                    System.out.println("Promedio: " + promedio);

                    int totalAct = 0;
                    for (String[] fila : actividades) {
                        for (String a : fila) {
                            if (a != null && !a.isEmpty()) {
                                totalAct++;
                            }
                        }
                    }

                    System.out.println("Total actividades: " + totalAct);

                    if (promedio < 3) {
                        System.out.println("Bienestar: Bajo");
                    } else if (promedio < 4) {
                        System.out.println("Bienestar: Medio");
                    } else {
                        System.out.println("Bienestar: Alto");
                    }
                    break;

                case 4:
                    int sumaRec = 0;
                    int contRec = 0;

                    for (int i = 0; i < estados.length; i++) {
                        if (estados[i] != 0) {
                            sumaRec += estados[i];
                            contRec++;
                        }
                    }

                    if (contRec == 0) {
                        System.out.println("Sin datos");
                        break;
                    }

                    double prom = (double) sumaRec / contRec;

                    if (prom < 3) {
                        System.out.println("Descansa y medita");
                    } else if (prom < 4) {
                        System.out.println("Haz ejercicio");
                    } else {
                        System.out.println("Excelente, sigue asi");
                    }
                    break;

                case 5:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opcion invalida");
            }

        } while (opcion != 5);

        sc.close();
    }
    
}
