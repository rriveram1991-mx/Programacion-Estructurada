/* Luis Manuel Aguilera Montoya

El sistema debe:
Permitir capturar 5 calificaciones.
Validar que cada calificación esté entre 0 y 100.
Mostrar todas las calificaciones ingresadas.
Calcular el promedio.
Mostrar cuántos alumnos aprobaron (>= 70).
*/

import java.util.Scanner;

public class DET_SEM5_2C 
{
    public static void main(String[] args)
    {
        //Declarar variables
        Scanner entrada = new Scanner(System.in);
        double calificaciones[] = new double[5]; //Declarar array, el "5" nos dice el tamaño del arreglo
        double promedio = 0, suma = 0;
        int aprobados = 0;

        System.out.println("----- SISTEMA DE CALIFICACIONES ------");
        System.out.println("Ingrese 5 calificaciones: ");

        //Ciclo for para agregarle las calificaciones al arreglo
        for (int i = 0; i < calificaciones.length;) //Elimine el i++ de dentro de la condición del for para que solo aumente cuanto el dato ingresado sea correcto 
        {
            double cal = entrada.nextDouble();      //La calificacion la guarde primero en una variable para que pueda comparar en el if si es correcta o no
            if (cal >= 0 && cal <= 100)             //Si "cal" cumple con las condiciones se agrega al arreglo
            {
            calificaciones[i] = cal;
            suma += calificaciones[i];
            i++;                            
            }
            else                                    //Si "cal" no cumple con las condiciones se manda un mensaje y no cuenta para el arreglo
            {
                System.out.println("Calificación inválida. Ingrese de nuevo...");
            }
        }

        //Mostrar calificaciones y contar aprobados
        for (double c : calificaciones)        //ForEach: Se repite segun el tamaño del arreglo, y "c" son los valores de cada posición del arreglo
        {
            System.out.println("Calificación: " + c);
            if (c >= 70) aprobados += 1;       //Si el valor de "c" es igual o mayor a 70 el num de aprobados aumenta, en cada ciclo verifica un valor diferente (segun el valor de la posicion)
        }

        promedio = suma / calificaciones.length;    //prom = suma/(tamaño del arreglo de calificaciones | 5)
 
        System.out.println("\nPromedio: " + promedio);
        System.out.println("Alumnos aprobados: " + aprobados);
    }
}
