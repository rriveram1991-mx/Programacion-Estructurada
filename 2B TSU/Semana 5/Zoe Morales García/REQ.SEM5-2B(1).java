/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject28;

/**
 *
 * @author Admin
 */
public class Mavenproject28 {

    public static void main(String[] args) {
        String[] mascotas = {"Suki", "Galleto", "Galleta", "Guero", "Chimuelo", "Milo"};
        int[] edades = {1, 2, 3, 4, 5, 6};
        int sumaEdades = 0;

        for (int i = 0; i < mascotas.length; i++) {
            System.out.println(mascotas[i] + " tiene " + edades[i] + " años");
            sumaEdades += edades[i];
        }

        double promedio = (double) sumaEdades / edades.length;
        System.out.println("El promedio de edad es: " + promedio);

    }
}
