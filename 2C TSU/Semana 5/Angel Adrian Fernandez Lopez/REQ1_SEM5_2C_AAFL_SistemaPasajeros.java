/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package req1_sem5_2c_aafl_sistemapasajeros;
// Importamos la clase Scanner para poder leer datos del teclado
import java.util.Scanner;
/**
 *
 * @author aleja
 */
public class REQ1_SEM5_2C_AAFL_SistemaPasajeros {
// Declaramos la clase principal del programa

    // Creamos un objeto Scanner estático para usarlo en todo el programa
    static Scanner scanner = new Scanner(System.in);

    // Método principal donde inicia la ejecución del programa
    public static void main(String[] args) throws InterruptedException {

        // Variable que guardará la opción elegida en el menú
        int opcion;

        // Bucle que mantiene el programa ejecutándose hasta elegir salir
        do {

            // Limpia la pantalla imprimiendo muchos saltos de línea
            limpiarPantalla();

            // Muestra el menú con la animación
            mostrarMenu();

            // VALIDACIÓN DEL MENÚ
            while (true) { // ciclo infinito hasta que el usuario ingrese un valor válido

                // Pedimos al usuario que seleccione una opción
                System.out.print("Seleccione una opcion (1 o 2): ");

                // Verificamos si el valor ingresado es un número entero
                if (scanner.hasNextInt()) {

                    // Guardamos el número ingresado en la variable opcion
                    opcion = scanner.nextInt();

                    // Limpiamos el buffer del teclado
                    scanner.nextLine();

                    // Verificamos que la opción sea 1 o 2
                    if (opcion == 1 || opcion == 2) {
                        break; // si es válido salimos del ciclo
                    } else {
                        // Mensaje de error si el número no es 1 o 2
                        System.out.println("Error: solo se permite 1 o 2.");
                    }

                } else {
                    // Mensaje de error si se ingresan letras o decimales
                    System.out.println("Error: solo se permiten numeros enteros.");

                    // Limpiamos la entrada incorrecta
                    scanner.next();
                }
            }

            // Estructura switch para ejecutar acciones según la opción elegida
            switch (opcion) {

                // Caso 1: Registrar pasajeros
                case 1:

                    // Ejecuta animación de carga
                    animacionCargando();

                    // Llama al método para registrar pasajeros
                    registrarPasajeros();

                    break;

                // Caso 2: Salir del sistema
                case 2:

                    // Pregunta al usuario si realmente desea salir
                    System.out.print("Seguro que desea salir? (s/n): ");

                    // Lee el primer carácter de la respuesta
                    char resp = scanner.next().charAt(0);

                    // Si el usuario responde "s" o "S"
                    if (resp == 's' || resp == 'S') {

                        // Ejecuta animación de salida
                        animacionSalida();

                        // Finaliza el programa completamente
                        System.exit(0);

                    } else {

                        // Si el usuario no confirma, regresa al menú
                        opcion = 0;
                    }

                    break;
            }

        // El ciclo se repite mientras la opción no sea 2
        } while (opcion != 2);
    }

    // Método que muestra el menú con una animación
    public static void mostrarMenu() {

        // Arreglo que contiene la imagen hecha con números
        String[] imagen = {

"0000000000000000000001000000000011011111100000000",
            "0000000000000000000011000000000010011111100000000",
            "0000000000000000000011000000000010011111100000000",
            "0000000000000000000111000000000000011111110000000",
            "1000000000000000000110000000000000011111100000000",
            "1000000000000000000110000000000000011111110000000",
            "1000000000000000001100000000000001111111110000000",
            "1000000000000000011000000000000001111111110000000",
            "1000000000000000110000000000000011111111110000000",
            "1000000000000001100000000000000111111111110000000",
            "1000000000000011000000000000000111111110110000000",
            "1100000000000000000000000000011100000000000000000",
            "1100000000010000000000000000111100001100000000000",
            "1100000000110000000000000001111100001100000000000",
            "1100000000111000011110001111111000001100000000000",
            "1100000100001000111111111111111110000000000000000",
            "1100000111111111111111111111111111111111110000000",
            "1110001111111111111111111111111111111111110000000",
            "1110001111111111111111111111111111111111110000001",
            "1110001111111111111111111111111111111111110000001",
            "1111001111111111111111111111111111111111111000001",
            "1111001111111111111111111111111111111111111000011",
            "1111000111111111111111111111111111111111110000011",
            "1111100111111111111111111111111111111111110000011",
            "1111110111111111111111111111111111111111110000111",
            "1111110011111111111111111111111111111111110000111",
            "1111110011111111111111111111111111111111100001111",
            "1111110001111111111111111111111111111111100001111",
            "1111111001111111111111111111111111111111100011111",
            "1111110000111111111111111111111111111111000011111",
            "1111110000111111111111111111111111111110000011111",
            "1111111000011111111111111111111111111110000011111",
            "1111111000001111111111111111111111111100000011111",
            "1111111000000111111111111111111111110000000011111",
            "1111111100000011111111111111111111100000000011111",
            "1111111100000001111111111111111111000000000011111",
            "1111111100000000111111111111111110000000000011111"

        };

        // Ciclo que mueve la imagen horizontalmente creando animación
        for (int movimiento = 0; movimiento < 30; movimiento++) {

            // Limpia la pantalla
            limpiarPantalla();

            // Recorre cada línea de la imagen
            for (String linea : imagen) {

                // Agrega espacios antes de imprimir la línea para moverla
                for (int i = 0; i < movimiento; i++) {
                    System.out.print(" ");
                }

                // Imprime la línea de la imagen
                System.out.println(linea);
            }

            try {

                // Pausa la ejecución 60 milisegundos para efecto de animación
                Thread.sleep(60);

            } catch (InterruptedException e) {
            }
        }

        // Muestra el menú del sistema
        System.out.println("\n===== SISTEMA DE PASAJEROS =====");
        System.out.println("1. Registrar pasajeros");
        System.out.println("2. Salir");
        System.out.println();
    }

