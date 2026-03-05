/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package s5.det;
import java.util.Scanner;


/**
 *
 * @author UTT
 */
public class S5DET {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Se crea un arreglo para almacenar 5 calificaciones
        int[] calificaciones = new int[5];
        // Variable para acumular la suma total
        int suma = 0;
        // Contador de alumnos aprobados
        int aprobados = 0;

        // Captura de datos y validacion de datos
        
        // Ciclo for que recorre cada posición del arreglo
        // i comienza en 0 porque los arreglos en Java inician en índice 0
        // Se repite mientras i sea menor que el tamaño del arreglo (5)
        for (int i = 0; i < calificaciones.length; i++) {
            // Se solicita al usuario ingresar una calificación
            // (1 + i) se usa solo para mostrar numeración desde 1 al usuario
            System.out.println("Ingrese calificación " + (1+i) + ": ");
            // Se guarda la calificación ingresada en la posición i del arreglo
            calificaciones[i] = sc.nextInt();
            
            // Ciclo while que valida que la calificación esté entre 0 y 100
            // Si es menor que 0 o mayor que 100, se considera inválida
            while (calificaciones[i] < 0 || calificaciones[i] > 100) {
                // Se muestra mensaje de error
                System.out.println("Calificación inválida. Intente nuevamente:");
                // Se vuelve a pedir la calificación hasta que sea válida
                calificaciones[i] = sc.nextInt();
            }
        }

        // Mostrar calificaciones
        // Ciclo for-each que recorre cada valor del arreglo
        for (int cal : calificaciones) {
        // Se muestra cada calificación almacenada
            System.out.println("Calificación: " + cal);
            // Se acumula cada calificación en la variable suma
            // suma = suma + cal
            suma += cal;
            
        }

        // Contar aprobados
        // Se crea una variable j para recorrer el arreglo manualmente
        int j = 0;
        // Mientras j sea menor que el tamaño del arreglo
        while (j < calificaciones.length) {
            // Si la calificación actual es mayor o igual a 70
            if (calificaciones[j] > 70) {
                 // Se incrementa el contador de aprobados
                aprobados++;
               
            }
            // Se incrementa j para avanzar a la siguiente posición
            // Sin esta línea el ciclo sería infinito
            j++;
        }
        // Se calcula el promedio dividiendo la suma entre el total de calificaciones
        // Se convierte suma a double para evitar división entera
        double promedio = (double) suma / calificaciones.length;
        
        // Si el promedio es mayor o igual a 70
        if (promedio >= 70){
            // Se indica que el grupo aprobó
            System.out.println("Grupo aprobado");
        }
        else{
             // En caso contrario, el grupo reprobó
            System.out.println("Grupo reprobado");
        }
        // Se muestra el promedio calculado
        System.out.println("Promedio: " + promedio);
        // Se muestra el total de alumnos aprobados
        System.out.println("Aprobados: " + aprobados);
        }
    
    
}
