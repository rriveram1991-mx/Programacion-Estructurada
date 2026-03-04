/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import java.util.Random; 
// Importa la clase Random para generar numeros aleatorios

public class DETSEM5_2CForEach1 {

    public static void main(String[] args) {

        Random rand = new Random(); 
        // Crea el objeto Random para generar numeros al azar

        int[] lanzamientos = new int[20]; 
        // Arreglo para guardar 20 lanzamientos de dado

        // ------------------------------
        // GENERAR LOS 20 LANZAMIENTOS
        // ------------------------------

        for(int i = 0; i < lanzamientos.length; i++){
        // Recorre el arreglo completo

            lanzamientos[i] = rand.nextInt(6) + 1;
            // Genera un numero entre 1 y 6
            // nextInt(6) genera de 0 a 5
            // +1 ajusta el rango a 1-6
        }

        // ------------------------------
        // MOSTRAR LOS LANZAMIENTOS
        // ------------------------------

        System.out.println("Lanzamientos realizados:");
        // Mensaje para indicar que se mostraran los numeros generados

        for(int num : lanzamientos){
        // Recorre el arreglo usando for-each

            System.out.print(num + " ");
            // Imprime cada numero en la misma linea separado por espacio
        }

        System.out.println();
        // Salto de linea para que la salida quede ordenada

        int[] frecuencia = new int[6]; 
        // Arreglo para contar cuantas veces sale cada cara
        // Posicion 0 = cara 1
        // Posicion 1 = cara 2
        // ...
        // Posicion 5 = cara 6

        // ------------------------------
        // CONTAR FRECUENCIAS
        // ------------------------------

        for(int num : lanzamientos){
        // Recorre cada lanzamiento usando for-each

            frecuencia[num - 1]++;
            // Se resta 1 porque el arreglo empieza en 0
            // Si sale 6 → posicion 5
        }

        // ------------------------------
        // BUSCAR LA CARA QUE MAS SALIO
        // ------------------------------

        int mayorFrecuencia = frecuencia[0]; 
        // Se asume inicialmente que la cara 1 es la mayor

        int caraGanadora = 1; 
        // Guarda la cara que tiene mayor frecuencia

        int posicion = 1; 
        // Variable para saber que cara estamos evaluando

        for(int f : frecuencia){
        // Recorre el arreglo de frecuencias

            if(f > mayorFrecuencia){
            // Si encuentra una frecuencia mayor

                mayorFrecuencia = f; 
                // Actualiza la mayor frecuencia

                caraGanadora = posicion; 
                // Guarda la cara correspondiente
            }

            posicion++; 
            // Avanza a la siguiente cara
        }

        // ------------------------------
        // MOSTRAR RESULTADOS
        // ------------------------------

        System.out.println("La cara que mas salio fue: " + caraGanadora);
        System.out.println("Veces que salio: " + mayorFrecuencia);
    }
}