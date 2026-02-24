/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package deteccionpro;

import java.util.Scanner;

/**
 *
 * @author jasun
 */
public class Deteccionpro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        Scanner sc = new Scanner(System.in);

        int opcion = 0;
        double total = 0;           // se cambio a double el total
        int cantidad = 0;
        boolean salir = false;
        int aprobados = 0;          //Se definieron los aprobados y reprobados desde el inicio
        int reprobados = 0;

        System.out.println("=== SISTEMA DE CONTROL DE NOTAS ===");

        while (salir == false) {        //ERROR LOGICO, faltaba un =

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

                    for (int i = 1; i <= n; i++) {      //Estaria mejor que i iniciara en 1

                        System.out.print("Ingrese nota #" + i + ": ");
                        int nota = sc.nextInt();

                        if (nota >= 0 && nota <= 10) {  //ERROR LOGICO faltaban {} en el if y en el else
                            total += nota;
                            cantidad++;
                            if (nota>=7){       //Se agrego un sumador/contador para los aprobados y reprobados
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
                    break;      //ERROR LOGICO, faltaba un break

                case 2:

                    if (cantidad>0){        //Se agrego un if por si se va al promedio sin tener datos
                    double promedio = total / cantidad;
                    System.out.println("Promedio: " + promedio);

                    if (promedio >= 9) {                       //Error logico, faltaban {} en todos los if y else
                        System.out.println("Excelente"); }
                    else if (promedio >= 8) {
                        System.out.println("Bueno"); }
                    else if (promedio >= 7) {       //Habia un ; innecesario
                        System.out.println("Regular"); }
                    else {
                        System.out.println("Reprobado"); }

                    } else {
                        System.out.println("No se han ingresado datos");
                    }
                    break;

                case 3:
                    //Se borro el while aqui, por que no era necesario
                    System.out.println("Aprobados: " + aprobados);
                    System.out.println("Reprobados: " + reprobados);
                    break;

                case 4:

                    total = 0;
                    cantidad = 0;
                    aprobados = 0;      //Se agrego el reinicio para los reprobados y aprobados
                    reprobados = 0;
                    System.out.println("Datos reiniciados");
                    break;      //faltaba un break

                case 5:

                    salir = true;
                    System.out.println("Saliendo del sistema");
                    break;
                    //faltaba un break
                
                default:
                    System.out.println("Opcion no valida");
            }

        }

        sc.close();
    }
}
