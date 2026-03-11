/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package s6.arraybiestacionamiento;

/**
 *
 * @author UTT
 */
public class S6ArrayBiEstacionamiento {

    /*
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        Se crea un arreglo bidimensional llamado "lugares"
        Representa los espacios de un estacionamiento
        Cada fila representa una fila o secciom del estacionamiento
        Cada numero dentro representa un lugar para estacionar
        0 = lugar libre
        1 = ugar ocupado
        */
         int[][] lugares = {
            {1,0,0,1},//Filas del estacionamiento
            {0,0,1,0},
            {1,1,0,0}
         };
        // Imprime un mensaje que indica lo que se mostraraa en pantalla
        // En este caso el estado de los lugares del estacionamiento
        System.out.println("Estado del estacionamiento:");
        // Este ciclo for recorre las filas del arreglo bidimensional
        // i representa cada fila del estacionamiento
        // lugares.length indica cunntas filas tiene el arreglo
        for(int i = 0; i < lugares.length; i++) {
            // Este segundo ciclo for recorre las columnas dentro de cada fila
            // j representa cada lugar dentro de la fila
            // lugares[i].length indica cuantos lugares hay en esa fila
            for(int j = 0; j < lugares[i].length; j++) {
                // Imprime el valor de cada lugar del estacionamiento
                // Si es 0 significa que el lugar está disponible
                // Si es 1 significa que el lugar está ocupado
                System.out.print(lugares[i][j] + " ");

            }
            // Despues de terminar de imprimir todos los lugares de una fila
            // se hace un salto de linea para mostrar la siguiente fila
            System.out.println();
        }
    }
}