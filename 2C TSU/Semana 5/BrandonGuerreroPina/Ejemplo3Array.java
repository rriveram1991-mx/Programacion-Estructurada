/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemplo3array;

import java.util.Scanner;

/**
 *
 * @author LABTICS
 */
public class Ejemplo3Array {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
          Scanner leer = new Scanner (System.in);
// Declaramos una variable contador que nos ayudará a recorrer el arreglo
// Se inicializa en 0 porque los arreglos comienzan en la posición 0
          int contador = 0;
// Declaramos un arreglo de tipo String con espacio para 8 alumnos
// Cada posición almacenará el nombre de un alumno
          String[] alumnos = new String [8];//8 Alumnos
          System.out.println("Numero de lista del Salon 2 C");
          System.out.println("Ingrese el nombre de los alumnos para guardarlos (1-8)");
          
// Ciclo while que se ejecuta mientras el contador sea menor
// que el tamaño del arreglo (8 posiciones)         
          while (contador < alumnos.length){
              /*
              Mostramos el número de alumno que se está registrando
              Se usa (contador + 1) porque el arreglo empieza en 0
              pero al usuario le mostramos desde 1
              */
              System.out.println((contador + 1));
               // Guardamos el nombre ingresado por el usuario
               // en la posición actual del arreglo
              alumnos[contador] = leer.nextLine();
              contador++;
          }
          // Una vez lleno el arreglo, mostramos la lista completa
          System.out.println("Lista de alumnos:");
// Ciclo for para recorrer nuevamente el arreglo
// imprimir todos los nombres almacenados
          for (int i = 0; i<alumnos.length; i++){
              // Mostramos el número de lista (i+1)
             // seguido del nombre guardado en esa posición
              System.out.println((i+1) +", "+alumnos[i]);
          }
    }
    }
    

