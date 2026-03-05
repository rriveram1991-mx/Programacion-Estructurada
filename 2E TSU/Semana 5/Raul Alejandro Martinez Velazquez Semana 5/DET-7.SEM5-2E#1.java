/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package det.pkg1.sem5;

/**
 *
 * @author pecha
 */
import java.util.Scanner;

public class SistemaCalificaciones {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] calificaciones = new int[5];
        int suma = 0;
        int aprobados = 0;

        // Captura de datos
        //Error al iniciar en 1, debe iniciar en 0
        for (int i = 0; i < calificaciones.length; i++) {

            System.out.println("Ingrese calificación " + (i + 1) + ": ");
            calificaciones[i] = sc.nextInt();
//Aqui hay error de validacion ya no puede haber un numero menor a 0 y mayor a 100 al mismo tiempo
            while (calificaciones[i] < 0 || calificaciones[i] > 100) {
                System.out.println("Calificación inválida. Intente nuevamente:");
                calificaciones[i] = sc.nextInt();
            }
        }

        // Mostrar calificaciones
        for (int cal : calificaciones) {
            System.out.println("Calificación: " + cal);
            //error en la suma al poner == 
            suma += cal;
        }

        // Contar aprobados
        int j = 0;
        while (j < calificaciones.length) {
            //Error pequeño en la condicion de aprobar 
            if (calificaciones[j] >= 70) {
                aprobados++;
            }
            //J nunca se incremente se queda en 0
            j++;
        }
//Aqui hay un error ya que debemos cambiar la variable a double porque si no haria division entera
        double promedio = (double) suma / calificaciones.length;

        if (promedio >= 70)
            System.out.println("Grupo aprobado");
        else
            System.out.println("Grupo reprobado");

        System.out.println("Promedio: " + promedio);
        System.out.println("Aprobados: " + aprobados);
    }
}

