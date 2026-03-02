public class Semana5 
{

    public static void main(String[] args) 
    {
        int suma = 0;
        
        int[] precios = {20, 40 , 60, 80, 100};
        for ( int pago : precios)
        {
            
            suma += pago;
            
        }
        System.out.println("El total a pagar es de " + suma);
    }
}