/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemacontrolnotas;
import java.util.Scanner;
/**
 *
 * @author miguelgu
 */
public class SistemaControlNotas {

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

         while (salir == false) // Es necesario poner ==. //error de compilacion.
        {

            System.out.println("1. Capturar notas"); //Debe de ir solamente 1 para avanzar al respectivo caso.
            System.out.println("2. Mostrar promedio"); //Debe de ir solamente 2 para avanzar al respectivo caso.
            System.out.println("3. Mostrar estadisticas"); //Debe de ir solamente 3 para avanzar al respectivo caso.
            System.out.println("4. Reiniciar datos"); //Debe de ir solamente 4 para avanzar al respectivo caso.
            System.out.println("5. Salir"); //Debe de ir solamente 5 para avanzar al respectivo caso.

            System.out.print("Seleccione opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {

                case 1:

                    System.out.print("Cuantas notas desea capturar: ");
                    int n = sc.nextInt();

                    for (int i = 1; i <= n; i++)  //faltaban corchetes y empezamos desde 1 ya que el usuario si pone 5 tendria que ingresar 6 notas.
                    {

                        System.out.print("Ingrese nota #" + i + ": ");
                        int nota = sc.nextInt();
                        

                        if (nota >= 0 && nota <= 10) //faltaba cerrar el parentesis. 
                        { //faltaban los corchetes
                            total += nota;
                            cantidad++;
                        }
                        else //faltaban corchetes.
                        {
                            System.out.println("Nota invalida");
                         }
                    }
                    break; //faltaba break
                case 2:

                    double promedio = total / cantidad;
                    System.out.println("Promedio: " + promedio);

                    if (promedio >= 9){
                        System.out.println("Excelente"); }
                    else if (promedio >= 8){
                        System.out.println("Bueno");}
                    else if (promedio >= 7)//Error por que no se pone ; en un else ni if.
                    {
                        System.out.println("Regular");}
                    else //faltaban corchetes en los if y else.
                   {
                   System.out.println("Reprobado"); 
                 
                   break; // si el alumno esta reprobado se para aqui mismo el sistema.
                    }
                        //Error de compilacion en toda esta parte de arriba.
                            
                case 3:

                    int aprobados = 0;
                    int reprobados = 0;

                    int i = 0;
                    while (i < cantidad) //no se pone ;. Error de compilacion.
                    {
                        if (total / cantidad >= 7)
                            aprobados++;
                        else
                            reprobados++;
                        i++;
                    }

                    System.out.println("Aprobados: " + aprobados);
                    System.out.println("Reprobados: " + reprobados);
                    break; //Agregamos break 

                case 4:

                    total = 0;
                    cantidad = 0;
                    System.out.println("Datos reiniciados");
                    break; //Agregamos break

                case 5:

                    salir = true;
                    System.out.println("Saliendo del sistema");
                    break; //se agrega un break para que termine aqui de correr el sistema.

                default: //El default es en caso de que ingrese un numero fuera del rango.
                    System.out.println("Opcion no valida");
            }

        }

        sc.close();
    }
    
}
