/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package semana7;

import java.util.Scanner;

/**
 *
 * @author Ernesto Montalvo
 */
public class RTO_1_SEM7_EMM {
    
public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        String[] espacios = new String[10];

        for (int i = 0; i < espacios.length; i++) {
            espacios[i] = "Libre";
        }

        int opcion = 0;

        while (opcion != 5) {
            System.out.println("\n Menu");
            System.out.println("1. Ver estacionamiento");
            System.out.println("2. Estacionar auto");
            System.out.println("3. Retirar auto");
            System.out.println("4. Contar espacios ocupados");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {

                case 1:
                    for (int i = 0; i < espacios.length; i++) {
                        System.out.println("Espacio " + (i + 1) + ": " + espacios[i]);
                    }
                    break;

                case 2:
                    System.out.println("Ingresa el número de espacio (1-10): ");
                    int lugEst = scanner.nextInt() - 1;

                    if (lugEst >= 0 && lugEst < 10) {
                        if (espacios[lugEst].equals("Libre")) {
                            espacios[lugEst] = "Ocupado";
                            System.out.println("Auto estacionado");
                        } else {
                            System.out.println("Espacio Ocupado");
                        }
                    } else {
                        System.out.println("Número de espacio inválido.");
                    }
                    break;

                case 3:
                    System.out.print("Ingresa el número de espacio (1-10): ");
                    int lugRet = scanner.nextInt() - 1;

                    if (lugRet >= 0 && lugRet < 10) {
                        if (espacios[lugRet].equals("Ocupado")) {
                            espacios[lugRet] = "Libre";
                            System.out.println("Auto retirado");
                        } else {
                            System.out.println("Espacio Libre");
                        }
                    } else {
                        System.out.println("Número de espacio inválido");
                    }
                    break;

                case 4:
                    int cont = 0;

                    for (String espacio : espacios) {
                        if (espacio.equals("Ocupado")) {
                            cont++;
                        }
                    }

                    System.out.println("Espacios ocupados: " + cont);
                    break;

                case 5:
                    System.out.println("Saliendo del sistema");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        }

        scanner.close();
    }
}