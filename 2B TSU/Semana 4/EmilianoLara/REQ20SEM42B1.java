/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package req.pkg20.sem4.pkg2b.pkg1;

import java.util.Scanner;

/**
 *
 * @author emili
 */
public class REQ20SEM42B1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
Scanner wong = new Scanner(System.in);
String us,con;
boolean ok=false;
int n=0,mn=3, opc;
 System.out.println("Bienvenido");
while(n<mn && !ok){
    System.out.println("Inserte su usuario");
        us=wong.next();
    System.out.println("Inserte su contraseña");
        con=wong.next();
        if (con.equals("123") && us.equals("root")){
            System.out.println("Acceso correcto");
        ok=true;
            System.out.println("Inserte que quiere hacer");
            System.out.println("1.INICIO");
            System.out.println("2.CREAR NEW PROJECT");
            System.out.println("3.EDITAR");
            System.out.println("4.FIN");   
        } else{
            System.out.println("Acceso incorrecto");
            n++;
            int re=mn-n;
                if (re> 0) {
                    System.out.println("Ingreso incorrecto:"+n);
                } else {
                    System.out.println("Cuenta bloqueada");}                     
}
}
    }
}
    
    

