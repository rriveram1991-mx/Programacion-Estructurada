/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cajero.aut;
import java.util.Scanner;
/**
 *
 * @author leidy
 */
public class CAJEROAUT {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner read=new Scanner (System.in);
        int op=1;
        double saldo =10000,sal=0, retiro,trans;
        
        while(op!=4){
            System.out.println("//////////////");
        System.out.println("QUE OPERACION DESEA REALIZAR?");
        System.out.println("1)Consulta de saldo");
        System.out.println("2)Transferir");
        System.out.println("3)Retirar");
        System.out.println("4)Salir");
        System.out.println("//////////////");
        op=read.nextInt();
        
    
    switch (op){
        case 1:
            System.out.println("Su saldo es de:" + saldo);
            break;
        case 2:
            System.out.println("CUANTO DESEA TRANSFERIR");
            trans=read.nextDouble();
            saldo=saldo-trans;
            break;
        case 3:
            System.out.println("CUANTO DEESEA RETIRAR ?");
            retiro=read.nextDouble();
            saldo=saldo-retiro;
          break;
        case 4:
            System.out.println("SALIENDO DEL SISTEMA");
    }
        }
}
}
