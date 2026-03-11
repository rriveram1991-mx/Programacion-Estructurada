/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cine;
import java.util.Scanner;
/**
 *
 * @author pecha
 */
public class Cine {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int [][] asientos = new int [6][6];
               String libre = "Asiento disponible",ocupado = "Asiento no dispoble",a;
        System.out.println("Asientos");

        System.out.println("Fila "  + " Columna " );
        for(int y = 0; y < asientos.length; y++){
            for(int x = 0;x < asientos[y].length; x++ ){
                
                if (asientos[y][x] == 0) {
                     a = libre;
                } else {
                    a = ocupado;
                }
               
                System.out.println(" "+ ( y+1  ) + "       " + (    x+1)+" ----- " + a);
            }
            
        }
        System.out.println("Elige la fila:");
        int f = sc.nextInt();
        System.out.println("Elige la columna");
        int col = sc.nextInt();
        
        f --;
        col --;
        int wi = 0;
        while (wi == 0) {
            if (f < 0 || f >= asientos.length || col < 0 || col >= asientos[0].length) {
                System.out.println("Valor no valido");
                System.out.println("Elige la fila:");
                f = sc.nextInt();
                System.out.println("Elige la columna");
                col = sc.nextInt();
                f --;
                col --;
            } else if(asientos[f][col] == 1){
                System.out.println("El lugar "+(f+1)+ "," +(col+1)+" no esta disponible");
                System.out.println("Elige la fila:");
                f = sc.nextInt();
                System.out.println("Elige la columna");
                col = sc.nextInt();
                f --;
                col --;
            } else {
                asientos[f][col] = 1;
                System.out.println("Lugar "+(f+1)+ ""+(col+1)+" elegido correctamente");
                wi = 1;
            }
            
        }
        
    }
        
}
