import java.util.Scanner;

public class REQ2SEM52B
{

    public static void main(String[] args) 
    {

        Scanner sc = new Scanner(System.in);

        int pasajeros,  i=0 , despop= 0 , CDMX =0, Local=0;

        System.out.println("------------------------------------------------------------------");
        System.out.println("\n                 - Registro de Pasajeros -");
        System.out.println("\n     Ingrese el número de pasajeros que seran registrados : \n");
        pasajeros = sc.nextInt();
        sc.nextLine();
        System.out.println("\n------------------------------------------------------------------");

        String[] nombres = new String [pasajeros];
        int[] destino = new int [pasajeros] ;

        for (i = 0; i < pasajeros; i++) 
        {
        System.out.println("\n                      Datos del pasajero #" + (i+1) + " :\n");
        System.out.println("Nombre : ");
        nombres[i] = sc.nextLine();
        while (nombres[i].isEmpty()) 
        {

            System.out.println("\nEspacio en blanco. Intente nuevamente : ");
            System.out.println("Ingrese el Nombre : ");   
            nombres[i] = sc.nextLine();
            
        }
        System.out.println("\n        Destinos disponibles : CDMX (1) | Local (2)\n");
        System.out.println("Destino : ");
        destino[i] = sc.nextInt();

        

        System.out.println("\n------------------------------------------------------------------\n");
    }

    System.out.println("                      - Lista de pasajeros -\n");
     System.out.println("\n-------------------                          --------------------\n");
    i= 0 ;
for (String nombre : nombres) 
    {
    
    System.out.println("                        - Pasajero #" + (i+1)+ " -\n");
    System.out.println("Nombre  : " + nombre);
    System.out.println("Destino : " + destino[i]);

    if(destino[i] == 1 )
    {
        CDMX ++ ;
    }
    else
    {
        Local ++;
    }
    i++;


    System.out.println("\n------------------------------------------------------------------\n");

}

        System.out.println("                       - Estadisticas - ");
        if(CDMX> Local)
        {
            System.out.println("\n                Destino con mas pasajeros : CDMX ");
            despop = CDMX;
        }
        else
        {
            System.out.println("\n                Destino con mas pasajeros : Lolcal");
            despop= Local;
        }
    
    System.out.println("\n                Pasajeros registrados en este destino : "+ despop);
    System.out.println("\n                Pasajeros regitrados en total : "+ pasajeros);
    System.out.println("\n------------------------------------------------------------------\n");

sc.close();

    }
}

    


