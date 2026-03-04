/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package s5_arrays;

public class S5_Arrays {

    public static void main(String[] args) {
        int[] n = {10, 9, 78, 5, 89, 1, 120};
        int max = n[0];
        int min = n[0];
        
        for(int i = 1; i < n.length; i++){
            if(n[i] > max){
                max = n[i];
            }
            if(n[i] < min){
                min = n[i];
            }
        }
        
        System.out.println("Numero mayor: " + max);
        System.out.println("Numero menor: " + min);
    }
    
}
