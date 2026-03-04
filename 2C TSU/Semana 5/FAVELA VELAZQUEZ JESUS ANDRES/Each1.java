/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package each1;

/**
 *
 * @author ASUS
 */
public class Each1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       String[] favoritos = {"Checo Perez", "Max Verstappen", "Franco Colapinto", "Fernando Alonso"};

System.out.println("Pasando lista de mis gallos:");

// Se lee: "Para cada 'p' (que es un String) dentro de 'favoritos'..."
for (String p : favoritos) {
    System.out.println("- " + p);
}
    }
    
}
