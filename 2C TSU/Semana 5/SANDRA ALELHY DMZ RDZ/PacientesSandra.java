
package pacientes.sandra;

import java.util.Scanner;

public class PacientesSandra {
//SANDRA DOMINGUEZ
    
    public static void main(String[] args) {
       Scanner leer =new Scanner (System.in);
       int Pac, Men=0,Adul=0,AdulM=0, Prio=0;
      
        System.out.println("CUANTOS PACIENTES REGISTRARA?:");
        Pac=leer.nextInt();
        
        int[] EDAD = new int[Pac];
        String [] Nom= new String[Pac];
        
        for (int i=0; i<Pac; i++)
        {
            System.out.println("-----------------------------------------------");
            System.out.println("PACIENTE #"+(i+1));
                  leer.nextLine();
            System.out.println("INGRESE NOMBRE:");
            Nom[i]=leer.nextLine();
            
            System.out.println("INGRESE EDAD:");
            EDAD[i]=leer.nextInt();
          
            
            while (EDAD[i]<0 || EDAD[i]>120)
            {
               if(EDAD[i]<0 || EDAD[i]>120)
               {
                   System.out.println("EDAD INVALIDAD. DEBE ESTAR ENTRE 0 Y 120");
               }
                System.out.println("INGRESE NUEVAMENTE:");
                EDAD[i]=leer.nextInt();
            }
        }
        
         System.out.println("---------------PACIENTES REGISTRADOS---------------");
         
         int j=0;
         for (String NOMBRE:Nom)
         {
             int EDADES=EDAD[j];
              System.out.println("--   --    --     --    --     --    --    --");
             System.out.println("NOMBRE:"+NOMBRE+  "  EDAD:"+EDADES); 
             
               if (EDAD[j]<18)
             {
                 Men++;
             }
             else if (EDAD[j]>=18 && EDAD[j]<=59) 
             {
                 Adul++;
             }
             else 
             {
                 AdulM++;
                 Prio++;
                 System.out.println("PACIENTE PRIORITARIO");
             }
               j++;

         }
 
         System.out.println("-------------RESULTADOS----------------------------");
         System.out.println("MENORES DE EDAD:"+Men);
         System.out.println("ADULTOS (18-59):"+Adul);
         System.out.println("ADULTOS MAYORES (60+):"+AdulM);
         System.out.println("TOTAL PACIENTES PRIORITARIOS:"+Prio);        
    }
    
}
