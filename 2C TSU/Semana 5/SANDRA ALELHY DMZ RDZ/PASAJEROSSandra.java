
package pasajeros.sandra;

import java.util.Scanner;

public class PASAJEROSSandra {
//SANDRA DOMINGUEZ
    
    public static void main(String[] args) {
       Scanner leer=new Scanner (System.in);
       int NPas, CDMX=0,Local=0, OtroDest=0;
       
      
        System.out.println("CUANTOS PASAJEROS REGISTRARA?:");
        NPas=leer.nextInt();
        leer.nextLine();
        
        String [] Nom= new String[NPas];
        String [] Dest= new String[NPas];
        
        
        for (int i=0; i<NPas; i++)
        {
            System.out.println("-----------------------------------------------");
            System.out.println("PASAJERO #"+(i+1));
            
            System.out.println("INGRESE NOMBRE:");
            Nom[i]=leer.nextLine();
            
            while (Nom[i].equals(""))
            {
               if(Nom[i].equals(""))
               {
                   System.out.println("ERROR. EL NOMBRE NO PUEDE ESTAR VACIO");
               }
                System.out.println("INGRESE NUEVAMENTE:");
                Nom[i]=leer.nextLine();
            }
             System.out.println("INGRESE DESTINO:");
             Dest[i]=leer.nextLine();
        }
        
         System.out.println("---------------LISTA DE PASAJEROS---------------");
         
         int j=0;
         for (String NOMBRE:Nom)
         {
            String DESTINO=Dest[j];
              System.out.println("--   --    --     --    --     --    --    --");
             System.out.println("NOMBRE:"+NOMBRE+  "  DESTINO:"+DESTINO); 
             
             
             //AGREGUE EL .equalsIgnoreCase POR QUE EN CASO DE QUE PONGA EN MAYUSCULA O MINUSCULA EL DESTINO, LO PUEDA LEER Y QUE SE REGISTRE EN EL QUE CORRESPONDE.
               if (Dest[j].equalsIgnoreCase("CDMX"))  
             {
                 System.out.println("VIAJE LARGO");
                 CDMX++;
             }
             else if (Dest[j].equalsIgnoreCase("Local")) 
             {
                 System.out.println("VIAJE CORTO");
                 Local++;
             }
             else 
             {
                 OtroDest++;
             }
               j++;
         }
         String DestM;
         if (CDMX>=Local && CDMX>= OtroDest)
         {
            DestM="CDMX"; 
         }
         else if (Local>=CDMX && Local>=OtroDest)
         {
             DestM="LOCAL"; 
         }
         else
         {
             DestM="OTROS DESTINOS "; 
         }
 
         System.out.println("-------------RESULTADOS----------------------------");
         System.out.println("PASAJEROS QUE VAN A CDMX:"+CDMX);
         System.out.println("PASAJEROS EN VIAJE LOCAL:"+Local);
         System.out.println("PASAJEROS QUE VAN A OTRO DESTINO:"+OtroDest);
         System.out.println("...................................................");
         System.out.println("DESTINO CON MAS PASAJEROS:"+DestM);
         System.out.println("TOTAL DE PASAJEROS REGISTRADOS:"+NPas);
    }
    
}
