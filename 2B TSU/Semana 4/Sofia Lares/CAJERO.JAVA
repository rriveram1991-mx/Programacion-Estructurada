import java.util.Scanner;
public class CAJERO 
{
    
    

    public static void main(String[] args) 
    {
        Scanner leer = new Scanner(System.in);

        int opcion;
        int saldo = 100;
        int retirar = 0;
        int depositar =0;
        int operaciones = 0;
        boolean salir = false;
        
        System.out.println("--------------CAJERO AUTOMATICO----------------");
        while (!salir)
        {
            System.out.println("1-Consultar saldo");
            System.out.println("2-Depositar");
            System.out.println("3-Retirar");
            System.out.println("4-Salir");
            
            System.out.println("Seleccione opcion");
            opcion = leer.nextInt();
            
            switch (opcion)
            {
                case 1:
                    
                    System.out.println("Tu saldo es de " + saldo);
                    operaciones++;
                    break;
                    
                case 2:
                    
                    System.out.println("Tu saldo actual es de " + saldo);
                    System.out.println("---Dinero a depositar---");
                    depositar = leer.nextInt();
                    
                    if (depositar <=0)
                    {
                        System.out.println("No se permiten valores negativos");
                    }
                    else
                    {
                        
                        saldo = saldo + depositar;
                        System.out.println("Tu saldo ahora es de " + saldo);
                        operaciones++;
                    }
                    
                    break;
                    
                case 3:
                    
                    System.out.println("---Cuanto dinero dinero desesas retirar---");
                    retirar = leer.nextInt();
                    
                   if (retirar > saldo)
                   {
                       System.out.println("Error");
                   }
                   else
                   {
                       System.out.println("Tu saldo era de " + saldo);
                       saldo = saldo - retirar;
                       System.out.println("Tu saldo ahora es de " + saldo);
                   }
                   operaciones++;
                   break;
                   
                case 4:
                    salir = true;
                    System.out.println("Saliendo del sistema");
                    
                   
                    System.out.println("Total de operaciones realizadas: " + operaciones);
            
                    break;
                    
                    default:
                    System.out.println("Opcion no valida");
               
            }
        }
        
        leer.close();
        
    }
}
