/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package videojuego;

import java.util.Scanner;

/**
 *
 * @author aguer
 */
public class Videojuego {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Scanner leer = new Scanner(System.in);
String[][] juegos = new String[10][3];

int opcion = 0;

while (opcion != 7) {

    System.out.println("\n1. Registrar");
    System.out.println("2. Mostrar");
    System.out.println("3. Buscar");
    System.out.println("4. Estadisticas");
    System.out.println("7. Salir");
    System.out.print("Opcion: ");

    // no se validaba que fuera numero, se agrego validacion
    if (!leer.hasNextInt()) {
        System.out.println("Ingresa un numero valido");
        leer.next();
        continue;
    }

    opcion = leer.nextInt();
    leer.nextLine(); // se agrego para limpiar buffer despues de nextInt

    switch (opcion) {

        case 1:
            int fila = -1;

            // antes era <= juegos.length, causaba desbordamiento
            for (int i = 0; i < juegos.length; i++) {

                // no se detenia al encontrar espacio, se agrego break
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
            juegos[fila][0] = leer.nextLine();

            System.out.print("Genero: ");
            juegos[fila][1] = leer.nextLine();

            System.out.print("Horas: ");

            //  no se validaban numeros, se agrego validacion
            if (!leer.hasNextInt()) {
                System.out.println("Horas invalidas");
                leer.next();
                break;
            }

            juegos[fila][2] = leer.next();
            break;

        case 2:
            boolean hayDatos = false;

            for (int i = 0; i < juegos.length; i++) {

                // imprimia null, se agrego validacion
                if (juegos[i][0] != null) {
                    System.out.println(juegos[i][0] + " - " +
                                       juegos[i][1] + " - " +
                                       juegos[i][2]);
                    hayDatos = true;
                }
            }

            // esta parte se mejoro agregando un mensaje cuando no hay videojuegos
            if (!hayDatos) {
                System.out.println("No hay videojuegos registrados");
            }
            break;

        case 3:
            System.out.print("Buscar: ");
            String buscar = leer.nextLine();
            boolean encontrado = false;

            for (int i = 0; i < juegos.length; i++) {

                //  se usaba == en String, se cambio a equalsIgnoreCase
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
                System.out.println("No encontrado");
            }
            break;

        case 4:
            int suma = 0;
            int contador = 0;

            for (int i = 0; i < juegos.length; i++) {

                //  podia hacer parseInt(null), se agrego validacion
                if (juegos[i][2] != null) {
                    suma += Integer.parseInt(juegos[i][2]);
                    contador++;
                }
            }

            // antes dividia entre juegos.length, ahora usa contador real
            if (contador == 0) {
                System.out.println("No hay datos para calcular");
            } else {
                System.out.println("Promedio: " + (suma / contador));
            }
            break;

        case 7:
            System.out.println("SISI, YA VETE ");
            break;

        default:
            System.out.println("Opcion invalida");
    }
}
    }
}