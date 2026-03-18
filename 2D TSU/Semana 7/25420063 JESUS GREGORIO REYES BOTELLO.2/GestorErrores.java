/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gestorerrores;

import java.util.Scanner;

/**
 *
 * @author jessr
 */
public class GestorErrores {

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
         String[][] juegos = new String[10][3];

        int opcion = 0;
         boolean Hora = false;
        while (opcion != 7) {

            System.out.println("1. Registrar");
            System.out.println("2. Mostrar");
            System.out.println("3. Buscar");
            System.out.println("4. Estadisticas");
            System.out.println("7. Salir");

            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    int fila = -1;
//Hay un <= que hace que salga del arreglo
//No se detiene cuando encuentra espacio libre
//sc.nextLine() después de nextInt()
//Muestra datos null
//Comparación de Strings con ==   
//Promedio incorrecto
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
                 int horas;
                 while (true){
                  System.out.print("Horas: ");
                  if(sc.hasNextInt()){
                  horas = sc.nextInt();
                  sc.nextInt();
                  break;
                  }else{
                  System.out.println("Ingresa un numero valido");
                   sc.next();
                  }
                 }
                    juegos[fila][2] = String.valueOf(horas);
                    break;

                case 2:
                    boolean datos = false;
                    for (int i = 0; i < juegos.length; i++) {
                        System.out.println(juegos[i][0] + " - " + juegos[i][1] + " - " + juegos[i][2]);
                        datos = true;
                    }
                    
                    if(!datos){
                        System.out.println("No hay juegos");
                    }
                    break;

                case 3:
                    System.out.print("Buscar: ");
                    String buscar = sc.nextLine();
                    boolean encontrado = false;

                    for (int i = 0; i < juegos.length; i++) {
                        if (juegos[i][0] != null && juegos[i][0].equalsIgnoreCase(buscar)) {
                            System.out.println("Encontrado" + juegos[i][0] + "-" + juegos[i][1] + ":" + juegos[i][2]);
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
                        if(juegos[i][2] != null){
                        suma = suma + Integer.parseInt(juegos[i][2]);
                        contador++;
                        }
                    }
                     if (contador == 0) {
                        System.out.println("No hay datos para calcular");
                    } else {
                        System.out.println("Promedio: " + (suma / contador));
                    }


                    System.out.println("Promedio: " + suma / juegos.length);
                    break;

                case 7:
                    System.out.println("Adios");
                    break;
                default:
            }
        }

       
    }
}
