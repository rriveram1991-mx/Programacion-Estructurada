/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pokemon;

import java.util.Scanner;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
/**
 *
 * @author emili
 */
public class Pokemon {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
Scanner dig = new Scanner (System.in);
String pok[][]=new String[2][3];
int hp[][]=new int[2][3];
int ata[][]=new int[2][3];
for (int j = 0; j < 2; j++) {
    System.out.println("JUGADOR " + (j + 1) );
    for (int i = 0; i < 3; i++) {
        System.out.print("Nombre Pokemon " + (i + 1) + ": ");
        pok[j][i] = dig.next();
        System.out.print("HP: ");
        hp[j][i] = dig.nextInt();
        System.out.print("Ataque: ");
        ata[j][i] = dig.nextInt();
    }
}
int p1 = 0;
int p2 = 0; 
System.out.println("COMIENZA LA BATALLA!");
while (p1 < 3 && p2 < 3) {
    System.out.println("" + pok[0][p1] + " vs " + pok[1][p2]);
    hp[1][p2] -= ata[0][p1];
    System.out.println(pok[0][p1] + " ataca! " + pok[1][p2] + " queda con " + Math.max(0, hp[1][p2]) + " HP.");
    if (hp[1][p2] <= 0) {
        System.out.println(pok[1][p2] + " ha sido derrotado!");
        p2++;
    } else {
        hp[0][p1] -= ata[1][p2];
        System.out.println(pok[1][p2] + " contraataca! " + pok[0][p1] + " queda con " + Math.max(0, hp[0][p1]) + " HP.");
        if (hp[0][p1] <= 0) {
            System.out.println(pok[0][p1] + " ha sido derrotado!");
            p1++; 
        }
    }
}
if (p1 < 3) {
    System.out.println("¡EL JUGADOR 1 ES EL GANADOR!");
    for(int k = 0; k < 3; k++) {
        Toolkit.getDefaultToolkit().beep(); 
        try { Thread.sleep(300); } catch (Exception e) {}    
    }
ImageIcon iconoGif = new ImageIcon("2DV.gif");
JOptionPane.showMessageDialog(
    null, 
    "¡FELICIDADES " + "!Eres el nuevo Maestro Pokémon.", 
    "FIN DE LA BATALLA", 
    JOptionPane.PLAIN_MESSAGE, 
    iconoGif
);
    
} else {
    System.out.println("¡EL JUGADOR 2 ES EL GANADOR!");
    for(int k = 0; k < 3; k++) {
        Toolkit.getDefaultToolkit().beep(); 
        try { Thread.sleep(300); } catch (Exception e) {} 
    }
    ImageIcon iconoGif = new ImageIcon("2DV.gif");
    JOptionPane.showMessageDialog(
    null, 
    "¡FELICIDADES " + "!Eres el nuevo Maestro Pokémon.", 
    "FIN DE LA BATALLA", 
    JOptionPane.PLAIN_MESSAGE, 
    iconoGif
);
}
}
    }

    

