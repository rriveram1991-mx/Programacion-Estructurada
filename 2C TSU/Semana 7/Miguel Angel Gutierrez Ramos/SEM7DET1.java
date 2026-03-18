/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sem7det1;

import java.util.Scanner;

/**
 *
 * @author miguelgu
 */
public class SEM7DET1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);

        String[][] juegos = new String[10][3]; // [nombre, genero, horas]
        int opcion = 0;

        while (opcion != 7) {

            System.out.println("\n1. Registrar");
            System.out.println("2. Mostrar");
            System.out.println("3. Buscar");
            System.out.println("4. Estadisticas");
            System.out.println("7. Salir");
            System.out.print("Opcion: ");

            while (!sc.hasNextInt()) {
            System.out.println("Ingresa un numero valido");
            sc.next();
            }
            opcion = sc.nextInt();
           

            switch (opcion) {

                case 1:
                    int fila = -1;

                    // uso de <= 
                    // correccion: usar <
                    // no había break (tomaba la última fila libre)
                    for (int i = 0; i < juegos.length; i++) {
                        if (juegos[i][0] == null) {
                            fila = i;
                            break; // se detiene en el primer espacio libre
                        }
                    }

                    // no validaba si ya no hay espacio
                    if (fila == -1) {
                        System.out.println("No hay espacio disponible");
                        break;
                    }

                    // problema después de nextint
                    sc.nextLine(); 

                    System.out.print("Nombre: ");
                    juegos[fila][0] = sc.nextLine();

                    System.out.print("Genero: ");
                    juegos[fila][1] = sc.nextLine();

                    System.out.print("Horas: ");
                    while (!sc.hasNextInt()) {
                    System.out.println("Ingresa un numero valido");
                    sc.next();
                    }
                    juegos[fila][2] = sc.next();
                    
                    sc.nextLine();
                    break;

                case 2:
                    boolean hayDatos = false;

                    for (int i = 0; i < juegos.length; i++) {

                        // imprimía valores null
                        if (juegos[i][0] != null) {
                            System.out.println(juegos[i][0] + " - " +
                                               juegos[i][1] + " - " +
                                               juegos[i][2] + " hrs");
                            hayDatos = true;
                        }
                    }
                    if (!hayDatos) {
                    System.out.println("No hay videojuegos registrados");
                    }   
                    break;

                case 3:

                    // problema con buffer
                    sc.nextLine();

                    System.out.print("Buscar: ");
                    String buscar = sc.nextLine();

                    boolean encontrado = false;

                    for (int i = 0; i < juegos.length; i++) {

                        // uso de == en Strings
                        // corregido equalsIgnoreCase
                        if (juegos[i][0] != null &&
                            juegos[i][0].equalsIgnoreCase(buscar)) {

                            System.out.println("Encontrado: " +
                                               juegos[i][0] + " - " +
                                               juegos[i][1] + " - " +
                                               juegos[i][2] + " hrs");

                            encontrado = true;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("No se encontro el videojuego");
                    }

                    break;

                case 4:
                    int suma = 0;
                    int contador = 0;

                    for (int i = 0; i < juegos.length; i++) {

                        //  parseint con null (truena)
                        if (juegos[i][2] != null) {
                            suma += Integer.parseInt(juegos[i][2]);
                            contador++;
                        }
                    }

                    // dividía entre juegos.length (incorrecto)
                    if (contador == 0) {
                        System.out.println("No hay datos para calcular");
                    } else {
                        System.out.println("Promedio: " + (suma / contador));
                    }

                    break;

                case 7:
                    System.out.println("Adios");
                    break;

                default:
                    System.out.println("Opcion invalida");
            }
        }
    }
    }
    

