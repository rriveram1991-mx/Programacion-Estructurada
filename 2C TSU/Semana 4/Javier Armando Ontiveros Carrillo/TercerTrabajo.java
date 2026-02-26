package tercer.trabajo;
import java.util.Scanner;

public class TercerTrabajo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String usuarioCorrecto = "admin";
        String contraseñaCorrecta = "1234";
        int intentosMaximos = 3;
        int intentosFallidos = 0;
        boolean accesoConcedido = false;

        while (intentosFallidos < intentosMaximos) {
            System.out.println("--- Sistema de Acceso ---");
            System.out.print("Usuario: ");
            String usuarioIngresado = scanner.nextLine();
            System.out.print("Contraseña: ");
            String contraseñaIngresada = scanner.nextLine();

            if (usuarioIngresado.equals(usuarioCorrecto) && contraseñaIngresada.equals(contraseñaCorrecta)) {
                System.out.println("Acceso concedido.\n");
                accesoConcedido = true;
                break; 
            } else {
                intentosFallidos++;
                System.out.println("Acceso incorrecto. Intentos restantes: " + (intentosMaximos - intentosFallidos) + "\n");
            }
        }

        if (accesoConcedido) {
            System.out.println("--- Menú de Opciones ---");
            for (int i = 1; i <= 5; i++) {
                System.out.println(i + ". Opción " + i);
            }
            System.out.println("Seleccione una opción del 1 al 5.");
        } else {
            System.out.println("Cuenta bloqueada por exceder el número de intentos fallidos.");
        }

        System.out.println("Número de intentos fallidos: " + intentosFallidos);
    }
}
