/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package s6.arraybicine;

/**
 *
 * @author UTT
 */
public class S6ArrayBiCine {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* Se crea un arreglo bidimensional llamado "asientos"
        Representa los asientos del cine
        Cada fila del arreglo representa una fila del cine
        Cada número dentro representa un asiento
        0 = asiento libre
        1 = asiento ocupado
        */
       int[][] asientos = {
            {0,0,0,0,0,1,0,0},//Fila 1
            {1,0,0,0,1,1,1,1},//Fila 2
            {0,0,1,1,0,0,0,1},//Fila 3
            {1,1,0,1,1,0,1,1},//Fila 4
            {1,0,0,0,1,0,0,1}//Fila 5
        };
       // Se crea un arreglo de tipo char llamado "columnas"
       // Este arreglo contiene letras que representan las columnas de los asientos
       // Cada letra identifica un asiento en cada fila (A, B, C, D, E, F, G, H)
       char[] columnas = {'A','B','C','D','E','F','G','H'};
       // Imprime un mensaje en pantalla indicando el estado general del cine
       System.out.println("Disponibilidad de los asientos del cine:");
       System.out.println("ASIENTOS DEL CINE");
       /*
       Explica al usuario qué significa cada número mostrado en la tabla
       0 indica que el asiento está libre
       1 indica que el asiento está ocupado
       */
       System.out.println("0 = Libre   1 = Ocupado");
       // Imprime dos espacios para alinear correctamente las columnas con las filas
       // Evitando que no esten representadas graficamente de manera adecuada
       System.out.print("  ");
       // Este ciclo recorre el arreglo "columnas"
       // Su objetivo es mostrar las letras A B C D E F G H en la parte superior de la tabla
        for(int i = 0; i < columnas.length; i++) {
            // Imprime cada letra del arreglo columnas seguida de un espacio
            // Esto sirve como encabezado para las columnas del cine coincida con los asientos
            System.out.print(columnas[i] + " ");
        }
        // Hace un salto de linea despues de imprimir las letras de las columnas
        System.out.println();

        // Mostrar filas y asientos
        // Este ciclo for recorre las filas del arreglo bidimensional "asientos"
        // i representa el número de fila del cine
        for(int i = 0; i < asientos.length; i++) {
            // Imprime el nmero de fila del cine
            // Se usa (i+1) porque los arreglos comienzan en 0
            // pero para el usuario es mas claro ver filas comenzando desde 1
            System.out.print((i+1) + " ");
            // Este segundo ciclo for recorre las columnas dentro de cada fila
            // j representa cada asiento dentro de la fila
            for(int j = 0; j < asientos[i].length; j++) {
                 // Imprime el valor del asiento
                 // Si el valor es 0 el asiento esta libre
                 // Si el valor es 1 el asiento ests ocupado
                System.out.print(asientos[i][j] + " ");

            }
            // Despuss de imprimir todos los asientos de una fila
            // se hace un salto de linea para mostrar la siguiente fila
            System.out.println();
        }
    }
}