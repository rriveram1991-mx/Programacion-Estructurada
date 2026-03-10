/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package req.pkg2.sem6.pkg2b.avr;
import java.util.Scanner;
/**
 *
 * @author adrianvalenzuelaramirez
 */
public class REQ2SEM62BAVR {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        // definimos una sala de 5 filas y 6 columnas
        char[][] sala = new char[5][6];

        // llenar la sala inicialmente
        for (int f = 0; f < 5; f++) {
            for (int c = 0; c < 6; c++) {
                sala[f][c] = 'L';
            }
        }

        System.out.println("=== bienvenido a cine adrian ===");
        
        // simulación de una compra
        System.out.print("¿qué fila desea? (0-4): ");
        int fila = sc.nextInt();
        System.out.print("¿qué asiento desea? (0-5): ");
        int asiento = sc.nextInt();

        // validación de coordenadas y disponibilidad
        if (fila >= 0 && fila < 5 && asiento >= 0 && asiento < 6) {
            if (sala[fila][asiento] == 'L') {
                sala[fila][asiento] = 'X'; 
                System.out.println("asiento reservado con éxito.");
            } else {
                System.out.println("el asiento ya está ocupado.");
            }
        } else {
            System.out.println("coordenadas fuera de rango.");
        }

        // mostrar mapa de la sala usando for-each anidado
        System.out.println("\n--- MAPA DE LA SALA (L=Libre, X=Ocupado) ---");
        for (char[] filaActual : sala) {
            for (char silla : filaActual) {
                System.out.print("[" + silla + "] ");
            }
            System.out.println(); 
        }
    }
}