import java.io.FileWriter;
import java.io.IOException;

public class InventarioErrores {
    public static void main(String[] args) {
        String[] productos = {"Mouse", "Teclado", "Monitor", "USB", "Laptop"};
        double[] precios = {200, 350, 3200, 150, 15000};
        double total = 0;

        // Usamos try-with-resources para cerrar automáticamente el recurso
        try (FileWriter writer = new FileWriter("inventario.txt")) {
            for (int i = 0; i < productos.length; i++) { // Cambiado a i < productos.length
                writer.write("Producto: " + productos[i] + "\n");
                writer.write("Precio: " + precios[i] + "\n");
                total += precios[i]; // Corregido: += en lugar de =+
                if (precios[i] > 1000) {
                    writer.write("Producto caro\n"); // Punto y coma añadido
                }
                writer.write("\n");
            }
            System.out.println("Inventario guardado. Total: " + total);
        } catch (IOException e) {
            System.out.println("Error al crear archivo: " + e.getMessage());
            e.printStackTrace();
        }
        // El cierre se hace automáticamente gracias a try-with-resources
    }
}   