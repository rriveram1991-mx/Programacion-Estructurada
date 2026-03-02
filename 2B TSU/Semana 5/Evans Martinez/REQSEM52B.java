import java.util.Scanner;

public class REQSEM52B {
    public static void main(String[] args) {    
Scanner sc = new Scanner(System.in);


        // --- 1. CONTROL DE INVENTARIO ---
        System.out.println("--- Inventario de Tienda ---");
        // Declaré mi arreglo de strings con los productos básicos.
        String[] productos = {"Laptop", "Mouse", "Teclado", "Monitor", "Audífonos"};
        
        int contador = 1;
        // Usé for-each para no liarme con los índices [i]. 
        // El ciclo extrae cada 'p' (producto) de la lista automáticamente.
        for (String p : productos) {
            System.out.println(contador + ". Producto en stock: " + p);
            contador++;
        }
        System.out.println();
    }}