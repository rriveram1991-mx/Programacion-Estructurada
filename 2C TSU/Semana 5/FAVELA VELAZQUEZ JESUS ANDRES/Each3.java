/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package each3;

/**
 *
 * @author ASUS
 */
public class Each3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Matriz: [Coche], [Piloto], [Copiloto]
        String[][] parrillaGrupoB = {
            {"Audi Quattro S1", "Michèle Mouton", "Fabrizia Pons"},
            {"Lancia 037", "Walter Röhrl", "Christian Geistdörfer"},
            {"Peugeot 205 T16", "Ari Vatanen", "Terry Harryman"},
            {"Lancia Delta S4", "Henri Toivonen", "Sergio Cresto"}
        };

        System.out.println("=== REVISIÓN TÉCNICA GRUPO B - AÑOS 80 ===");

        // 1. PRIMER FOR-EACH: Saca el grupo completo (el coche y su gente)
        // Usamos String[] porque estamos sacando una "fila" entera
        for (String[] unidad : parrillaGrupoB) {
            
            System.out.println("\n>>> SALVAJISMO EN SU MAXIMA EXPRESION...");

            // 2. SEGUNDO FOR-EACH: Saca cada dato de esa unidad
            // Aquí ya es String porque sacamos el texto final
            for (String dato : unidad) {
                
                // 'dato' tomará el valor del Coche, luego Piloto, luego Copiloto
                System.out.println(" - Registro: " + dato);
            }
        }
    }
}
    
    

