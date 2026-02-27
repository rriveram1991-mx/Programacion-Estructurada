/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemacajeroautomatico;
// Importamos la clase Scanner para poder leer datos del teclado
import java.util.Scanner;
/**
 *
 * @author gl873
 */
public class SistemaCajeroAutomatico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         // Creamos un objeto Scanner para leer datos desde el teclado
        Scanner Leer = new Scanner(System.in);

        // Variable para guardar la opción que elija el usuario
        int opcion = 0;

        // Variable que almacena el saldo inicial (empieza con 10,000)
        int saldo = 10000;

        // Variable para guardar la cantidad a depositar
        int deposi = 0;

        // Variable para guardar la cantidad a retirar
        int retirar = 0;

        // Variable booleana para controlar cuándo salir del menú
        boolean salir = false;

        // Contador para llevar registro de cuántas operaciones se realizan
        int contador = 0;

        // Ciclo while que se repetirá mientras salir sea false
        while (salir == false) {

            try { // Intentamos ejecutar el código que puede generar error

                // Mostramos el menú de opciones
                System.out.println("1.-Consultar Saldo");
                System.out.println("2.-Depositar");
                System.out.println("3.-Retirar");
                System.out.println("4.-Salir");

                // Leemos la opción que el usuario ingresa
                opcion = Leer.nextInt();

                // Evaluamos la opción seleccionada usando switch
                switch (opcion) {

                    case 1:
                        // Mostramos el saldo actual
                        System.out.println("Su Saldo Disponible es de: $" + saldo);
                        // Aumentamos el contador de operaciones
                        contador++;
                        break;

                    case 2:
                        // Pedimos la cantidad a depositar
                        System.out.println("Cuanto dinero quiere depositar?");
                        deposi = Leer.nextInt();

                        // Validamos que el depósito sea mayor que 0
                        if (deposi > 0) {

                            // Sumamos el depósito al saldo actual
                            saldo = saldo + deposi;

                            // Mostramos mensaje de éxito
                            System.out.println("Se ha realizado con exito el deposito");
                            System.out.println("Su saldo actualizado es de: $" + saldo);

                            // Aumentamos el contador
                            contador++;

                        } else {
                            // Si la cantidad no es válida
                            System.out.println("No se puede depositar esa cantidad");
                        }
                        break;

                    case 3:
                        // Pedimos la cantidad a retirar
                        System.out.println("Cuanto dinero quiere retirar?");
                        retirar = Leer.nextInt();

                        // Verificamos que haya saldo suficiente
                        if (saldo >= retirar && saldo > 0) {

                            // Restamos el dinero del saldo
                            saldo = saldo - retirar;

                            // Mostramos mensaje de éxito
                            System.out.println("Se ha realizado con exito el retiro");
                            System.out.println("Su saldo actualizado es de: $" + saldo);

                            // Aumentamos el contador
                            contador++;

                        } else {
                            // Si no hay saldo suficiente
                            System.out.println("No se puede retirar esa cantidad // Ya no le queda saldo");
                        }
                        break;

                    case 4:
                        // Cambiamos salir a true para terminar el ciclo
                        salir = true;

                        // Mostramos mensaje de salida
                        System.out.println("Saliendo...");

                        // Mostramos el total de operaciones realizadas
                        System.out.println("El numero total de operaciones realizadas es de: " + contador);
                        break;

                    default:
                        // Si el usuario ingresa una opción inválida
                        System.out.println("No existe esa opcion...");
                        break;
                }

            } catch (Exception e) {
                // Si el usuario ingresa letras o números decimales
                System.out.println("No se pueden ingresar numeros decimales o letras");
                break; // Salimos del ciclo en caso de error
            }

        }

    }
}