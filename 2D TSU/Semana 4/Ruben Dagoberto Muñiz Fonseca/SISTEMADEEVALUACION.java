/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemadeevaluacion;

import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class SISTEMADEEVALUACION {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int opcion = 0;
        int total = 0;
        int contador = 1;
        boolean salir = false;// creacion de boolean para arreglar error de compilacion

        System.out.println("=== SISTEMA DE EVALUACION ===");

        while (!salir) { // Error o mala practica, agregue variable boolean para 
            //un funcionamento correcto el while 

            System.out.println("1. Capturar calificaciones");
            System.out.println("2. Mostrar promedio");
            System.out.println("3. Mostrar nivel");
            System.out.println("4. Salir");

            System.out.print("Seleccione opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    for (int i = 1; i <= 5; i++) {// elimine el ; pq el for lleva a error de compilacion
                        System.out.print("Ingrese calificacion " + i + ": ");
                        int cal = sc.nextInt();

                        if (cal >= 0 && cal <= 10) {//colocacion de llaves en el if y mala practica realizada
                            total = total + cal;
                            contador++;
                        } else {//colocacion de llaves en el else ,mala practida realizada
                            System.out.println("Calificacion invalida");
                        }
                    }
                    break;

                case 2:
                    double promedio = (double) total / contador;//Error de logica se agrego el double para decimales en promedio
                    System.out.println("Promedio: " + promedio);
                    break;

                case 3:
                    if (total / contador >= 9) {//Se agregaron llaves en el if ,se realizo una mala pr
                        System.out.println("Excelente");
                    } else if (total / contador >= 8) {//Se borraron los ; , el else if no los lleva , mala practica realizada 
                        System.out.println("Bueno");
                    } else if (total / contador >= 7) {//Colocacion de LLaves
                        System.out.println("Regular");
                    } else { // coloque un {} para terminar el codigo de manera correcta
                        System.out.println("Reprobado");
                    }
                    break;

                case 4:
                    salir = true;// Se coloco el boleano ya que cerraba el codigo presenaba error de compilacion
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opcion incorrecta");
            }

        }

        sc.close();
    }

}
