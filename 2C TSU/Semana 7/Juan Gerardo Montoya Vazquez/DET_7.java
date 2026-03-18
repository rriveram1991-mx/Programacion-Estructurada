/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package det_7;

import java.util.Scanner;

/**
 *
 * @author juang
 */
public class DET_7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
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

            // Validación de número
            if (!sc.hasNextInt()) {
                System.out.println("Ingresa un numero valido");
                sc.next();
                continue;
            }

            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {

                case 1:
                    int fila = -1;

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

                    System.out.print("Nombre: ");
                    juegos[fila][0] = sc.nextLine();

                    System.out.print("Genero: ");
                    juegos[fila][1] = sc.nextLine();

                    System.out.print("Horas: ");

                    while (!sc.hasNextInt()) {
                        System.out.println("Ingresa horas validas");
                        sc.next();
                    }
                    juegos[fila][2] = String.valueOf(sc.nextInt());
                    sc.nextLine(); // limpiar buffer

                    break;

                case 2:
                    boolean hayDatos = false;

                    for (int i = 0; i < juegos.length; i++) {
                        if (juegos[i][0] != null) {
                            System.out.println(juegos[i][0] + " - " + juegos[i][1] + " - " + juegos[i][2]);
                            hayDatos = true;
                        }
                    }

                    if (!hayDatos) {
                        System.out.println("No hay videojuegos registrados");
                    }

                    break;

                case 3:
                    System.out.print("Buscar: ");
                    String buscar = sc.nextLine();

                    boolean encontrado = false;

                    for (int i = 0; i < juegos.length; i++) {
                        if (juegos[i][0] != null && juegos[i][0].equalsIgnoreCase(buscar)) {
                            System.out.println("Encontrado: " + juegos[i][0]);
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
                        if (juegos[i][2] != null) {
                            suma += Integer.parseInt(juegos[i][2]);
                            contador++;
                        }
                    }

                    if (contador == 0) {
                        System.out.println("No hay datos para calcular promedio");
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

    