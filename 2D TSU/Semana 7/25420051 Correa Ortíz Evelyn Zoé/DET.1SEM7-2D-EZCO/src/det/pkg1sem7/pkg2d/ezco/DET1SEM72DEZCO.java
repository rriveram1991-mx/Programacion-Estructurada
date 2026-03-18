/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package det.pkg1sem7.pkg2d.ezco;

import java.util.Scanner;

/**
 * 
 * @author Zoé
 * 
 * Se cerró correctamente este comentario con */
public class DET1SEM72DEZCO {

    public static void main(String[] args) {
        // Scanner para entrada de datos
        Scanner sc = new Scanner(System.in);
        // Arreglo para guardar videojuegos [nombre, genero, horas]
        String[][] juegos = new String[10][3];
        int opcion = 0;
        // Ciclo principal del menú
        while (opcion != 7) {
            System.out.println("\n1. Registrar");
            System.out.println("2. Mostrar");
            System.out.println("3. Buscar");
            System.out.println("4. Estadisticas");
            System.out.println("7. Salir");
            // Se valida que el usuario ingrese un número
            // Evita que el programa truene si escriben letras
            if (!sc.hasNextInt()) {
                System.out.println("Opcion invalida");
                sc.next(); // limpiar entrada incorrecta
                continue;
            }
            opcion = sc.nextInt();
            // Se limpia el buffer después de nextInt()
            // porque nextLine() se saltaba entradas
            sc.nextLine();
            switch (opcion) {
                case 1:
                    int fila = -1;
                    // Se cambió <= por < para evitar error de índice
                    // y se agregó break para detenerse al encontrar espacio
                    for (int i = 0; i < juegos.length; i++) {
                        if (juegos[i][0] == null) {
                            fila = i;
                            break; // evita recorrer todo innecesariamente
                        }
                    }

                    // Se valida si el arreglo está lleno
                    if (fila == -1) {
                        System.out.println("Lista llena");
                        break;
                    }

                    System.out.print("Nombre: ");
                    juegos[fila][0] = sc.nextLine();

                    System.out.print("Genero: ");
                    juegos[fila][1] = sc.nextLine();

                    // Validación para asegurar que horas sea número
                    System.out.print("Horas: ");
                    while (!sc.hasNextInt()) {
                        System.out.print("Ingrese numero valido: ");
                        sc.next();
                    }
                    juegos[fila][2] = String.valueOf(sc.nextInt());

                    // limpiar buffer otra vez
                    sc.nextLine();

                    break;

                case 2:
                    boolean hayDatos = false;

                    // ✅ CORRECCIÓN:
                    // Se valida que no sea null para evitar NullPointerException
                    for (int i = 0; i < juegos.length; i++) {
                        if (juegos[i][0] != null) {
                            System.out.println(juegos[i][0] + " - " + juegos[i][1] + " - " + juegos[i][2]);
                            hayDatos = true;
                        }
                    }
                    // Mensaje cuando no hay videojuegos registrados
                    if (!hayDatos) {
                        System.out.println("No hay videojuegos registrados");
                    }

                    break;

                case 3:
                    System.out.print("Buscar: ");
                    String buscar = sc.nextLine();

                    boolean encontrado = false;
                    // Se usa equalsIgnoreCase en lugar de ==
                    // porque == compara referencias, no contenido
                    for (int i = 0; i < juegos.length; i++) {
                        if (juegos[i][0] != null && juegos[i][0].equalsIgnoreCase(buscar)) {
                            System.out.println("Encontrado: " + juegos[i][0]);
                            encontrado = true;
                        }
                    }

                    // Mensaje si no se encuentra
                    if (!encontrado) {
                        System.out.println("No encontrado");
                    }

                    break;

                case 4:
                    int suma = 0;
                    int contador = 0;

                    // Se valida que no sea null antes de convertir a entero
                    for (int i = 0; i < juegos.length; i++) {
                        if (juegos[i][2] != null) {
                            suma += Integer.parseInt(juegos[i][2]);
                            contador++;
                        }
                    }

                    // Se evita dividir entre 0 y se calcula promedio real
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