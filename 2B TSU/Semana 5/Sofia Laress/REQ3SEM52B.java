public class EjercicioSem5 
{

    public static void main(String[] args) 
    {
       
        int[] edades = {15, 20, 17, 40, 14, 18};

        System.out.println("Lista de personas mayores de edad:");

        
        for (int edad : edades) 
        {
     
            if (edad >= 18) 
            { 
                
                System.out.println("Edad permitida: " + edad);
            }
        }
    }
}
_