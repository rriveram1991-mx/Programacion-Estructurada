import java.util.Scanner;

public class cajeroAutomatico {
    public static void main(String[] args) {
        //variables
       
        int saldo = 1000, retiro, deposito, opcion, contadordeoperaciones = 0;
        int contadorConsulta = 0, contadorRetiro = 0, contadorDeposito = 0, contadorSalida = 0;
        String usuario, contrasena;

        //entrada de datos
        try (Scanner sc = new Scanner(System.in)) {
        
            //entrada de datos
        System.out.println("Bienvenido al cajero automatico");
    
        
        
        //Sistema de Registro y Acceso con Intentos Limitados
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
 System.out.println("Seleccione una opcion(1:consultar saldo, 2:depositar, 3:retirar, 4:salir):");
        opcion = sc.nextInt();
        while (opcion != 4) {

            switch (opcion) {
                case 1:
                    contadorConsulta++;
                    System.out.println("Su saldo actual es: " + saldo);
                    break;
                case 2:
                    contadorDeposito++;
                    System.out.println("Ingrese la cantidad a depositar:");
                    deposito = sc.nextInt();
                    saldo += deposito;
                    System.out.println("Deposito exitoso. Su nuevo saldo es: " + saldo);
                    break;
                case 3:
                    contadorRetiro++;
                    System.out.println("Ingrese la cantidad a retirar:");
                    retiro = sc.nextInt();
                    if (retiro > saldo) {
                        System.out.println("Saldo insuficiente. Su saldo actual es: " + saldo);
                    } else {
                        saldo -= retiro;
                        System.out.println("Retiro exitoso. Su nuevo saldo es: " + saldo);
                    }
                    break;
                default:
                    System.out.println("Opcion no valida. Por favor seleccione una opcion valida.");
            }
            System.out.println("Seleccione una opcion(1:consultar saldo, 2:depositar, 3:retirar, 4:salir):");
            opcion = sc.nextInt();

        }
        
        // Mostrar resumen de operaciones realizadas
        contadorSalida++;
        System.out.println("\n=== RESUMEN DE OPERACIONES ===");
        System.out.println("Consultas de saldo: " + contadorConsulta);
        System.out.println("Depositos realizados: " + contadorDeposito);
        System.out.println("Retiros realizados: " + contadorRetiro);
        System.out.println("Total de operaciones: " + (contadorConsulta + contadorDeposito + contadorRetiro));
        System.out.println("Saldo final: " + saldo);
        System.out.println("¡Gracias por usar el cajero automatico!");
        }}}
    