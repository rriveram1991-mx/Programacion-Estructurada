/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package estacionamiento;
 import java.util.Scanner;

/**
 *
 * @author LABTICS
 */
public class Estacionamiento {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       
        Scanner scanner = new Scanner(System.in);

        // Crear el arreglo de 10 espacios
        String[] espacios = new String[10];

        // primero ponemos todos los espacios como LIBRE
        for (int i = 0; i < espacios.length; i++) {
            espacios[i] = "LIBRE";
        }

        int opcion = 0;

        // el menú que se repite hasta que el usuario salga
        while (opcion != 5) {

            System.out.println("\n MENU DE ESTACIONAMIENTO");
            System.out.println("1. Ver estacionamiento");
            System.out.println("2. Estacionar auto");
            System.out.println("3. Retirar auto");
            System.out.println("4. Contar espacios ocupados");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {

                case 1:
                    // Ver estacionamiento
                    for (int i = 0; i < espacios.length; i++) {
                        System.out.println("Espacio " + (i + 1) + ": " + espacios[i]);
                    }
                    break;

                case 2:
                    // Estacionar auto
                    System.out.print("Ingresa el número de espacio (1-10): ");
                    int lugar = scanner.nextInt();

                    if (espacios[lugar - 1].equals("LIBRE")) {
                        espacios[lugar - 1] = "OCUPADO";
                        System.out.println("Auto estacionado correctamente.");
                    } else {
                        System.out.println("Error: Ese espacio ya está ocupado.");
                    }
                    break;

                case 3:
                    // Retirar auto
                    System.out.print("Ingresa el número de espacio (1-10): ");
                    int retirar = scanner.nextInt();

                    if (espacios[retirar - 1].equals("OCUPADO")) {
                        espacios[retirar - 1] = "LIBRE";
                        System.out.println("Auto retirado correctamente.");
                    } else {
                        System.out.println("Ese espacio ya está libre.");
                    }
                    break;

                case 4:
                    // Contar espacios ocupados
                    int contador = 0;

                    for (String estado : espacios) {
                        if (estado.equals("OCUPADO")) {
                            contador++;
                        }
                    }

                    System.out.println("Espacios ocupados: " + contador);
                    break;

                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        }

        scanner.close();
    }
}
