/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg7;


import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author juang
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         Scanner sc = new Scanner(System.in);

        String[] espacios = new String[10];

        // Inicializar espacios
        for (int i = 0; i < espacios.length; i++) {
            espacios[i] = "LIBRE";
        }

        int opcion = 0;

        while (opcion != 5) {

            System.out.println("\n--- MENU ESTACIONAMIENTO ---");
            System.out.println("1. Ver estacionamiento");
            System.out.println("2. Estacionar auto");
            System.out.println("3. Retirar auto");
            System.out.println("4. Contar espacios ocupados");
            System.out.println("5. Salir");
            System.out.print("Elige una opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    System.out.println("\nEstado del estacionamiento:");

                    try {
                        FileWriter archivo = new FileWriter("estacionamiento.txt");

                        for (int i = 0; i < espacios.length; i++) {
                            String linea = "Espacio " + (i + 1) + ": " + espacios[i];
                            System.out.println(linea);

                            // Guardar en el archivo
                            archivo.write(linea + "\n");
                        }

                        archivo.close();
                        System.out.println("Datos guardados en estacionamiento.txt");

                    } catch (IOException e) {
                        System.out.println("Error al crear el archivo.");
                    }

                    break;

                case 2:
                    System.out.print("Ingresa el numero de espacio (1-10): ");
                    int lugar = sc.nextInt();

                    if (lugar >= 1 && lugar <= 10) {
                        if (espacios[lugar - 1].equals("LIBRE")) {
                            espacios[lugar - 1] = "OCUPADO";
                            System.out.println("Auto estacionado correctamente.");
                        } else {
                            System.out.println("Error: El espacio ya esta ocupado.");
                        }
                    } else {
                        System.out.println("Numero invalido.");
                    }
                    break;

                case 3:
                    System.out.print("Ingresa el numero de espacio (1-10): ");
                    int retirar = sc.nextInt();

                    if (retirar >= 1 && retirar <= 10) {
                        if (espacios[retirar - 1].equals("OCUPADO")) {
                            espacios[retirar - 1] = "LIBRE";
                            System.out.println("Auto retirado correctamente.");
                        } else {
                            System.out.println("El espacio ya esta libre.");
                        }
                    } else {
                        System.out.println("Numero invalido.");
                    }
                    break;

                case 4:
                    int contador = 0;

                    for (String espacio : espacios) {
                        if (espacio.equals("OCUPADO")) {
                            contador++;
                        }
                    }

                    System.out.println("Espacios ocupados: " + contador);
                    break;

                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opcion invalida.");
            }
        }

        
    }
}
   
    

