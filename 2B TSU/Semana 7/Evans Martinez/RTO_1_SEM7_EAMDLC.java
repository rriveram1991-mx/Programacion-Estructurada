import java.util.Scanner;

public class RTO_1_SEM7_EAMDLC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Crear el estacionamiento (matriz de tamaño 10)
        String[] estacionamiento = new String[10];
        for (int i = 0; i < estacionamiento.length; i++) {
            estacionamiento[i] = "LIBRE";
        }

        boolean salir = false;
        while (!salir) {
            // 2. Menú interactivo
            System.out.println("\n--- Sistema de Estacionamiento ---");
            System.out.println("1. Ver estacionamiento");
            System.out.println("2. Estacionar auto");
            System.out.println("3. Retirar auto");
            System.out.println("4. Contar espacios ocupados");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");

            String opcion = scanner.nextLine().trim();
            switch (opcion) {
                case "1" -> mostrarEstacionamiento(estacionamiento);
                case "2" -> estacionarAuto(estacionamiento, scanner);
                case "3" -> retirarAuto(estacionamiento, scanner);
                case "4" -> contarOcupados(estacionamiento);
                case "5" -> {
                    System.out.println("Saliendo...");
                    salir = true;
                }
                default -> System.out.println("Opción inválida. Intenta de nuevo.");
            }
        }

        scanner.close();
    }

    private static void mostrarEstacionamiento(String[] estacionamiento) {
        // 3. Ver estacionamiento
        System.out.println("\nEstado del estacionamiento:");
        for (int i = 0; i < estacionamiento.length; i++) {
            System.out.printf("Espacio %d: %s\n", i + 1, estacionamiento[i]);
        }
    }

    private static void estacionarAuto(String[] estacionamiento, Scanner scanner) {
        System.out.print("Ingrese el número de espacio (1-" + estacionamiento.length + "): ");
        String entrada = scanner.nextLine().trim();
        try {
            int espacio = Integer.parseInt(entrada);
            if (espacio < 1 || espacio > estacionamiento.length) {
                System.out.println("Número de espacio inválido.");
                return;
            }

            int indice = espacio - 1;
            // 4. Estacionar auto
            if ("LIBRE".equalsIgnoreCase(estacionamiento[indice])) {
                estacionamiento[indice] = "OCUPADO";
                System.out.println("Auto estacionado en el espacio " + espacio + ".");
            } else {
                System.out.println("El espacio " + espacio + " ya está ocupado.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Debes ingresar un número.");
        }
    }

    private static void retirarAuto(String[] estacionamiento, Scanner scanner) {
        System.out.print("Ingrese el número de espacio (1-" + estacionamiento.length + "): ");
        String entrada = scanner.nextLine().trim();
        try {
            int espacio = Integer.parseInt(entrada);
            if (espacio < 1 || espacio > estacionamiento.length) {
                System.out.println("Número de espacio inválido.");
                return;
            }

            int indice = espacio - 1;
            // 5. Retirar auto
            if ("OCUPADO".equalsIgnoreCase(estacionamiento[indice])) {
                estacionamiento[indice] = "LIBRE";
                System.out.println("Auto retirado del espacio " + espacio + ".");
            } else {
                System.out.println("El espacio " + espacio + " ya está libre.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Debes ingresar un número.");
        }
    }

    private static void contarOcupados(String[] estacionamiento) {
        // 6. Contar espacios ocupados (for-each)
        int contador = 0;
        for (String estado : estacionamiento) {
            if ("OCUPADO".equalsIgnoreCase(estado)) {
                contador++;
            }
        }
        System.out.println("\nEspacios ocupados: " + contador + " de " + estacionamiento.length + "\n");
    }
}
