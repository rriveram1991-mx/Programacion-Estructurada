import java.util.Scanner;
public class ProblemasArrays {

    public static void main(String[] args) {
    Scanner read = new Scanner(System.in);
    // problema 1: lectura de 5 numeros enteros y mostrar su suma
    int[] numeros = new int[5];
    for(int i=0; i<numeros.length; i++){
        // Recoleccion de los numeros
        System.out.print("Ingrese un numero entero: ");
        numeros[i] = read.nextInt();
    }
    // proceso de la
    int suma = 0;
    for(int numero : numeros){
        suma += numero;
    }
    System.out.println("La suma de los numeros es: " + suma);

    }
}