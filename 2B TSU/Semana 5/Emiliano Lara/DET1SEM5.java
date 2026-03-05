/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package det1.sem5;

import java.util.Scanner;

/**
 *
 * @author emili
 */
public class DET1SEM5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
        int[] calificaciones = new int[5];
        //SUMA TIENE QUE SER DOUBLE
        double suma = 0;
        int aprobados = 0;
        // Captura de datos
        //SE QUITA EL IGUAL Y SE PONE EL I +1 PARA QUE EMPIECE EN 1 Y NO EN 0
        for (int i = 0; i < calificaciones.length; i++) {
            System.out.println("Ingrese calificación " + (i+1) + ": ");
            calificaciones[i] = sc.nextInt();         
            //SE PONE UN OR EN VEZ DE &&
            while (calificaciones[i] < 0 || calificaciones[i] > 100) {
                System.out.println("Calificación inválida. Intente nuevamente:");
                calificaciones[i] = sc.nextInt();
            }
        }
        // Mostrar calificaciones
        for (int cal:calificaciones) {
            System.out.println("Calificación: " + cal);
            //se corrige el sumador
            suma = suma+cal;
        }
        // Contar aprobados
        int j = 0;
        while (j < calificaciones.length ) {
            //se agrega un igual
            if (calificaciones[j] >= 70) {
                aprobados++;}
            
                j++;
        }
        double promedio = suma / calificaciones.length;
        if (promedio >= 70)
            System.out.println("Grupo aprobado");
        else
            System.out.println("Grupo reprobado");
        System.out.println("Promedio: " + promedio);
        System.out.println("Aprobados: " + aprobados);
    }
    
}
