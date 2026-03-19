/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pokemones.rto.pkg2.sem7;

import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.*;

/**
 *
 * @author jasun
 */
public class PokemonesRTO2SEM7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        String[][]pokemones=new String [2][3];
        int [][]hp=new int [2][3];
        int [][]ataque=new int [2][3];
        String[]jugador=new String [2];
        
        
        for(int j=0;j<2;j++) {
            System.out.println("\nJugador #"+(j+1));
            System.out.println("Nombre del entrenador:");
            jugador[j]=sc.next();
            while (jugador[j].isEmpty()){
                    System.out.println("Error al ingresar el nombre, ingreselo de nuevo");
                    jugador[j]=sc.next();
                }
            System.out.println("Registre a sus 3 pokemones para la batalla");
            for (int i=0;i<3;i++) {
                System.out.println("Pokemon #"+(i+1));
                pokemones[j][i]=sc.next();
                while (pokemones[j][i].isEmpty()){
                    System.out.println("Error al ingresar al pokemon, ingreselo de nuevo");
                    pokemones[j][i]=sc.next();
                }
                System.out.println("Vida del pokemon "+(pokemones[j][i]));
                hp[j][i]=sc.nextInt();
                while (hp[j][i]<0){
                    System.out.println("Vida negativa, ingresela de nuevo");
                    hp[j][i]=sc.nextInt();
                }
                System.out.println("Ataque del pokemon "+(pokemones[j][i]));
                ataque[j][i]=sc.nextInt();
                while (ataque[j][i]<0){
                    System.out.println("Ataque negativo, ingreselo de nuevo");
                    ataque[j][i]=sc.nextInt();
                }
            }
        }
        
        for(int i=0;i<2;i++) {
            System.out.println("\nPokemones de "+(jugador[i]));
            for(int j=0;j<3;j++) {
            System.out.println("\n"+pokemones[i][j]);
            System.out.println("HP: "+(hp[i][j]));
            System.out.println("Ataque: "+(ataque[i][j]));
            }
        }
        boolean[] jugpok = {true, true};
        int[] seleccion = {-1, -1};

        while (jugpok[0] && jugpok[1]) {

            for (int j = 0; j < 2; j++) {
            System.out.println("\n" + jugador[j] + ", elige tu Pokemon:");
            for (int i = 0; i < 3; i++) {
                if (hp[j][i] > 0) {
                System.out.println((i+1) + ": " + pokemones[j][i] + " (HP: " + hp[j][i] + ")");
                }
            }
            seleccion[j] = sc.nextInt() -1;
            while (seleccion[j]<0 || seleccion[j]>2){
                    System.out.println("Error al escoger pokemon, escogalo de nuevo");
                    seleccion[j]=sc.nextInt() -1;
                }
        }
        int atk1 = seleccion[0];
            int def1 = seleccion[1];
            hp[1][def1] -= ataque[0][atk1];
            if (hp[1][def1] < 0) hp[1][def1] = 0;
            System.out.println("\n" + pokemones[0][atk1] + " ataca!");
            System.out.println(pokemones[1][def1] + " pierde " + ataque[0][atk1] + " de vida. Vida restante: " + hp[1][def1]);

            if (hp[1][def1] == 0) {
                System.out.println(pokemones[1][def1] + " ha sido derrotado!");
            }

            if (hp[1][def1] > 0) {
                int atk2 = seleccion[1];
                int def2 = seleccion[0];
                hp[0][def2] -= ataque[1][atk2];
                if (hp[0][def2] < 0) hp[0][def2] = 0;
                System.out.println("\n" + pokemones[1][atk2] + " ataca!");
                System.out.println(pokemones[0][def2] + " pierde " + ataque[1][atk2] + " de vida. Vida restante: " + hp[0][def2]);

                if (hp[0][def2] == 0) {
                    System.out.println(pokemones[0][def2] + " ha sido derrotado!");
                }
            }

            for (int j = 0; j < 2; j++) {
                jugpok[j] = false;
                for (int i = 0; i < 3; i++) {
                    if (hp[j][i] > 0) {
                        jugpok[j] = true;
                        break;
                    }
                }
            }
        }

        String ganador;
        if (jugpok[0]) {
            System.out.println("\n" + jugador[0] + " gana la batalla!");
            ganador = jugador[0];
        } else {
            System.out.println("\n" + jugador[1] + " gana la batalla!");
            ganador=jugador[1];
        }
        
        ImageIcon original = new ImageIcon(PokemonesRTO2SEM7.class.getResource("med.png"));

        ImageIcon med = new ImageIcon(original.getImage().getScaledInstance(300, 300, java.awt.Image.SCALE_SMOOTH));

        JLabel label = new JLabel("¡Aquí tienes tu medalla de entrenador por ganar, " + ganador + "!", med, JLabel.CENTER);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.BOTTOM);

        JFrame frame = new JFrame("¡Victoria!");
        frame.add(label);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }  
}