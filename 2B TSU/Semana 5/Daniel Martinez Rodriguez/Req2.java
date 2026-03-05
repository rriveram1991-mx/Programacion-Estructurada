import java.util.Scanner;

public class Req2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
       
        int pasa,contaloc=0,contacd = 0 , i , j;

        System.out.println("Ingrese el numero de pasajeros ");
        pasa=scan.nextInt();
         String[] nombres = new String[pasa];
         String [] destinos = new String[pasa];
         scan.nextLine();

         for (i = 0; i < nombres.length; i++) {
             System.out.println("Ingresa el nombre del pasajero " + (i + 1));
             nombres[i] = scan.nextLine();

             while (nombres[i].trim().isEmpty()) {
                 System.out.println("El nombre no puede estar vacío. Intente de nuevo:");
                 nombres[i] = scan.nextLine();
             }
         }
         for ( j =0 ; j < destinos.length; j++){
            System.out.println("Pasajero " + nombres[j] + " ¿Cual es su destino? (CDMX) o (Local)");
            destinos[j] = scan.nextLine();
            if (destinos[j].equalsIgnoreCase("CDMX")){
                contacd++;
            }
            else {
                contaloc++;
            }
         }

         System.out.println("=============================================");
         int k = 0;
         for (String name : nombres) {
             System.out.println("El pasajero " + name + " se dirige a " + destinos[k]);
             k++;
         }
         System.out.println("=============================================");
         System.out.println("el total de viajes a la CDMX fue de "+ contacd);
         System.out.println("El total de los viajes locales fue de "+ contaloc );
         scan.close();






        


    }
    
}
