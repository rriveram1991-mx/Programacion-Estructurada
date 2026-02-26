/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package regyacceso;
import java.util.Scanner;
/**
 *
 * @author leidy
 */
public class Regyacceso {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Scanner read=new Scanner(System.in);
      int  intentos=1;
      String  password="" , username="";
      while(intentos<=3 && !username.equals("koku") || !password.equals("123")){
          intentos++;
          System.out.println("AGREGA TU USUARIO");
          username=read.nextLine();
          System.out.println("AGREGALA CONTRASEÑA");
          password=read.nextLine();
          
          if (!username.equals("koku") || !password.equals("123")){
              System.out.println("Datos incorrectos");
  
          }
        }
        if (username.equals("koku") && password.equals("123")) {
            System.out.println("Acceso concedido");
        } else {
            System.out.println("Acceso bloqueado");
        }
      }
    }
    

