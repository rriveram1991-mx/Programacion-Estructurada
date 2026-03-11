/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package estacionamientos;

/**
 *
 * @author OLguin21
 */
public class Estacionamientos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // 3. PARTE DE ESTACIONAMIENTOS
// Definimos 3 Niveles y 10 Cajones por nivel
        String[][] estacionamiento = new String[3][10];

        System.out.println("\n--- MAPA DE ESTACIONAMIENTO ---");

// Ciclo para los NIVELESs
        for (int i = 0; i < 3; i++) {
    
    System.out.print("Nivel " + (i + 1) + " | ");

    // Ciclo para los CAJONES (E1 al E10)
        for (int j = 0; j < 10; j++) {
        // Guardamos el nombre (E de estacionamiento + número)
        estacionamiento[i][j] = "E" + (j + 1);
        
        // Imprimimos cada cajón con un espacio
        System.out.print(estacionamiento[i][j] + "\t");
    }
    
    // Salto de línea al terminar cada nivel
        System.out.println("");
        }
}
    
}
