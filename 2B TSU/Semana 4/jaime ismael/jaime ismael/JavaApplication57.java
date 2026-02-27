/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication57;

//Sistema de Cajero Automático Básico

import java.util.Scanner;


//Requerimiento
//Desarrollar un sistema que simule un cajero automático:
//
//Definir un saldo inicial.
//Mostrar un menú repetitivo usando while:
//Consultar saldo
//Depositar
//Retirar
//Salir
//Validar que:
//El retiro no sea mayor al saldo.
//No se permitan cantidades negativas.
//Utilizar if para validar cada operación.
//Registrar cuántas operaciones se realizaron usando un contador.
//Mostrar al final el total de operaciones realizadas.
public class JavaApplication57 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner leer = new Scanner(System.in);
        //declaracion de variables 
        int cont_operacion = 0;
        double saldo = 1000;
        int opcion = 0;
        boolean salir = true;
        //while principal
        while (salir){
            
            System.out.println("--CAJERO AUTOMATICO--");
        // texto de opciones
            System.out.println("1.consultar saldo");
            System.out.println("2.depositar");
            System.out.println("3.retirar");
            System.out.println("4.salir");
            
            opcion = leer.nextInt();
            
            switch (opcion){
                    case 1://case uno imprime el saldo
                        System.out.println("su saldo es de: " + saldo + "$");
                        
                        break;
                    case 2://case dos lee el deposito y lo suma al saldo
                        System.out.print("cantidad a depositar: ");
                        double deposito = leer.nextDouble();
                        
                        if (deposito > 0 ){
                            saldo = saldo + deposito;
                            System.out.println("saldo actual: " + saldo + "$");
                             cont_operacion++;//contador de operaciones incrementa
                        }else {//en caso de que el usuario se sienta muy listo 
                            System.out.println("no se puede depositar cantidades negativas");
                        }
                          
                        break;
                    case 3://lo mismo que en deposito pero ahora restamos al saldo
                        System.out.println("cuanto desea retirar: ");
                        double retiro = leer.nextInt();
                        
                        if (retiro < saldo ){
                        saldo = saldo - retiro;
                        System.out.println("saldo actual: " + saldo + "$");
                        cont_operacion++;
                        }else {//por si el usuario se siente bien aca e intenta retirarmas de lo que tiene
                            System.out.println("no puedes retirar una cantidad mayor a tu sueldo ");
                        }
                        
                        break;
                    case 4://cerramos el programa en case 5 con el contador y un mensaje de gracias 
                        System.out.println("cantidad de operaciones realizadas: " + cont_operacion);
                        System.out.println("saliendo del sistema, gracias por su preferencia");
                        salir = false;
                        break;
                    default:
                        System.out.println("opcion no valida");
                        System.out.println("Programado por jaime ismael");
                        
            }  
        }
        
        System.out.println("que tenga buen dia");
            
        
        
        
    }
    
}
