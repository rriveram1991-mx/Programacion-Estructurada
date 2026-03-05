/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package det15_sem5_2c_aafl_sistemaventas;
import java.util.Locale;   // Permite configurar el formato regional (uso de punto decimal)
import java.util.Scanner;  // Permite leer datos desde el teclado   
/**
 *
 * @author gl873
 */
public class DET15_SEM5_2C_AAFL_SistemaVentas {//Clase principal del programa
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

        do {  // Se repetira hasta que el usuario decida salir

            limpiarPantalla();  // Simula limpiar la consola

            System.out.println("===== SISTEMA DE VENTAS =====");  
            System.out.println("1. Registrar ventas");
            System.out.println("2. Salir");
            System.out.print("Seleccione una opcion: ");

            try {

                opcion = Integer.parseInt(sc.nextLine());  
                // Lee la opcion como texto y la convierte a entero
                // Si el usuario escribe letras, lanza excepcion

                switch (opcion) {

                    case 1:
                        ejecutarSistema();  
                        // Ejecuta el sistema de registro de ventas
                        break;

                    case 2:
                        if (confirmarSalida()) {  
                            // Pregunta si realmente quiere salir
                            animacionSalida();  
                            opcion = 2;  
                        } else {
                            opcion = 0;  
                            // Si dice que no, regresa al menu
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
                // Vuelve a mostrar el menu
            }

        } while (opcion != 2);  
        // El menu se repite hasta que opcion sea 2
    }

    // ================= SISTEMA PRINCIPAL =================
    public static void ejecutarSistema() {

        limpiarPantalla();  
        // Limpia pantalla antes de comenzar

        double[] ventas = new double[6];  
        // Arreglo para guardar 6 ventas

        double total = 0;  
        // Acumulador del total vendido

        double mayor = 0;  
        // Variable para guardar la venta mayor

        System.out.println("Registrando ventas...");
        pausa(800);  
        // Pequeña animacion antes de capturar datos

        for (int i = 0; i < ventas.length; i++) {  
            // Repite 6 veces (una por cada venta)

            boolean valido = false;  
            // Controla si la venta ingresada es valida

            while (!valido) {  
                // Se repite hasta que el usuario ingrese dato correcto

                try {

                    System.out.print("Ingrese venta #" + (i + 1) + ": ");

                    String entrada = sc.nextLine().replace(",", ".");  
                    // Permite que si el usuario escribe coma, se cambie a punto

                    double valor = Double.parseDouble(entrada);  
                    // Convierte el texto a numero decimal

                    if (valor < 0) {  
                        // No permite numeros negativos
                        System.out.println("No se permiten negativos.");
                        continue;  
                        // Vuelve a pedir el numero
                    }

                    if (!entrada.matches("\\d+(\\.\\d{1,2})?")) {  
                        // Permite maximo 2 decimales
                        System.out.println("Maximo 2 decimales permitidos.");
                        continue;
                    }

                    ventas[i] = valor;  
                    // Guarda la venta en el arreglo

                    valido = true;  
                    // Sale del while

                } catch (NumberFormatException e) {
                    // Si escribe letras o simbolos
                    System.out.println("Ingrese un numero valido.");
                }
            }
        }

        animacionCarga("Calculando");  
        // Muestra animacion antes de mostrar resultados

        mayor = ventas[0];  
        // Inicializa la venta mayor con la primera venta

        for (double v : ventas) {  
            // Recorre todas las ventas

            total += v;  
            // Acumula el total vendido

            if (v > mayor) {  
                // Si encuentra una venta mayor
                mayor = v;  
                // La guarda
            }
        }

        double promedio = total / ventas.length;  
        // Calcula el promedio

        int contador = 0;  
        // Contador de ventas mayores al promedio

        for (double v : ventas) {
            if (v > promedio) {  
                // Cuenta cuantas son mayores al promedio
                contador++;
            }
        }

        System.out.println("\n===== RESULTADOS =====");

        System.out.printf("Total vendido: %.2f\n", total);  
        // Muestra total con 2 decimales

        System.out.printf("Promedio: %.2f\n", promedio);  
        // Muestra promedio con 2 decimales

        System.out.printf("Venta mayor: %.2f\n", mayor);  
        // Muestra venta mayor con 2 decimales

        System.out.println("Cantidad mayores al promedio: " + contador);

        System.out.println("\nPresione Enter para volver al menu...");
        sc.nextLine();  
        // Espera que el usuario presione Enter
    }

    // ================= CONFIRMAR SALIDA =================
    public static boolean confirmarSalida() {

        System.out.print("Seguro que desea salir? (S/N): ");

        String respuesta = sc.nextLine().toUpperCase();  
        // Convierte respuesta a mayusculas

        return respuesta.equals("S");  
        // Devuelve true si escribe S
    }

    // ================= ANIMACION =================
    public static void animacionCarga(String mensaje) {

        System.out.print(mensaje);  
        // Imprime mensaje inicial

        for (int i = 0; i < 3; i++) {
            pausa(500);  
            // Espera medio segundo
            System.out.print(".");  
            // Imprime punto
        }

        pausa(500);
        System.out.println();
    }

    public static void animacionSalida() {
        animacionCarga("Saliendo del sistema");  
        // Reutiliza la animacion
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
    
    
//Ventas Errores:
/*
CODIGO ORIGINAL CON ERRORES MARCADOS

import java.util.Scanner;

public class SistemaVentas {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double[] ventas = new double[6];
        double total = 0;
        double mayor = 0;

        // Captura de ventas
        for (int i = 0; i <= ventas.length; i++) {

            // ERROR 1:
            // Uso de <= provoca desbordamiento del arreglo.
            // ERROR 2:
            // Debe ser i < ventas.length
            System.out.println("Ingrese venta #" + (i + 1) + ": ");
            ventas[i] = sc.nextDouble();

            while (ventas[i] < 0) {
                System.out.println("No se permiten ventas negativas. Intente de nuevo:");
                ventas[i] = sc.nextDouble();
            }
        }

        // Calcular total y mayor
        for (double v : ventas) {

            // ERROR 3:
            // Se reemplazaba el total en lugar de acumular.
            total = v;

            // ERROR 4:
            // Asignacion incorrecta.
            // Debia ser mayor = v;
            if (v > mayor) {
                mayor = ventas[0];
            }
        }

        double promedio = total / ventas.length;

        int contador = 0;
        int j = 0;

        while (j <= ventas.length) {

            // ERROR 5:
            // Uso de <= provoca desbordamiento.
            if (ventas[j] >= promedio) {
                contador++;
            }

            // ERROR 6:
            // Falta j++.
            // Bucle infinito.
        }

        System.out.println("Total vendido: " + total);
        System.out.println("Promedio: " + promedio);
        System.out.println("Venta mayor: " + mayor);
        System.out.println("Cantidad mayores al promedio: " + contador);
    }
}
*/
