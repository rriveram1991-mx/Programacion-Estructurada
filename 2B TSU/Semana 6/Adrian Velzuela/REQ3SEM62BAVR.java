/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package req.pkg3.sem6.pkg2b.avr;
  import java.util.Scanner;
/**
 *
 * @author adrianvalenzuelaramirez
 */
public class REQ3SEM62BAVR {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        // estacionamiento de 3 niveles y 4 cajones por nivel
        String[][] parking = new String[3][4];

        // inicializar estacionamiento
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                parking[i][j] = "vacio";
            }
        }

        System.out.println("=== sistema de parking ===");
        
        // registrar un auto
        System.out.print("ingrese el nivel (0-2): ");
        int nivel = sc.nextInt();
        System.out.print("ingrese el cajón (0-3): ");
        int cajon = sc.nextInt();
        System.out.print("ingrese la placa del auto: ");
        String placa = sc.next();

        // lógica de registro
        if (nivel >= 0 && nivel < 3 && cajon >= 0 && cajon < 4) {
            if (parking[nivel][cajon].equals("vacio")) {
                parking[nivel][cajon] = placa;
                System.out.println("auto registrado en nivel " + nivel + ", cajón " + cajon);
            } else {
                System.out.println("espacio ocupado por el auto: " + parking[nivel][cajon]);
            }
        }

        // mostrar reporte de ocupación
        System.out.println("\n=== estado actual del estacionamiento ===");
        int ocupados = 0;
        for (int i = 0; i < 3; i++) {
            System.out.print("nivel " + i + ": ");
            for (int j = 0; j < 4; j++) {
                System.out.print("[" + parking[i][j] + "] ");
                if (!parking[i][j].equals("vacio")) {
                    ocupados++;
                }
            }
            System.out.println();
        }
        
        System.out.println("\ntotal de espacios ocupados: " + ocupados);
        System.out.println("espacios disponibles: " + (12 - ocupados));
    }
}