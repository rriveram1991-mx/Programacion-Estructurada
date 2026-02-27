import java.util.Scanner;
public class Practica14 {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int i = 0;
        while (i < 3 ) {
            System.out.println("=== Ingrese usuario ===");
            String usuario = leer.nextLine();
            System.out.println("=== Ingrese contraseña ===");
            String contraseña = leer.nextLine();
            if (usuario.equals("admin") && contraseña.equals("12345")) {
                System.out.println("=== Bienvenido al sistema ===");
                System.out.println("=== Se realizaron " + i + " intentos ===");
                for (int j = 0; j < 5; j++) {
                    System.out.println("=== Menú de opciones ===");
                    System.out.println("=== 1. Leer notificaciones ===");
                    System.out.println("=== 2. Comentar ===");
                    System.out.println("=== 3. Ver perfil ===");
                    System.out.println("=== 4. Salir ===");
                    int opcion = leer.nextInt();
                    if (opcion == 4) {  
                        System.out.println("=== Saliendo del sistema ===");
                        return;
                    }
                     else {
                        System.out.println("=== Opción no válida ===");
                    }
                }
            }
             else {
                System.out.println("=== Usuario u contraseña incorrecto ===");
                i++;
            }
        }
        if (i == 3) {
            System.out.println("=== Cuenta bloqueada ===");
        }
    
    
}
    }
