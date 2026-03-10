/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package array2;

/**
 *
 * @author ASUS
 */
public class Array2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Definimos una matriz de 5 filas por 8 columnas para simular la sala
        // char[][] permite usar caracteres individuales como 'L' o 'X'
        char[][] salaCine = {
            {'L', 'L', 'X', 'X', 'X', 'X', 'L', 'L'}, // Fila A (Fondo)
            {'L', 'L', 'L', 'X', 'X', 'L', 'L', 'L'}, // Fila B
            {'X', 'X', 'L', 'L', 'L', 'L', 'X', 'X'}, // Fila C
            {'L', 'L', 'L', 'L', 'L', 'L', 'L', 'L'}, // Fila D
            {'L', 'X', 'X', 'L', 'L', 'X', 'X', 'L'}  // Fila E (Frente a pantalla)
        };

        // --- Simulación de una reserva ---
        System.out.println("ESTADO DE LA SALA");

        // Usamos un ciclo 'for' anidado para recorrer toda la matriz
        // salaCine.length nos da el número de filas (5)
        for (int i = 0; i < salaCine.length; i++) {
            
            // Imprimimos la letra de la fila para que parezca un cine real
            System.out.print("Fila " + (char)('A' + i) + " | ");

            // salaCine[i].length nos da el número de columnas en esa fila (8)
            for (int j = 0; j < salaCine[i].length; j++) {
                // Imprimimos el estado del asiento seguido de un espacio
                System.out.print(salaCine[i][j] + " ");
            }
            
            // Salto de línea al terminar cada fila de la matriz
            System.out.println();
        }

        // --- Verificando un asiento específico (Fila C, Asiento 3) ---
        // Recuerda: Fila C es índice 2, Asiento 3 es índice 2
        System.out.println("\nVerificando disponibilidad en C3...");
        if (salaCine[2][2] == 'L') {
            System.out.println("Resultado: El asiento está disponible para la función.");
        } else {
            System.out.println("Resultado: El asiento ya está ocupado.");
        }
    }
}
    
    

