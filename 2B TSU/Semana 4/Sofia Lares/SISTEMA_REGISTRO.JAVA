import java.util.Scanner;

public class SISTEMA_REGISTRO 
{

    public static void main(String[] args) 
    {
        Scanner leer = new Scanner(System.in);

        String usuario = "sofi";
        int clave = 1234;
        int intentos = 0;
        boolean entro = false;
        
            while (intentos < 3 && entro == false) 
            {
            System.out.println("Introduce usuario:");
            String usuario1 = leer.next();

            System.out.println("Introduce contraseña:");
            int claveIngresada = leer.nextInt();

         
            if (usuario1.equals(usuario) && claveIngresada == clave) 
            {
                entro = true;
            } 
            else 
            {
                intentos = intentos + 1; 
                System.out.println("Error. Llevas " + intentos + " intento(s) fallido(s).");
            }
        }

     
        if (entro == true) 
        {
            System.out.println("ACCESO CONCEDIDO");
            
         for (int i = 1; i <= 1; i++) 
            {
                 System.out.println("1-Consultar saldo");
                 System.out.println("2-Depositar");
                 System.out.println("3-Retirar");
                 System.out.println("4-Salir");
            }
        } 
        else 
        {
            System.out.println("Cuenta bloqueada, por exceso de intentos");
        }
    }
}