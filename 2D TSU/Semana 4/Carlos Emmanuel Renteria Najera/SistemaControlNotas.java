/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemacontrolnotas;

import java.util.Scanner;

/**
 *
 * @author Memer
 */
public class SistemaControlNotas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int opcion; //13# error de logica?
        int total = 0;
        int cantidad = 0;
        boolean salir = false; //1#error de logica, el codigo no se va ejecutar por mucho que lo intentes

        System.out.println("=== SISTEMA DE CONTROL DE NOTAS ===");

        while (salir == false) { //por que solo lo esta 

            System.out.println("\n1. Capturar notas"); //
            System.out.println("2. Mostrar promedio");
            System.out.println("3. Mostrar estadisticas");
            System.out.println("4. Reiniciar datos");
            System.out.println("5. Salir");

            System.out.print("Seleccione opcion: ");
            opcion = sc.nextInt();
            sc.nextLine(); //16# no se donde categorizarla, pero solo para que limpe el buffer, que avece hace que pone dos veces el enter :p

            switch (opcion) {

                case 1: {

                    System.out.print("Cuantas notas desea capturar: ");
                    int n = sc.nextInt();

                    for (int i = 1; i <= n; i++) { //8# error de logica, si te piden 2 califiaciones, va a caputar 3, ya que la I esta inicializada en 0, solo cambiadolo a 1 deberia funcionar

                        System.out.print("Ingrese nota #" + i + ": ");
                        int nota = sc.nextInt();
                       
                        if (nota >= 0 && nota <= 10){ //2# error de compilacion y 3#de mala practica, siendo que no tenias llaves
                            total += nota;
                            cantidad++;
                            }//y tenia un ; antes del if siento que deja afuera el else.
                        else{
                            System.out.println("Nota invalida");
                        }

                       
                    }
                     
                        break;//4# error de compilacion, no habia break que pudiera cerrar el case, haciendo que se ejecute todo el codigo antes de llegar a un break
                    } 
                
                case 2: { //5#error de compilacion antes del case 2, le faltaba una llave que cerraba el case 1
                    
                    if (cantidad == 0) { //14# error de compilacion, al hacer una division en 0, iba hacer un error aritmetico, entonces, como parche hice esto para que diga eso en vez de hace toda la operacion
                        System.out.println("No hay notas caputradas.");
                    }else{
                        
                    double promedio = total / cantidad;
                    System.out.println("Promedio: " + promedio);

                    if (promedio >= 9){ //6# error de compilacion y 7# mala practica, mismo caso, habia un else if; con un punto y coma antes del else
                        System.out.println("Excelente");// son decir, que es mala practica por que no tiene llavez
                    }else if (promedio >= 8){
                        System.out.println("Bueno");
                    }else if (promedio >= 7) {
                        System.out.println("Regular");
                    }else{
                        System.out.println("Reprobado");
                    }
                        
                    }
                    break;
                    }
                    
                    
                case 3:{

                    int aprobados = 0;
                    int reprobados = 0;

                    int i = 0;
                    
                    if (cantidad == 0) { //15#error de compilacion, mismo caso que con el case 2
                        System.out.println("No hay notas caputradas.");
                    }
                    else{
                        while (i <= cantidad) { //9# error compilacion, un punto y coma antes de las llavez, haciendo que solo ese ejecutara ese codigo
                            if (total / cantidad >= 7){ //16# mala practica, if sin llavez
                            aprobados++;
                            }else{
                            reprobados++;
                            i++;
                            }
                    }

                    System.out.println("Aprobados: " + aprobados);
                    System.out.println("Reprobados: " + reprobados);
                    }
                    
                    
                    break;
                }
                case 4: {
                    
                    total = 0;
                    cantidad = 0;
                    System.out.println("Datos reiniciados");
                    break;//10# error de complilacion, faltaba un break para cerrar el caso
                }
                case 5:{

                    salir = true;
                    System.out.println("Saliendo del sistema");
                    break; //11# error de complilacion, faltaba un break para cerrar el caso
                }
                default:{
                    System.out.println("Opcion no valida");
                    break;//12# error de complilacion, faltaba un break para cerrar el caso
                }
            }

        }

        sc.close();
    }
    
}
