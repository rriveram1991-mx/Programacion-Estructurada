/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg5calificaciones;

import java.util.Scanner;

/**
 *
 * @author aguer
 */
public class Caligficaciones5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
     Scanner sc = new Scanner(System.in);

        int[] calificaciones = new int[5];
        int suma = 0;
        int aprobados = 0;

        // Captura de datos
        for (int i = 0; i <calificaciones.length ; i++) {// tiene que iniciar desde 0 y tiene que ser menor

            System.out.println("Ingrese calificación " + (i+1) + ": ");
            calificaciones[i] = sc.nextInt();

            while (calificaciones[i] < 0 || calificaciones[i] > 100) {// cambiamos el and por un or para que se pueda cumplir la condicion
                System.out.println("Calificación inválida. Intente nuevamente:");
                calificaciones[i] = sc.nextInt();
            }
        }

        // Mostrar calificaciones
        for (int cal : calificaciones) {
            System.out.println("Calificación: " + cal);
            suma += cal;// no estaba sumando
        }

        // Contar aprobados
        int j = 0;
        while (j < calificaciones.length) {
            if (calificaciones[j] >= 70) {// faltaba el igual ya que estan aprobados si es igual o mayor a 70
                aprobados++;
            }
            j++;// faltaba ir sumando si no, nunca se saldria del while
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
    
    
    

