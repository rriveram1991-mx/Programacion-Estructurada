/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sisev.pkg24022026;

import java.util.Scanner;

/**
 *
 * @author Memer
 */
public class SISEV24022026 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);

        int opcion = 0;
        double total = 0;
        int contador = 0;//5# ERROR DE LOGICA, AL PONERLO EN 1, EL CONTADOR EMPEZABA UNO DESPUES DEL 
        double promedio = 0;//10# ERROR LOGICO, POR ENDE, NECESITAMOS UNA VARIABLE EN EL INCIO DEL MAIN

        System.out.println("=== SISTEMA DE EVALUACION ===");

        while (opcion != 4) {

            System.out.println("1. Capturar calificaciones");
            System.out.println("2. Mostrar promedio");
            System.out.println("3. Mostrar nivel");
            System.out.println("4. Salir");

            System.out.print("Seleccione opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    total = 0;
                    contador = 0; //7# ERROR LOGICO, EL USUARIO PUEDE PONER MAS CALIFICACIONES Y PUEDE SER QUE SE ACUMULEN
                    
                    for (int i = 1; i <= 5; i++) { //1# ERROR DE COMPILACION, PUNTO Y COMA, LO QUE PROVOCA QUE EL FOR NO EJECUTE NADA DE CODIGO
                        System.out.print("Ingrese calificacion " + i + ": ");
                        double cal = sc.nextDouble(); //#6 ERROR DE LOGICA, INT, PUEDE QUE LA CALIFICACION NO SEA ENTERA, Y SE TENGA QUE USAR DECIMALES PARA PONER CIERTAS CALIFICACIONES

                        if (cal >= 0 && cal <= 10){ //2# MALA PRACTICA, IF SIN LLAVEZ, HACE QUE EL CODIGO SEA MUY CONFUSO
                            total = total + cal;
                            contador++;
                        }
                        else{
                            System.out.println("Calificacion invalida");
                        }
                    }
                    break;

                case 2:
                    if (contador > 0) { //8# tanto en el case 2 y 3 tienen la posibilidad de tener una posible division en 0, haciendo que pueda provocar un error aritmetico
                        promedio = total / contador;
                        System.out.println("Promedio: " + promedio);
                    }
                    else{
                        System.out.println("No hay calificaciones capturadas");
                    }
                    
                    break;

                case 3:
                    
                    if (contador > 0) {
                        promedio = total/contador; //9# MALA PRACTICA esta en los if elseif estaba calculado constantemente el promedio, cuando solo se podria usar una variable para calcularla.
                        if (promedio >= 9){//3#MALA PRACTICA, IF SIN LLAVEZ, HACE MAS DIFICIL DE LEER EL CODIGO
                            System.out.println("Excelente");
                        }
                        else if (promedio >= 8){ //4#ERROR DE LOGICA, UN PUNTO Y COMA ANTES DE CERRAR COMPLETO EL IF, CON ESTO SOLO EL PRIMERO Y EL SEGUDO IF VA HA HACER QUE SE EJECUTE
                            System.out.println("Bueno");
                        }
                        else if (promedio >= 7){
                            System.out.println("Regular");
                        }
                        else{
                            System.out.println("Reprobado");
                        }
                    }
                    else{
                        System.out.println("No hay calificaciones capturadas");
                    }
                    
                    break;

                case 4:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opcion incorrecta");
            }

        }

        sc.close();
    }
    
}
