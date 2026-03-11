/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package req1.sem6.pkg2d.ezco.pkg4;

/**
 *
 * @author Zoé
 */
public class REQ1SEM62DEZCO4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         int[][] lugares = new int[4][5]; // Se crea un array bidimensional
        // 4 filas de estacionamiento
        // 5 lugares por fila
        for(int fila = 0; fila < 4; fila++) { 
        // Este ciclo recorre cada fila del estacionamiento
            for(int columna = 0; columna < 5; columna++) { 
            // Este ciclo recorre cada lugar dentro de la fila
                lugares[fila][columna] = 0;  // Se asigna el valor 0
                // 0 significa que el lugar está libre
            }
        }
        lugares[1][2] = 1; // Marcamos un lugar ocupado
        // fila 2, lugar 3 del estacionamiento
        lugares[3][4] = 1;  // Otro lugar ocupado
        // fila 4, lugar 5
        for(int fila = 0; fila < 4; fila++) { 
        // Recorre nuevamente las filas para mostrar el estacionamiento
            for(int columna = 0; columna < 5; columna++) { 
            // Recorre cada lugar de la fila
                System.out.print(lugares[fila][columna] + " "); 
                // Imprime si el lugar está libre (0) o ocupado (1)
            }
            System.out.println(); 
            // Hace salto de línea para mostrar la siguiente fila
        }

    }
}