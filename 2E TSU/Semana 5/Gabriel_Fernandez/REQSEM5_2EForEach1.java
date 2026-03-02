/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package reqsem5_2eforeach1;

/**
 *
 * @author gl873
 */
public class REQSEM5_2EForEach1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
     
        int[] numeros = {2, 8, 3, 17, 7, 20};
        int pares = 0;

        for (int n : numeros) {
        if (n % 2 == 0) {
        pares++;
                        }
        }

     System.out.println("Cantidad de números pares: " + pares);

    }
    }
    

