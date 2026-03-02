/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package array2req.sem5.pkg2b.java;

/**
 *
 * @author juanc
 */
public class ARRAY2REQSEM52BJAVA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Arreglo con nombres de estudiantes
        String[] nombres = {"Joshue", "Daniel", "Emiliandro", "Bucio"};

        int total = 0; // Contador de nombres

        // For-each para recorrer el arreglo
        for (String nombre : nombres) {
            System.out.println("Nombre: " + nombre);
            total++; // Cuenta cada nombre
        }

        // Muestra el total
        System.out.println("Total de estudiantes: " + total);
    }
}
    
  
