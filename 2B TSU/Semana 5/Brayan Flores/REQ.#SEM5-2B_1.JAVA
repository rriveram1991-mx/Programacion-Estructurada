 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkgfor.each;

public class EjercicioForEach {
    public static void main(String[] args) {
        System.out.println("==================================");
        double[] precios = {10.50, 5.00, 20.00, 3.25, 15.00};
        double total = 0;

        System.out.println("Calculando el total de la compra...");

        for (double precio : precios) {
            System.out.println("Sumando: $" + precio);
            total += precio; 
        }

        System.out.println("===================================");
        System.out.println("El total de la compra es: $" + total);
    }
}