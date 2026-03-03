import java.util.Scanner;

public class EjercicioFor1 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] lista = {"Leche", "Pan", "Huevos", "Manzanas", "Arroz", "Pollo"};

        System.out.println("Lista del súper:");

        int numero = 1;
        for (String producto : lista) {
            System.out.println("Opcion " + numero + ": " + producto);
            numero++; 
        }

        System.out.println("Selecciona el producto a comprar:");
        int eleccion = sc.nextInt();

        if (eleccion >= 1 && eleccion <= lista.length) {
            System.out.println("Compraste: " + lista[eleccion - 1]);
        } else {
            System.out.println("Opcion no valida");
        }

        sc.close();
    }
}