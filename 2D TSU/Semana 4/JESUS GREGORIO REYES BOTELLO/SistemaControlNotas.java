/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication65;

import java.util.Scanner;

/**
 *
 * @author jessr
 */
public class SistemaControlNotas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int[] notas = new int[100];
        int opcion = 0;
        int total = 0;
        int cantidad = 0;
        boolean salir = false;

        System.out.println("=== SISTEMA DE CONTROL DE NOTAS ===");
        //#2 Estaba utilizando un valor de asignacion en lugar de comparacion
        while (salir == false) {
            System.out.print("Seleccione opcion: ");
            System.out.println("\n1. Capturar notas");
            System.out.println("2. Mostrar promedio");
            System.out.println("3. Mostrar estadisticas");
            System.out.println("4. Reiniciar datos");
            System.out.println("5. Salir");

            opcion = sc.nextInt();

            switch (opcion) {

                case 1:

                    System.out.print("Cuantas notas desea capturar: ");
                    int n = sc.nextInt();
//#2 El for tiene un limite incorrecto, el original tiene i <= n pero es i < n
                    for (int i = 0; i < n; i++) {

                        System.out.print("Ingrese nota #" + i + ": ");
                        int nota = sc.nextInt();
//#3 Tenia un punto y coma al final de la condicion, ERROR LOGICO Y COMPILACION
                        if (nota >= 0 && nota <= 10){
                            notas[cantidad] = nota;
                            total += nota;
                            cantidad++;
                        }
//#4 Debido al ; anterior, este else queda sin if válido:
                         else{
                            System.out.println("Nota invalida");           
                    }
                    }
                    break;
//#5 falta break y ERROR LOGICO
                case 2:
//#6 En el original no estaba esta condicion si se emula enviara un error ya que no hay caificaciones
                    if (cantidad == 0){
                        System.out.println("NO HAY NOTAS REGISTRADAS");
                        break;
                    }
//#7 El Promedio es double, pero en la operacion total es entero, solo se cambia a double o se agrega un double antes del total (double) total
//MALA PRACTICA   
                    double promedio = (double) total / cantidad;
                    System.out.println("Promedio: " + promedio);

                    if (promedio >= 9){
                     System.out.println("Excelente");
                    }else if(promedio >= 8){
                        System.out.println("BUENO");
  //#8 Tenia un punto y coma en else if , ERROR LOGICO Y COMPILACION
                    }else if(promedio >= 7){
                        System.out.println("REGULAR");
                    }else{
                        System.out.println("REPROBADO");
                    }                 
                    break;
                case 3: 
//#9 Break para dejar de ejecutar el if si no hay ninguna nota
                     if (cantidad == 0){
                        System.out.println("NO HAY NOTAS REGISTRADAS");
                        break;
                    }
                   
                    int aprobados = 0;
                    int reprobados = 0;

                    int i = 0;
//#10 Punto y coma en el while , ERROR LOGICO Y compilacion
                    while (i < cantidad){
//#11 En el if me apoye con un arreglo
                        if (notas[i] >= 7){
                            aprobados++;
                        }else{
                            reprobados++;
                        }
//#12 Este i++ debe de ir afuera para que el while no se vuelva infinito  y ERROR LOGICO                      
                         i++;
                    }

                    System.out.println("Aprobados: " + aprobados);
                    System.out.println("Reprobados: " + reprobados);
//#13 Falta un break Y ERROR LOGICO
                    break;
                case 4:
                    total = 0;
                    cantidad = 0;
                    System.out.println("Datos reiniciados");
                    break;
                case 5:
                    salir = true;
                    System.out.println("Saliendo del sistema");
                    break;
//#14 Falta un break Y ERROR LOGICO
                default:
                    System.out.println("Opcion no valida");
            }

        }
// EL CODIGO NO FUNCIONA POR MULTIPLES ERRORES LOGICOS Y DE COMPILACION SE DEBE MODIFICAR ALGUNAS COSAS O TODO PARA QUE FUNCIONE DE MANERA CORRECTA
//MI CABEZA SOLO ENCONTRO 14 XDXD
        sc.close();
    }
    
}
