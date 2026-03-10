/**
 * Institución: Universidad Tecnológica de Torreón.
 * Carrera: Ingeniería en Desarrollo de Software.
 * Alumno: [Juan Diego Arroyo Bucio.]
 * Materia: Programación Estructurada.
 */
public class Main {
    public static void main(String[] args) {
        // Fase 1: Construir la sala VIP (4 filas y 5 columnas)
        char[][] sala = new char[4][5];

        // Fase 2: Llenar la sala con asientos Libres ('L') usando ciclos anidados
        for (int i = 0; i < sala.length; i++) {
            for (int j = 0; j < sala[i].length; j++) {
                sala[i][j] = 'L';
            }
        }

        // Fase 3: Vender un par de boletos (Cambiar a Ocupado 'O')
        sala[2][3] = 'O'; // El asiento que tú elegiste
        sala[0][0] = 'O'; // Vendimos otro en primera fila
        sala[3][4] = 'O'; // Y otro en la última esquina

        System.out.println("=== MAPA DE ASIENTOS VIP ===");

        // Fase 4: Imprimir el mapa en forma de cuadrícula
        for (int i = 0; i < sala.length; i++) {
            System.out.print("Fila " + i + ": "); // Un extra para identificar la fila

            for (int j = 0; j < sala[i].length; j++) {
                System.out.print("[" + sala[i][j] + "] ");
            }
            System.out.println(); // El "Enter" para bajar a la siguiente fila de asientos
        }
    }
}