/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistema_cajero_automatico;

import java.util.Scanner;

/**
 *
 * @author jasun
 */
public class Sistema_cajero_automatico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        //Definir variables
        double saldo, depo, reti;
        int opcion, operaciones;
        
        saldo=6000;
        opcion=0;
        operaciones=0;
        
        while (opcion!=4)
        {
            System.out.println("\nMENU DE CAJERO AUTOMATICO");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Depositar");
            System.out.println("3. Retirar");
            System.out.println("4. Salir");
            System.out.println("\nIngrese que opcion elige:");
            opcion=sc.nextInt();
        
        if (opcion==1) {
            System.out.println("SALDO DISPONIBLE: $"+saldo);
            operaciones=operaciones+1;
        }
        else if (opcion==2) {
            System.out.println("Cuanto quiere depositar?");
            depo=sc.nextDouble();
            operaciones=operaciones+1;
            saldo=saldo+depo;
            System.out.println("Nuevo saldo: $"+saldo);
        }
        else if (opcion==3){
            System.out.println("Cuanto quiere retirar?");
            reti=sc.nextDouble();
            if (reti<saldo) {
                saldo=saldo-reti;
                System.out.println("SALDO RETIRADO");
                System.out.println("Nuevo saldo: $"+saldo);
            }
            else {
                System.out.println("Saldo insuficiente");
            }
            operaciones=operaciones+1;
        }
            else if(opcion==4) {
                    System.out.println("Saliendo, gracias por su preferencia");
                    System.out.println("TOTAL DE OPERACIONES REALIZADAS: "+operaciones);
                    opcion=4;
                    }
            else {
                    System.out.println("Opcion invalida");
                    }
        }
        }
    }
    
