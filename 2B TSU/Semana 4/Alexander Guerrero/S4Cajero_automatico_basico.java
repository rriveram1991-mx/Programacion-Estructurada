/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package s4.cajero_automatico_basico;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Lex
 */
public class S4Cajero_automatico_basico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Scanner leer = new Scanner(System.in);
        ArrayList<Double> movimientos = new ArrayList<>();
                
        double saldo = 5000;
        double deposito, retiro;
        int opcion = 0;
        int movimiento = 0;
        
        do{
            System.out.println("===========MENU============");
            System.out.println("");
            System.out.println("1) Consultar saldo");
            System.out.println("2) Depositar");
            System.out.println("3) Retirer");
            System.out.println("4) Salir");
            System.out.println("\nCual acción desea realizar? : ");
            
            opcion=leer.nextInt();
            leer.nextLine();
        
            switch (opcion){
                case 1:
                    System.out.println("Su saldo actual es de " +saldo);
                    break;
                case 2:
                    System.out.println("Cantidad a depositar: ");
                    deposito=leer.nextDouble();                    
                    if (deposito < 0){
                        System.out.println("Cantidad invalida");
                    } else {
                        saldo=saldo+deposito;
                        movimientos.add(deposito);
                        System.out.println("Deposito exitoso");
                    }                               
                    break;
                case 3:
                    System.out.println("Cantidad a retirar: ");
                    retiro=leer.nextDouble();                    
                    if (retiro > saldo || retiro<0){
                        System.out.println("Error: Saldo insuficiente o cantidad invalida");
                    } else {
                        saldo=saldo-retiro;
                        movimientos.add(-retiro);
                        System.out.println("Retiro exitoso");
                    }                    
                    break;
                case 4:
                    System.out.println("Saliendo del sistema");
                    System.out.println("Movimientos realizados: " +movimientos);
                    break;
                default:
                    System.out.println("Acción invalida, favor de reintentar");                    
                    break;
            }
        } while (opcion != 4);
    }
    
}
