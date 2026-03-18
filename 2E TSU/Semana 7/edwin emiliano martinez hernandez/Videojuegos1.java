/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package videojuegos1;

import java.util.Scanner;

/**
 *
 * @author edwin
 */
public class Videojuegos1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
        String[][] juegos = new String[10][3];

        int opcion = 0;

        while (opcion != 7) {

            System.out.println("\n1. Registrar");
            System.out.println("2. Mostrar");
            System.out.println("3. Buscar");
            System.out.println("4. Estadisticas");
            System.out.println("7. Salir");
            System.out.print("Opcion: ");

            // ERROR 1: No se validaban números
            while (!sc.hasNextInt()) {
                System.out.println("Ingresa un número válido");
                sc.next();
            }

            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    int fila = -1;

                    // ERROR logico: antes usaba <= 
                    // ERROR logico: no hacía break 
                    for (int i = 0; i < juegos.length; i++) {
                        if (juegos[i][0] == null) {
                            fila = i;
                            break;
                        }
                    }

                    if (fila == -1) {
                        System.out.println("No hay espacio disponible");
                        break;
                    }

                    // ERROR sintaxis: nextLine se saltaba por nextInt
                    sc.nextLine();

                    System.out.print("Nombre: ");
                    juegos[fila][0] = sc.nextLine();

                    System.out.print("Genero: ");
                    juegos[fila][1] = sc.nextLine();

                    System.out.print("Horas: ");

                    while (!sc.hasNextInt()) {
                        System.out.println("Horas inválidas, intenta de nuevo:");
                        sc.next();
                    }

                    juegos[fila][2] = String.valueOf(sc.nextInt());

                    break;

                case 2:
                    boolean hayDatos = false;

                    for (int i = 0; i < juegos.length; i++) {

                        // ERROR logico: antes imprimía null
                        if (juegos[i][0] != null) {
                            System.out.println(juegos[i][0] + " - " + juegos[i][1] + " - " + juegos[i][2]);
                            hayDatos = true;
                        }
                    }

                    // Mejora: mensaje cuando no hay videojuegos
                    if (!hayDatos) {
                        System.out.println("No hay videojuegos registrados");
                    }
                    break;

                case 3:
                    sc.nextLine();

                    System.out.print("Buscar: ");
                    String buscar = sc.nextLine();

                    boolean encontrado = false;

                    for (int i = 0; i < juegos.length; i++) {

                        // ERROR logico: usaba == en Strings
                        if (juegos[i][0] != null &&
                            juegos[i][0].equalsIgnoreCase(buscar)) {

                            System.out.println("Encontrado: " +
                                    juegos[i][0] + " - " +
                                    juegos[i][1] + " - " +
                                    juegos[i][2]);

                            encontrado = true;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("No se encontró el videojuego");
                    }

                    break;

                case 4:
                    int suma = 0;
                    int contador = 0;

                    for (int i = 0; i < juegos.length; i++) {

                        // ERROR ejecucion: podía hacer parseInt(null)
                        if (juegos[i][2] != null) {
                            suma += Integer.parseInt(juegos[i][2]);
                            contador++;
                        }
                    }

                    // ERROR logico: antes dividía entre juegos.length
                    if (contador > 0) {
                        System.out.println("Promedio: " + (suma / contador));
                    } else {
                        System.out.println("No hay datos para calcular promedio");
                    }

                    break;

                case 7:
                    System.out.println("Hasta la vista");
                    break;

                default:
                    System.out.println("Opcion invalida");
            }
        }
    }
}
