/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciosingricardo42;

/**
 *
 * @author yahir
 */
public class EjerciciosIngRicardo42 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int suma = 0;
        int[] edades = {19,18,18,18,22,22};
        for (int edad : edades) {
            System.out.println("La edad de tu amigo es: " +edad);
            suma = suma+edad;
            
            
        }
        System.out.println("La suma de las edades de tus amigos es: " + suma);
    }
    
}
