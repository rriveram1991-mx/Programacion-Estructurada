/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cajero.automatico;

import java.util.Scanner;

/**
 *
 * @author Brayan
 */
public class CAJEROAUTOMATICO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner (System.in);
        int saldo = 22000;
        int menu = 0;
        int deposito,retirar;
        int contadordeoperaciones = 0;
        
        while(menu != 4){
            System.out.println("=====Menu del cajero=====");
            System.out.println("1) Consultar tu saldo");
            System.out.println("2) Depositar");
            System.out.println("3) retirar");
            System.out.println("4) Salir");
            System.out.println("=========================");
            
            menu = leer.nextInt();
            
            switch (menu){
                case 1:
                    System.out.println("Tu saldo total es de: "+saldo);
                    contadordeoperaciones ++;
                    break;
                case 2:
                    System.out.println("Cuanto dinero desea depositar: ");
                    deposito = leer.nextInt();
                    saldo = saldo + deposito;
                    contadordeoperaciones ++;
                    System.out.println("Deposito realizado con exito!");
                    System.out.println("Saldo nuevo:"+saldo);  
                    break;
                case 3:
                    System.out.println("Cuanto dinero desea retirar:");
                    retirar = leer.nextInt();
                    saldo = saldo - retirar;
                    contadordeoperaciones ++;
                    if (retirar > saldo){
                        System.out.println("Fondos insuficientes!");
                    }else
                    {System.out.println("Retiro realizado con exito!");}
                    System.out.println("Saldo nuevo:"+saldo);
                    break;
                case 4:
                    System.out.println("Saliendo del sistema...");
                    System.out.println("Operaciones realizadas: "+contadordeoperaciones);
                    
            
            }
        }
    }
    
}
