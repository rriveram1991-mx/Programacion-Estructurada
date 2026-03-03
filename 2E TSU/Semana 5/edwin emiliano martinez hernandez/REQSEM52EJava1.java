/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package reqsem5.pkg2e.java1;

/**
 *
 * @author edwin
 */
public class REQSEM52EJava1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      int[] numeros = {5, 10, 15, 20, 25};
        int suma = 0;

        System.out.println("Numeros del arreglo:");

        for (int num : numeros) {
            System.out.println(num);
            suma += num;
        }

        System.out.println("La suma total es: " + suma);
    }
    }
    

