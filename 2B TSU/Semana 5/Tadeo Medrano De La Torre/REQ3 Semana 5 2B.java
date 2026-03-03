/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package pkgfor.each.y.array;
import java.util.Scanner;
/**
 *
 * @author eltan
 */
public class ForEachYArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner leer = new Scanner(System.in);
        //declaracion del array
        int[] perros = new int[4];
        //uso de for para usarlo
        for(int i=0; i<perros.length; i++){
            switch(i)
            {
                case 0:
                    System.out.println("chano");
                    break;
                case 1:
                    System.out.println("chon");
                    break;
                case 2:
                    System.out.println("covi");
                    break;
                case 3:
                    System.out.println("pokyhs");
                    break;
                default: System.out.println("no hay otro perro");
            }
             
        }
        }
    }
    
    

