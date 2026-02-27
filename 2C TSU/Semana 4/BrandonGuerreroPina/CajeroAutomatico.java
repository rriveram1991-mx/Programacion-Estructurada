/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cajeroautomatico;

import java.util.Scanner;

/**
 *
 * @author UTT
 */
public class CajeroAutomatico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);// Crea un objeto Scanner para poder leer datos que el usuario escriba en el teclado
        
        System.out.println("Bienvenido a VVBA");// Muestra un mensaje de bienvenida en pantalla
        
        int saldo = 50000;// Variable que guarda el dinero disponible en la cuenta (saldo inicial)
        int seleccion = 0;// Variable que almacena la opción que el usuario elige del menú
        int salir = 0;// Variable que se usa para saber si el usuario quiere continuar o salir
        int contadorOperaciones = 0;// Contador para registrar cuántas operaciones válidas se realizan
        
        // Muestra el menú de opciones
        while (seleccion != 4){// Ciclo que se repetirá mientras la opción seleccionada NO sea 4 (Salir)
            System.out.println("Menu del servicio");
            System.out.println("Tecle la opcion que necesite");
            System.out.println("1) Consultar saldo");
            System.out.println("2) Depositar en efectivo");
            System.out.println("3) Retiro de dinero");
            System.out.println("4) Salir");
            
            seleccion = sc.nextInt();// Guarda la opción que el usuario escribe
            
            if (seleccion == 1){ // Si el usuario elige 1 (Consultar saldo)
                //Opcion de consultar el saldo
                System.out.println("Su saldo actual es de: $"+saldo);// Muestra el saldo actual
                contadorOperaciones++;// Aumenta el contador porque se realizó una operación
                System.out.println("¿Desea realizar otra operacion? 1) Si 2) No"); // Pregunta si desea hacer otra operación
                salir = sc.nextInt();// Guarda la respuesta
                if (salir == 2)// Si el usuario elige 2 (No)
                {
                    seleccion = 4;// Cambia la selección a 4 para salir del ciclo
                }
            }
            else if (seleccion == 2){// Si el usuario elige 2 (Depositar)
                System.out.println("Ingrese la cantidad a depositar: "); // Solicita la cantidad a depositar
                // Mensajes informativos del cajero
                System.out.println("No se aceptan monedas, billetes rotos, billetes doblados");
                System.out.println("Capacidad maxima de 45 billetes de culquiera denominacion por transaccion");
                int deposito = sc.nextInt();  // Guarda la cantidad ingresada
                // Verifica que el depósito sea mayor a 0
                if (deposito > 0){
                    saldo += deposito;// Suma el depósito al saldo
                    System.out.println("Deposito de: $"+deposito+" exitoso!");// Muestra mensaje de éxito
                    contadorOperaciones++;// Aumenta el contador de operaciones
                     // Pregunta si desea continuar
                    System.out.println("¿Desea realizar otra operacion? 1) Si 2) No");
                    salir = sc.nextInt();
                    // Si elige no, se prepara para salir
                    if (salir == 2)
                    {
                    seleccion = 4;
                    }
                }
                // Si la cantidad ingresada es negativa (caso del depósito anterior)
                else {
                        // Se muestra mensaje de error porque no se permiten números negativos
                    System.out.println("Error: No se permiten cantidades negativas");
                }
                // Se pregunta al usuario si desea realizar otra operación
                System.out.println("¿Desea realizar otra operacion? 1) Si 2) No");
                salir = sc.nextInt();
                if (salir == 2){
                        // Se cambia la selección a 4 para forzar la salida del menú
                    seleccion = 4;
                }
            }
            // Si el usuario selecciona la opción 3 (Retirar dinero)
            else if (seleccion == 3)
            {
            // Se solicita la cantidad que desea retirar
                System.out.println("Ingrese la cantidad a retirar: ");
                int retiro = sc.nextInt();// Se guarda la cantidad ingresada
                // Se valida que la cantidad sea mayor que 0
                if (retiro > 0)
                {
                    // Se verifica que el retiro no exceda el saldo disponible
                    if(retiro <= saldo )
                    {
                        saldo -=retiro; // Se descuenta el monto retirado del saldo actual
                        System.out.println("Retiro exitoso");
                        contadorOperaciones++;  // Se incrementa el contador de operaciones realizadas correctamente
                    }
                    else 
                    {
                        // Si el retiro es mayor al saldo disponible, se muestra error
                        System.out.println("Error: Fondos insuficiente");  
                    }
                }
                else 
                {
                    // Si la cantidad es 0 o negativa, se muestra mensaje de error
                    System.out.println("Error: No se permiten cantidades negativas");
                }
                    // Se pregunta nuevamente si desea realizar otra operación
                System.out.println("¿Desea realizar otra operacion? 1) Si 2) No");
                salir = sc.nextInt();
                if (salir == 2)
                {
                    seleccion = 4;
                }
            }
            // Si el usuario elige la opción 4 (Salir)
            else if (seleccion == 4)
            {
                    // Se muestra mensaje de despedida
                System.out.println("Gracia por utilizar VVBA");
            }
            // Si el usuario escribe una opción diferente a las vlidas
            else
            {
                // Se muestra mensaje indicando que la opcón no es correcta
                System.out.println("Opcion invalida");
            }
        }
// Cuando termina el ciclo while principal
// Se muestra el total de operaciones realizadas exitosamente
System.out.println("Total de operaciones realizadas por el usuario fue: "+ contadorOperaciones);
    }
}

