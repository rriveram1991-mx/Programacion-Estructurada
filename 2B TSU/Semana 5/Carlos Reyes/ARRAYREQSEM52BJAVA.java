/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package array.req.sem5.pkg2b.java;

/**
 *
 * @author juanc
 */
public class ARRAYREQSEM52BJAVA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Arreglo que almacena calificaciones
        int[] calificaciones = {85, 90, 78, 92, 88};

        int suma = 0;       // Guarda la suma de las calificaciones
        int contador = 0;  // Cuenta cuántos valores hay en el arreglo

        // For-each para recorrer el arreglo
        for (int calificacion : calificaciones) {
            System.out.println("Calificación: " + calificacion);
            suma += calificacion; // Suma cada calificación
            contador++;           // Incrementa el contador
        }

        // Cálculo del promedio
        double promedio = (double) suma / contador;

        // Resultados finales
        System.out.println("\nTotal de calificaciones: " + contador);
        System.out.println("Promedio: " + promedio);
    }
    }
    
