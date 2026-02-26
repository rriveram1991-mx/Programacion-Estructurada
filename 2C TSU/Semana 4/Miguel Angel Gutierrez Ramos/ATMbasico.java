/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package atmbasico;
import java.util.Scanner;
/**
 *
 * @author miguelgu
 */
public class ATMbasico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        double saldo = 0;
        boolean salir = false;
        
        System.out.println("Bienvenido, ingrese tarjeta...");
        
        System.out.println("Ingrese nip Ej.(0000): ");
        String nip = input.nextLine();
         
        int contador = 0;
         saldo = 0; 
        
        while (!salir)
        {
        System.out.println("Seleccione opcion: ");
        System.out.println("1. Consultar saldo");
        System.out.println("2. Depositar");
        System.out.println("3. Retirar");
        System.out.println("4. Salir");
        
        int opc = input.nextInt();
        
        switch (opc){
            case 1:
               
                System.out.println("Su saldo actual es de "+saldo);  
                break;
                
            case 2:
                System.out.println("Ingrese saldo a depositar: ");
                double dep = input.nextDouble();
                
                if (dep>0){
                    saldo += dep;
                    System.out.println("====DEPOSITO EXITOSO====");
                    contador++;
                }
                else{
                    System.out.println("Ingrese numero valido...");
                }
                
                 break;
                
            case 3:   
                System.out.println("Ingrese saldo a retirar: ");
                double retiro = input.nextDouble();
                if (retiro > saldo){
                    System.out.println("Saldo insuficiente..");
                }
                else if (retiro<=saldo){
                    saldo -= retiro;
                    contador++;
                }
                break;
                
            case 4:
                salir = true;
                System.out.println("Operaciones realizadas: "+contador);
                System.out.println("Saliendo del sistema...");
                break;
                
            default:
                System.out.println("Ingrese opcion valida...");
                
                
        }

        }
            
        
        
        
        
        
    }
    
}
