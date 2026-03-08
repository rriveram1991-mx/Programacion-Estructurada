/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistema.de.calif;

import java.util.Scanner;

/**
 *
 * @author Lair ☆
 */
public class SistemaCalificaciones {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] calificaciones = new int[4];//le coloque 4 para que garre del 0 al 4 haciendo las 5 
        int suma = 0;
        int aprobados = 0;

        // Captura de datos
        for (int i = 0; i < calificaciones.length; i++) {//le doy el valor del 0 para que cuando vaya sumando se vaya agregando 1 y pongosolamente el <para arreglar la sintaxis de mala practica

            System.out.println("Ingrese calificación " + (i+1) + ": ");// le coloco el +i para que se vaya sumando
            calificaciones[i] = sc.nextInt();

            while (calificaciones[i] <0 || calificaciones[i] > 100) {// le coloco el || para que ingree si sucede uno u otro
                System.out.println("Calificación inválida. Intente nuevamente:");
                calificaciones[i] = sc.nextInt();
            }
        }

        // Mostrar calificaciones
        for (int calificacion : calificaciones) {
            System.out.println("Calificación: " + calificacion);
            suma += calificacion;
        }

        // Contar aprobados
        int j = 0;
        while (j < calificaciones.length) {
            if (calificaciones[j] >= 70) {//cambie el > por el >= asi dando algo mas acorde a lo pedido
                aprobados++;
            }
            j++;//lo agregue pq no avanzaba el codigo y agrregue para que siguiera con el codigo
        }

        double promedio = (double)suma / calificaciones.length; //agregue el double para los decimales

        if (promedio >= 70)
            System.out.println("Grupo aprobado");
        else
            System.out.println("Grupo reprobado");

        System.out.println("Promedio: " + promedio);
        System.out.println("Aprobados: " + aprobados);
    }
}


