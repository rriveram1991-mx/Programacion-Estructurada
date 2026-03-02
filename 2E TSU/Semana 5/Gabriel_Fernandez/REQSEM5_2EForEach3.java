/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package reqsem5_2eforeach3;

/**
 *
 * @author gl873
 */
public class REQSEM5_2EForEach3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      int[] tabla = {1,2,3,4,5,6,7,8,9,10};
      int numero = 7;

      for (int num : tabla) {
      System.out.println(numero + " x " + num + " = " + (numero * num));
                          }
    }
    
}
