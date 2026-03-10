/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject31;

/**
 *
 * @author Admin
 */
public class Mavenproject31 {

    public static void main(String[] args) {
         int[][] asientos = {
            {1, 1, 0, 1},
            {1, 0, 0, 1},
            {1, 1, 1, 1}
        };
         
        System.out.println("Elemento en fila 1) ocupado y 0) libre: ");
        for(int i=0;i<asientos.length;i++){
            for(int j=0;j<asientos[i].length;j++){
                System.out.print(asientos[i][j] + " ");
            }
            System.out.println();
        }

    }
}
