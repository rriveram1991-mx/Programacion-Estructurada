/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication31;

/**
 *
 * @author adrianvalenzuelaramirez
 */
public class JavaApplication31 {

    /**
     * @param args the command line arguments
     */
        public static void main(String[] args) {
            
        // arreglo de notas de un examen de certificación
        double[] notasExamen = {6.5, 8.9, 4.2, 10.0, 7.5, 5.8, 9.2, 3.5};
        
        double suma = 0;
        double notaMaxima = 0; // asumimos 0 como base mínima
        double notaMinima = 10; // asumimos 10 como base máxima
        int aprobados = 0;

        System.out.println("analisis de rendimiento academico");

        // primer recorrido para estadísticas generales
        for (double nota : notasExamen) {
            suma += nota;
            
            // logica para encontrar el máximo
            if (nota > notaMaxima) {
                notaMaxima = nota;
            }
            
            // logica para encontrar el mínimo
            if (nota < notaMinima) {
                notaMinima = nota;
            }
            
            if (nota >= 7.0) {
                aprobados++;
            }
        }

        double promedio = suma / notasExamen.length;

        System.out.println("promedio grupal: " + promedio);
        System.out.println("nota más alta:   " + notaMaxima);
        System.out.println("nota más baja:   " + notaMinima);
        System.out.println("total aprobados: " + aprobados);

        // segundo recorrido para filtrar alumnos destacados (For-each sobre el mismo Array)
        System.out.println("\ncuadro de honor (Notas >= 9.0)");
        for (double nota : notasExamen) {
            if (nota >= 9.0) {
                System.out.println("alumno con calificacion de: " + nota);
            }
        }
    }
}