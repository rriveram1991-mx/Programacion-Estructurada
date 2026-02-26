import java.util.Scanner;

public class iniciodesesion {
    public static void main(String[] args) {
       //variables
        String usuario, contrasena;
        int contadordeoperaciones = 0, contadordeintentos = 0;

        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Bienvenido al sistema de inicio de sesión");
            System.err.println("usuario");
            usuario = sc.next();
            System.err.println("contrasena");
            contrasena = sc.next();
          
            while (!usuario.equals("admin") || !contrasena.equals("1234")) {
                contadordeoperaciones++;
                if (contadordeoperaciones >= 3) {
                    System.out.println("Demasiados intentos fallidos. Acceso bloqueado.");
                    return;
                }
                System.out.println("Usuario o contraseña incorrectos. Intente de nuevo.");
                System.err.println("usuario");
                usuario = sc.next();
                System.err.println("contrasena");
                contrasena = sc.next();
            }
            System.out.println("Inicio de sesión exitoso. ¡Bienvenido, " + usuario + "!");
            System.err.println("Número de intentos: " + contadordeoperaciones);
    }
}}
