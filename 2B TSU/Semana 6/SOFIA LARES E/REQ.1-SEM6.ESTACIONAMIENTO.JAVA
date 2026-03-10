public class Estacionamiento 
{

    public static void main(String[] args) 
    {
    
        
        String[][] lugar = {
            {"A", "B"},
            {"C", "D"}
        };

        System.out.println("=== MI ESTACIONAMIENTO ===");
        System.out.println("| " + lugar[0][0] + " | " + lugar[0][1] + " |");
        System.out.println("-------------");
        
    
        System.out.println("| " + lugar[1][0] + " | " + lugar[1][1] + " |");
        
        System.out.println("==========================");
        System.out.println("¡Lugar A es el mas cercano!");
    }
}