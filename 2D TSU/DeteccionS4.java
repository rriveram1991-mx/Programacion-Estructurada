/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package deteccion.s4;

import java.util.Scanner;

/**
 *
 * @author Lair ☆
 */
public class DeteccionS4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int opcion = 0;
        int total = 0;
        int cantidad = 0;
        boolean salir = false;

        System.out.println("=== SISTEMA DE CONTROL DE NOTAS ===");

        while (!salir) { //modifique la estructua del salir agregando el !

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

                    for (int i = 1; i <= n; i++) { //coloque en el forn i=1

                        System.out.print("Ingrese nota #" + i + ": ");
                    int nota = sc.nextInt();

                        if (nota >= 0 && nota <= 10){//elimine el punto y coma y agregue las llaves
                            total= total + nota;
                            cantidad++;
                        }else{
                            System.out.println("Nota invalida");
                        }
                    }

                case 2:

                    double promedio = (double) total / cantidad;//coloque otro double para que salga mejor la division
                    System.out.println("Promedio: " + promedio);


                    if (promedio >= 10){//agregue en este if {} 
                        System.out.println("Excelente");//elimine los ;
                    }else if (promedio >= 8){//agregue {}
                        System.out.println("Bueno");//agregue {}
                    }else if (promedio >=7 ){//agregue {} y elimine ;
                        System.out.println("Regular");//agregue [] y elimine ;
                    }else{
                        System.out.println("Reprobado");
                    }
                    break;

                case 3:
                    System.out.println("---Estadisticas---");// cambio la estrutctura a una estadistica mas comprensible y facil de redactar
                    System.out.println("total de notas validas: " + cantidad);//valgo las notas validas y las sumas acumuladas
                    System.out.println("sumas acumulados: " + total);

                case 4:

                    total = 0;
                    cantidad = 0;
                    System.out.println("Datos reiniciados");
                    break;//agregue un break
                case 5:

                    salir = true;// dejo esto epro coloque con la anterioridad el !
                    System.out.println("Saliendo del sistema");
                    break;//agregue un break
                default:
                    System.out.println("Opcion no valida");
            }

        }

        sc.close();
    }
}
