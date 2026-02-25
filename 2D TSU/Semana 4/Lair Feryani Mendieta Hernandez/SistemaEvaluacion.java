/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package s4.sisev;

import java.util.Scanner;

public class SistemaEvaluacion {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int opcion=0;
        int total = 0;
        int contador = 1;
        boolean salir=false;// creacion de boolean para arreglar erro de compilacion
        
        System.out.println("=== SISTEMA DE EVALUACION ===");
        
        while (!salir ) { // error de mala practica, crre una variable boolean para el while funcione de manera correcta
            
            System.out.println("1. Capturar calificaciones");
            System.out.println("2. Mostrar promedio");
            System.out.println("3. Mostrar nivel");
            System.out.println("4. Salir");
            
            System.out.print("Seleccione opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    for (int i = 1; i <= 5; i++){// elimine el ; pq el for lleva a error de compilacion
                        System.out.print("Ingrese calificacion "+ i + ": ");
                        int cal = sc.nextInt();

                        if (cal >= 0 && cal <= 10){//colocacion de llaves en el if y eso lo hace funcionar de mejor manera mala practica
                            total = total + cal;
                            contador++;
                        }else{//colocacion de llaves en el else mala practica
                            System.out.println("Calificacion invalida");
                        }    
                    }
                    break;

                case 2:
                    double promedio = (double) total / contador;// error logico, agregue el double para los decimales de lpromedio
                    System.out.println("Promedio: "+promedio);
                    break;

                case 3:
                    if (total / contador >= 9){// agregue llaves al if  mala practica
                        System.out.println("Excelente");
                    }else if (total / contador >= 8){//borre los ; pq el else if no los lleva mala practiva
                        System.out.println("Bueno");
                    }else if (total / contador >= 7){// coloque llaves
                        System.out.println("Regular");
                    }else{ // coloque un {} para terminar el codigo de manera correcta
                        System.out.println("Reprobado");
                    }
                    break;

                case 4:
                    salir = true;// coloque el booleano pq me cerraba el codigo error de compilacion
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opcion incorrecta");
            }

        }

        sc.close();
    }
}