import java.util.Scanner;
public class CajeroAutomaticoBasico {
     public static void main(String[] args) 
    {
        Scanner leer = new Scanner(System.in);
        double saldo=0 , retiro , deposito;
        int operacion=0;
        boolean salir=true;
        while (salir==true) {
        System.out.println("Que tipo de operacion deseas hacer?");
        System.out.println("1-consultar saldo");
        System.out.println("2-Depositar");
        System.out.println("3-Retirar");
        System.out.println("4-salir del sistema");
        int opcion=leer.nextInt();
        if(opcion==1)
        {
            System.out.println("Tu saldo es de: "+saldo+"$");
            operacion++;
        }
        else if(opcion==2)
        {
            System.out.println("Teclea el monto a depositar ");
            deposito=leer.nextDouble();
            if(deposito<0)
            {
              System.out.println("error solo cantidades positivas");
            }
            else{
            saldo+=deposito;
            System.out.println("Oper4acion realizada tu saldo nuevo es de: "+saldo+"$");
            operacion++;
            }
        }
        else if(opcion==3)
        {
         System.out.println("Teclea la cantidad a retirar");
         retiro=leer.nextDouble();
         if(retiro>saldo || retiro<0)
         {
            System.out.println("Error de monto vuelve a intentarlo");
         }
         else{
            saldo=saldo-retiro;
            System.out.println("Retiro realizado tu saldo restante es de: "+saldo+"$");
            operacion++;
         }
        }
        else if(opcion==4)
        {
            salir=false;
        }

        }
        System.out.println("Cantidad de operaciones realizadas : "+operacion);
        leer.close();
    }
}
