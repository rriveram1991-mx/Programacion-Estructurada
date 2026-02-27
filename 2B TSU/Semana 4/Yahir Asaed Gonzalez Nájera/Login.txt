package ejerciciosingricardo40;

import java.util.Scanner;

public class EjerciciosIngRicardo40 {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        
        int intentos = 4;
        boolean accesoConcedido = false;

        while (intentos > 0 && !accesoConcedido) {
            System.out.println("Ingrese el nombre de usuario:");
            String usuario = leer.nextLine();
            
            System.out.println("Ingrese la contraseña:");
            String contraseña = leer.nextLine();
            
            if (usuario.equals("Yahir") && contraseña.equals("1234")) {
                System.out.println("Bienvenido a Facebook");
                accesoConcedido = true;
                
                System.out.println("¿Desea añadir amigos?");
                String amigos = leer.nextLine();
                
            } else {
                intentos--;
                System.out.println("Usuario o contraseña incorrectos.");
                System.out.println("Te quedan " + intentos + " intentos.");
            }
        }

        if (!accesoConcedido) {
            System.out.println("Cuenta bloqueada por demasiados intentos.");
        }
        
        leer.close();
    }
}