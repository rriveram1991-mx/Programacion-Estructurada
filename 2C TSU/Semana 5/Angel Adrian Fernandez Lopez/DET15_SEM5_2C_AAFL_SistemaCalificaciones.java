/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package det15_sem5_2c_aafl;
import java.util.Locale; // Permite configurar el formato regional (uso de punto decimal)
import java.util.Scanner;  // Permite leer datos desde el teclado
public class DET15_SEM5_2C_AAFL_SistemaCalificaciones {
 static Scanner sc = new Scanner(System.in);
  // Scanner global para que todos los metodos puedan usarlo
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         // Metodo principal donde inicia el programa

        sc.useLocale(Locale.US);
        // Fuerza el uso de punto (.) como separador decimal

        int opcion;  
        // Variable para guardar la opcion del menu

        do {  // Se repetira hasta que el usuario elija salir

            limpiarPantalla();  
            // Simula limpiar la consola

            System.out.println("===== SISTEMA DE CALIFICACIONES =====");
            System.out.println("1. Capturar calificaciones");
            System.out.println("2. Salir");
            System.out.print("Seleccione una opcion: ");

            try {

                opcion = Integer.parseInt(sc.nextLine());
                // Lee la opcion como texto y la convierte a entero
                // Si escribe letras, lanza excepcion

                switch (opcion) {

                    case 1:
                        ejecutarSistema();  
                        // Ejecuta el sistema principal
                        break;

                    case 2:
                        if (confirmarSalida()) {  
                            // Pregunta si realmente desea salir
                            animacionSalida();  
                            opcion = 2;  
                        } else {
                            opcion = 0;  
                            // Si responde que no, vuelve al menu
                        }
                        break;

                    default:
                        System.out.println("Opcion invalida.");
                        pausa(1000);  
                        // Espera 1 segundo
                }

            } catch (NumberFormatException e) {
                // Captura error si escribe texto en vez de numero
                System.out.println("Debe ingresar un numero.");
                pausa(1000);
                opcion = 0;  
                // Vuelve al menu
            }

        } while (opcion != 2);
        // El menu se repite hasta que opcion sea 2

