/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.rtosem7;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class RTOSEM7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] espacios = new String[10];
        for (int i = 0; i < espacios.length; i++) {
            espacios[i] = "Libre";
        }

        int opcion = 0;
        while (opcion != 5) {
            System.out.println("\n1. Ver estacionamiento\n2. Estacionar auto\n3. Retirar auto\n4. Contar espacios ocupados\n5. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("\n--- ESTADO ACTUAL ---");
                    for (int i = 0; i < espacios.length; i++) {
                        System.out.println("Espacio " + (i + 1) + ": " + espacios[i]);
                    }
                    break;

                case 2:
                    System.out.print("Ingrese el numero de espacio (1-10): ");
                    int slotE = sc.nextInt() - 1;
                    if (slotE >= 0 && slotE < 10) {
                        if (espacios[slotE].equals("Libre")) {
                            espacios[slotE] = "Ocupado";
                            System.out.println("Auto estacionado.");
                        } else {
                            System.out.println("El espacio ya esta ocupado.");
                        }
                    }
                    break;

                case 3:
                    System.out.print("Ingrese el numero de espacio a liberar: ");
                    int slotR = sc.nextInt() - 1;
                    if (slotR >= 0 && slotR < 10) {
                        if (espacios[slotR].equals("Ocupado")) {
                            espacios[slotR] = "Libre";
                            System.out.println("Espacio liberado.");
                        } else {
                            System.out.println("El espacio ya estaba libre.");
                        }
                    }
                    break;

                case 4:
                    int contador = 0;
                    for (String e : espacios) { 
                        if (e.equals("Ocupado")) contador++;
                    }
                    System.out.println("Total de autos: " + contador);
                    break;

                case 5:
                    try {
                        FileWriter fichero = new FileWriter("estacionamiento.txt");
                        PrintWriter pw = new PrintWriter(fichero);
                        
                        pw.println("--- REPORTE DE ESTACIONAMIENTO ---");
                        for (int i = 0; i < espacios.length; i++) {
                            pw.println("Espacio " + (i + 1) + ": " + espacios[i]);
                        }
                        
                        fichero.close();
                        System.out.println("Archivo 'estacionamiento.txt' creado con exito.");
                    } catch (IOException e) {
                        System.out.println("Error al crear el archivo: " + e.getMessage());
                    }
                    System.out.println("Saliendo...");
                    break;
            }
        }
    }
}
