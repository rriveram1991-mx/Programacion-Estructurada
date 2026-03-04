/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arrays;

import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class Arrays {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //3. DECLARACIÓN E INICIALIZACIÓN
        // Tipo[] nombre = { valores separados por coma };
        String[] misMaterias = {
            "Cálculo Diferencial", 
            "Conmutación y Enrutamiento", 
            "Probabilidad y Estadística", 
            "Programación Estructurada", 
            "Desarrollo Integral"
        };

        // 4. ESTRUCTURA DEL CICLO FOR
        // (Inicio; Condición de parada; Incremento)
        for (int i = 0; i < misMaterias.length; i++) {
            
            // 5. ACCESO AL DATO
            // Usamos misMaterias[i] para sacar el texto de la posición "i"
            System.out.println("Materia en posición " + i + ": " + misMaterias[i]);
        }
    }
}
    
    

