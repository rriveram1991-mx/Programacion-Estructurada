/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemplo3foreach;

import java.util.Scanner;

/**
 *
 * @author UTT
 */
public class Ejemplo3ForEach {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        // Declaramos e inicializamos un arreglo de tipo String
        // Este arreglo contiene los nombres de los alumnos
        String [] alumnos = {"Samuel", "Roberto", "Carlos", "Claudia", "Andres"};
        // Variable booleana que nos ayudará a saber si el alumno fue encontrado
        // Se inicializa en false porque al inicio no sabemos si está en la lista
        boolean esta = false;
        // Pedimos al usuario que escriba el nombre que desea buscar
        System.out.println("Ingrese el nombre del alumno que desea buscar");
        // Guardamos el nombre que el usuario escribe
        String nombreBusqueda = leer.nextLine();
        // Utilizamos un ciclo for each para recorrer todos los nombres del arreglo
        // La variable "nombre" tomará cada valor del arreglo uno por uno
        for (String nombre : alumnos){
             // Comparamos el nombre actual del arreglo
             // con el nombre que el usuario escribió
            if (nombre.equals(nombreBusqueda)){
                 // Si son iguales, cambiamos la variable a true
                // Esto indica que el alumno sí existe en la lista
                esta = true;
            }
        }
        // Después de recorrer todo el arreglo,
        // verificamos si la variable cambió a true
        if (esta){
            System.out.println("El alumno si se encuentra en la lista");
        }
        else {
            System.out.println("El alumno no se encuentra en la lista");
        }
    }
    
}
