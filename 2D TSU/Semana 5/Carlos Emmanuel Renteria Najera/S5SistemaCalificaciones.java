/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package s5.sistemacalificaciones;

import java.util.Scanner;

/**
 *
 * @author Memer
 */
public class S5SistemaCalificaciones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] calificaciones = new int[5];
        int suma = 0;
        int aprobados = 0;

        // Captura de datos
        for (int i = 0; i < calificaciones.length; i++) { //1- agarraba un especio del Array que no existia cuando estaba en la calificacion 5, lo unico que hice fue cambiar la i de 1 a 0

            System.out.println("Ingrese calificación " + (i+1) + ": "); //2- con ello, el Array va estar a 0, por lo tanto seria confuso para el usuario, lo unico que hice fue que se sumara i + 1 para que estuviera correcto
            calificaciones[i] = sc.nextInt();

            if (calificaciones[i] < 0 || calificaciones[i] > 100) { //3- independiemente de lo que pongas la condicion esta mal, eso es por culpa del && (and), solo cambia a || (or)
                System.out.println("Calificación inválida. Intente nuevamente:");
                calificaciones[i] = sc.nextInt();
            }
        }

        // Mostrar calificaciones
        for (int cal : calificaciones) {
            System.out.println("Calificación: " + cal);
            suma += cal; //4- no se sumaba solo asignaba el ultimo valor de cal a Suma
        }
        
        //////////////////////////////////////////////////////////////////////////////////////

        // Contar aprobados
        for (int j : calificaciones) { //5- el error estaba en el while, ya que no hacia nada cuando intentaba ejecutarse, lo unico que hice fue cambiarlo a un for each
            if (j >= 70) { //6- no captaba todos los alumnos aprobados, ya que solo capturaba los alumnos que son arriba de 70, solo puse que sean igual o mayor a 70
                aprobados++;
            }
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
