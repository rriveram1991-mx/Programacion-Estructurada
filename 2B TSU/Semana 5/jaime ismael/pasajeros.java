/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication66;
//Requerimientos del Sistema 2
//El sistema debe solicitar:

import java.util.Scanner;

//Número de pasajeros.
//Crear dos arrays:
//String[] nombres
//String[] destinos
//Captura:
//Usar for para capturar nombre y destino.
//Validar con while que el nombre no esté vacío.
//Si está vacío → mostrar error usando if.
//Procesamiento:
//Usar for-each para mostrar la lista completa de pasajeros.
//Contar cuántos pasajeros van a cada destino.
//Si el destino es "CDMX" → mostrar "Viaje largo".
//Si el destino es "Local" → mostrar "Viaje corto".
//Al final mostrar:
//Destino con más pasajeros.
//Total de pasajeros registrados.


public class JavaApplication66 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        
       int cant = 0;
        
        //solicitud de cantidad de paciente y en base a eso hacer el tamano de el arreglo
        System.out.println("dame el numero de pasajeros ");
        cant = leer.nextInt();
        
        String[] nombres = new String[cant];
        String[] destinos = new String[cant];
        
        for (int x = 0; x < nombres.length; x++) {

    while (true) {
//solicitud de nombres 
        System.out.println("Dame el nombre del pasajero " + (x + 1) + ": ");
        nombres[x] = leer.nextLine();
// en caso de estar vacio repite el ciclo de lo contrario rompe el wile 
        if (nombres[x].equals("")) {
            System.out.println("Error, intenta de nuevo.");
        } else {
            break;
        }

    }
 System.out.println("Dame el destino del pasajero: ");
            destinos[x] = leer.nextLine();
}
     //declaramos las variables que se usaran de contadores 
   int contadorCDMX = 0;
        int contadorLocal = 0;

        System.out.println("Lista de pasajeros:");
//variable que se usara como indice en el for each
        int x = 0;

        
        for (String nombre : nombres) {
//la variable recorre el arreglo de el nombre
            System.out.println("Pasajero: " + nombre);
            System.out.println("Destino: " + destinos[x]);
//contadores y mensajes 
            if (destinos[x].equals("CDMX")) {
                System.out.println("Viaje largo");
                contadorCDMX++;
            } 
            else if (destinos[x].equals("Local")) {
                System.out.println("Viaje corto");
                contadorLocal++;
            }

            System.out.println();
//la variable de indice para el destino la incrementamos para recorrer a la siguiente casilla
            x++;
        }
// imprime resumen 
        System.out.println("Resumen del viaje:");
//comparacion 
        if (contadorCDMX > contadorLocal) {
            System.out.println("Destino con más pasajeros: CDMX");
        } 
        else if (contadorLocal > contadorCDMX) {
            System.out.println("Destino con más pasajeros: Local");
        } 
       

        System.out.println("Total de pasajeros registrados: " + cant);

    }

}         

        
    
    

