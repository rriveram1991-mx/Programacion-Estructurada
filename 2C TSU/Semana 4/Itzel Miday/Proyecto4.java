/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto4;

import java.util.Scanner;


public class Proyecto4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int opcion = 0;
        double total = 0;
        double cantidad = 0;
        boolean salir=true;
        int nota= 0;

        System.out.println("=== SISTEMA DE CONTROL DE NOTAS ===");

        while (salir) {

            System.out.println("1. Capturar notas");
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

                    for (int i = 1; i <= n; i++) {
                        System.out.print("Ingrese nota #" + i + ": ");
                        nota = sc.nextInt();
                        if (nota >= 0 && nota <= 100){
                            total = total + nota;
                            cantidad= cantidad+1;
                        }else{
                            System.out.println("Nota invalida");
                        }
                    }
                        break;
 
                case 2:
                    System.out.println("canctidad: "+cantidad);
                    System.out.println("total: "+total);
                    double promedio = total / cantidad;
                    System.out.println("Promedio: " + promedio);
                    if (promedio >= 90){
                        System.out.println("Excelente");
                    }else if (promedio >= 80){
                        System.out.println("Bueno");
                    }else if (promedio >= 70){
                        System.out.println("Regular");
                    }else{
                        System.out.println("Reprobado");
                    }
                    break;

                case 3:

                    int aprobados = 0;
                    int reprobados = 0;
                    int i = 0;
                    
                    while (i < cantidad){
                        if (total / cantidad >= 7){
                            aprobados++;
                            i++;
                        }else{
                            reprobados++;
                        i++;
                        }
                    }

                    System.out.println("Aprobados: " + aprobados);
                    System.out.println("Reprobados: " + reprobados);
                    break;
                case 4:

                    total = 0;
                    cantidad = 0;
                    System.out.println("Datos reiniciados");
                    break;
                    
                case 5:

                    System.out.println("Saliendo del sistema");
                    salir = false;
break;
                default:
                    System.out.println("Opcion no valida");
            }

        }
    }
}