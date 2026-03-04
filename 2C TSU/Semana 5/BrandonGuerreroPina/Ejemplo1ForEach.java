/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemplo1foreach;

/**
 *
 * @author UTT
 */
public class Ejemplo1ForEach {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
// Declaramos e inicializamos un arreglo de tipo entero
// Este arreglo contiene varios números
        int [] numeros = {10, 45, 49, 99, 120, 12, 88};
        /*
        Declaramos una variable contador
        Esta variable almacenará cuántos números son mayores a 50
        Se inicializa en 0 porque aún no hemos contado ninguno
        */
        int contadorMayores = 0;
        // Utilizamos un ciclo for each para recorrer todos los elementos del arreglo
        // La variable "numero" tomará el valor de cada elemento del arreglo uno por uno
        for(int numero: numeros){
             // Verificamos si el número elegido es mayor a 50
            if (numero > 50){
                // Si la condición se cumple:
                // Mostramos el número que es mayor a 50
                System.out.println(numero);
                // Aumentamos el contador en 1
                // Esto nos permite llevar el conteo de cuántos cumplen la condición
                contadorMayores++;
            }
        }
// Después de recorrer todo el arreglo
// mostramos cuántos números fueron mayores a 50
        System.out.println("Valores de los numeros mayores a 50 son: "+ contadorMayores);
    }
    
}
