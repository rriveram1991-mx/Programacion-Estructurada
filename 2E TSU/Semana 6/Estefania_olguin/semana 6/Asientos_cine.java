/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package asientos_cine;

/**
 *
 * @author OLguin21
 */
public class Asientos_cine {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
            // Definimos la matriz: 5 filas y 10 columnas
            String[][] asientos = new String[5][10];

            System.out.println("\n--- MAPA DE ASIENTOS ---");

            for (int i = 0; i < 5; i++) {

             char letra;
            if (i == 0) letra = 'X';
            else if (i == 1) letra = 'A';
            else if (i == 2) letra = 'B';
            else if (i == 3) letra = 'C';
            else letra = 'D';

             for (int j = 0; j < 10; j++) {
      
               asientos[i][j] = letra + "" + (j + 1);
        
              System.out.print(asientos[i][j] + "\t"); 
            }
    
 
            System.out.println("");
}
    }
    
}
