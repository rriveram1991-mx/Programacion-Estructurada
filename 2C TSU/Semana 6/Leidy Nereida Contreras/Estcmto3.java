/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package estcmto;
import java.util.Scanner;

/**
 *
 * @author leidy
 */
public class Estcmto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
   Scanner read=new Scanner(System.in);
   String op = null;
        String[][] estacionamiento = {
            {"E1","E2","E3","E4"},
            {"F1","F2","F3","F4"},
            {"G1","G2","G3","G4"}
        };


        for (int i = 0; i < estacionamiento.length; i++) {
            for (int j = 0; j < estacionamiento[i].length; j++) {
                System.out.print(estacionamiento[i][j] + " ");
            }
                System.out.println("");
            
            }
        
    
    
boolean encontrado = false;
        for (int i = 0; i < estacionamiento.length; i++) {
            for (int j = 0; j < estacionamiento[i].length; j++) {
                if (estacionamiento[i][j].equals(op)) {
                    estacionamiento[i][j] = "X"; 
                    encontrado = true;
                }

        }
             if (encontrado) {
            System.out.println("ESPACIO " + op + " RESERVADO CORRECTAMENTE");
        } else {
            System.out.println(" EL ESPACIO NO EXISTE");
        }

      

        }}}

