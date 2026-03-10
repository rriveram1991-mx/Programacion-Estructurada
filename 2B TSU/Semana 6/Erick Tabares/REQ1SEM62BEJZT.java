public class REQ1SEM62BEJZT 
{
    
     public static void main(String[] args) 
     {

        int i , j ;
        int[][] matriz = 
        {
            { 0 , 0 , 1 },
            { 1 , 0 , 1 },
            { 0 , 1 , 0 }
        };

        System.out.println("-------------------------------------------");
        System.out.println("\n     - Asientos de una sala de cine - \n");
        
         for ( i = 0; i < matriz.length; i++) 
        {
    
            System.out.println("\n              Fila  #" + (i+1) + " :");

            for (j = 0; j < matriz[i].length; j++) 
            { 

                System.out.println("\nAsiento #" + (j+1) + " :");

                if (matriz[i][j] == 0) 
                {  
                    System.out.println("\nDisponible ...");
                }
                else
                    if (matriz[i][j] == 1) 
                    {
                    
                        System.out.println("\nOcupado ...");

                    }

            }

            System.out.println("\n-------------------------------------------");

        }

     }

}
