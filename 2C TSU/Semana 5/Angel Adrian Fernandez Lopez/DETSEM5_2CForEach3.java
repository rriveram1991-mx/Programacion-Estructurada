/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import java.util.Scanner;

public class DETSEM5_2CForEach3{

    public static void main(String[] args) {

        Scanner Leer = new Scanner(System.in);
        // Crea el objeto Scanner

        double[] calificaciones = new double[7];
        // Arreglo para guardar 7 calificaciones

        int i = 0;
        // Controlador de posicion

        // ------------------------------
        // LLENAR ARREGLO CON VALIDACION
        // ------------------------------

        while(i < calificaciones.length){

            try{
                System.out.println("Ingrese su calificacion Numero " + (i+1) + " :");

                double nota = Leer.nextDouble();

                if(nota >= 0 && nota <= 10){

                    calificaciones[i] = nota;
                    // Guarda la calificacion

                    i++;
                    // Avanza posicion
                }
                else{
                    System.out.println("Fuera del rango (0-10)");
                }

            }catch(Exception e){
                System.out.println("Solo se permiten numeros");
                Leer.next();
            }
        }

        // ------------------------------
        // CALCULAR PROMEDIO CON FOR-EACH
        // ------------------------------

        double suma = 0;

        for(double c : calificaciones){
            // Recorre cada valor del arreglo directamente

            suma += c;
            // Suma cada calificacion
        }

        double prom = suma / calificaciones.length;
        // Calcula promedio

        // ------------------------------
        // RESULTADO
        // ------------------------------

        if(prom >= 7){
            System.out.println("Pasaste...Felicidades =)");
        }
        else{
            System.out.println("No pasaste...ve sacando ficha en el Tec laguna =(");
        }

        System.out.printf("El promedio es: %.2f", prom);

       
    }
}