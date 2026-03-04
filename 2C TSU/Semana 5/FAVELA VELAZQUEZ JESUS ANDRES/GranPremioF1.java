/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package granpremiof1;
import java.util.Random;
/**
 *
 * @author ASUS
 */
public class GranPremioF1 {

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) {
        
        // Tu lista de 22 pilotos
        String[] pilotos = {"Max Verstappen", "Isack Hadjar", "Lewis Hamilton", "Charles Leclerc", "George Russell", "Kimi Antonelli", "Lando Norris", "Oscar Piastri", "Alex Albon", "Carlos Sainz", "Nico Hulkenberg", "Gabriel Bortoleto", "Liam Lawson", "Arvid Lindblad", "Fernando Alonso", "Lance Stroll", "Esteban Ocon", "Oliver Bearman", "Pierre Gasly", "Franco Colapinto", "Checo Perez", "Valtteri Bottas"};

        // Creamos el generador de números aleatorios
        Random random = new Random();

        System.out.println("=== RESULTADOS ALEATORIOS DEL GP ===");
        System.out.println("------------------------------------");

        for (int i = 0; i < pilotos.length; i++) {
            // Generamos puntos al azar entre 0 y 25 para cada piloto
            // random.nextInt(26) da un número entre 0 y 25
            int puntosAzar = random.nextInt(26); 
            
            int posicion = i + 1;
            System.out.println("P" + posicion + ": " + pilotos[i] + " - " + puntosAzar + " pts");
        }

        System.out.println("------------------------------------");
        System.out.println("¡El destino ha hablado!");
    }

}
   
    

