/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package s5_foreach3;

public class S5_ForEach3 {

    public static void main(String[] args) {
        double[] precios = {99.99, 149.50, 250.00, 75.25};
        double total = 0;

        for (double precio : precios) {
            total += precio;
        }

        System.out.println("Total a pagar: $" + total);
    }
    
}
