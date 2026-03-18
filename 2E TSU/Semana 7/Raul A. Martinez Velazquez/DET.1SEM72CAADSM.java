package gestorerrores;
import java.util.Scanner;
public class GestorErrores {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[][] juegos = new String[10][3];

        int opcion = 0;

        while (opcion != 7) {

            System.out.println("1. Registrar");
            System.out.println("2. Mostrar");
            System.out.println("3. Buscar");
            System.out.println("4. Estadisticas");
            System.out.println("7. Salir");

            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {

                case 1 -> {
                    int fila = 0;

                    for (int i = 0; i < juegos.length; i++) {
                        if (juegos[i][0] == null) {
                            fila = i;
                            break;
                        }
                    }

                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    juegos[fila][0] = nombre;

                    System.out.print("Genero: ");
                    juegos[fila][1] = sc.nextLine();

                    System.out.print("Horas: ");
                    juegos[fila][2] = sc.nextLine();
                }

                case 2 -> {
                    for (int i = 0; i < juegos.length; i++) {
                        if (juegos[i][0] != null) {
    System.out.println(juegos[i][0] + " - " + juegos[i][1] + " - " + juegos[i][2]);};
                    }
                }

                case 3 -> {
                    System.out.print("Buscar: ");
                    String buscar = sc.nextLine();

                    for (int i = 0; i < juegos.length; i++) {
                        if (juegos[i][0] != null && juegos[i][0].equals(buscar)) {
                            System.out.println("Encontrado");
                        }
                    }
                }

                case 4 -> {
                   int suma = 0;
                   int contador = 0;

                   for (int i = 0; i < juegos.length; i++) {
                   if (juegos[i][2] != null) {
                   suma += Integer.parseInt(juegos[i][2]);
                   contador++;
                        } 
                    }

if (contador > 0) {
    System.out.println("Promedio: " + (suma / contador));
} else {
    System.out.println("No hay datos");
}}
                case 7 -> System.out.println("Adios");
            default -> {
                    System.out.println("Opción inválida");
                }
            }
        }
        sc.close();
    }
}