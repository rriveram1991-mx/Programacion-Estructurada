/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package promcalifsdet.sem5.pkg2b.java;

import java.util.Scanner;

/**
 *
 * @author juanc
 */
public class PromcalifsDETSEM52BJAVA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] calificaciones = new int[5]; 

        int suma = 0;
        int aprobados = 0;
        
        // Antes empezaba en 1 y usaba <=
        // Eso provocaba error de índice.
        // Ahora empieza en 0 y usa < length.
        for (int i = 0; i < calificaciones.length; i++) {

            System.out.print("Ingrese calificación " + (i + 1) + ": ");
            calificaciones[i] = sc.nextInt();

            // Antes usaba && (imposible que sea menor que 0 y mayor que 100 al mismo tiempo)
            // Se cambió por || para validar correctamente fuera de rango
            while (calificaciones[i] < 0 || calificaciones[i] > 100) {
                System.out.print("Calificación inválida. Intente nuevamente: ");
                calificaciones[i] = sc.nextInt();
            }
        }

        // Antes decía suma = cal; (sobrescribía la suma)
        // Ahora usa suma += cal; para acumular correctamente
        for (int cal : calificaciones) {
            System.out.println("Calificación: " + cal);
            suma += cal;

            // Se cambió > 70 por >= 70 según el requerimiento
            if (cal >= 70) {
                aprobados++;
            }
        }

        // Antes era división entre enteros (perdía decimales)
        // Se convirtió suma a double para obtener promedio correcto
        double promedio = (double) suma / calificaciones.length;

        // Resultado final
        if (promedio >= 70)
            System.out.println("Grupo aprobado");
        else
            System.out.println("Grupo reprobado");

        System.out.println("Promedio: " + promedio);
        System.out.println("Aprobados: " + aprobados);

        sc.close();
    }
    }


    
    

