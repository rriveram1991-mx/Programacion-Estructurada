/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package det.pkg1.sem5.ezco;

import java.util.Scanner;

/**
 *
 * @author Zoé
 */
public class DET1SEM5EZCO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         Scanner sc = new Scanner(System.in);

        int[] calificaciones = new int[5];
        int suma = 0;
        int aprobados = 0;

        // Captura de datos
        for (int i = 0; i < calificaciones.length; i++) {//se quito el <= ya que tuene que ser  <
            System.out.println("Ingrese calificación " + i + ": ");
            calificaciones[i] = sc.nextInt();
            while (calificaciones[i] < 0 || calificaciones[i] > 100) {//estaba mal && ya que tenia que ser ||
                System.out.println("Calificación inválida. Intente nuevamente:");
                calificaciones[i] = sc.nextInt();
            }
        }
        // Mostrar calificaciones
        for (int cal : calificaciones) {//empezaba de 1 cuando para los arreglos empieza dde 0
            System.out.println("Calificación: " + cal);
            suma = suma+ cal;//no estaba sumando ya que solo estaba reemplazando el valor
        }
        // Contar aprobados
        int j = 0;
        while (j < calificaciones.length) {
            if (calificaciones[j] >= 70) {//en vez de > lo cambie a >=
                aprobados++;
            }
            j=j+1;
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