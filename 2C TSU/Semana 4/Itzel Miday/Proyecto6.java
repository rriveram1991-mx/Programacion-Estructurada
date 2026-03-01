/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto6;

import java.util.Scanner;


public class Proyecto6 {
    
    public static void main(String[] args) {
        Scanner minimi = new Scanner(System.in);
        /*
        Defina un usuario y contraseña preestablecidos.
Permita máximo 3 intentos usando while.
Valide credenciales con if.
Si el acceso es correcto:
Mostrar menú con opciones (usar for para simular operaciones).
Si falla 3 veces:
Mostrar mensaje de cuenta bloqueada.
Contar número de intentos fallidos
        */
        int I=0,X=0;
        String USER, USERN,CON,CONT;
        boolean OP=true;
        System.out.println("NUEVO USUARIO Y CONTRASEÑA.");
        System.out.println("------------------------------------------------");
        System.out.println("Ingrese su usuario:");
        USER = minimi.next();
        System.out.println("Ingrese su contraseña:");
        CON = minimi.next();
         System.out.println("------------------------------------------------");
        System.out.println("Valide sus credenciales.");
         System.out.println("------------------------------------------------");
        while (OP){
            System.out.println("Ingresar usuario. ");
            USERN = minimi.next();
            System.out.println("Ingresar contraseña.");
            CONT = minimi.next();
            if (USERN.equals(USER) && CONT.equals(CON)){
                System.out.println("Credenciales validadas!");
                System.out.println("Intentos fallidos: "+I);
                boolean K=true;
                while (K){
                System.out.println("""
                                   1: Cambiar contraseña.
                                   2: Cambiar usuario.
                                   3: Salir.
                                   """);
                X = minimi.nextInt();
                switch (X){
                    case 1: 
                        System.out.println("Ingrese su nueva contraseña:");
                        CON = minimi.next();
                        break;
                    case 2:
                        System.out.println("Ingrese su nuevo usuario:");
                        USER = minimi.next();
                    break;
                    case 3:
                        System.out.println("Saliendo...");
                        K=false;
                        OP=false;
                }
                }
            }else if (I>=3){
                 System.out.println("CUENTA BLOQUEADA.");
                System.out.println("Intentos fallidos: "+I);
                OP=false;
            }else{
                System.out.println("Nombre de usuario y/o contraseña incorrectos");
                I= I+1;
            }
        }
                
    }
    
}
