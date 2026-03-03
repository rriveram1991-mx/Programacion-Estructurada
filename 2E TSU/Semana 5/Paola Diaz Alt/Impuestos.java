//paola geraldine diaz altamira
public class Impuestos {
    public static void main(String[] args) {
        double[] preciosBase = {100.0, 250.50, 50.0, 1200.0};
        double impuesto = 1.15; 

        System.out.println("Precios finales con IVA:");
        for (double precio : preciosBase) {
            System.out.println("$" + (precio * impuesto));
        }
    }
}