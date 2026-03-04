/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemplo2foreach;

/**
 *
 * @author UTT
 */
public class Ejemplo2ForEach {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Declaramos e inicializamos un arreglo de tipo entero
        // El arreglo contiene varios números
        int[] numeros = {2, 10, 33, 54, 100, 12};
        System.out.println("Sistema para imprimir solo numeros pares");
        // Utilizamos un ciclo for each para recorrer todos los elementos del arreglo
        // La variable "numero" tomará el valor de cada elemento uno por uno
        for (int numero : numeros){
            // Verificamos si el número es par
            // El operador % (numero) obtiene el residuo de una división
            // Si numero % 2 == 0 significa que el número es divisible entre 2
            // y por lo tanto es un número par
            if (numero %2 == 0){
                // Si la condición se cumple, imprimimos el número
                System.out.println(numero);
            }
        }
    }
    
}
