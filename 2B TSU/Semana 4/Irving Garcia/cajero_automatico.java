import java.util.Scanner;

public class cajero_automatico {
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Cual es tu saldo actual");
        int saldo = sc.nextInt();
        int contador_depositos = 0;
        int contador_retiros = 0;

        while (saldo > 0) {
            System.out.println("Saldo actual: " + saldo);
            System.out.println("============ MENU ============");
            System.out.println("       Que desea hacer");
            System.out.println("       1) DEPOSITAR");
            System.out.println("       2)  RETIRAR");
            System.out.println("       3)   SALIR");
            System.out.println("Porfavor seleccione una opcion");

            int opcion = sc.nextInt();
            
            switch (opcion) {
                case 1:
                    System.out.println("Saldo disponible: " + saldo);
                    System.out.println("¿Cuanto desea depositar?");
                    int deposito = sc.nextInt();

                    if (deposito > 0) {
                        System.out.println("Usted deposito: " + (saldo += deposito));
                        contador_depositos++;
                        
                    }else {
                        System.out.println("FONDOS INSUFICIENTES");
                    }
                    break;
                case 2:
                    System.out.println("Saldo disponible: " + saldo);
                    System.out.println("¿Cuanto desea retirar?");
                    int retirar = sc.nextInt();

                    if (retirar <= saldo) {
                        System.out.println("Usted ha retirado: " + (saldo -= retirar));
                        contador_retiros++;
                    }else {
                        System.out.println("FONDOS INSUFICIENTES");
                    }
                    break;
                default:
                    break;
            }
            if (opcion == 3) {
                System.out.println("Tu saldo final es de: " + saldo);
                System.out.println("Depositos Realizados: " + contador_depositos);
                System.out.println("Retiros Realizados: " + contador_retiros);
                break;
            }
        }
    }
}
