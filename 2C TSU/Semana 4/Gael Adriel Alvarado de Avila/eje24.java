import java.util.Scanner;

public class eje24 {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        String usuario = "gael";
        String contraseña = "1234";
        int intentos = 0;
        int maxIntentos = 3;

        while (intentos < maxIntentos) {
            System.out.print("Usuario: ");
            String user = leer.nextLine();
            System.out.print("Contraseña: ");
            String pwd = leer.nextLine();

            if (user.equals(usuario) && pwd.equals(contraseña)) {
                System.out.println("\nAcceso correcto");
                System.out.println("--- MENu DE OPERACIONES ---");
                for (int i = 1; i <= 3; i++) { 
                    System.out.println("Operación " + i + " realizada.");
                }
                break;
            } else {
                intentos++;
                System.out.println("Credenciales incorrectas. Intento " + intentos + "/" + maxIntentos);
            }
        }

        if (intentos == maxIntentos) {
            System.out.println("\nCuenta bloqueada ");
        }

        
    }
}
