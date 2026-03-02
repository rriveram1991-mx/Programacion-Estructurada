/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package req.sem5.pkg2e.java_2;

import java.util.Scanner;

/**
 *
 * @author lalit
 */
public class REQSEM52EJAVA_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

        String[] nombres = {"Gerardo", "Leonardo", "Eduardo", "Paola", "Vaca"};
        boolean encontrado = false;

        System.out.print("Ingresa un nombre a buscar: ");
        String buscar = sc.nextLine();

        for (String nombre : nombres) {
            if (nombre.equalsIgnoreCase(buscar)) {
                encontrado = true;
                break;
            }
        }

        if (encontrado) {
            System.out.println("El nombre SI esta en el arreglo.");
        } else {
            System.out.println("El nombre NO esta en el arreglo.");
        }
    }
}