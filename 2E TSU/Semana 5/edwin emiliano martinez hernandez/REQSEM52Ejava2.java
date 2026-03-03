/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package reqsem52ejava2;

/**
 *
 * @author edwin
 */
public class REQSEM52Ejava2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    double[] notas = {8.5, 9.0, 7.5, 10.0, 8.0};
        double suma = 0;

        for (double nota : notas) {
            suma += nota;
        }

        double promedio = suma / notas.length;

        System.out.println("El promedio es: " + promedio);
    }
    
}
