/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package semana_4;

/**
 *
 * @author Ernesto Montalvo
 */
import java.util.Scanner;

public class SistemaEvaluacion {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int opcion = 0;
        int total = 0;
        int contador = 0;
        //Tiene que iniciar en 0 porque no contaria nada
float promedio;
//declarar la variable promedio como float
        System.out.println("=== SISTEMA DE EVALUACION ===");

        while (opcion != 4) {

            System.out.println("1. Capturar calificaciones");
            System.out.println("2. Mostrar promedio");
            System.out.println("3. Mostrar nivel");
            System.out.println("4. Salir");

            System.out.print("Seleccione opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {

                case 1 ->
                    //se cambio ":" por "->"
                {
                    for (int i = 1; i <= 5; i++) {
                        //eliminacion de ";" de linea 41 al terminar la instruccion
                        System.out.print("Ingrese nota #" + i + ": ");
                        int cal = sc.nextInt();

                        if (cal >= 0 && cal <= 10){
                            //asignacion de llaves
                            total = total + cal;
                            contador++;
                        }else{
                            System.out.println("Calificacion invalida");
                        }
                        //asignacion de llave
                    }
                }

                case 2 -> {
                    promedio =(float) total / contador;
                    //asignacion de variable float
                    System.out.println("Promedio: " + promedio);
                }

                case 3 -> {
                    if(contador==0){
                        System.out.println("No hay ninguna calificacion");
                        break;
                    }
                    /*se puso el if de contador para por si se selecciona la opcion 2 o 3, 
                    no truene el programa
                    */
                    promedio =(float) total / contador;
                    //asignacion de variable
                    //volver a poner el promedio la formula para leer la operacion
                    if (promedio >= 9){
                        //Asigancion de llave
                        System.out.println("Excelente");
                    }else if (promedio >= 8){
                        //correccion de ";" y asignacion de llave
                        System.out.println("Bueno");
                    }else if (promedio >= 7){
                        //asignacion de llave
                        System.out.println("Regular");
                    }else{
                        //asignacion de llave
                        System.out.println("Reprobado");
                    }
                }
                case 4 -> System.out.println("Saliendo...");
                
                default -> System.out.println("Opcion incorrecta");
            }
        }
        sc.close();
    }
}
/*
No habria corrido de manera correcta el programa si no se hubieran puesto las llaves 
del if-else del caso 3
De igual manera se agrego un if else sobre si el contador era equivalente a 0
para que pudiera asignar las calificaciones
La variable de contador inicia desde 1 para poder contar desde el principio 1,2,3...
*/