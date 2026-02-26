import java.util.Scanner;
public class Cajero {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);
        double saldo =6000;
        int accion,con1,con2,con3;
        con1=0;
        con2=0;
        con3=0;

        System.out.println("================================");
        System.out.println("Bienvenido al porgrama ");
        System.out.println("1-Consultar saldo");
        System.out.println("2-Depositar ");
        System.out.println("3-Retirar ");
        System.out.println("4-Salir");
        System.out.println("Que desea realizar ");
        accion=scan.nextInt();
        System.out.println("================================");
        while (accion !=4  ) {
            switch (accion) {
                case 1:
                    con1++;
                    System.out.println("Tu saldo es: " + saldo);
                    break;
                case 2:
                    con2++;
                    System.out.println("Ingresa la cantidad a depositar: ");
                    double deposito = scan.nextDouble();
                    saldo += deposito;
                    System.out.println("Deposito realizado. Nuevo saldo: " + saldo);
                    break;
                case 3:
                    con3++;
                    System.out.println("Ingresa la cantidad a retirar: ");
                    double retiro = scan.nextDouble();
                    if (retiro <= saldo) {
                        saldo -= retiro;
                        System.out.println("Retiro realizado. Nuevo saldo: " + saldo);
                    } else {
                        System.out.println("Saldo insuficiente");
                    }
                    break;
                    default :
                    System.out.println("No se puede realizar esta operacion intente de nuevo ");
                    break;
            }
            System.out.println("1-Consultar saldo");
        System.out.println("2-Depositar ");
        System.out.println("3-Retirar ");
        System.out.println("4-Salir");
            System.out.println("Que desea realizar ");
           
            accion = scan.nextInt();
        }
            
            System.out.println("Realizo "+ con1+" Consultas de saldo ");
             System.out.println("Realizo "+ con2+" depositos ");
              System.out.println("Realizo "+ con3+" retiros de saldo ");

            
        }
        



        

        
    }

