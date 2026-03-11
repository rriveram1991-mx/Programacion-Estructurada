/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cine;
import java.util.Scanner;
/**
 *
 * @author leidy
 */
public class Cine {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    
    Scanner read = new Scanner(System.in);

        String[][] asientos = {
            {"C21","C22","C23","C24","C25","C26","C27","C28","C29","C30"},
            {"D31","D32","D33","D34","D35","D36","D37","D38","D39","D40"},
            {"E41","E42","E43","E44","E45","E46","E47","E48","E49","E50"}
        };

        System.out.println("FAVOR DE SELECCIONAR CANTIDAD DE ASIENTOS");
        int n = read.nextInt();
        read.nextLine(); 

        while (n != 0) {
            System.out.println("Seleccione el asiento: ");
            String asientoselecc = read.nextLine();
            boolean aqui = false;


            for (int i = 0; i < asientos.length; i++) {
                for (int j = 0; j < asientos[i].length; j++) {
                    if (asientos[i][j].equals(asientoselecc)) {
                        asientos[i][j] = "X"; //
                        aqui = true;
                        break;
                    }
                }
            }

            if (aqui) {
                System.out.println(" ASIENTO " + asientoselecc + " RESERVADO CORRECTAMENTE");
            } else {
                System.out.println("EL ASIENTO NO EXISTE/O NO ESTA DISPONIBLE");
            }

          
            mostrarAsientos(asientos);

            n--; 
        }
    }

    public static void mostrarAsientos(String[][] asientos) {
        for (int i = 0; i < asientos.length; i++) {
            for (int j = 0; j < asientos[i].length; j++) {
                System.out.print(asientos[i][j] + " ");
            }
            System.out.println(); 
        }
    }
}

