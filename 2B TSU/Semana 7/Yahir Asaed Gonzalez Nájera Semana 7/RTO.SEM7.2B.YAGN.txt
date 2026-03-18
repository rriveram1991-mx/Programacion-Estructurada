

//**Author Yahir

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EjerciciosIngRicardo55 {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        String[] estacionamiento = new String[10];
        for (int i = 0; i < estacionamiento.length; i++) {
            estacionamiento[i] = "LIBRE";
        }

        int opcion = 0;

        
        while (opcion != 5) {
            System.out.println("\n--- MENÚ ESTACIONAMIENTO ---");
            System.out.println("1. Ver estacionamiento");
            System.out.println("2. Estacionar auto");
            System.out.println("3. Retirar auto");
            System.out.println("4. Contar espacios ocupados");
            System.out.println("5. Guardar el estadu actual del estacionamiento en un archivo");
            System.out.print("Elija una opción: ");
            opcion = leer.nextInt();

            switch (opcion) {
                case 1: 
                    for (int i = 0; i < estacionamiento.length; i++) {
                        System.out.println("Espacio " + (i + 1) + ": " + estacionamiento[i]);
                    }
                    break;

                case 2: 
                    System.out.print("¿Qué número de espacio quiere ocupar (1-10)?: ");
                    int ocupar = leer.nextInt() - 1;
                    if (estacionamiento[ocupar].equals("LIBRE")) {
                        estacionamiento[ocupar] = "OCUPADO";
                        System.out.println("¡Auto estacionado!");
                    } else {
                        System.out.println("Error: El espacio ya está OCUPADO.");
                    }
                    break;

                case 3: 
                    System.out.print("¿Qué número de espacio quiere liberar (1-10)?: ");
                    int liberar = leer.nextInt() - 1;
                    if (estacionamiento[liberar].equals("OCUPADO")) {
                        estacionamiento[liberar] = "LIBRE";
                        System.out.println("¡Espacio liberado!");
                    } else {
                        System.out.println("Error: El espacio ya estaba LIBRE.");
                    }
                    break;

                case 4: 
                    int contador = 0;
                    for (String estado : estacionamiento) {
                        if (estado.equals("OCUPADO")) {
                            contador++;
                        }
                    }
                    System.out.println("Hay " + contador + " espacios ocupados.");
                    break;

                case 5: 
                    try (FileWriter writer = new FileWriter("Guardar el estado del estacionamiento en un archivo.txt")) {
                        writer.write("ESTADO FINAL DEL ESTACIONAMIENTO:\n");
                        for (int i = 0; i < estacionamiento.length; i++) {
                            writer.write("Espacio " + (i + 1) + ": " + estacionamiento[i] + "\n");
                        }
                        System.out.println("Archivo guardado");
                    } catch (IOException e) {
                        System.out.println("Error al crear el archivo.");
                    }
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}	