public class VENTAS 
{

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        double[] ventas = new double[6];
        double total = 0;
        double mayor = 0;

        // Captura de ventas
        for (int i = 0; i < ventas.length; i++) 
        { // Corregido: i < ventas.length
            System.out.print("Ingrese venta #" + (i + 1) + ": ");
            ventas[i] = sc.nextDouble();

            while (ventas[i] < 0) {
                System.out.println("No se permiten ventas negativas. Intente de nuevo:");
                ventas[i] = sc.nextDouble();
            }
        }

        // Calcular total y mayor
        for (double v : ventas) {
            total += v; // Acumular con +=

            if (v > mayor) {
                mayor = v; //Asignar el valor actual v
            }
        }

        double promedio = total / ventas.length;

        // Contar ventas mayores al promedio
        int contador = 0;
        int j = 0;

        while (j < ventas.length) { // j < ventas.length
            if (ventas[j] > promedio) {
                contador++;
            }
            j++; // Incrementar j para evitar bucle infinito
        }

        // Salida de resultados
        System.out.println("\n--- REPORTE DE VENTAS ---");
        if (contador > 0) {
            System.out.println("Hay ventas mayores al promedio.");
        }

        System.out.println("Total vendido: $" + total);
        System.out.println("Promedio: $" + promedio);
        System.out.println("Venta mayor registrada: $" + mayor);
        System.out.println("Cantidad de ventas sobre el promedio: " + contador);
        
       
    }
}