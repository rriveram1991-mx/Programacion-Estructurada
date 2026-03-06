/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package req1_sem5_2c_aafl_sistemapacientes;
// Importamos la clase Scanner para poder leer datos desde el teclado
import java.util.Scanner;
// Importamos la clase Scanner para poder leer datos desde el tecladoommand line 
/**
 *
 * @author aleja
 */
public class REQ1_SEM5_2C_AAFL_SistemaPacientes {


// Declaramos la clase principal del programa

    // Creamos un objeto Scanner estático para poder usarlo en todo el programa
    static Scanner scanner = new Scanner(System.in);

    // Método principal donde inicia la ejecución del programa
    public static void main(String[] args) throws InterruptedException {

        // Variable que guardará la opción seleccionada en el menú
        int opcion;

        // Ciclo do-while para mantener el programa ejecutándose hasta que el usuario salga
        do {

            // Limpia la pantalla simulando un borrado con saltos de línea
            limpiarPantalla();

            // Llama al método que muestra el menú y la animación
            mostrarMenu();

            // VALIDACIÓN DE LA OPCIÓN DEL MENÚ
            while (true) {

                // Pedimos al usuario que seleccione una opción
                System.out.print("Seleccione una opcion: ");

                // Verificamos si lo que ingresó el usuario es un número entero
                if (scanner.hasNextInt()) {

                    // Guardamos la opción ingresada
                    opcion = scanner.nextInt();

                    // Limpiamos el buffer del teclado
                    scanner.nextLine();

                    // Verificamos que solo se permita 1 o 2
                    if (opcion == 1 || opcion == 2) {

                        // Si es válida salimos del ciclo
                        break;

                    } else {

                        // Si el número no es 1 o 2 mostramos error
                        System.out.println("Error: solo se permite 1 o 2.");
                    }

                } else {

                    // Si se ingresan letras o símbolos mostramos error
                    System.out.println("Error: solo se permiten numeros enteros.");

                    // Limpiamos la entrada inválida
                    scanner.next();
                }
            }

            // Estructura switch para ejecutar la opción seleccionada
            switch (opcion) {

                // Caso 1: registrar pacientes
                case 1:

                    // Ejecuta animación de carga
                    animacionCargando();

                    // Llama al método para registrar pacientes
                    registrarPacientes();

                    break;

                // Caso 2: salir del programa
                case 2:

                    // Preguntamos si realmente desea salir
                    System.out.print("Seguro que desea salir? (s/n): ");

                    // Leemos el primer carácter ingresado
                    char resp = scanner.next().charAt(0);

                    // Si el usuario responde s o S
                    if (resp == 's' || resp == 'S') {

                        // Ejecuta animación de salida
                        animacionSalida();

                        // Termina completamente el programa
                        System.exit(0);

                    } else {

                        // Si no confirma, volvemos al menú
                        opcion = 0;
                    }

                    break;
            }

        // El programa seguirá ejecutándose mientras la opción no sea 2
        } while (opcion != 2);
    }

    // Método que muestra el menú y la animación
    public static void mostrarMenu() {

        // Arreglo que contiene una imagen hecha con números
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

        // Animación moviendo la imagen horizontalmente
        for (int movimiento = 0; movimiento < 40; movimiento++) {

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

                // Pausa para crear efecto de animación
                Thread.sleep(80);

            } catch (InterruptedException ex) {

                // Mensaje si ocurre un error en la animación
                System.out.println("Error en la animacion.");
            }
        }

        // Mostramos el menú del sistema
        System.out.println("\n===== SISTEMA DE PACIENTES =====");
        System.out.println("1. Registrar pacientes");
        System.out.println("2. Salir");
        System.out.println();
    }

    // Método para registrar pacientes
    public static void registrarPacientes() throws InterruptedException {

        // Limpia pantalla
        limpiarPantalla();

        // Variable que guardará la cantidad de pacientes
        int cantidad = 0;

        // VALIDAR LA CANTIDAD DE PACIENTES
        while (true) {

            System.out.print("Cuantos pacientes se registraran: ");

            // Verificamos que el valor ingresado sea entero
            if (scanner.hasNextInt()) {

                cantidad = scanner.nextInt();

                scanner.nextLine();

                // Verificamos que sea mayor que cero
                if (cantidad > 0) {

                    break;

                } else {

                    System.out.println("Error: la cantidad debe ser un numero entero positivo.");
                }

            } else {

                System.out.println("Error: solo se permiten numeros enteros.");

                scanner.next();
            }
        }

        // Arreglo para guardar los nombres
        String[] nombres = new String[cantidad];

        // Arreglo para guardar las edades
        int[] edades = new int[cantidad];

        // Ciclo para registrar cada paciente
        for (int i = 0; i < cantidad; i++) {

            System.out.println("\nPaciente " + (i + 1));

            // VALIDACIÓN DEL NOMBRE
            while (true) {

                System.out.print("Nombre: ");

                nombres[i] = scanner.nextLine();

                // Verifica que el nombre solo tenga letras
                if (nombres[i].matches("[a-zA-Z ]+")) {

                    break;

                } else {

                    System.out.println("Error: el nombre no debe contener numeros ni simbolos.");
                }
            }

            // VALIDACIÓN DE LA EDAD
            while (true) {

                System.out.print("Edad: ");

                if (scanner.hasNextInt()) {

                    edades[i] = scanner.nextInt();

                    // Verifica que la edad esté entre 0 y 120
                    if (edades[i] >= 0 && edades[i] <= 120) {

                        break;

                    } else {

                        System.out.println("Error: la edad debe estar entre 0 y 120.");
                    }

                } else {

                    System.out.println("Error: solo se permiten numeros enteros.");

                    scanner.next();
                }
            }

            scanner.nextLine();
        }

        // Contadores para estadísticas
        int menores = 0;
        int adultos = 0;
        int adultosMayores = 0;
        int prioritarios = 0;

        limpiarPantalla();

        System.out.println("===== LISTA DE PACIENTES =====");

        int index = 0;

        // Recorremos el arreglo de nombres
        for (String nombre : nombres) {

            int edad = edades[index];

            System.out.println("Nombre: " + nombre + " | Edad: " + edad);

            // Clasificación por edad
            if (edad < 18) {

                menores++;

            } else if (edad <= 59) {

                adultos++;

            } else {

                adultosMayores++;
            }

            // Pacientes prioritarios
            if (edad >= 60) {

                System.out.println("Paciente prioritario");

                prioritarios++;
            }

            index++;
        }

        // Mostrar estadísticas
        System.out.println("\n===== ESTADISTICAS =====");

        System.out.println("Total de pacientes: " + cantidad);
        System.out.println("Menores de edad: " + menores);
        System.out.println("Adultos: " + adultos);
        System.out.println("Adultos mayores: " + adultosMayores);
        System.out.println("Pacientes prioritarios: " + prioritarios);

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

    // Método que simula limpiar pantalla
    public static void limpiarPantalla() {

        for (int i = 0; i < 55; i++) {

            System.out.println();
        }
    }
}
    

