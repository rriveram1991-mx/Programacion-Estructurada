import java.util.Scanner;

public class code {
    public static void main(String[] args) {
        Scanner leer=new Scanner (System.in);
        double saldo= 1000;
        int opcion;
        int contador= 0;
        boolean salir= false;
        while(!salir){
            System.out.println("\n== cajero automatico");
            System.out.println("1. consultar saldo");
            System.out.println("2.- depositar");
            System.out.println("3.- retirar");
            System.out.println("4.- salir");
            System.out.println("seleccione una accion: ");
            opcion=leer.nextInt();
            switch (opcion){
                case 1:
                    System.out.println("su saldo actual es de: $"+ saldo);
                    contador++;
                    break;
                case 2:
                    System.out.println("ingrese la cantidad a depositar: ");
                    double deposito= leer.nextDouble();
                    if (deposito > 0){
                        saldo += deposito;
                        System.out.println("deposito realizado con exito");
                        contador++;
                    } else {
                        System.out.println("no se permiten cantidades menores a 0");
                    }
                    break;
                case 3:
                    System.out.println("ingrese la cantidad a retirar: ");
                    double retiro=leer.nextDouble();
                    if (retiro > 0){
                        if (retiro <= saldo){
                            saldo-= retiro;
                            System.out.println("retiro realizado con exito");
                            contador++;
                        } else {
                            System.out.println("fondos insuficientes");
                        }
                    } else {
                        System.out.println("no se permiten cantidades menores a 0");
                    }
                    break;
                case 4:
                    salir= true;
                    break;
                default:
                    System.out.println("opcion invalida.");
    }
}
System.out.println("\ntotal de operaciones realizadas"+ contador);
leer.close();
    }
}