    // Método que registra pasajeros
    public static void registrarPasajeros() throws InterruptedException {

        // Limpia la pantalla
        limpiarPantalla();

        // Variable que guardará la cantidad de pasajeros
        int cantidad = 0;

        // Validación para que solo se ingresen números enteros positivos
        while (true) {

            // Pedimos la cantidad de pasajeros
            System.out.print("Cuantos pasajeros se registraran: ");

            // Verificamos que el dato ingresado sea entero
            if (scanner.hasNextInt()) {

                // Guardamos el número
                cantidad = scanner.nextInt();

                // Limpiamos buffer
                scanner.nextLine();

                // Verificamos que sea mayor a 0
                if (cantidad > 0) {
                    break;
                } else {
                    System.out.println("Error: la cantidad debe ser un numero entero positivo.");
                }

            } else {

                // Mensaje de error si no es número
                System.out.println("Error: solo se permiten numeros enteros.");

                // Limpia entrada incorrecta
                scanner.next();
            }
        }

        // Arreglo para guardar los nombres
        String[] nombres = new String[cantidad];

        // Arreglo para guardar los destinos
        String[] destinos = new String[cantidad];

        // Ciclo para registrar cada pasajero
        for (int i = 0; i < cantidad; i++) {

            // Muestra número de pasajero
            System.out.println("\nPasajero " + (i + 1));

            // VALIDACIÓN DEL NOMBRE
            while (true) {

                // Pedimos el nombre
                System.out.print("Nombre: ");

                // Guardamos el nombre
                nombres[i] = scanner.nextLine();

                // Verificamos que no esté vacío
                if (nombres[i].isEmpty()) {

                    System.out.println("Error: el nombre no puede estar vacio.");

                // Verificamos que solo tenga letras
                } else if (!nombres[i].matches("[a-zA-Z ]+")) {

                    System.out.println("Error: el nombre solo puede contener letras.");

                } else {

                    // Si es válido salimos del ciclo
                    break;
                }
            }

            // VALIDACIÓN DEL DESTINO
            while (true) {

                // Pedimos destino
                System.out.print("Destino (CDMX o Local): ");

                // Guardamos destino y quitamos espacios
                destinos[i] = scanner.nextLine().trim();

                // Validamos que no esté vacío
                if (destinos[i].isEmpty()) {

                    System.out.println("Error: el destino no puede estar vacio.");

                // Validamos que solo sea CDMX o Local
                } else if (!destinos[i].equalsIgnoreCase("CDMX") &&
                           !destinos[i].equalsIgnoreCase("Local")) {

                    System.out.println("Error: el destino solo puede ser CDMX o Local.");

                } else {

                    // Normalizamos el texto
                    destinos[i] = destinos[i].equalsIgnoreCase("CDMX") ? "CDMX" : "Local";

                    break;
                }
            }
        }

        // Contadores de destinos
        int cdmx = 0;
        int local = 0;

        // Limpia pantalla
        limpiarPantalla();

        // Título
        System.out.println("===== LISTA DE PASAJEROS =====");

        // Variable para recorrer destinos
        int index = 0;

        // Recorre todos los nombres
        for (String nombre : nombres) {

            // Obtiene el destino correspondiente
            String destino = destinos[index];

            // Muestra pasajero
            System.out.println("Nombre: " + nombre + " | Destino: " + destino);

            // Si el destino es CDMX
            if (destino.equalsIgnoreCase("CDMX")) {

                System.out.println("Viaje largo");

                cdmx++; // suma contador
            }

            // Si el destino es Local
            if (destino.equalsIgnoreCase("Local")) {

                System.out.println("Viaje corto");

                local++; // suma contador
            }

            // Avanza índice
            index++;
        }

        // Muestra estadísticas
        System.out.println("\n===== ESTADISTICAS =====");

        // Compara qué destino tiene más pasajeros
        if (cdmx > local) {

            System.out.println("Destino con mas pasajeros: CDMX");

        } else if (local > cdmx) {

            System.out.println("Destino con mas pasajeros: Local");

        } else {

            System.out.println("Empate de destinos");
        }

        // Muestra cantidades
        System.out.println("Pasajeros a CDMX: " + cdmx);
        System.out.println("Pasajeros Locales: " + local);
        System.out.println("Total de pasajeros: " + cantidad);

        // Espera para regresar al menú
        System.out.println("\nPresione Enter para volver al menu...");
        scanner.nextLine();
    }

    // Animación de carga
    public static void animacionCargando() throws InterruptedException {

        limpiarPantalla();

        System.out.print("Cargando");

        for (int i = 0; i < 5; i++) {

            System.out.print(".");

            Thread.sleep(500);
        }

        System.out.println();

        Thread.sleep(800);
    }

    // Animación al salir del sistema
    public static void animacionSalida() throws InterruptedException {

        limpiarPantalla();

        System.out.print("Saliendo del sistema");

        for (int i = 0; i < 5; i++) {

            System.out.print(".");

            Thread.sleep(500);
        }

        System.out.println("\nHasta luego");

        Thread.sleep(1000);
    }

    // Método para simular limpiar pantalla
    public static void limpiarPantalla() {

        // Imprime muchos saltos de línea
        for (int i = 0; i < 55; i++) {
            System.out.println();
        }
    }

}