        sc.close();
        // Cierra el Scanner (opcional en programas pequeños)
    }

    // ================= SISTEMA PRINCIPAL =================
    public static void ejecutarSistema() {

        limpiarPantalla();  
        // Limpia pantalla antes de comenzar

        double[] calificaciones = new double[5];
        // Arreglo para guardar 5 calificaciones

        double suma = 0;  
        // Acumulador para calcular el promedio

        int aprobados = 0;  
        // Contador de alumnos aprobados

        System.out.println("Capturando calificaciones...");
        pausa(800);  
        // Pequena animacion

        for (int i = 0; i < calificaciones.length; i++) {
            // Repite 5 veces (una por cada calificacion)

            boolean valido = false;  
            // Controla si la entrada es valida

            while (!valido) {  
                // Se repite hasta que el dato sea correcto

                try {

                    System.out.print("Ingrese calificacion " + (i + 1) + ": ");

                    String entrada = sc.nextLine().replace(",", ".");
                    // Permite que si el usuario escribe coma, se cambie a punto

                    double valor = Double.parseDouble(entrada);
                    // Convierte el texto a numero decimal

                    if (valor < 0 || valor > 100) {
                        // Valida que este entre 0 y 100
                        System.out.println("Debe estar entre 0 y 100.");
                        continue;  
                        // Vuelve a pedir el numero
                    }

                    if (!entrada.matches("\\d+(\\.\\d{1,2})?")) {
                        // Permite maximo 2 decimales
                        System.out.println("Maximo 2 decimales permitidos.");
                        continue;
                    }

                    calificaciones[i] = valor;  
                    // Guarda la calificacion en el arreglo

                    valido = true;  
                    // Sale del while

                } catch (NumberFormatException e) {
                    // Si escribe letras o simbolos
                    System.out.println("Ingrese un numero valido.");
                }
            }
        }

        animacionCarga("Calculando");  
        // Animacion antes de mostrar resultados

        System.out.println("\nCalificaciones ingresadas:");
        // Muestra encabezado

        for (int i = 0; i < calificaciones.length; i++) {

            System.out.printf("Calificacion %d: %.2f\n",
                    (i + 1), calificaciones[i]);
            // Muestra cada calificacion con 2 decimales

            suma += calificaciones[i];
            // Acumula para el promedio

            if (calificaciones[i] >= 70) {
                // Cuenta cuantos aprobaron (>= 70)
                aprobados++;
            }
        }

        double promedio = suma / calificaciones.length;
        // Calcula el promedio

        System.out.println("\n===== RESULTADOS =====");

        System.out.printf("Promedio: %.2f\n", promedio);
        // Muestra promedio con 2 decimales

        System.out.println("Aprobados: " + aprobados);
        // Muestra cantidad de aprobados

        if (promedio >= 70)
            System.out.println("Grupo aprobado");
        else
            System.out.println("Grupo reprobado");
        // Evalua si el grupo aprobo segun el promedio

        System.out.println("\nPresione Enter para volver al menu...");
        sc.nextLine();  
        // Espera que el usuario presione Enter
    }

    // ================= CONFIRMAR SALIDA =================
    public static boolean confirmarSalida() {

        System.out.print("Seguro que desea salir? (S/N): ");

        String respuesta = sc.nextLine().toUpperCase();
        // Convierte la respuesta a mayusculas

        return respuesta.equals("S");
        // Devuelve true si escribe S
    }

    // ================= ANIMACION =================
    public static void animacionCarga(String mensaje) {

        System.out.print(mensaje);

        for (int i = 0; i < 3; i++) {
            pausa(500);  
            System.out.print(".");
        }

        pausa(500);
        System.out.println();
        // Crea efecto de puntos suspensivos
    }

    public static void animacionSalida() {
        animacionCarga("Saliendo del sistema");
        // Reutiliza la animacion para salida
    }

    // ================= LIMPIAR PANTALLA =================
    public static void limpiarPantalla() {

        for (int i = 0; i < 40; i++) {
            System.out.println(" ");
            // Imprime lineas en blanco para simular limpieza
        }
    }

    // ================= PAUSA =================
    public static void pausa(int ms) {

        try {
            Thread.sleep(ms);
            // Detiene el programa cierta cantidad de milisegundos
        } catch (InterruptedException e) {
            System.out.println("Error en la pausa.");
        }
    }
}
    
   // Calificaciones Errores:
/*
CODIGO ORIGINAL CON ERRORES MARCADOS

import java.util.Scanner;

public class SistemaCalificaciones {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] calificaciones = new int[5];
        int suma = 0;
        int aprobados = 0;

        // Captura de datos
        for (int i = 1; i <= calificaciones.length; i++) {

            // ERROR 1:
            // El arreglo empieza en indice 0.
            // Cuando i vale 5 intenta acceder a calificaciones[5]
            // y eso provoca ArrayIndexOutOfBoundsException.
            System.out.println("Ingrese calificacion " + i + ": ");
            calificaciones[i] = sc.nextInt();

            // ERROR 2:
            // Condicion incorrecta.
            // No puede ser menor que 0 Y mayor que 100 al mismo tiempo.
            // Debe usarse || en lugar de &&
            while (calificaciones[i] < 0 && calificaciones[i] > 100) {
                System.out.println("Calificacion invalida. Intente nuevamente:");
                calificaciones[i] = sc.nextInt();
            }
        }

        // Mostrar calificaciones
        for (int cal : calificaciones) {
            System.out.println("Calificacion: " + cal);

            // ERROR 3:
            // Aqui no se acumulaba la suma.
            // Se estaba reemplazando el valor.
            suma = cal;
        }

        // Contar aprobados
        int j = 0;
        while (j < calificaciones.length) {

            // ERROR 4:
            // El requerimiento pide >= 70
            // Aqui se uso > 70
            if (calificaciones[j] > 70) {
                aprobados++;
            }

            // ERROR 5:
            // Falta j++.
            // Esto genera bucle infinito.
        }

        // ERROR 6:
        // Division entre enteros.
        // Se pierden los decimales.
        double promedio = suma / calificaciones.length;

        if (promedio >= 70)
            System.out.println("Grupo aprobado");
        else
            System.out.println("Grupo reprobado");

        System.out.println("Promedio: " + promedio);
        System.out.println("Aprobados: " + aprobados);
    }
}
*/

