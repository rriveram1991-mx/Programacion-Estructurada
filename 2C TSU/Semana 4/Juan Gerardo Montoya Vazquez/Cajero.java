/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cajero;

import java.util.Scanner;

/**
 *
 * @author juang
 */
public class Cajero {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc =new Scanner(System.in);
        
        boolean salir = false;
        int opcion;
        double saldodelacuenta = 1000;
        double deposito;
        double retiro;
        int Cconsultar=0, Cdeposito=0,Cretiro=0,Coperaciones=0;
        
        while (salir == false) {

            System.out.println("\n1. Consultar saldo actual");
            System.out.println("2. Depositar");
            System.out.println("3. Retirar");
            System.out.println("4. Salir");
            
            System.out.println("Selecciona alguna opción");
            opcion=sc.nextInt();
            
            switch(opcion){
                   
                case 1:
                    System.out.println("Consultar saldo");
                    System.out.println("Tu saldo actual es de $"+ saldodelacuenta);
                    Cconsultar++;
                break;
                
                case 2:
                    System.out.println("DEPOSITO");
                    System.out.println("Digita la cantidad que deseas depositar");
                    deposito=sc.nextDouble();
                    
                    if(deposito>0){
                        saldodelacuenta += deposito;
                        Cdeposito++;
                    System.out.println("Tu saldo actual es de $"+saldodelacuenta);
                    }
                    else{
                        System.out.println("cantidad invalida, vuelva a intentar con una cantidad diferente");
                    } 
                break;
                
                case 3:
                    System.out.println("RETIRO");
                    System.out.println("Tu saldo actual es de $"+saldodelacuenta);
                    System.out.println("Digita la cantidad que deseas retirar de tu cuenta");
                    retiro = sc.nextDouble();
                    if(retiro < 0){
                       
                    System.out.println("Tu saldo actual es de $"+saldodelacuenta);
                    }
                    else{
                        if(saldodelacuenta<retiro){
                            System.out.println("No cuentas con la cantidad que deseas retirar");
                            System.out.println("Tu saldo actual es de $"+saldodelacuenta);
                        }
                        else{
                            saldodelacuenta -= retiro;
                            Cretiro++;
                            System.out.println("Retiro Realizado correctamente");
                            }
                    } 
                break;
                case 4:
                    salir=false;
                    System.out.println("Gracias por la confianza");
                    Coperaciones = Cconsultar + Cdeposito + Cretiro;
                    System.out.println("operciones realizdas "+Coperaciones);
                    System.out.println("Total de consultas "+Cconsultar);
                    System.out.println("Total de depositos "+Cdeposito);
                    System.out.println("Total de retiros "+Cretiro);
                    System.out.println("Saliendo del sistema...............");
                    
                    
                break;
                
                default:
                    System.out.println("Opcion no valida");
            }
         }
    }
}
