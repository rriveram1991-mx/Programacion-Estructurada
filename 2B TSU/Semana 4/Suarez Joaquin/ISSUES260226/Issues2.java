/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package issues2;

import java.util.Scanner;

/**
 *
 * @author ssjoa
 */
public class Issues2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        int intentos=0;/*contador con el que aseguraremos la validez de tres intentos*/
        Scanner leer = new Scanner(System.in);
        System.out.println("Usuario: ");
        String usuario = leer.next();
        if(usuario.equals("usuario"))/*nos aseguramos de que el usuario sea el correcto, caso contrario, salimos del sistema*/
        {
        while(intentos<3)/*limte de intentos basado en el contador*/
        {
         System.out.println("Contraseña : ");
         String pass = leer.next();
         if(pass.equals("1701"))/*asegurarnos de que la contraseña sea la ya establecida*/
         {
        System.out.println("Bienvenido al sistema");/*mensaje en caso de datos corrextos*/
        
        for( int x = 1; x<=50; x++)/*simulacion de operaciones dentro del sistema*/
        {
            System.out.println("x");/*impresion de los "resultados" de las operaciones*/
        }
        break;
                
         }else
         {
          intentos++;/*contador en caso de intentos fallidos*/
          if (intentos<3)/*condicion de intentos*/
          {
              System.out.println("Contraseña incorrecta despues de "+intentos);/*acumulador de los intentos*/
          }
         }
         
         }
        if(intentos==3)/*maximo de intentos alcanzados, se pone fuera del blucle porque es la opcion a tomar si la accion anterior se cumple terminando al mismo*/
        {
            System.out.println("bloqueando cuenta");
        }
         
       }else
        {
            System.out.println("usuario incorrecto");/*en caso de que el usuario sea incorrecto*/
        }
    }
}

        
     
    
