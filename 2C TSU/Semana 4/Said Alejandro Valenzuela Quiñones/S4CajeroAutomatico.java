/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package s4cajeroautomatico;

import java.util.Scanner;

public class S4CajeroAutomatico {

    public static void main(String[] args) {
        // Variables y Scanner
        Scanner leer = new Scanner(System.in);
        boolean salir = false;
        int opcion;
        double saldoInicial = 1000;
        double deposito, retiro;
        int cConsultar = 0, cDepositar = 0, cRetirar = 0, totalOperaciones;
        
        while(salir == false){
            System.out.println("\n1. Consultar saldo");
            System.out.println("2. Depositar");
            System.out.println("3. Retirar");
            System.out.println("4. Salir");
            
            System.out.println("Selecciona una opcion:");
            opcion = leer.nextInt();
            
            switch(opcion){
                case 1:
                    System.out.println("===== CONSULTAR SALDO =====");
                    System.out.println("Saldo: $" + saldoInicial);
                    cConsultar++;
                    break;
                    
                case 2:
                    System.out.println("===== DEPOSITAR =====");
                    System.out.println("Ingresa la cantidad del deposito:");
                    deposito = leer.nextDouble();
                    if(deposito < 0){
                        System.out.println("Ingresa una cantidad valida.");
                    }
                    else{
                        System.out.println("Deposito realizado.");
                        saldoInicial += deposito;
                        cDepositar++;
                    }
                    
                    break;
                    
                case 3:
                    System.out.println("===== RETIRAR =====");
                    System.out.println("Saldo disponible: $" + saldoInicial);
                    System.out.println("Ingresa la cantidad a retirar:");
                    retiro = leer.nextDouble();
                
                    if(retiro < 0){
                        System.out.println("Ingresa una cantidad valida.");
                    }
                    else{
                        if(saldoInicial < retiro){
                            System.out.println("No tienes esa cantidad en tu saldo disponible.");
                        }
                        else{
                            saldoInicial -= retiro;
                            System.out.println("Retiro realizado.");
                            cRetirar++;
                        }
                    }
                    break;
                    
                case 4:
                    salir = true;
                    totalOperaciones = cConsultar + cDepositar + cRetirar;
                    System.out.println("===== OPERACIONES REALIZADAS =====");
                    System.out.println("Consulta de saldo: " + cConsultar);
                    System.out.println("Depositos: " + cDepositar);
                    System.out.println("Retiros: " + cRetirar);
                    System.out.println("Total de operaciones: " + totalOperaciones);
                    System.out.println("Saliendo del sistema....");
                    
                    break;
                
                default: 
                    System.out.println("Opcion no valida");
            }
        }
    }  
}
