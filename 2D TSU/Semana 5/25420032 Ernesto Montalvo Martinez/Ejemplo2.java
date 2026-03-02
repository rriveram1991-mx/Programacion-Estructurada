/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arreglo_for_each;


/**
 *
 * @author Ernesto Montalvo
 */
public class Ejemplo2 {
    public static void main(String[] args) {

        String[] nombres = {"Andy", "Luis", "Carlos", "Marcos"};

        // Mostrar los nombres en orden alfabético
        System.out.println("Nombres en orden alfabético:");
        for (String nombre : nombres) {
            System.out.println(nombre);
        }

        // Contar cuántos nombres hay
        int cantidad = nombres.length;
        System.out.println("Cantidad de nombres: " + cantidad);
    }
}

