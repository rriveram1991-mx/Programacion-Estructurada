/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemplo2array;

/**
 *
 * @author LABTICS
 */
public class Ejemplo2Array {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Declaramos e inicializamos un arreglo de tipo entero
        // El arreglo contiene 5 números impares
        int[] numeros = {1,3,5,7,9};
        /* Declaramos una variable llamada suma
        Esta variable almacenará el resultado de la suma total
        Se inicializa en 0 porque aún no hemos sumado nada
        */
        int suma = 0;
        /* Ciclo for que recorrerá el arreglo desde la posición 0
        hasta la última posición de numeros que tiene 5 valores
        */
        for(int i = 0; i < numeros.length; i++){
            /*
            En cada vuelta del ciclo:
            numeros[i] obtiene el valor que está en la posición actual del arreglo
            suma += numeros[i] es equivalente a:
            suma = suma + numeros[i]
            Esto va acumulando cada número dentro de la variable suma
            */
            suma += numeros[i]; //Suma el valor que este en la posicion i del arreglo numeros y lo guardaa en la variable suma
        }
        // Al finalizar el ciclo, mostramos el resultado total acumulado
        System.out.println("La suma total es: "+suma);
    }
    
}
