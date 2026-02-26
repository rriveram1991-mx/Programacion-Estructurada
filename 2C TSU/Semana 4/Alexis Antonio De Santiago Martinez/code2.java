import java.util.Scanner;

public class code2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Usuario y contraseña preestablecidos
        String usuarioCorrecto = "admin";
        String contraseñaCorrecta = "1234";

        int intentos = 0;
        int intentosMaximos = 3;
        boolean accesoConcedido = false;

        // Bucle while para máximo 3 intentos
        while (intentos < intentosMaximos) {

            System.out.print("Ingrese usuario: ");
            String usuario = scanner.nextLine();

            System.out.print("Ingrese contraseña: ");
            String contraseña = scanner.nextLine();

            // Validación con if
            if (usuario.equals(usuarioCorrecto) && contraseña.equals(contraseñaCorrecta)) {
                accesoConcedido = true;
                break;
            } else {
                intentos++;
                System.out.println("Credenciales incorrectas.");
                System.out.println("Intentos fallidos: " + intentos);
            }
        }

        // Verificación final
        if (accesoConcedido) {
            System.out.println("\n Acceso concedido.");
            System.out.println("Bienvenido al sistema.\n");

            // Menú
            System.out.println("Menú:");
            System.out.println("1. Ver perfil");
            System.out.println("2. Consultar datos");
            System.out.println("3. Cerrar sesión");

            // Simulación de operaciones con for
            System.out.println("\nSimulando operaciones...");
            for (int i = 1; i <= 3; i++) {
                System.out.println("Procesando operación " + i + "...");
            }

            System.out.println("Sesión finalizada.");

        } else {
            System.out.println("\n Cuenta bloqueada.");
            System.out.println("Número total de intentos fallidos: " + intentos);
        }

        scanner.close();
    }
}