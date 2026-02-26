/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication29;
import java.util.Scanner;
/**
 *
 * @author adrianvalenzuelaramirez
 */
public class JavaApplication29 {

    /**
     * @param args the command line arguments
     */


/**
 *
 * @author adrianvalenzuelaramirez
 */
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {


        try (Scanner sc = new Scanner(System.in)) {
            // definir credenciales preestablecidas
            final String USER_DB = "admin";
            final String PASS_DB = "java123";
            
            int intentos = 0;
            int maxIntentos = 3;
            boolean accesoConcedido = false;
            
            System.out.println("=== sistema de acceso restringido ===");
            
            // control de intentos con while
            while (intentos < maxIntentos && !accesoConcedido) {
                System.out.print("\nusuario: ");
                String usuarioIngresado = sc.next();
                System.out.print("contraseña: ");
                String passIngresada = sc.next();
                
                // validar credenciales con if
                if (usuarioIngresado.equals(USER_DB) && passIngresada.equals(PASS_DB)) {
                    accesoConcedido = true;
                    System.out.println("\n acceso concedido, bienvenido.");
                } else {
                    intentos++;
                    int restantes = maxIntentos - intentos;
                    System.out.println(" credenciales incorrectas.");
                    if (restantes > 0) {
                        System.out.println("intentos restantes: " + restantes);
                    }
                }
            }
            
            // logica post-validacion
            if (accesoConcedido) {
                System.out.println("\n--- iniciando servicios del sistema ---");
                
                // usar for para simular la carga de 5 módulos/operaciones
                for (int i = 1; i <= 5; i++) {
                    System.out.println("cargando módulo de operación #" + i + "...");
                   
                }
                
                System.out.println("\ntodos los módulos están listos para operar.");
                
            } else {
                // mensaje de bloqueo si falla 3 veces
                System.out.println("\n cuenta bloqueada raton.");
                System.out.println("se han alcanzado los " + intentos + " intentos fallidos.");
                System.out.println("contacte al administrador del sistema.");
            }
        }
    }
}
    
    

