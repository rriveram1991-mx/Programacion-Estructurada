 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package errorarray3;
import java.util.Scanner;
/**
 *
 * @author leidy
 */
public class Errorarray3 {

    /**Permitir capturar 5 calificaciones.
Validar que cada calificación esté entre 0 y 100.
Mostrar todas las calificaciones ingresadas.
Calcular el promedio.
Mostrar cuántos alumnos aprobaron (>= 70).

     * 
     */
  

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] calificaciones = new int[5];
        int suma = 0;
        int aprobados = 0;

        // Captura de datos
        for (int i = 0; i < calificaciones.length; i++) { // se pone solo menor por q si no seguira repitiendose  y se inicializa desde 0 

            System.out.println("Ingrese calificación " + i + ": ");
            calificaciones[i] = sc.nextInt();

            while (calificaciones[i] < 0 || calificaciones[i] > 100) {//s epone "||" para que tome cualquiera de los 2 valores (-)||(+)
                System.out.println("Calificación inválida. Intente nuevamente:");
                calificaciones[i] = sc.nextInt();
            }
        }

        // Mostrar calificaciones
        for (int cal : calificaciones) {
            System.out.println("Calificación: " + cal);
            suma += cal;// para que se vya acumulando los valores ingresados
        }
                double promedio = suma / calificaciones.length;

        if (promedio >= 70){
            System.out.println("Grupo aprobado");
           System.out.println("Promedio: " + promedio);//cambio esto para el verdadero en vez de q ste en else
        int j = 0;
       
        while (j < calificaciones.length) {
            if (calificaciones[j] > 70) {//cambiuo esto igual para que tenga una secuencia 
          aprobados++;
            }
              j++;//agrego un comtador que los vaya sumando para q j tope y el ciclo no se atasque 
        }

           System.out.println("Aprobados: " + aprobados);}//separo esto para que quede despues de que cuento los aprobados
        
        else{
            System.out.println("Grupo reprobado");
        }
    }
}

    
    

