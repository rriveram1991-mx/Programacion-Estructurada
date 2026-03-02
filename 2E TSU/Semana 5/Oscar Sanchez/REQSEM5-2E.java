/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package req.sem5.pkg2ejava;

/**
 *
 * @author Oscar Sanchez
 */
public class REQSEM52EJAVA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] puntajes = {75, 92, 84, 98, 63}; // Lista de calificaciones
        int maximo = puntajes[0]; // Empezamos asumiendo que el primer número es el mayor

        // El for-each dice: "Revisa cada puntaje 'p' en el arreglo 'puntajes'"
        for (int p : puntajes) {
            if (p > maximo) { // Si el puntaje actual 'p' es mayor al que tenemos guardado...
                maximo = p;   // ...entonces 'maximo' ahora vale lo que vale 'p'
            }
        }

        System.out.println("El puntaje más alto es: " + maximo); // Imprimimos el ganador
    }
}
