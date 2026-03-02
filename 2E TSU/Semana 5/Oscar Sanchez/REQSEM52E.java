/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package req.sem5.pkg2e.java;

/**
 *
 * @author Oscar Sanchez
 */
public class REQSEM52EJAVA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] nombres = {"alejandrito", "jose", "Carlitso"}; // Arreglo con nombres (cadenas de texto)

        // El for-each dice: "Toma cada 'nombre' del arreglo 'nombres' uno por uno"
        for (String nombre : nombres) {
            // Imprimimos un saludo uniendo el texto con la variable temporal
            System.out.println("¡Hola, " + nombre + ", bienvenido al curso!"); 
        }
    }
}
