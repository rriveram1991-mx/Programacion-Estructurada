/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication60;

/**
 *
 * @author Jaime Ismael
 */
public class JavaApplication60 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //por defecto ponemos numeros con decimal para calcular el promedio
        double[] notas = {8.5, 9.0, 7.5, 10.0, 8.0};
        double suma = 0;
//el for se detiene hasta que alcance la ultima casilla del arreglo
        for (int x = 0; x < notas.length; x++) {
            suma = suma + notas[x];//suma a la vez que recorre el arreglo
        }

        double promedio = suma / notas.length;
//imprime el promedio
        System.out.println("El promedio es: " + promedio);
        System.out.println("Programado por jaime ismael");
    }
    
}
