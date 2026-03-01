/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practica5;

import java.util.Scanner;

public class Practica5 {

    
    public static void main(String[] args) {
        double SI=0,DEP=0,SR=0;
        Scanner mika =new Scanner (System.in);
        boolean OP=true;
        int I=0,X=0;
        System.out.print("Ingrese su saldo inicial:");
        SI = mika.nextDouble();
        System.out.println("BIENVENIDO AL SISTEMA DE CAJERO AUTOMATICO");
        while (OP){
            System.out.print("""
                               -------------------------------------------------------
                               1: Consultar saldo.
                               2: Depositar.
                               3: Retirar.
                               4: Salir
                               -------------------------------------------------------
                               """);
        X = mika.nextInt();
        switch (X){
            case 1: 
                System.out.println("Su saldo es: "+SI);
                I=I+1;
            break;
            case 2: 
                System.out.println("Cuanto desea depositar?");
                DEP = mika.nextDouble();
                if (DEP<0){
                    System.out.println("Ingrese un numero valido.");
                }else{
                SI +=DEP;
                }
                I=I+1;
            break;
            case 3:
                System.out.println("Cuanto saldo desea retirar?");
                SR = mika.nextDouble();
                if (SR>SI){
                    System.out.println("Su saldo es menor.");
                }else if (SR<0){
                    System.out.println("Ingrese un numero valido.");
                }else{
                    SI= SI-SR;
                }
            break;
            case 4:
                System.out.println("Saliendo...");
                OP=false;
            break;
            default:
                System.out.println("Ingrese una opcion valida!");
        }
               
            
        }
    }
    
}
