/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemadelogin;
 import java.util.Scanner;
/**
 *
 * @author jegh1
 */
public class Sistemadelogin {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    {
        Scanner sc = new Scanner(System.in);

        String usuarioCorrecto = "admin";
        String passCorrecta = "1234";

        int intentos = 0;
        boolean acceso = false;

        // ===== INTENTOS DE LOGIN =====
        while (intentos < 3 && !acceso) {

            System.out.print("Usuario: ");
            String usuario = sc.nextLine();

            System.out.print("Contraseña: ");
            String pass = sc.nextLine();

            if (usuario.equals(usuarioCorrecto) && pass.equals(passCorrecta)) {
                acceso = true;
                System.out.println("✅ Acceso concedido");
            } else {
                intentos++;
                System.out.println("❌ Datos incorrectos. Intento " + intentos + " de 3");
            }
        }

        // ===== SI ACCEDE =====
        if (acceso) {

            System.out.println("\nSimulación de operaciones:");

            // Usamos FOR como pide el ejercicio
            for (int i = 1; i <= 3; i++) {
                System.out.println("Operación #" + i + " realizada");
            }

        } else {
            // ===== BLOQUEO =====
            System.out.println("🔒 Cuenta bloqueada por demasiados intentos.");
            System.out.println("Intentos fallidos: " + intentos);
        }

        sc.close();
    }
}

