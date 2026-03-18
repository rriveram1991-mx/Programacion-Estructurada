/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package det7;

import java.util.Scanner;

/**
 *
 * @author LABTICS
 */
public class DET7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
        // Matriz de 10 filas (juegos) y 3 columnas (Nombre, Género, Horas)
        String[][] juegos = new String[10][3];
        int opcion = 0;

        while (opcion != 7) {

            System.out.println("\n--- MENU GESTOR ---");
            System.out.println("1. Registrar");
            System.out.println("2. Mostrar");
            System.out.println("3. Buscar");
            System.out.println("4. Estadisticas");
            System.out.println("7. Salir");
            System.out.print("Selecciona: ");

            // EXTRA: Validación de entrada para que el programa no truene si ingresan letras
            try {
                // CORRECCIÓN 1: Se usa Integer.parseInt(sc.nextLine()) en lugar de nextInt() 
                // para evitar que el "Enter" se quede en el búfer y se salte los campos de texto después.
                opcion = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingresa un numero valido del menu.");
                continue; 
            }

            switch (opcion) {

                case 1:
                    int fila = -1; // Iniciamos en -1 para validar si hay espacio

                    // CORRECCIÓN 2: Se cambió '<=' por '<' para evitar ArrayIndexOutOfBoundsException (Error de ejecución)
                    for (int i = 0; i < juegos.length; i++) {
                        if (juegos[i][0] == null) {
                            fila = i;
                            // CORRECCIÓN 3: Se agrega break para que asigne el PRIMER espacio vacío 
                            // y no se vaya hasta el último (Error lógico)
                            break; 
                        }
                    }

                    // CORRECCIÓN 4: Validación de seguridad por si el arreglo de 10 ya está lleno
                    if (fila != -1) {
                        System.out.print("Nombre: ");
                        juegos[fila][0] = sc.nextLine();

                        System.out.print("Genero: ");
                        juegos[fila][1] = sc.nextLine();

                        // EXTRA: Validación de número para las horas (evita NumberFormatException en Estadísticas)
                        System.out.print("Horas: ");
                        String horasInput = sc.nextLine();
                        try {
                            Integer.parseInt(horasInput);
                            juegos[fila][2] = horasInput;
                            System.out.println("Registrado correctamente.");
                        } catch (NumberFormatException e) {
                            System.out.println("Error: Horas invalidas. Registro cancelado.");
                            juegos[fila][0] = null; // Limpiamos el registro fallido
                        }
                    } else {
                        System.out.println("Error: Memoria llena (10/10 juegos).");
                    }
                    break;

                case 2:
                    // EXTRA: Mensaje cuando no hay videojuegos (Validación de contenido)
                    boolean hayDatos = false;
                    for (int i = 0; i < juegos.length; i++) {
                        // CORRECCIÓN 5: Se agrega el IF para no imprimir filas "null" (Error lógico/estético)
                        if (juegos[i][0] != null) {
                            System.out.println(juegos[i][0] + " | " + juegos[i][1] + " | " + juegos[i][2] + " hrs");
                            hayDatos = true;
                        }
                    }
                    if (!hayDatos) System.out.println("No hay videojuegos registrados.");
                    break;

                case 3:
                    System.out.print("Nombre a buscar: ");
                    String buscar = sc.nextLine();
                    boolean encontrado = false;

                    for (int i = 0; i < juegos.length; i++) {
                        // CORRECCIÓN 6: Se usa .equalsIgnoreCase() porque == no sirve para comparar contenido de Strings. 
                        // Además se valida que no sea null para evitar errores de ejecución.
                        if (juegos[i][0] != null && juegos[i][0].equalsIgnoreCase(buscar)) {
                            System.out.println("¡Encontrado! Genero: " + juegos[i][1]);
                            encontrado = true;
                        }
                    }
                    if (!encontrado) System.out.println("Juego no encontrado.");
                    break;

                case 4:
                    int suma = 0;
                    int contador = 0; // CORRECCIÓN 7: Se requiere un contador real de juegos registrados.

                    for (int i = 0; i < juegos.length; i++) {
                        // CORRECCIÓN 8: Validar que la celda no sea null antes de hacer el parse (Error de ejecución)
                        if (juegos[i][2] != null) {
                            suma = suma + Integer.parseInt(juegos[i][2]);
                            contador++;
                        }
                    }

                    // CORRECCIÓN 9: Dividir entre 'contador' y no entre 'juegos.length' (10), 
                    // de lo contrario el promedio sería falso (Error lógico).
                    if (contador > 0) {
                        System.out.println("Promedio de horas: " + (suma / contador));
                    } else {
                        System.out.println("No hay datos para calcular estadisticas.");
                    }
                    break;

                case 7:
                    System.out.println("Saliendo...");
                    break;
                
                // EXTRA: Caso default para opciones fuera de rango (ej. presionar 5)
                default:
                    System.out.println("Opcion invalida.");
                    break;
            }
        }
    }
}