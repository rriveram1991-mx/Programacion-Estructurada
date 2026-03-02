/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arreglo_for_each;

/**
 *
 * @author Ernesto Montalvo
 */
public class Ejemplo3 {
    
  public static void main(String[] args) {

        double[] precios = {19.99, 5.50, 3.75, 12.00};

        float total = (float) (precios[0] + precios[1] + precios[2] + precios[3]);

        System.out.println("Total sin descuento: $" + total);

        double Descuento = total*0.84;

        System.out.println("Total con descuento : $" + Descuento);
    }
}
