/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arrays.pkgfor.each.pkg3.req.sem5.pkg2b;

import java.util.Scanner;

/**
 *
 * @author jasun
 */
public class ARRAYSFOREACH3REQSEM52B {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("BIENVENIDO A LA BIBLIOTECA DIGITAL");
        
        //Array con los libros
        String[] libros={"Habitos atomicos", "It(eso)", "El stand de los besos", "El principito", "Goodnight, PUNPUN", "El libro troll", "Literatura femenina"};
        
        //Lista de los libros disponibles
        System.out.println("Libros disponibles:");
        int numero = 1;
        for (String libro : libros) {
            System.out.println(numero + ". " + libro);
            numero++;
        }
        
         // Elegir el libro
        System.out.print("Ingresa el numero del libro que quieres: ");
        int eleccion = sc.nextInt();
        
        // Verificacion que el numero sea valido
        if (eleccion >= 1 && eleccion <= libros.length) {
            System.out.println("Elegiste: " + libros[eleccion - 1]);
        } else {
            System.out.println("Numero invalido.");
        }
    }
    
}
