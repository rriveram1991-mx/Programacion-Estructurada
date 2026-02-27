/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject26;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Mavenproject26 {

    public static void main(String[] args) {
        //Sistema de Cajero Automático Básico
        System.out.print("==CAJERO AUTOMATICO==");
        Scanner leer = new Scanner(System.in);
        int opcion;
        double saldo = 0, operacion=0;
        boolean menu = false;
        
        System.out.print("Saldo inicial: ");
        saldo=leer.nextDouble();
        while(!menu){
        System.out.print("1) Consultar saldo ");
        System.out.print("2) Depositar ");
        System.out.print("3) Retirar ");
        System.out.print("4) Salir ");
        System.out.print("Elige una opcion ");
        opcion=leer.nextInt();
        switch(opcion){
            case 1:{
                //Consultar saldo
                System.out.print("Consultar saldo: "+ saldo);
                operacion++;
                break;
            }
            case 2:{
                //Depositar
                System.out.print("Cantidad que desea depositar: ");
                    double cant = leer.nextDouble();
                    if (cant > 0) {
                        saldo += cant; 
                        System.out.println("Deposito realizado. Nuevo saldo: " + saldo);
                        operacion++;
                    } else {
                        System.out.println("Deposito no realizado.");
                    }
                    break; 
            }
            case 3:{
                //Retirar
                System.out.print("¿Que cantidad desea retirar? ");
                    double cant_retirar = leer.nextDouble();
                    if (cant_retirar > 0 && cant_retirar <= saldo) { 
                        saldo -= cant_retirar;
                        System.out.println("Retiro exitoso: Saldo actual = " + saldo);
                        operacion++;
                    } else if (cant_retirar > saldo) {
                        System.out.println("Dinero insuficiente.");
                    } else {
                        System.out.println("Cantidad invalida.");
                    }
                    break; 
            }
            case 4: {
               //Salir
               menu = true;
               System.out.println("Saliendo...");
                    
            }
            default: System.out.println("Opcion no valida.");
                    break;
        }
        }
        System.out.println("Total de operaciones exitosas realizadas: " + operacion);
        leer.close();
    }
}
