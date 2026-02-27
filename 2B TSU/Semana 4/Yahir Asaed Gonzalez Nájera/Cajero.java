/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciosingricardo39;

import java.util.Scanner;

/**
 *
 * @author yahir
 */
public class EjerciciosIngRicardo39 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner leer = new Scanner(System.in);
        
        Double sueldo,deposito,retiro;
        int ct1,ct2,ct3;
        boolean salir=false;
        String  opcion;
        
        
        sueldo=5000.00;
        ct1=0;
        ct2=0;
       ct3=0;
        while (salir==false) {
            System.out.println("Bienvenido al cajero!");
            System.out.println("Ingrese la opción deseada");
            System.out.println(" Consultar saldo");
            System.out.println(" Depositar");
            System.out.println(" Retirar");
            System.out.println(" Salir");
            System.out.println("Ingrese a la opción que desea entrar:");
            opcion=leer.nextLine();
            
            switch (opcion) {
                case "Consultar saldo":
                    System.out.println("-------------------------");
            System.out.println("Su saldo actual es de :" +sueldo);
            System.out.println("---------------------------------");
                    ct1=ct1+1;
            break;  
            
                case "Depositar":
                    System.out.println("¿Cuánto dinero desea depositar?");
                    deposito=leer.nextDouble();
                    System.out.println("-----------------------------------------------------");
                    System.out.println("El dinero se ha ingresado correctamente a la cuenta");
                    sueldo=sueldo+deposito;
                    leer.nextLine();
                    System.out.println("Su nuevo sueldo es de :" + sueldo + " pesos");
                    System.out.println("-----------------------------------------------------");
                    ct2=ct2+1;
                    
                    break;
                    
            case "Retirar":
                System.out.println("¿Cuánto dinero desea Retirar?");
                retiro=leer.nextDouble();
                if (retiro>sueldo || retiro<=0 ) {
                    System.out.println("Error!");
                    System.out.println("Saldo insuficiente! Intente de nuevo");
                    }else  {
                    sueldo=sueldo-retiro;
                    leer.nextLine();
                    System.out.println("---------------------------------");
                            System.out.println("Listo, se ha hecho la transacción!");
                            System.out.println("Su nuevo sueldo es de :" + sueldo +  " pesos");
                            System.out.println("---------------------------------");
                            }
                ct3=ct3+1;
                break;
                
            case "Salir":
                System.out.println("El número de consultas de saldo hechas hoy: " +ct1);
                System.out.println("El número de depósitos hechos hoy: " +ct2);
                System.out.println("El número de retirosD hechos hoy: " +ct3);
             salir=true;
                }
                }
                
                }
            
        }
    

