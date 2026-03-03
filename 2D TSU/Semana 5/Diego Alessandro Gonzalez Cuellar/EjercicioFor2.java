import java.util.Scanner;

public class EjercicioFor2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] equipos = {"Real Madrid", "Barcelona", "Bayern Munich", "Manchester City", "PSG"};
        int[]    puntos  = {90, 85, 78, 88, 72};

        System.out.println(" TABLA DE POSICIONES ");

        int posicion = 1;
        for (String equipo : equipos) {
            int idx = posicion - 1;
            System.out.println(posicion + ". " + equipo + " - " + puntos[idx] + " pts");
            posicion++;
        }

        int maxPuntos = puntos[0];
        for (int p : puntos) {
            if (p > maxPuntos) {
                maxPuntos = p;
            }
        }

        for (String equipo : equipos) {
            int idx = java.util.Arrays.asList(equipos).indexOf(equipo);
            if (puntos[idx] == maxPuntos) {
                System.out.println("\nCampeon: " + equipo + " con " + maxPuntos + " puntos");
            }
        }

        System.out.println("\nSelecciona un equipo para ver sus puntos:");
        int eleccion = sc.nextInt();

        if (eleccion >= 1 && eleccion <= equipos.length) {
            System.out.println(equipos[eleccion - 1] + " tiene " + puntos[eleccion - 1] + " puntos");
        } else {
            System.out.println("Opcion no valida");
        }

        sc.close();
    }
}