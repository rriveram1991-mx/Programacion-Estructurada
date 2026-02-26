/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cajeroautomatico;

import java.util.Scanner;

/**
 *
 * @author aguer
 */
public class CajeroAutomatico {

    public static void main(String[] args) 
    {
      Scanner leer = new Scanner (System.in);
        double Saldo=2000, dep,ret,ope=0;
        int opc;
       boolean salir = true;
       while (salir == true){
           
           System.out.println("-------------MENU---------------");
           System.out.println("1. Consultar saldo");
           System.out.println("2. Depositar ");
           System.out.println("3. Retirar");
           System.out.println("4. Salir ");
           System.out.println("Indica la opcion que quieres realizar");
           opc= leer.nextInt();
           
           switch(opc){
               case 1:
                   System.out.println("Saldo disponible: "+ Saldo);
                   ope++;
                   break;
               case 2:
                   System.out.println("Ingresa la cantidad a depositar:");
                   dep= leer.nextDouble();
                   if(dep>0){
                       Saldo+= dep;
                   
                   System.out.println("Saldo disponible: "+ Saldo);
                    ope++;
                   }else 
                       System.out.println("No se puede realizar el deposito");
                   
                    break;
               case 3: 
                   System.out.println("Ingresa la cantidad a retirar:");
                   ret=leer.nextDouble();
                   if (ret< Saldo && ret >0){
                       Saldo -= ret;
                       System.out.println("Saldo disponible: "+ Saldo);
                       ope++;
                       }else if(ret>Saldo) {
                           System.out.println("Error: Saldo insuficiente para realizar el retiro");
                          
                       
                   }else{
                           System.out.println("Error: Nos se pueden cantidades negativas ");
                           
                       }
                  break;
               case 4: 
                   System.out.println("Saliendo del programa");
                    salir = false;
                  break;
               default:
                   System.out.println("Opcion invalida");
                   return;
                  
           }
                      
           
           
       }
       System.out.println("Operaciones Realizadas: "+ ope);

       
        
        
        
    }
    
}
