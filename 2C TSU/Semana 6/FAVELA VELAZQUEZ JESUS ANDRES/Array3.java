/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package array3;

/**
 *
 * @author ASUS
 */
public class Array3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Matriz bidimensional de String: 3 filas x 2 columnas
        // Estructura: { "Modelo", "Color" } por cada cajón no funcionaría en 2D simple si queremos varios autos (investigado)
        // Así que cada celda de la matriz será un cajón que contiene: "Modelo - Color"
        String[][] cajones = {
            {"Porsche 911 Turbo - Gris Metálico", "Nissan Silvia S15 - Blanco Perlado"},
            {"Vacío", "Mazda RX-7 - Amarillo FD"},
            {"Nissan Skyline GT-R - Azul ", "Vacío"}
        };

        System.out.println("=== REPORTE DE ESTACIONAMIENTO DEPORTIVO ===");

        // 
        
        // i recorre las filas (Niveles del estacionamiento)
        for (int i = 0; i < cajones.length; i++) {
            
            // j recorre las columnas (Cajones por nivel)
            for (int j = 0; j < cajones[i].length; j++) {
                
                String infoCajon = cajones[i][j];

                // Verificamos si el cajón no está vacío
                if (!infoCajon.equals("Vacío")) {
                    System.out.println("Nivel " + (i + 1) + " | Cajón " + (j + 1) + ": " + infoCajon);
                } else {
                    System.out.println("Nivel " + (i + 1) + " | Cajón " + (j + 1) + ": [ DISPONIBLE ]");
                }
            }
            // Línea divisoria entre niveles para que se vea ordenado en consola
            System.out.println("------------------------------------------------");
        }
    }
}
    
    

