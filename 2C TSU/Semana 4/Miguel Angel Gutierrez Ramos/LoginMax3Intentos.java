/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package loginmax3intentos;
import java.util.Scanner;
/**
 *
 * @author miguelgu
 */
public class LoginMax3Intentos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        String correctuser = "admin";
        String correctpass = "1234";
        boolean access = false;
        int intento = 0;
        
        while (intento < 3 && !access){
            System.out.println("Usuario: ");
            String user = input.nextLine();
            System.out.println("Contraseña: ");
            String pass = input.nextLine();
            
            if (user.equals(correctuser) && pass.equals(correctpass))
            {
                access = true;
                System.out.println("Accediendo al sistema..");
            }
            else
            {
                intento++;
                System.out.println("usuario o contraseña incorrecto, intento "+intento+ " de 3");
                
                if (intento == 3)
                {
            System.out.println("Superaste el limite de intentos, intentalo mas tarde..");
                 }
            }
        }
        
        
        
        
        
    }
    
}
