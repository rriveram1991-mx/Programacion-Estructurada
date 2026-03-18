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
            System.out.println("4. Estadísticas");
            System.out.println("7. Salir");
            System.out.print("Opción: ");

            // Validación de entrada numérica
            while (!sc.hasNextInt()) {
                System.out.print("Ingrese un número válido: ");
                sc.next();
            }
            opcion = sc.nextInt();
            sc.nextLine(); // Consumir salto de línea

            switch (opcion) {
                case 1:
                    int fila = -1;
                    for (int i = 0; i < juegos.length; i++) {
                        if (juegos[i][0] == null) {
                            fila = i;
                            break;
                        }
                    }
                    if (fila == -1) {
                        System.out.println("No hay espacio para más juegos.");
                        break;
                    }

                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    if (nombre.trim().isEmpty()) {
                        System.out.println("El nombre no puede estar vacío.");
                        break;
                    }
                    juegos[fila][0] = nombre;

                    System.out.print("Género: ");
                    juegos[fila][1] = sc.nextLine();

                    System.out.print("Horas: ");
                    String horasInput = sc.nextLine();
                    // Validación de número
                    if (!esNumero(horasInput)) {
                        System.out.println("Ingrese un número válido para las horas.");
                        break;
                    }
                    juegos[fila][2] = horasInput;
                    System.out.println("Juego registrado con éxito.");
                    break;

                case 2:
                    boolean hayJuegos = false;
                    for (int i = 0; i < juegos.length; i++) {
                        if (juegos[i][0] != null) {
                            System.out.println(juegos[i][0] + " - " + juegos[i][1] + " - " + juegos[i][2] + " horas");
                            hayJuegos = true;
                        }
                    }
                    if (!hayJuegos) {
                        System.out.println("No hay videojuegos registrados.");
                    }
                    break;

                case 3:
                    System.out.print("Buscar: ");
                    String buscar = sc.nextLine();
                    boolean encontrado = false;
                    for (int i = 0; i < juegos.length; i++) {
                        if (juegos[i][0] != null && juegos[i][0].equals(buscar)) {
                            System.out.println("Encontrado: " + juegos[i][0] + " - " + juegos[i][1] + " - " + juegos[i][2] + " horas");
                            encontrado = true;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("No se encontró el juego.");
                    }
                    break;

                case 4:
                    int suma = 0;
                    int contador = 0;
                    for (int i = 0; i < juegos.length; i++) {
                        if (juegos[i][0] != null && juegos[i][2] != null && !juegos[i][2].isEmpty()) {
                            suma += Integer.parseInt(juegos[i][2]);
                            contador++;
                        }
                    }
                    if (contador == 0) {
                        System.out.println("No hay juegos registrados para calcular promedio.");
                    } else {
                        System.out.println("Total de juegos: " + contador);
                        System.out.println("Promedio de horas: " + (double) suma / contador);
                    }
                    break;

                case 7:
                    System.out.println("Adiós");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        }
        sc.close();
    }

    // Método para validar si una cadena es un número entero
    public static boolean esNumero(String str) {
        if (str == null || str.isEmpty()) return false;
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}   