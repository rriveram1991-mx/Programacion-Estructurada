/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package calificaciónerror;

import java.util.Scanner;

/**
 *
 * @author emili
 */
public class Calificaciónerror {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
        int calificacion = sc.nextInt();
        if (calificacion > 100 || calificacion < 0){
            System.out.println("Calificacion inválida");
            return;
        }
        switch (calificacion / 10) {
            case 10:
            case 9:
                System.out.println("Excelente");
                break;
            case 8:
                System.out.println("Bueno");
                break;
            case 7:
                System.out.println("Regular");
                break;
            case 6:
                System.out.println("Suficiente");
                break;
            default:
                System.out.println("Reprobado");
        }
    }
}