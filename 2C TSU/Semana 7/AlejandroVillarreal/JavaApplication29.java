/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication29;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class JavaApplication29 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         Scanner sc = new Scanner(System.in);

        String[][] juegos = new String[10][3];

        int opcion = 0;

        while (opcion != 7) {

            System.out.println("1. Registrar");
            System.out.println("2. Mostrar");
            System.out.println("3. Buscar");
            System.out.println("4. Estadisticas");
            System.out.println("7. Salir");

            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    int fila = 0;

                    for (int i = 0; i < juegos.length; i++) {  //Aqui es "<" no "="
                        if (juegos[i][0] == null) {
                            fila = i;
                        }
                    }
                    
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    juegos[fila][0] = nombre;

                    System.out.print("Genero: ");
                    juegos[fila][1] = sc.nextLine();

                    System.out.print("Horas: ");
                    juegos[fila][2] = sc.nextLine();

                    break;

                case 2:
                    for (int i = 0; i < juegos.length; i++) {
                        System.out.println(juegos[i][0] + " - " + juegos[i][1] + " - " + juegos[i][2]);
                    }
                    break;

                case 3:
                    System.out.print("Buscar: ");
                    String buscar = sc.nextLine();

                    for (int i = 0; i < juegos.length; i++) {
                        if (juegos[i][0] == buscar) {
                            System.out.println("Encontrado");
                        }
                    }
                    break;

                case 4:
                    int suma = 0;

                    for (int i = 0; i < juegos.length; i++) {
                        suma = suma + Integer.parseInt(juegos[i][2]);
                    }

                    System.out.println("Promedio: " + suma / juegos.length);
                    break;

                case 7:
                    System.out.println("Adios");
                    break;
            }
        }
    }
    
}
