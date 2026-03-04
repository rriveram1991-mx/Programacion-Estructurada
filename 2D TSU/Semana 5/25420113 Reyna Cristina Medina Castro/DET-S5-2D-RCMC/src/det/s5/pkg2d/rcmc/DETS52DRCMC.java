/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package det.s5.pkg2d.rcmc;

import java.util.Scanner;

/**
 *
 * @author STAR KRIS
 */
public class DETS52DRCMC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //RREYNA CRISTINA MEDINA CASTRO
        Scanner sc = new Scanner(System.in);

        int[] calificaciones = new int[4];
        int suma = 0;
        int aprobados = 0;

        // Captura de datos
        //COMENZAR CON EL ARRAY EN 0
        //cambiar el <= por el <
        for (int i = 0; i < calificaciones.length; i++) {

            System.out.println("Ingrese calificación " + i + ": ");
            calificaciones[i] = sc.nextInt();
  //CAMBIE EL Y POR EL O
            while (calificaciones[i] < 0 || calificaciones[i] > 100) {
                System.out.println("Calificación inválida. Intente nuevamente:");
                calificaciones[i] = sc.nextInt();
            }
        }

        // Mostrar calificaciones
        for (int cal : calificaciones) {
            System.out.println("Calificación: " + cal);
            //MOSTRAR LA SUMA
            suma += cal;
            //no estaba mostrando la suma
            System.out.println("la suma es de "+suma);
            
        }

        // Contar aprobados
        int j = 0;
        //EL CICLO ERA INIFINITO, YA LO CAMBIE
        while (j < calificaciones.length) {
            if (calificaciones[j] > 70) {
                aprobados++;
            }
            //para q la j incremente y no se quede atascado
            j++;
        }
//poner double para los decimalres
        double promedio = (double)suma / calificaciones.length;

        if (promedio >= 70)
            System.out.println("Grupo aprobado");
        else
            System.out.println("Grupo reprobado");

        System.out.println("Promedio: " + promedio);
        System.out.println("Aprobados: " + aprobados);
    }
}
    
