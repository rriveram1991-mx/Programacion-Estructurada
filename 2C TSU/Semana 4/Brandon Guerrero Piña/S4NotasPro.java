/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package s4.notaspro;

import java.util.Scanner;

/**
 *
 * @author UTT
 */
public class S4NotasPro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

        int opcion = 0;
        double total = 0; //Cambiar tipo de variable dado que nos ayudara a realizar la operacion de promedio usando decimales
        int cantidad = 0;
        boolean salir = false;
        int aprobados = 0; //Usar estas variables como contador y declararlas desde el inicio del sistema para poderlas mandar a llamar a otro caso
        int reprobados = 0;//Usar estas variables como contador y declararlas desde el inicio del sistema para poderlas mandar a llamar a otro caso

        System.out.println("=== SISTEMA DE CONTROL DE NOTAS ===");

        while (salir == false) { //Doble igual para igualar uno se usar de asignacion

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

                    for (int i = 1; i <= n; i++) { //Tiene que ser mayor a 0 no debe tener una nota 0 dado que el cero no es un numero nulo

                        System.out.print("Ingrese nota #" + i + ": ");
                        int nota = sc.nextInt();
                        

                        if (nota > 0 && nota <= 10){ //No se usar ; al final de una condicion IF simplemente se le agrega un {
                             
                            //Cree una condicion donde ire guardando la cantidad de notas aprobadas y reprobadas dependiendo de su nota
                            if (nota <7){ 
                               reprobados++;
                            }
                            else{
                                 aprobados++;
                            }
                            total += nota;
                            cantidad++;
                        }
                        else
                        {//Se debe abrir y cerrar {}
                            System.out.println("Nota invalida");
                            i=i-1; // Creamos una resta para vovler a pedir la misma nota dado a su error al introducir la calificacion
                        }
                    }
                    
                    break;//Break para terminar el case
                    

                case 2:

                    double promedio = total / cantidad;
                    System.out.println("Promedio: " + promedio);
                    
                    if (promedio > 0 && promedio <=10) //Condicionar el promedio para evitar mandar a imprimir reprobado 
                    {
                    if (promedio >= 9) { //Uso de corchetes
                        System.out.println("Excelente");
                    }
                    else if (promedio >= 8){ //Uso de corchetes
                        System.out.println("Bueno");
                    }
                    else if (promedio >= 7){//; //Punto y coma no se usan al final de una condicion else if pero si un {}
                        System.out.println("Regular");
                    }
                    else {//uso de {}
                        System.out.println("Reprobado");
                    }
                    }

                    break;

                case 3:

                    /*int aprobados = 0;
                    int reprobados = 0;

                    
                    int i = 0;
                    while (i < cantidad)// ";" //Uso de ; mal no se debe colocar al final de la condicion del while
                    {
                        if (total / cantidad >= 7){ //Uso de corchetes {}
                            aprobados++;
                            
                        }
                        else { //Debemos condicionar el else//Uso de corchetes
                            reprobados++;
                        }
                    
                        i++;
                        
                    }*/ 
                    // Meti estas operaciones y condiciones dentro del case 1 para poder evaluar cada calificaciones

                    System.out.println("Aprobados: " + aprobados);
                    System.out.println("Reprobados: " + reprobados);
                    break;

                case 4:
                    //Tenemos que hacer 0 todas las variables iniciales como las aprobados y reprobados
                    total = 0;
                    cantidad = 0;
                    aprobados = 0; 
                    reprobados = 0;
                    System.out.println("Datos reiniciados");
                    
                    break;//Se tiene que cerrar el case con BREAK

                case 5:

                    salir = true;
                    System.out.println("Saliendo del sistema");
                    

                default:
                    System.out.println("Opcion no valida");
            }

        }

        sc.close();
    }
}
