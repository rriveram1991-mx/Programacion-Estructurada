import java.util.Scanner;

public class p12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String usuario = "admin";
        String contraseña = "1234";
        int intentos = 0;
        int maxIntentos = 3;

        while (intentos < maxIntentos) {
            System.out.print("Usuario: ");
            String user = sc.nextLine();
            System.out.print("Contraseña: ");
            String pwd = sc.nextLine();

            if (user.equals(usuario) && pwd.equals(contraseña)) {
                System.out.println("\nAcceso correcto ✅");
                System.out.println("--- MENÚ DE OPERACIONES ---");
                for (int i = 1; i <= 3; i++) { // simulamos 3 operaciones
                    System.out.println("Operación " + i + " realizada.");
                }
                break;
            } else {
                intentos++;
                System.out.println("Credenciales incorrectas. Intento " + intentos + "/" + maxIntentos);
            }
        }

        if (intentos == maxIntentos) {
            System.out.println("\nCuenta bloqueada ❌");
        }

        
    }
}
