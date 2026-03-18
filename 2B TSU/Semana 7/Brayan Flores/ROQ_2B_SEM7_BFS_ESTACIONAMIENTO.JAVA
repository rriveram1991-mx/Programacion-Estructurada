/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package estacionamiento2;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class Estacionamiento {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 1. Crear el estacionamiento (array de 10 espacios)
        String[] espacios = new String[10];

        // Inicializar todos como LIBRE
        for (int i = 0; i < espacios.length; i++) {
            espacios[i] = "LIBRE";
        }

        int opcion;

        // 2. Menú interactivo (while + switch)
        do {
            System.out.println("\n--- SISTEMA DE ESTACIONAMIENTO ---");
            System.out.println("1. Ver estacionamiento");
            System.out.println("2. Estacionar auto");
            System.out.println("3. Retirar auto");
            System.out.println("4. Contar espacios ocupados");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    // 3. Ver estacionamiento (for)
                    System.out.println("\nEstado del estacionamiento:");
                    for (int i = 0; i < espacios.length; i++) {
                        System.out.println("Espacio " + (i + 1) + ": " + espacios[i]);
                    }
                    break;

                case 2:
                    // 4. Estacionar auto (if)
                    System.out.print("Ingresa el número de espacio (1-10): ");
                    int lugar = sc.nextInt();

                    if (lugar >= 1 && lugar <= 10) {
                        if (espacios[lugar - 1].equals("LIBRE")) {
                            espacios[lugar - 1] = "OCUPADO";
                            System.out.println("Auto estacionado correctamente.");
                        } else {
                            System.out.println("Error: Ese espacio ya está ocupado.");
                        }
                    } else {
                        System.out.println("Número inválido.");
                    }
                    break;

                case 3:
                    // 5. Retirar auto (if)
                    System.out.print("Ingresa el número de espacio (1-10): ");
                    int retirar = sc.nextInt();

                    if (retirar >= 1 && retirar <= 10) {
                        if (espacios[retirar - 1].equals("OCUPADO")) {
                            espacios[retirar - 1] = "LIBRE";
                            System.out.println("Auto retirado correctamente.");
                        } else {
                            System.out.println("Ese espacio ya está libre.");
                        }
                    } else {
                        System.out.println("Número inválido.");
                    }
                    break;

                case 4:
                    // 6. Contar espacios ocupados (for-each)
                    int contador = 0;
                    for (String espacio : espacios) {
                        if (espacio.equals("OCUPADO")) {
                            contador++;
                        }
                    }
                    System.out.println("Espacios ocupados: " + contador);
                    break;

                case 5:
                    // 7. Salir
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 5);

        // 8. Crear TXT (guardar estado final)
        try {
            FileWriter writer = new FileWriter("estacionamiento.txt");

            for (int i = 0; i < espacios.length; i++) {
                writer.write("Espacio " + (i + 1) + ": " + espacios[i] + "\n");
            }

            writer.close();
            System.out.println("Archivo TXT creado correctamente.");

        } catch (IOException e) {
            System.out.println("Error al crear el archivo.");
        }

        sc.close();
    }
}