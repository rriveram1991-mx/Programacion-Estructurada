import java.util.Scanner;

public class EjercicioArray2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] frutas = {"Manzana", "Banana", "Naranja", "Uva", "Mango"};

        System.out.println("Frutas disponibles:");

        System.out.println("Fruta 1: " + frutas[0] + "\n" +
            "Fruta 2: " + frutas[1] + "\n" + 
            "Fruta 3: " + frutas[2] + "\n" + 
            "Fruta 4: " + frutas[3] + "\n" +
            "Fruta 5: " + frutas[4]
        );
        System.out.println("Seleccione la fruta que comprara");
        
        int eleccion = sc.nextInt();

        if (eleccion >= 1 && eleccion <= frutas.length) {
            System.out.println("Elegiste: " + frutas[eleccion - 1] + "\nDisfrute de su compra");
        } else {
            System.out.println("Numero de fruta no valido");
        }

        sc.close();
    }
}
