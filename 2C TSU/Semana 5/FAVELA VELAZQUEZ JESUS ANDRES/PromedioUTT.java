/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package promedioutt;

/**
 *
 * @author ASUS
 */
public class PromedioUTT {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) {
        
        // 1. Declaramos el array con tus calificaciones (inventa unas si quieres)
        double[] calificaciones = {7.0, 10.0, 10.0, 7.5, 8.0};
        
        // 2. Variable para ir acumulando la suma
        double suma = 0;

        // 3. EL CICLO FOR (Aquí es donde aplicas lo aprendido)
        for (int i = 0; i < calificaciones.length; i++) {
            
            // sumamos el valor de la posición 'i' a la variable 'suma'
            suma = suma + calificaciones[i];
            
            System.out.println("Sumando calificación " + (i + 1) + ": " + calificaciones[i]);
        }

        // 4. CALCULAR EL PROMEDIO
        // El promedio es la suma total entre la cantidad de materias
        double promedio = suma / calificaciones.length;

        System.out.println("------------------------------");
        System.out.println("Tu promedio final es: " + promedio);
        
       
        if (promedio >= 7.0) {
            System.out.println("¡Felicidades! Vas por buen camino en la UTT.");
        } else {
            System.out.println("A darle átomos, hay que estudiar más.");
        }
    }
}
    
    

