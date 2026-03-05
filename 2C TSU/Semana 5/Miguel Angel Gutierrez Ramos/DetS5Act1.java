/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dets5act1;
import java.util.Scanner;
/**
 *
 * @author miguelgu
 */
public class DetS5Act1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
            Scanner sc = new Scanner(System.in);

        int[] calificaciones = new int[5]; 
        double suma = 0; //Aqui hacemos que la suma sea double para al momento de sacar promedio en la division la haga en decimal.
        int aprobados = 0;

        // Captura de datos
        for (int i = 0; i < calificaciones.length; i++) //Error aqui por el hecho de que quiere llegar a 5 y el arreglo tiene menor tamaño.
        {

            System.out.println("Ingrese calificación " + (i+1) + ": "); //agregamos un + 1 para que se muestre desde el 1 y no desde 0.
            calificaciones[i] = sc.nextInt();

            while (calificaciones[i] < 0 || calificaciones[i] > 100) //Aqui hay un error ya que no es && debe ser un ||
            {
                System.out.println("Calificación inválida. Intente nuevamente:");
                calificaciones[i] = sc.nextInt();
            }
        }

        // Mostrar calificaciones
        for (int cal : calificaciones) {
            System.out.println("Calificación: " + cal);
            suma += cal; //Error aqui ya que si dejamos solo el = no se hace la suma y se van borrando los datos acumulados.
        }

        // Contar aprobados
        int j = 0;
        while (j < calificaciones.length) //Este es un while infinito ya que j se queda en 0 siempre, se arregla agregando j++
        {
            if (calificaciones[j] > 70) {
                aprobados++;
            }
            j++; //esto faltaba.
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
