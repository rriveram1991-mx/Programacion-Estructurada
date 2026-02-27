/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package registroacceso;
import java.util.Scanner;
/**
 *
 * @author gl873
 */
public class RegistroAcceso {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
// Creamos un objeto Scanner para leer datos desde el teclado
Scanner Leer = new Scanner(System.in);

// Variable para guardar el usuario ingresado (el correcto es "admin")
String Usuario;

// Variable para guardar la contraseña ingresada (la correcta es "12345")
String password;

// Variable para contar los intentos de inicio de sesión
int intentos = 0;

// Variable para guardar la opción del menú
int opcion = 0;

// Ciclo while que permite máximo 3 intentos
while (intentos < 3) {

    // Aumentamos el número de intentos cada vez que entra al ciclo
    intentos++;

    // Mostramos mensaje de inicio de sesión
    System.out.println("//INICIO DE SECCION//");

    // Pedimos el usuario
    System.out.println("User:");
    Usuario = Leer.nextLine();

    // Pedimos la contraseña
    System.out.println("Password");
    password = Leer.nextLine();

    // Verificamos si el usuario es correcto
    if (Usuario.equals("admin")) {

        // Si el usuario es correcto, verificamos la contraseña
        if (password.equals("12345")) {

            // Mensaje de inicio de sesión exitoso
            System.out.println("//Inicio de Seccion correcta //");

            // Mostramos los intentos realizados
            System.out.println("Intentos hechos: " + intentos);
            System.out.println("/////////////////////////////////////////////");

            // Ciclo for que mostrará el menú 3 veces
            for (int i = 1; i <= 3; i++) {

                // Mostramos el menú
                System.out.println("\n--- MENU ---");
                System.out.println("1. Depositar");
                System.out.println("2. Retirar");
                System.out.println("3. Consultar saldo");
                System.out.println("4.-Salir");

                // Leemos la opción elegida
                opcion = Leer.nextInt();

                // Evaluamos la opción con switch
                switch (opcion) {

                    case 1:
                        // Simulación de depósito
                        System.out.println("Simulando deposito...");
                        break;

                    case 2:
                        // Simulación de retiro
                        System.out.println("Simulando retiro...");
                        break;

                    case 3:
                        // Simulación de consulta de saldo
                        System.out.println("Simulando consulta de saldo...");
                        break;

                    case 4:
                        // Simulación de salida
                        System.out.println("Simulando Saliendo...");
                        break;

                    default:
                        // Opción inválida
                        System.out.println("Opcion invalida");
                }

             
                if (i == 3) {
                    System.out.println("Se alcanzo el limite de apariciones del Menu");
                }
                
            }
break;
        } else {
            // Si la contraseña es incorrecta
            System.out.println("User o Password estan mal");
        }

    } else {
        // Si el usuario es incorrecto
        System.out.println("User o Password estan mal");
    }
             
         }
         if(intentos==3){
             // Si se alcanzan los 3 intentos, se bloquea la cuenta
             System.out.println("Cuenta Bloqueada. Por haber superado el limite de intentos");
             System.out.println("Intentos hechos: "+intentos);
         }
    
    }
    
}
