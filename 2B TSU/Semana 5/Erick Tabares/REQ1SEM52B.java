import java.util.Scanner;

public class REQ1SEM52B
{

    public static void main(String[] args) 
    {

        Scanner sc = new Scanner(System.in);

        int pacientes,  i=0 , prioritarios= 0 , mayor =0, menor=0 , adult=0;

        System.out.println("------------------------------------------------------------------");
        System.out.println("\n                 - Registro de pacientes -");
        System.out.println("\n     Ingrese el número de pacientes que seran registrados : \n");
        pacientes = sc.nextInt();
        System.out.println("\n------------------------------------------------------------------");

        String[] nombres = new String [pacientes];
        int[] edades = new int [pacientes] ;

        for (i = 0; i < pacientes; i++) 
        {
        System.out.println("\n                      Datos del paciente #" + (i+1) + " :\n");
        System.out.println("Nombre : ");
        nombres[i] = sc.next();
        System.out.println("\nEdad   : ");
        edades[i] = sc.nextInt();

        while (edades[i] < 0 || edades[i] > 120) 
        {

            System.out.println("\nEdad inválida. Intente nuevamente : ");
            System.out.println("Ingrese la edad : ");   
            edades[i] = sc.nextInt();
            
        }

        System.out.println("\n------------------------------------------------------------------\n");

        if (edades[i] <18 )
        {
            menor ++ ; 
        }
        else
            if (edades[i]>= 18 && edades[i]<=59) 
                {
                    adult ++;
            }else
                if (edades[i]>=60) 
                    {
                    mayor ++;
                    prioritarios++;
                }

    }
    
    System.out.println("                       - Estadisticas - ");
    System.out.println("\n                Pacientes menores de edad : " + menor);
    System.out.println("\n                    Pacientes adultos : " + adult);
    System.out.println("\n            Pacientes adultos mayores de 60 años: " + mayor);
    System.out.println("\n------------------------------------------------------------------\n");
    

    System.out.println("                      - Lista de pacientes -\n");
     System.out.println("\n-------------------                          --------------------\n");
    i= 0 ;
for (String nombre : nombres) 
    {
    
    System.out.println("                        - Paciente #" + (i+1)+ " -\n");
    System.out.println("Nombre : " + nombre);
    System.out.println("Edad   : " + edades[i]);
    i++;
    System.out.println("\n------------------------------------------------------------------\n");

}
 System.out.println("\n           - Pacientes de prioridad (60 años o más) -\n");
 System.out.println("                Pacientes prioritarios : " + prioritarios+"\n");
 System.out.println("-------------------                          --------------------\n");
        i = 0;
        for (String nombre : nombres) 
        {
            if (edades[i] >= 60) {
                System.out.println("                        - Paciente #" + (i+1)+ " -\n");
                System.out.println("Nombre : " + nombre);
                System.out.println("Edad   : " + edades[i]);
                System.out.println("\n------------------------------------------------------------------\n");

            }
            i++;

        }

sc.close();

    }
}

    


