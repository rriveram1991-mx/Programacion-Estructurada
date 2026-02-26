/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistema.de.registro.y.acceso.con.intentos.limitados;

import java.util.Scanner;

/**
 *
 * @author jasun
 */
public class SistemaDeRegistroYAccesoConIntentosLimitados {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        //Usuario y contra
        String usuario, contra;
        int intentos, opcion;
        intentos=0;
        usuario="joshue";
        contra="12345";
        
        System.out.println("Binevendio, Ingrese su usuario y contraseña");
        
        while(intentos<=2)
        {
            System.out.println("Ingrese el usuario:");
            usuario=sc.next();
            
            System.out.println("\nIngrese la contraseña:");
            contra=sc.next();
            
            if (usuario.equals("joshue") && contra.equals("12345")) {
                System.out.println("ACCESO CORRECTO");
                intentos=4;
                
                System.out.println("\nQue opcion quiere realizar?");
                System.out.println("1. Bombardear peru");
                System.out.println("2. Explotar la UTT");
                System.out.println("3. Tomar agua");
                System.out.println("   ");
                opcion=sc.nextInt();
                System.out.println("....");
            }
            else {
                System.out.println("INCORRECTO");
                intentos++;
            }
            
             if (intentos==3) {
            System.out.println("CUENTA BLOQUEADA");
        }
        }
    }
    
}
