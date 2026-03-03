/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package pkgfor.andarray;
import java.util.Scanner;
/**
 *
 * @author eltan
 */
public class ForAndarray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner leer = new Scanner(System.in);
        int[] pcs ={ 0, 1, 2,3 };
        for (int i=0; i<pcs.length; i++){
            System.out.println("tipo de pc:" + i);
             
        } 
        for(int pc:pcs){
            switch(pc){
                case 0:
                    System.out.println("pc con rtx");
                    break;
                case 1:
                    System.out.println("pc mala");
                    break;
                case 2:
                    System.out.println("pc con 6090 ti");
                    break;
                case 3:
                    System.out.println("pc mas menos");
                    break;
            }
        }
        }
        }
    
    

