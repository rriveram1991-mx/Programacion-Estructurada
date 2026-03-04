/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sumatoria; 

import java.util.Scanner; // Importa la clase Scanner para leer datos

public class DETSEM5_2CArray1 {

    public static void main(String[] args) {

        Scanner Leer = new Scanner(System.in); 
        // Objeto para leer datos desde teclado

        int cantidad = 0; 
        // Variable para guardar cuantos numeros se van a sumar

        // Validar que la cantidad sea un numero entero positivo
        while(true){
            try{
                System.out.println("Cuantos numeros quiere sumar?");
                cantidad = Leer.nextInt();

                if(cantidad > 0){
                    break; // Sale del ciclo si es valido
                } else {
                    System.out.println("Debe ser mayor que 0");
                }

            }catch(Exception e){
                System.out.println("Solo se permiten numeros enteros");
                Leer.next(); // Limpia el dato incorrecto
            }
        }

        double[] sumatoria = new double[cantidad]; 
        // Se crea el arreglo con el tamaño indicado por el usuario

        int rep = 0; 
        // Contador para recorrer el arreglo

        double sum = 0; 
        // Variable acumuladora para guardar la suma total

        // Ciclo para ingresar los numeros
        while(rep < cantidad){

            try{
                System.out.println("Ingrese el numero " + (rep+1) + " :");

                sumatoria[rep] = Leer.nextDouble(); 
                // Guarda el numero en el arreglo

                sum += sumatoria[rep]; 
                // Suma el numero al acumulador

                rep++; 
                // Avanza a la siguiente posicion

            }catch(Exception e){
                System.out.println("Solo se permiten numeros");
                Leer.next(); // Limpia el valor incorrecto
            }
        }

        // Muestra el resultado final con 2 decimales
        System.out.printf("La suma total es: %.2f", sum);

       
    }
}