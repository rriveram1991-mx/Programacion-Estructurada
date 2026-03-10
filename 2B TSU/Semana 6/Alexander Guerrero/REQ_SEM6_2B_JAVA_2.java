/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package req_sem6_2b_java_2;

/**
 *
 * @author Lex
 */
public class REQ_SEM6_2B_JAVA_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        int[][]matriz = {
            {1,0,1},
            {0,0,1},
            {1,1,1}
        };
        
        //Acceder a un elemento
        System.out.println("==========ESTACIONAMIENTO==========\n"); 
        System.out.println("1 = ocupado / 0 = vacio\n");
        System.out.println("Elemento en fila 0 columna 0: " + matriz[0][0]);
        System.out.println("Elemento en fila 1 columna 0: " + matriz[1][0]);
        System.out.println("Elemento en fila 2 columna 0: " + matriz[2][0]);
        System.out.println("Elemento en fila 0 columna 1: " + matriz[0][1]);
        System.out.println("Elemento en fila 1 columna 1: " + matriz[1][1]);
        System.out.println("Elemento en fila 2 columna 1: " + matriz[2][1]);
        System.out.println("Elemento en fila 0 columna 2: " + matriz[0][2]);
        System.out.println("Elemento en fila 1 columna 2: " + matriz[1][2]);
        System.out.println("Elemento en fila 2 columna 2: " + matriz[2][2]);
    }
}
    

