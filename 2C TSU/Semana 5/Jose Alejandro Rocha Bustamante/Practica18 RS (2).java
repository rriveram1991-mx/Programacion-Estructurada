import java.util.Scanner;
public class Practica18 {
    private static int j;

    public static void main(String[]args){
        Scanner leer = new Scanner(System.in);
        String nombre;
        String destino;
        int pasajeros = 0;
        int p = 0;
        int m = 0;
        System.out.println("== Registro de Viajes ==");
        System.out.println("== Ingrese la cantidad de pasajeros ==");
        pasajeros = leer.nextInt();
        for (int i = 1; i <= pasajeros; i++) {
            System.out.println("Ingrese el nombre del pasajero #" + i + ": ");
            nombre = leer.next();

            while (nombre.isEmpty()){
                if (nombre.isEmpty()) {
                    System.out.println("== El nombre vacío. Ingrese nombre del pasajero #" + i + ": ");
                    nombre = leer.next();
                }
            }
            System.out.println("Ingrese el destino del pasajero #" + i + ": ");
            destino = leer.next();
            if(destino.equalsIgnoreCase("CDMX")){
                System.out.println("== Viaje largo ==");
                p++;
            } else if(destino.equalsIgnoreCase("Local")){
                System.out.println("== Viaje corto ==");
                m++;
            }
            for (j = 0; j < 1; j++) {
               System.out.println("Pasajero #" + i + ": " + nombre + " con destino a " + destino);
            }
        }
     
        System.out.println("Destino con más pasajeros ");
        if(p > m){
            System.out.println("CDMX");
        } else if(m > p){
            System.out.println("Local");
        } else {
            System.out.println("Empate");
        }
        System.out.println("Total de pasajeros fueron: " + pasajeros);
    leer.close();
    }
}
