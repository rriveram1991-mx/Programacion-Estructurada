/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication61;

import java.util.Scanner;

/**
 *
 * @author Jaime Ismael
 */
public class JavaApplication61 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
//primero pedimos la cantidad de calificaciones 

        System.out.print("¿Cuántas calificaciones vas a ingresar? ");
        int cantidad = sc.nextInt();
//creamos el arreglo de tipo double

        double[] calificaciones = new double[cantidad];
//el for recorre el arreglo asignandole los datos que le damos
        for (int x = 0; x < calificaciones.length; x++) {
            System.out.print("Ingresa la calificación " + (x + 1) + ": ");
            calificaciones[x] = sc.nextDouble();
        }

        double suma = 0;
//for each para hacer la suma de todas las calificaciones
        for (double calificacion : calificaciones) {
            suma = suma + calificacion;
        }

        double promedio = suma / calificaciones.length;

        System.out.println("El promedio es: " + promedio);
        System.out.println("Programado por jaime ismael");
    }
    
}
