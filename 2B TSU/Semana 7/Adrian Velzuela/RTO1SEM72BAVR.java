/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rto.pkg1.sem7.pkg2b.avr;
 import java.util.Scanner;
/**
 *
 * @author adrianvalenzuelaramirez
 */
public class RTO1SEM72BAVR {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
 
        try (Scanner sc = new Scanner(System.in)) {
            // crear el estacionamiento (Array de tamaño 10)
            String[] espacios = new String[10];
            
            // inicializar todos los espacios como "LIBRE"
            for (int i = 0; i < espacios.length; i++) {
                espacios[i] = "libre";
            }
            
            int opcion = 0;
            
            // menú interactivo
            while (opcion != 5) {
                System.out.println("\n--- control de estacionamiento ---");
                System.out.println("1. Ver estacionamiento");
                System.out.println("2. Estacionar auto");
                System.out.println("3. Retirar auto");
                System.out.println("4. Contar espacios ocupados");
                System.out.println("5. Salir");
                System.out.print("seleccione una opción: ");
                opcion = sc.nextInt();
                
                switch (opcion) {
                    case 1:
                        // ver estacionamiento (Recorrer con for)
                        System.out.println("\nestado actual:");
                        for (int i = 0; i < espacios.length; i++) {
                            System.out.println("espacio " + (i + 1) + ": " + espacios[i]);
                        }
                        break;
                        
                    case 2:
                        // estacionar auto
                        System.out.print("ingrese el número de espacio (1-10): ");
                        int eEstacionar = sc.nextInt() - 1; // Ajuste de índice (0-9)
                        
                        if (eEstacionar >= 0 && eEstacionar < 10) {
                            if (espacios[eEstacionar].equals("libre")) {
                                espacios[eEstacionar] = "ocupado";
                                System.out.println("auto estacionado con éxito");
                            } else {
                                System.out.println("el espacio ya está ocupado.");
                            }
                        } else {
                            System.out.println("numero de espacio inválido.");
                        }
                        break;
                        
                    case 3:
                        // retirar auto
                        System.out.print("ingrese el número de espacio a liberar (1-10): ");
                        int eRetirar = sc.nextInt() - 1;
                        
                        if (eRetirar >= 0 && eRetirar < 10) {
                            if (espacios[eRetirar].equals("ocupado")) {
                                espacios[eRetirar] = "disponible";
                                System.out.println("Espacio liberado.");
                            } else {
                                System.out.println("el espacio ya está disponible.");
                            }
                        } else {
                            System.out.println("numero de espacio invalido.");
                        }
                        break;
                        
                    case 4:
                        // contar espacios ocupados
                        int contador = 0;
                        for (String estado : espacios) {
                            if (estado.equals("ocupado")) {
                                contador++;
                            }
                        }
                        System.out.println("total de autos estacionados: " + contador);
                        break;
                        
                    case 5:
                        System.out.println("saliendo del sistema...");
                        break;
                        
                    default:
                        System.out.println("opción no valida.");
                }
            }
        }
    }
}