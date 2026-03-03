import java.util.Scanner;

public class EjercicioArray1 {
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] dinero = {50,100,200,300,400};

        System.out.println("BANCO");

        System.out.println("Opcion 1: " + dinero[0] + "\n" +
            "Opcion 2: " + dinero[1] + "\n" + 
            "Opcion 3: " + dinero[2] + "\n" + 
            "Opcion 4: " + dinero[3] + "\n" +
            "Opcion 5: " + dinero[4] + "\nIndique la cantidad de dinero que va sacar"
        );

        int eleccion = sc.nextInt();

        if (eleccion >= 1 && eleccion <= dinero.length) {
            System.out.println("Retiraste: " + dinero[eleccion - 1] + "\nDisfrute de su dinero");
        } else {
            System.out.println("Numero de opcion invalido");
        }

        sc.close();
    }
}
