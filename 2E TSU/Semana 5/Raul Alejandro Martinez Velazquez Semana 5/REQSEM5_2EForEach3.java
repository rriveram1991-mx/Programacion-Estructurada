/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package array3;
import java.util.Scanner;
/**
 *
 * @author pecha
 */
public class Array3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
   
        Scanner sc = new Scanner(System.in);
        int[ ] edades = {18, 19, 17, 20, 21};
        // TODO code application logic here
        int suma = 0;
        int max = edades[0];
        int min = edades[0];
        for (int i = 0; i < edades.length; i++) {
            suma += edades[i];

            if (edades[i] > max) {
                max = edades[i];
            }

            if (edades[i] < min) {
                min = edades[i];

}}
        System.out.println("Que operacion desea realizar?");
        System.out.println("1. Saber cual es la edad maxima");
        System.out.println("2. Saber cual es la edad minima");
        System.out.println("3. Promedio de edad");
        System.out.println("0. Salir");
        int opcion = sc.nextInt();
        switch (opcion){
            
            case 1 -> {System.out.println("La edad maxima es: " + max);
            }
            case 2 ->{ System.out.println("La edad minima es: " + min);
            }
            case 3 -> {
                double promedio = (double) suma / edades.length;
                System.out.println("El promedio de edad es: " + promedio);
            }

            case 0 -> { System.out.println("Saliendo...");
            }
            default -> System.out.println("Opcion no valida");
        }

        sc.close();
    }
}
