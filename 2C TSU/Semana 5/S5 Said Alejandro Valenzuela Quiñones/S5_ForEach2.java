/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package s5_foreach2;

public class S5_ForEach2 {

    public static void main(String[] args) {
        int[] n = {10, 2, 7, 21, 89, 12};
        int contador = 0;
        
        for(int num : n){
            if (num > 10){
                contador++;
            }
        }
        
        System.out.println("Numeros mayores a 10: " + contador);
    }
    
}
