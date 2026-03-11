/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package req1.sem6.pkg2d.ezco.pkg3;

import java.util.Scanner;

/**
 *
 * @author Zoé
 */
public class REQ1SEM62DEZCO3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner leer= new Scanner (System.in);
        int[][] asientos = new int [5][6];//se crea arreay bidimensional
        //5= número de filas del cine
        //6=numeros de asientos por fila
        for (int fila=0; fila<5; fila++){
            //primer ciclo que recorre los asientos de cada fila
            for(int columna=0; columna<6; columna++){
     //la culmna empieza en 0 y termina en 5 (6 asientos en total)
       asientos[fila][columna] =0;//se asigna el valor a cada asiento
       //0= asiento libre
            } 
        }
         asientos[2][3] = 1; 
        // Se cambia el asiento de la fila 3 y columna 4 a 1
        // 1 significa que el asiento está ocupado

        for(int fila=0; fila<5; fila++){// Otro ciclo para recorrer las filas y mostrar los asientos
            for(int columna=0; columna<6; columna++){// Recorre cada asiento dentro de la fila

                System.out.println(asientos[fila][columna]+"");
            }
            System.out.println();
        }
    }
    
}
