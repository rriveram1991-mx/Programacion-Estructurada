/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package each2;

/**
 *
 * @author ASUS
 */
public class Each2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {       
        // Matriz: Cada fila es un equipo con sus dos pilotos
        String[][] temporada93 = {
            {"Williams", "Alain Prost", "Damon Hill"},
            {"McLaren", "Ayrton Senna", "Michael Andretti"},
            {"Benetton", "Michael Schumacher", "Riccardo Patrese"},
            {"Ferrari", "Jean Alesi", "Gerhard Berger"}
        };

        System.out.println("=== REPASO DE EQUIPOS 1993 ===");

        // 1. EL PRIMER FOR-EACH: Saca el array de cada equipo
        for (String[] equipoCompleto : temporada93) {
            
            System.out.println("\nAnalizando equipo...");

            // 2. EL SEGUNDO FOR-EACH: Saca cada dato (Nombre equipo y Pilotos)
            for (String dato : equipoCompleto) {
                
                // Aquí 'dato' va tomando el valor de cada String
                System.out.println(" > " + dato);
            }
        }
    }
}

