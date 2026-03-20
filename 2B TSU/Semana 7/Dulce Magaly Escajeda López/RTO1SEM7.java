/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rto.pkg1.sem7rbt;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author lopez
 */
public class RTO1SEM7RBT {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    Scanner lr = new Scanner(System.in);
        
        // 1. Crear el estacionamiento (Array de tamaño 10)
        String[] espacios = new String[10];
        
        // Inicializar espacios como "LIBRE" (Punto 1)
        for (int i = 0; i < espacios.length; i++) {
            espacios[i] = "LIBRE";
        }

        int opcion = 0;

        // 2. Menu interactivo (while + switch)
        while (opcion != 5) {
            System.out.println("\n--- MENU ESTACIONAMIENTO ---");
            System.out.println("1. Ver estacionamiento");
            System.out.println("2. Estacionar auto");
            System.out.println("3. Retirar auto");
            System.out.println("4. Contar espacios ocupados");
            System.out.println("5. Salir");
            System.out.print("\nQue quiere realizar?: ");
            opcion = lr.nextInt();

            switch (opcion) {
                case 1:
                    // 3. Ver estacionamiento (uso de for)
                    System.out.println("\nEstado actual:");
                    for (int i = 0; i < espacios.length; i++) {
                        System.out.println("Espacio " + (i + 1) + ": " + espacios[i]);
                    }
                    break;

                case 2:
                    // 4. Estacionar auto (Validacion con if)
                    System.out.print("Ingrese el numero de espacio (1-10): ");
                    int slotOcupar = lr.nextInt() - 1;

                    if (slotOcupar >= 0 && slotOcupar < 10) {
                        if (espacios[slotOcupar].equals("LIBRE")) {
                            espacios[slotOcupar] = "OCUPADO";
                            System.out.println("Auto estacionado con exito!");
                        } else {
                            System.out.println("Error: el espacio ya esta ocupado");
                        }
                    } else {
                        System.out.println("Numero de espacio invalido.");
                    }
                    break;

                case 3:
                    // 5. Retirar auto (Validacion con if)
                    System.out.print("Ingrese el numero de espacio para retirar (1-10): ");
                    int slotLiberar = lr.nextInt() - 1;

                    if (slotLiberar >= 0 && slotLiberar < 10) {
                        if (espacios[slotLiberar].equals("OCUPADO")) {
                            espacios[slotLiberar] = "LIBRE";
                            System.out.println("Auto retirado, espacio libre.");
                        } else {
                            System.out.println("Error: el espacio ya esta libre");
                        }
                    } else {
                        System.out.println("Numero de espacio invalido.");
                    }
                    break;

                case 4:
                    // 6. Contar espacios ocupados (uso de for-each)
                    int contadorOcupados = 0;
                    for (String estado : espacios) {
                        if (estado.equals("OCUPADO")) {
                            contadorOcupados++;
                        }
                    }
                    System.out.println("Total de autos estacionados: " + contadorOcupados);
                    break;

                case 5:
                    // 7. Salir del programa
                    System.out.println("Saliendo y generando reporte...");
                    break;

                default:
                    System.out.println("Opcion no valida.");
            }
        }

        // 8. Crear TXT (Escritura de archivo al finalizar el ciclo)
        try {
            FileWriter writer = new FileWriter("ControlEstacionamiento.txt");
            writer.write("--- REPORTE DE ESTACIONAMIENTO ---\n");
            
            int total = 0;
            for (int i = 0; i < espacios.length; i++) {
                writer.write("Espacio " + (i + 1) + ": " + espacios[i] + "\n");
                if (espacios[i].equals("OCUPADO")) {
                    total++;
                }
            }
            writer.write("\nResumen final: " + total + " autos estacionados.");
            writer.close();
            System.out.println("Archivo 'ControlEstacionamiento.txt' creado con exito.");
            
        } catch (IOException e) {
            System.out.println("Error al intentar escribir el archivo TXT.");
        }
        
        lr.close();
    }
}