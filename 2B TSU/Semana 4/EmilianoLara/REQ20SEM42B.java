/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package req.pkg20.sem4.pkg2b;

import java.util.Scanner;

/**
 *
 * @author emili
 */
public class REQ20SEM42B {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner dani= new Scanner (System.in);
double si,dep,ret;
int acc, op=0;
boolean co=true;
si=5000;
 System.out.println("Bievenido a su banco");
while(co){
        System.out.println("Inserte la opcion que desea realizar");
        System.out.println("1.Consultar saldo");
        System.out.println("2.Depositar");
        System.out.println("3.Retirar");
        System.out.println("4.Salir");
        acc=dani.nextInt();
    switch (acc){
        case 1:
        System.out.println("Este es su saldo:"+si);
        op=op+1;
    break;
        case 2:
            System.out.println("Inserte el saldo que desea depositar");
            dep=dani.nextDouble();
            if (dep<0){
                System.out.println("Cantidad no válida");
            }
            else{
            si=si+dep;
            op=op+1;}
          break;
        case 3:
            System.out.println("Inserte el saldo que desea retirar");
            ret=dani.nextDouble();
            if (ret<0){
                System.out.println("Cantidad no válida");}
            if (ret>si){
                System.out.println("Saldo insuficiente");}
            else{
                si=si-ret;
            op=op+1;}
            break;
        case 4:
            System.out.println("Finalizando sistema");
            co=false;
            break;
             default:
                    System.out.println("Opcion no valida");
                    break;
        }
}
        System.out.println("Operaciones realizadas:"+op);        
    }
}
