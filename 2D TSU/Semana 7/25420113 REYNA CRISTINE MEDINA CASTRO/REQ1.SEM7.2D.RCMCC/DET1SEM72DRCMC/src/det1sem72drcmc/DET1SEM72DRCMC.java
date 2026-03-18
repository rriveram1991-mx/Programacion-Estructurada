/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package det1sem72drcmc;

import java.util.Scanner;

/**
 *
 * @author STAR KRIS
 */
public class DET1SEM72DRCMC {

    /**
     * @param args the command line arguments
     */
   
public class GestorErrores {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[][] juegos = new String[10][3];
        int opcion = 0;

        while (opcion != 7) {
            System.out.println("\n1. Registrar\n2. Mostrar\n3. Buscar\n4. Estadisticas\n7. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // LIMPIEZA DE BUFFER: evita que se salte el siguiente sc.nextLine()

            switch (opcion) {
                case 1 -> {
                    int fila = -1;
                    // Buscar la primera fila libre (que el nombre sea null)
                    for (int i = 0; i < juegos.length; i++) {
                        if (juegos[i][0] == null) {
                            fila = i;
                            break; // Salir al encontrar el primer hueco
                        }
                    }

                    if (fila != -1) {
                        System.out.print("Nombre: ");
                        juegos[fila][0] = sc.nextLine();
                        System.out.print("Genero: ");
                        juegos[fila][1] = sc.nextLine();
                        System.out.print("Horas: ");
                        juegos[fila][2] = sc.nextLine();
                    } else {
                        System.out.println("Error: No hay espacio disponible.");
                    }
                }

                case 2 -> {
                    for (int i = 0; i < juegos.length; i++) {
                        if (juegos[i][0] != null) { // Solo mostrar si hay datos
                            System.out.println(juegos[i][0] + " - " + juegos[i][1] + " - " + juegos[i][2]);
                        }
                    }
                }

                case 3 -> {
                    System.out.print("Buscar nombre: ");
                    String buscar = sc.nextLine();
                    boolean encontrado = false;
                    for (int i = 0; i < juegos.length; i++) {
                        // Comparar con .equals() en lugar de ==
                        if (juegos[i][0] != null && juegos[i][0].equalsIgnoreCase(buscar)) {
                            System.out.println("Encontrado en la posición: " + i);
                            encontrado = true;
                        }
                    }
                    if (!encontrado) System.out.println("No se encontró el juego.");
                }

                case 4 -> {
                    int suma = 0;
                    int cont = 0;
                    for (int i = 0; i < juegos.length; i++) {
                        if (juegos[i][2] != null) { // Evitar NullPointerException
                            suma += Integer.parseInt(juegos[i][2]);
                            cont++;
                        }
                    }
                    if (cont > 0) {
                        System.out.println("Promedio de horas: " + (double) suma / cont);
                    } else {
                        System.out.println("No hay datos para calcular.");
                    }
                }

                case 7 -> System.out.println("Adios");
                
                default -> System.out.println("Opción no válida.");
            }
        
       }
    
     
    
    }


        
                           
    
    

