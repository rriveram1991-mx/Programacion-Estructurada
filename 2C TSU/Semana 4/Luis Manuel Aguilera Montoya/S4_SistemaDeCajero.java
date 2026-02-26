/* Luis Manuel Aguilera Montoya
Desarrollar un sistema que simule un cajero automático:

*Definir un saldo inicial.
*Mostrar un menú repetitivo usando while:
Consultar saldo, Depositar, Retirar, Salir
*Validar que:
El retiro no sea mayor al saldo. 
(No se permitan cantidades negativas. Utilizar if para validar cada operación).
Registrar cuántas operaciones se realizaron usando un contador.
Mostrar al final el total de operaciones realizadas. */

import java.util.Scanner;
public class S4_SistemaDeCajero
{
    public static void main(String[] args) 
    {
        //Declarar variables
        Scanner entrada = new Scanner(System.in);
        double saldo = 0, saldoD = 0, saldoR = 0;
        int opcion = 0, i1=0, i2=0, i3=0;
        boolean salir = false;
        
        System.out.println("----- SISTEMA DE CAJERO AUTOMATICO -----");
        System.out.println("Ingrese su saldo inicial: ");
        saldo = entrada.nextDouble();
    
        //Menu de opciones
        while (salir == false)
        {
            double operacion;
            System.out.println("\n--- Menu de opciones ---");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Depositar");
            System.out.println("3. Retirar");
            System.out.println("4. Salir");

            System.out.print("\nSeleccione opcion: ");
            opcion = entrada.nextInt();

            //Funciones de cada opcion
            switch (opcion)
            {
                case 1: //Consultar saldo
                        System.out.println("Saldo: $" + saldo);
                        i1++;   //Contador de operacion
                    break;
                case 2: //Depositar
                        System.out.println("¿Cuánto dinero desea depositar?:");
                        operacion = entrada.nextDouble();

                        if (operacion >= 0) 
                        {
                            saldoD += operacion;    //Saldo depositado total
                             i2++;                  //Contador de operacion
                        }
                        else 
                            System.out.println("Cantidad a depositar inválida...");

                        saldo += saldoD;            //Saldo total despues de la operacion
                    break;
                case 3:
                        System.out.println("¿Cuánto dinero desea retirar?:");
                        operacion = entrada.nextDouble();

                        if (operacion >= 0 && saldo >= operacion)   //Se ejecuta si el numero de retiro es positivo y si es menor que el saldo total
                        {
                            saldoR += operacion;    //Saldo retirado total
                            i3++;
                        }
                        else 
                            System.out.println("Cantidad retirar inválida...");

                        saldo -= saldoR;        //Saldo total despues de la operacion
                    break;
                case 4:
                    System.out.println("Hasta luego!");
                    salir = true;               //Cambia el valor de salir para terminar el ciclo while
                    break;
                default: System.out.println("Opción inválida...");
                    break;
            }
        }
        System.out.println("\n# RESUMEN DE OPERACIONES #");
        System.out.println("Saldo restante: " + saldo + "   |   Número de veces que se ejecuto la operación: " + i1);
        System.out.println("Saldo depositado: " + saldoD + "   |   Número de veces que se ejecuto la operación: " + i2);
        System.out.println("Saldo retirado: "+ saldoR + "   |   Número de veces que se ejecuto la operación: " + i3);
    }
}
