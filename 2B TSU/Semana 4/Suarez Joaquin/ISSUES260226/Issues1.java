/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package issues1;

import java.util.Scanner;

/**
 *
 * @author ssjoa
 */
public class Issues1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    
   {
Scanner leer = new Scanner(System.in);
double saldo = 1000;
int opcion = 0;
int operaciones=0;
/*incializacion del saldo; Inicializacion del Switch; Valor para el contador*/
       System.out.println("Buen dia querido usario, ");
       System.out.println("--------------------------------------------------");
       System.out.println("Tu saldo actual es de $100000");
       System.out.println("--------------------------------------------------");
       System.out.println("Deseas hacer algun movimiento [True/False");
       System.out.println("--------------------------------------------------");
       boolean movimiento = leer.nextBoolean();
       /*interfaz de interaccion con el usuario*/
       while(movimiento)
       {
           /*ciclo donde sucede las operaciones*/
       System.out.println("Que movimiento deseas realizar?");
       System.out.println("1) Consultar saldo");
       System.out.println("2) Depositar");
       System.out.println("3) Retirar");
       System.out.println("4) Salir");
       
       System.out.println("Seleccione una opcion: ");
       opcion=leer.nextInt();
       
       switch(opcion)
       {
           /*consecuencias del tipo de opcion de accion dada por el usuario*/
       case 1:
       System.out.println("Su saldo actual es de: "+saldo);/*actualizacion del saldo*/
       operaciones++;/*contador presente en cada operacion*/
       break;
       
       case 2:
       System.out.println("Deseas ingresar dinero a tu cuenta? Si lo que quieres es ingresar dinero a otra cuenta, escriba false [true/false]");
       boolean ingreso = leer.nextBoolean();
       if(ingreso)/*condicion booleana para desiganar el tipo de ingreso*/
       {
       System.out.println("Cuanto desea depositar");
       int deposito = leer.nextInt();
       if(deposito<0)
       {
           System.out.println("Cantidad invalidad, intente de  nuevo");/*en caso de que el usuario ponag 0 o cualquier cosa bajo 0*/
       }else
       saldo += deposito;/*actualizador del saldo*/
       operaciones++;
       System.out.println("Operacion excitosa, el deposito se ha reflejado en su cuenta, tenga un buen dia");
       
       }else 
       {
       System.out.println("Cuanto desea depositar");
       double deposito = leer.nextDouble();
       if (deposito<0)
       {
       System.out.println("Cantidad invalida, intente de nuevo");
       }else
 
       leer.nextLine();/*evita que el programa hago un salto de linea, ingorando la indicacion de leer tambien el numero de cuenta como dato*/

       System.out.println("Ingrese la cuenta de deposito");
       String cuenta = leer.nextLine();
       System.out.println("Deposito de: $"+deposito+"a cuenta :"+cuenta);
       saldo-=deposito;/*en este caso de quita al total porque se supone que estamos llevando dinero a otra cuenta*/
       operaciones++;

       }
       break;
           
       case 3:
      System.out.println("Ingrese la cantidad que desea retirar");
      double retiro = leer.nextDouble();
      if(retiro<0)
      {
      System.out.println("Cantidad no valida;Regresando al menu de opciones...");
      }else if (retiro>saldo)
      {
      System.out.println("Saldo insuficiente");/*en caso de que el retiro suepere el presupuesto actual*/
      }else
      {
          saldo-=retiro;
      System.out.println("Operacion excitosa que tenga un buen dia");
      operaciones++;
      }
      break;
       
       case 4:
       System.out.println("Tenga un buen dia");
       System.out.println("Total de operaciones = "+operaciones);/*valor donde vaciamos el total de operacion que obtuvimos con los contadores*/
       movimiento =false;
       break;
       
       default:
       System.out.println("Opcion no valida");/*en caso de cualuqier opcion que no sea 1,2,3 o 4*/
       }
       
       
       }if(!movimiento)
       {
       System.out.println("tenga un buen dia");/*opcion de salida rapida si el usuario asi lo desea*/
       }
           System.out.println("Programado por Joaquin Suarez 2B");
       }
   }
    

