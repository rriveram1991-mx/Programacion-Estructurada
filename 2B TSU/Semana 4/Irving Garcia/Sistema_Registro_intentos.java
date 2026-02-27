import java.util.Scanner;

public class Sistema_Registro_intentos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String usuario_correcto = "Irving";
        String password_correcto = "cisco";

        int intentos = 0;
        int intentos_max = 3;
        int contador_intentos = 0;

        while (intentos < intentos_max) {
            System.out.println("Usuario: ");
            String usuario = sc.next();

            System.out.println("Password: ");
            String password = sc.next();
            
            if (usuario.equals(usuario_correcto) && password.equals(password_correcto)) {
                System.out.println("Acceso concedido bienvenido");
                System.out.println("Te equivocastes: " + contador_intentos);
                break;
                }else {
                    intentos++;
                    System.out.println("Usuario o Password incorrectos");
                    System.out.println("Intentos restantes: " + (intentos_max - intentos));
                    contador_intentos++;
            }
        }
        if (intentos == intentos_max) {
            System.out.println("Cuenta bloqueada");
            System.out.println("Te equivocastes: " + contador_intentos);
        }
        sc.close();
    }
}
