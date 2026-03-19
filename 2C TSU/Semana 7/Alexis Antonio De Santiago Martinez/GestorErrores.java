import java.util.Scanner;

public class GestorErrores {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[][] juegos = new String[10][3];

        int opcion = 0;

        while (opcion != 7) {

            System.out.println("\n1. Registrar");
            System.out.println("2. Mostrar");
            System.out.println("3. Buscar");
            System.out.println("4. Estadisticas");
            System.out.println("7. Salir");
            System.out.print("Opcion: ");

            // VALIDACIÓN NUMÉRICA
            if (!sc.hasNextInt()) {
                System.out.println("Error: Ingrese un numero valido.");
                sc.next();
                continue;
            }

            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {

                case 1:
                    int fila = -1;

                    // buscar espacio libre
                    for (int i = 0; i < juegos.length; i++) {
                        if (juegos[i][0] == null) {
                            fila = i;
                            break;
                        }
                    }

                    if (fila == -1) {
                        System.out.println("No hay espacio disponible.");
                        break;
                    }

                    System.out.print("Nombre: ");
                    juegos[fila][0] = sc.nextLine();

                    System.out.print("Genero: ");
                    juegos[fila][1] = sc.nextLine();

                    System.out.print("Horas: ");

                    // VALIDACIÓN DE NÚMERO
                    if (!sc.hasNextInt()) {
                        System.out.println("Horas inválidas.");
                        sc.next();
                        juegos[fila][2] = "0";
                    } else {
                        juegos[fila][2] = String.valueOf(sc.nextInt());
                        sc.nextLine();
                    }

                    break;

                case 2:
                    boolean hayDatos = false;

                    for (int i = 0; i < juegos.length; i++) {
                        if (juegos[i][0] != null) {
                            System.out.println(juegos[i][0] + " - " +
                                               juegos[i][1] + " - " +
                                               juegos[i][2]);
                            hayDatos = true;
                        }
                    }

                    if (!hayDatos) {
                        System.out.println("No hay videojuegos registrados.");
                    }
                    break;

                case 3:
                    System.out.print("Buscar: ");
                    String buscar = sc.nextLine();
                    boolean encontrado = false;

                    for (int i = 0; i < juegos.length; i++) {
                        if (juegos[i][0] != null &&
                            juegos[i][0].equalsIgnoreCase(buscar)) {

                            System.out.println("Encontrado: " +
                                juegos[i][0] + " - " +
                                juegos[i][1] + " - " +
                                juegos[i][2]);

                            encontrado = true;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("No se encontró el videojuego.");
                    }
                    break;

                case 4:
                    int suma = 0;
                    int contador = 0;

                    for (int i = 0; i < juegos.length; i++) {
                        if (juegos[i][2] != null) {
                            try {
                                suma += Integer.parseInt(juegos[i][2]);
                                contador++;
                            } catch (NumberFormatException e) {
                                // evitar fallo
                            }
                        }
                    }

                    if (contador == 0) {
                        System.out.println("No hay datos para calcular.");
                    } else {
                        System.out.println("Promedio de horas: " + (suma / contador));
                    }
                    break;

                case 7:
                    System.out.println("Adios");
                    break;

                default:
                    System.out.println("Opcion invalida.");
            }
        }

        sc.close();
    }
}