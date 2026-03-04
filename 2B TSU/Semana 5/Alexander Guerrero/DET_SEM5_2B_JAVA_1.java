/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package det_sem5_2b_java_1;

import java.util.Scanner;

/**
 *
 * @author Lex
 */
public class DET_SEM5_2B_JAVA_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        int[] calificaciones = new int[5];
        double suma = 0; //Cambiamos int por double para evitar errores de calculo
        int aprobados = 0;

        // Captura de datos
        for (int i = 0; i < calificaciones.length; i++) { //Arreglamos el fro cambiando i=1 a i=0

            System.out.println("Ingrese calificación " + (i + 1) + ": "); //cambiamos (i+1) para al momento de ingresar los datos no muestre que empieza desde calificacion 0
            calificaciones[i] = sc.nextInt();

            while (calificaciones[i] < 0 || calificaciones[i] > 100) { //Cambiamos && por un || para que la variable no sea imposible
                System.out.println("Calificación inválida. Intente nuevamente:");
                calificaciones[i] = sc.nextInt();
            }
        }

        // Mostrar calificaciones
        for (int cal : calificaciones) {
            System.out.println("Calificación: " + cal);
            suma += cal;
        }

        // Contar aprobados
        int j = 0;
        while (j < calificaciones.length) {
            if (calificaciones[j] > 70) {
                aprobados++;
            }
            j++; //agregamos incremento en el while para que no sea un bucle infinito
        }

        double promedio = suma / calificaciones.length;

        if (promedio >= 70)
            System.out.println("Grupo aprobado");
        else
            System.out.println("Grupo reprobado");

        System.out.println("Promedio: " + promedio);
        System.out.println("Aprobados: " + aprobados);
        
        sc.close(); //Cerramos recursos por mayor comodidad
    }
    
}
