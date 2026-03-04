/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package s5_foreach;

public class S5_ForEach {

    public static void main(String[] args) {
        int[] n = {1, 2, 3, 4, 5, 6};
        int suma = 0;
        
        for(int num : n){
            suma += num;
        }
        
        System.out.println("Suma total: " + suma);
    }
    
}
