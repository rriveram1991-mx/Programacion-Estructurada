* @author nohemi
 */
public class Errores {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

        double[] ventas = new double[6];
        double total = 0;
        double mayor = 0;

        // Captura de ventas
        //se quita el =
        for (int i = 0; i < ventas.length; i++) {

            System.out.println("Ingrese venta #" + (i + 1) + ": ");
            ventas[i] = sc.nextDouble();

            while (ventas[i] < 0) {
                System.out.println("No se permiten ventas negativas. Intente de nuevo:");
                ventas[i] = sc.nextDouble();
            }
        }

        // Calcular total y mayor
        for (double v : ventas) {
            //se agrega el +
            total += v;

            if (v > mayor) {
                //se pone v en lugar de ventas[0]
                mayor = v;
            }
        }

        double promedio = total / ventas.length;

        // Contar ventas mayores al promedio
        int contador = 0;
        int j = 0;
         //se quita el =
        while (j < ventas.length) {

            if (ventas[j] > promedio) {
                contador++;
            }
            j++;
            //se agrga contadorr
        }

        if (contador > 0)
            System.out.println("Hay ventas mayores al promedio");

        System.out.println("Total vendido: " + total);
        System.out.println("Promedio: " + promedio);
        System.out.println("Venta mayor: " + mayor);
        System.out.println("Cantidad mayores al promedio: " + contador);
    }
}
















