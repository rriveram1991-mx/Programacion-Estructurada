/**
 * Institución: Universidad Tecnológica de Torreón.
 * Carrera: Ingeniería en Desarrollo de Software.
 * Alumno: [Juan Diego Arroyo Bucio.]
 * Materia: Programación Estructurada.
 */
public class Main {
    public static void main(String[] args) {
        int[] puntos = {4, 15, 2, 1, 3, 29};
        int total = 0;
        System.out.println("Contador de puntos en torneo de basketball:");
        for (int punto : puntos) {
            System.out.println("Puntos obtenidos: " + punto);
            total += punto;
        }
        System.out.println("Su total de puntos en el torneo fué de: " + total);
    }
    }