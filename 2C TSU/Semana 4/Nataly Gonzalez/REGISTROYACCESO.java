/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package registro.y.acceso;
 import java.util.Scanner;
/**
 *
 * @author LABTICS
 */
public class REGISTROYACCESO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      
        Scanner sc = new Scanner(System.in);
        
        // Usuario y contraseña predefinidos
        String usuarioCorrecto = "admin";
        String contraseñaCorrecta = "1234";
        
        int intentos = 0;
        int maxIntentos = 3;
        boolean acceso = false;
        
        // Ciclo while para máximo 3 intentos
        while (intentos < maxIntentos) {
            
            System.out.print("Ingrese usuario: ");
            String usuario = sc.nextLine();
            
            System.out.print("Ingrese contraseña: ");
            String contrasena = sc.nextLine();
            
            // Validación con if
            if (usuario.equals(usuarioCorrecto) && contrasena.equals(contraseñaCorrecta)) {
                System.out.println("Acceso correcto ");
                acceso = true;
                break;
            } else {
                intentos++;
                System.out.println("Datos incorrectos ");
                System.out.println("Intento " + intentos + " de " + maxIntentos);
            }
        }
        if (!acceso) {
    System.out.println("\nCuenta bloqueada");
    System.out.println("Total intentos fallidos: " + intentos);
}
        // Si entra correctamente, mostrar menú
          if (acceso) {
           System.out.println("\n--- MENU ---");
           System.out.println("1. Ver datos");
           System.out.println("2. Cambiar contraseña");
           System.out.println("3. Salir");
    
           System.out.print("Seleccione una opción: ");
          int opcion = sc.nextInt();
    
           switch (opcion) {
        
        case 1:
            System.out.println("Mostrando datos...");
            break;
        case 2:
            System.out.println("Cambio de contraseña...");
            break;
        case 3:
            System.out.println("Saliendo del sistema...");
            break;
        default:
            System.out.println("Opción no válida");
    }
}
    }
}
   
