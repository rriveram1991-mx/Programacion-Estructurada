/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package deteccionpro;

import java.util.Scanner;

/**
 *
 * @author juanc
 */
public class Deteccionpro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int opcion = 0;
        // el total se cambio a double
        double total = 0;           
        int cantidad = 0;
        boolean salir = false;
        //Se definio los reprobados y aprobados desde el principio
        int aprobados = 0;          
        int reprobados = 0;

        System.out.println("=== SISTEMA DE CONTROL DE NOTAS ===");
         //Error logico, agregue un "="
        while (salir == false) {        

            System.out.println("\n1. Capturar notas");
            System.out.println("2. Mostrar promedio");
            System.out.println("3. Mostrar estadisticas");
            System.out.println("4. Reiniciar datos");
            System.out.println("5. Salir");

            System.out.print("Seleccione opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {

                case 1:

                    System.out.print("Cuantas notas desea capturar: ");
                    int n = sc.nextInt();
                   //cambiamos para que "i" iniciara en 1
                    for (int i = 1; i <= n; i++) {      

                        System.out.print("Ingrese nota #" + i + ": ");
                        int nota = sc.nextInt();
                     //error logico, faltaban "{}" en el if y en el else
                        if (nota >= 0 && nota <= 10) {  
                            total += nota;
                            cantidad++;
                            //esto es un contador para los aprobados y reprobados
                            if (nota>=7){      
                                aprobados++;
                            } 
                            else {
                                reprobados++;
                        }
                        }
                        else {
                            System.out.println("Nota invalida");
                        }
                    }
                    //error logico, faltaba un break
                    break;      

                case 2:
                //agregue un if por si se va al promedio sin tener respuestas
                    if (cantidad>0){       
                    double promedio = total / cantidad;
                    System.out.println("Promedio: " + promedio);
                    //error logico, faltaban "{}" en los if y else
                    if (promedio >= 9) {                       
                        System.out.println("Excelente"); }
                    else if (promedio >= 8) {
                        System.out.println("Bueno"); }
                    //quite un ";" innecesario
                    else if (promedio >= 7) {       
                        System.out.println("Regular"); }
                    else {
                        System.out.println("Reprobado"); }

                    } else {
                        System.out.println("No se han ingresado datos");
                    }
                    break;

                case 3:
                    //borre un while que no servia de nada
                    System.out.println("Aprobados: " + aprobados);
                    System.out.println("Reprobados: " + reprobados);
                    break;

                case 4:

                    total = 0;
                    cantidad = 0;
                    //agregue un reinicio para los reprobados y aprobados
                    aprobados = 0;      
                    reprobados = 0;
                    System.out.println("Datos reiniciados");
                    //agregue un break
                    break;      

                case 5:

                    salir = true;
                    System.out.println("Saliendo del sistema");
                    //agregue un break
                    break;
                    
                
                default:
                    System.out.println("Opcion no valida");
            }

        }

        sc.close();
    }
}
