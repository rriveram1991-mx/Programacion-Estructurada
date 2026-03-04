/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemplo.pkg1.array;

/**
 *
 * @author LABTICS
 */
public class EJEMPLO1ARRAY {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       // Declaramos e inicializamos un arreglo de tipo entero
       // El arreglo contiene 5 números
        int[] numeros = {10, 20 , 30, 40, 50};
        /* 
        Ciclo for para recorrer el arreglo
        La variable i empieza en 1 (no en 0)
        El ciclo se ejecuta mientras i sea menor que la longitud del arreglo
        */
        for(int i= 1; i < numeros.length; i++){
              /*
            Imprime la posición actual y el valor almacenado en esa posición
            numeros[i] obtiene el número que está en la posición i
            */
        System.out.println("Posicion "+i+":"+numeros[i]);
    }
    }
}
    

