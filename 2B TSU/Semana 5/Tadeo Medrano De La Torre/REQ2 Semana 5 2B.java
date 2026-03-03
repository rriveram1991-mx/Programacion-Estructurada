/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkgfor.each;
import java.util.Scanner;
/**
 *
 * @author eltan
 */
public class ForEach {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner leer = new Scanner(System.in);
        String[] panes ={"polvoron", "cocha", "Dona" };
        for(String pan:panes){
            System.out.println("tipo:" + pan);
        }
    }
    
}
