/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication54;

import java.util.Scanner;

/**
 *
 * @author Lair ☆
 */
public class JavaApplication54 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
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
            sc.nextLine();//agregue este
            switch (opcion) {

                case 1 -> {
                    int fila = 0;

                    for (int i = 0; i < juegos.length; i++) {
                        if (juegos[i][0] == null) {
                            fila = i;
                     
                    //ingrese todo esto adentro del for
                    System.out.print("Nombre: ");// elimine la string inecesaria de name y agregue todod desde la fila
                    juegos[fila][0] = sc.nextLine();


                    System.out.print("Genero: ");
                    juegos[fila][1] = sc.nextLine();

                    System.out.print("Horas: ");
                    juegos[fila][2] = sc.nextLine();
                        } //agrgue todo igual dentro del if
                    }

                    
                  }

                case 2 -> {
                for (String[] juego : juegos) {
                    if(juego[0] != null){ //esto por si no hay texto no lo detecte
                    System.out.println(juego[0] + " - " + juego[1] + " - " + juego[2]);
                    }
                }
                  }

                case 3 -> {
                    System.out.print("Buscar: ");
                    String buscar = sc.nextLine();

                for (String[]juego : juegos) {
                    if ( juego[0] != null && juego[0].equalsIgnoreCase(buscar)) {//agregue el .equals para comparar de mejor manera y si no hay nada lo ignore
                        System.out.println("Encontrado" + juego[0]);//agregue un +juego[0]
                    }
                }
                  }

                case 4 -> {
                    int suma = 0;
                    int cantidad=0; //agregue una variable de suma

                for (String[] juego : juegos) {
                    if (juego[2] != null){// si noha ytexto no lo detecte
                    suma = suma + Integer.parseInt(juego[2]);
                    } 
                }
                  if (cantidad>0 ){//agregue este if por si coloca algo menor a 0 no sea valido
                    System.out.println("Promedio: " + (double) suma / juegos.length);//agregue el double para que agarre la suma correctamente
                  cantidad++;
                  }else{
                      System.out.println("no hay jeugos registardos");
                  
                  }
                  }

                case 7 -> System.out.println("Adios");
            }
    }
    
    }
}