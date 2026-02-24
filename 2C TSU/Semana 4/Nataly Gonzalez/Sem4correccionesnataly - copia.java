/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sem4correccionesnataly;
import java.util.Scanner;
/**
 *
 * @author LABTICSNAT
 */
public class Sem4correccionesnataly {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         Scanner sc = new Scanner(System.in);
        
        int opcion = 0; 
      
        int total = 0; 

        int cantidad = 0; 
       
        int aprobados = 0; 

        int reprobados = 0; 
       
        boolean salir = false; 
        // Se mantiene, pero se usará correctamente en el while por que la condicion estaba mal del while.

        System.out.println("=== SISTEMA DE CONTROL DE NOTAS ===");

        while (!salir) { 
        // Antes era (salir = false) y eso daba error en al querer comparar para salr y se breackeaba el codigo

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
                    // Antes iniciaba en 0 y estaba mal aplicado <=.
                    //venia asi :int i = 0; i <= n; i++.

                        System.out.print("Ingrese nota #" + i + ": ");
                        int nota = sc.nextInt();

                        if (nota >= 0 && nota <= 10) { 
                        //Se eliminó el ; que rompía el if por que el punto y coma cierra la condicion.

                            total += nota;

                            cantidad++; 
                           
                            if (nota >= 7)
                                aprobados++; 
                            else
                                reprobados++; 
                            //Ahora sí se cuentan correctamente, estaba mal hecho el sumador .

                        } else {
                            System.out.println("Nota invalida");
                            i--; 
                            // Repite el mensaje  si la anota es invalida antes no lo hacia 
                        }
                    }

                    break; 
                   //Antes faltaba break y ejecutaba más casos no terminaba nunca ya que si no se pone su 
                   //ciclo se hara infinito.

                case 2:

                    if (cantidad > 0) { 
                    //Evita división entre cero.

                        double promedio = (double) total / cantidad; 
                        // Se fuerza división decimal.
                        // Antes hacía división entera.

                        System.out.println("Promedio: " + promedio);

                        if (promedio >= 9)
                            System.out.println("Excelente");
                        else if (promedio >= 8)
                            System.out.println("Bueno");
                        else if (promedio >= 7) 
                            System.out.println("Regular"); 
                        // Se eliminó el ; que hacía que se cerra el codigo otra vez .
                        else
                            System.out.println("Reprobado");

                    } else {
                        System.out.println("No hay notas registradas.");
                    }

                    break;

                case 3:

                    if (cantidad > 0) {
                        System.out.println("Total de notas: " + cantidad);
                        System.out.println("Aprobados: " + aprobados);
                        System.out.println("Reprobados: " + reprobados);
                        System.out.println("Suma total: " + total);
                    } else {
                        System.out.println("No hay datos.");
                    }

                    break;

                case 4:

                    total = 0; 
                    cantidad = 0; 
                    aprobados = 0; 
                    reprobados = 0; 
                    //Ahora reinicia todos los contadores para que no sumen datos de mas.

                    System.out.println("Datos reiniciados");

                    break;

                case 5:

                    salir = true; 
                    //Permite salir correctamente por que antes arriba al tener false no se podia o se llegaba a complicar

                    System.out.println("Saliendo del sistema");

                    break;
                  // le hacia falta un break.
                default:
                    System.out.println("Opcion no valida");
            }
        }

        sc.close(); 
    }
}
 
