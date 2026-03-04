/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import java.util.Scanner; 
// Importa la clase Scanner para poder leer datos desde el teclado

public class DETSEM5_2CArray2 {

    public static void main(String[] args) {

        Scanner Leer = new Scanner(System.in); 
        // Crea el objeto Scanner para capturar la entrada del usuario

        double[] numeros = new double[10]; 
        // Declara un arreglo de tipo double con espacio para 10 numeros

        // ------------------------------
        // LLENAR EL ARREGLO CON VALIDACION
        // ------------------------------

        for(int i = 0; i < numeros.length; i++){
        // Ciclo que se repite 10 veces (desde 0 hasta 9)

            while(true){
            // Se repite hasta que el usuario ingrese un numero valido

                try{
                    System.out.println("Ingrese el Numero " + (i+1) + " :");
                    // Pide al usuario el numero correspondiente

                    numeros[i] = Leer.nextDouble();
                    // Guarda el numero en la posicion i del arreglo

                    break; 
                    // Si no hubo error, sale del while

                }
                catch(Exception e){
                    // Si el usuario escribe algo que no es numero

                    System.out.println("Solo se permiten numeros");
                    // Muestra mensaje de error

                    Leer.next(); 
                    // Limpia el dato incorrecto del buffer
                }
            }
        }

        int opcion = 0; 
        // Variable para guardar la opcion del menu

        // ------------------------------
        // MENU CON VALIDACION
        // ------------------------------

        while(true){
        // Se repite hasta que el usuario elija una opcion valida

            try{
                System.out.println("\n//MENU//");
                System.out.println("1.- Saber cual numero es el mayor");
                System.out.println("2.- Saber cual numero es el menor");
                System.out.println("3.- Mostrar mayor y menor");

                opcion = Leer.nextInt();
                // Lee la opcion seleccionada

                if(opcion >= 1 && opcion <= 3){
                    break; 
                    // Sale del ciclo si la opcion es valida
                } else {
                    System.out.println("Seleccione 1, 2 o 3 solamente");
                }

            }catch(Exception e){
                // Si el usuario escribe letras en el menu

                System.out.println("Solo se permiten numeros");
                Leer.next(); 
                // Limpia la entrada incorrecta
            }
        }

        double mayor = numeros[0]; 
        // Inicializa la variable mayor con el primer numero del arreglo

        double menor = numeros[0]; 
        // Inicializa la variable menor con el primer numero del arreglo

        // Recorre el arreglo desde la posicion 1
        for(int i = 1; i < numeros.length; i++){

            if(numeros[i] > mayor){
                mayor = numeros[i]; 
                // Si encuentra un numero mayor, actualiza la variable
            }

            if(numeros[i] < menor){
                menor = numeros[i]; 
                // Si encuentra un numero menor, actualiza la variable
            }
        }

        // ------------------------------
        // RESPUESTA SEGUN OPCION
        // ------------------------------

        if(opcion == 1){
            // Si eligio opcion 1
            System.out.println("El numero mayor es: " + mayor);
        }
        else if(opcion == 2){
            // Si eligio opcion 2
            System.out.println("El numero menor es: " + menor);
        }
        else{
            // Si eligio opcion 3
            System.out.println("El numero mayor es: " + mayor);
            System.out.println("El numero menor es: " + menor);
        }

        
    }
}