/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package req.pkg1.sem5.pkg2e.agfl.sistema2;

import java.util.Scanner;
/**
 *
 * @author gl873
 */
public class REQ1SEM52EAGFLSistema2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner leer = new Scanner(System.in);

        System.out.print("Numero de pasajeros: ");
        int num = leer.nextInt();
        leer.nextLine();

        String[] nom = new String[num];
        String[] des = new String[num];

        for (int i = 0; i < num; i++) {

            System.out.print("Nombre: ");
            nom[i] = leer.nextLine();

            while (nom[i].equals("")) {
                if (nom[i].equals("")) {
                    System.out.print("Nombre vacio, ingrese otra vez: ");
                    nom[i] = leer.nextLine();
                }
            }

            System.out.print("Destino: ");
            des[i] = leer.nextLine();
        }

        System.out.println("\nLista de pasajeros:");

        for (String n : nom) {
            System.out.println(n);
        }

        int cdmx = 0;
        int local = 0;

        for (String d : des) {

            if (d.equals("CDMX")) {
                System.out.println("Viaje largo");
                cdmx++;
            }

            if (d.equals("Local")) {
                System.out.println("Viaje corto");
                local++;
            }
        }

        if (cdmx > local) {
            System.out.println("Destino con mas pasajeros: CDMX");
        } else {
            System.out.println("Destino con mas pasajeros: Local");
        }

        System.out.println("Total pasajeros registrados: " + num);
    }
    
    
}
    
    

