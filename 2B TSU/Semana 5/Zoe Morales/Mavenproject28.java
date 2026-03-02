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
        Scanner leer = new Scanner(System.in);
        String[] mascotas = {"Suki", "Galleto", "Galleta", "Guero", "Chimuelo", "Milo"};
        int[] edades = {1, 2, 3, 4, 5};
        int sum_edades=0;
        for (int edad:edades){
            sum_edades+=edad;
        }
        for (String mascota : mascotas) {
            System.out.println(mascota);
        }
        
        double prom = (double) sum_edades/edades.length;
        System.out.print("El promedio de las edades es "+ prom);

    }
}
