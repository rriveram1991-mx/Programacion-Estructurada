import java.util.Scanner;

public class EXREQSEM5P2
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        int cantcal , op , cal = 0 ;
        double prom = 0;

        do
        {
            System.out.println("-----------------------------------------\n");
            System.out.println("      - Promedio de Calificaciones -");
            System.out.println("\n     - Registrar calificaciones (1) -");
            System.out.println("               - Salir (2) -");
            System.out.println("\n         - ¿Qué desea realizar? -");
            op = sc.nextInt();
            System.out.println("\n-----------------------------------------\n");

            switch (op) 
            {
                case 1:

                    System.out.println("-----------------------------------------\n");

                    System.out.println("¿Cuantas calificaciones quiere registrar?");
                    cantcal = sc.nextInt() ;


                    

                    for (int i = 1 ; i <= cantcal ; i ++)
                    {

                        cal = 0 ;
                         System.out.println("Ingrese la calificación #" + i + " :");
                        cal = sc.nextInt();

                        if (cal >= 0 && cal <= 100)
                        {                           
                            prom = prom + cal ;
                        }
                        else
                        {
                            System.out.println("Califiacion fuera del rango ...");
                            i = i - 1 ;
                        }
                        
                    }

                    prom = (prom / cantcal) ;
                    System.out.println("Su promedio es de : " + prom );

                    System.out.println("\n-----------------------------------------\n");
                    
                break;

                case 2:

                    System.out.println("-----------------------------------------\n");
                    System.out.println("   - Gracias por usar este programa -");
                    System.out.println("            - Hasta pronto -");
                    System.out.println("\n-----------------------------------------");

                break;
            
                default:

                    System.out.println("\n-----------------------------------------\n");
                    System.out.println("Operación no reconocida ...");
                    System.out.println("\n-----------------------------------------\n");
                
                break;

            }

        }while(op != 2);
        
        sc.close();
    }
}

