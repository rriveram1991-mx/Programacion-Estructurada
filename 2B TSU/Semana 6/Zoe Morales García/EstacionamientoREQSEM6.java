/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject32;

/**
 *
 * @author Admin
 */
public class Mavenproject32 {

    public static void main(String[] args) {
         String[][] estacionamiento = {
            {"libre", "auto", "libre"},
            {"auto", "libre", "auto"},
            {"libre", "libre", "auto"}
        };
         
        System.out.println("Estado de el estacionamiento:  ");
        for(int i=0;i<estacionamiento.length;i++){
            for(int j=0;j<estacionamiento[i].length;j++){
                System.out.print(estacionamiento[i][j] + " ");
            }
            System.out.println();
        }

    }
}
