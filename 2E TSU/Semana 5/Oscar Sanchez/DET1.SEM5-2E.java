/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package det.sem5.pkg2e.txt;

/**
 *
 * @author Oscar Sanchez
 */
import java.util.Scanner;

public class SistemaCalificaciones {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] calificaciones = new int[5];
        int suma = 0;
        int aprobados = 0;

        // --- Captura de datos ---
        // ERROR DE EJECUCIÓN: Cambié el i <= length por i < length porque se me estaba 
        // saliendo del rango del arreglo (los arreglos en Java llegan hasta n-1).
        for (int i = 0; i < calificaciones.length; i++) {

            // MALA PRÁCTICA: Le puse (i + 1) para que en la consola no salga "Calificación 0"
            // y sea más fácil de leer para el usuario.
            System.out.println("Ingrese calificación " + (i + 1) + ": ");
            calificaciones[i] = sc.nextInt();

            // ERROR LÓGICO: Tenía un '&&' pero lo cambié a '||' porque un número no puede 
            // ser menor a 0 y mayor a 100 al mismo tiempo. Estaba mal la condición.
            while (calificaciones[i] < 0 || calificaciones[i] > 100) {
                System.out.println("Calificación inválida. Intente nuevamente:");
                calificaciones[i] = sc.nextInt();
            }
        }

        // --- Mostrar calificaciones ---
        for (int cal : calificaciones) {
            System.out.println("Calificación: " + cal);
            // ERROR LÓGICO: Aquí puse '+=' porque antes solo estaba guardando el último valor
            // en la variable suma, ahora sí las va acumulando todas.
            suma += cal; 
        }

        // --- Contar aprobados ---
        int j = 0;
        while (j < calificaciones.length) {
            // ERROR LÓGICO: Le puse '>=' porque el 70 también cuenta como aprobado.
            if (calificaciones[j] >= 70) {
                aprobados++;
            }
            // ERROR LÓGICO: Faltaba el j++ para que el contador avance, 
            // si no, se quedaba en un bucle infinito y no terminaba nunca.
            j++; 
        }

        // ERROR LÓGICO: Agregué el (double) para que la división no me de un entero 
        // truncado y pueda ver los decimales del promedio.
        double promedio = (double) suma / calificaciones.length;

        if (promedio >= 70)
            System.out.println("Grupo aprobado");
        else
            System.out.println("Grupo reprobado");

        System.out.println("Promedio: " + promedio);
        System.out.println("Aprobados: " + aprobados);
        
        
    }
}