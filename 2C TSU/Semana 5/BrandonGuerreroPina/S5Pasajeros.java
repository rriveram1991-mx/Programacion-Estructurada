/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package s5.pasajeros;

import java.util.Scanner;

/**
 *
 * @author LABTICS
 */
public class S5Pasajeros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        // Se muestra un título del sistema para indicar al usuario la función del programa
        System.out.println("////////Sistemas de pasajeros////////");
        // Se solicita al usuario ingresar el número de pasajeros que serán registrados
        System.out.println("Cuantos pasajeros son?");
        // Se lee el número de pasajeros y se almacena en la variable n
        int n = leer.nextInt();
        leer.nextLine();// Se limpia el buffer del teclado para evitar problemas con lecturas posteriores de texto
        // Se crean dos arreglos de tipo String para almacenar los nombres y destinos de los pasajeros
        String [] nombres = new String [n];
        String [] destinos = new String [n];
        
        // Se utiliza un ciclo for para capturar la información de cada pasajero
        // El ciclo se repetirá tantas veces como pasajeros se hayan indicado
        for(int i=0; i<n;i++){
            
            // Se muestra el número del pasajero que se está registrando
            System.out.println("Pasajero " + (i+1)+":");
            // Se solicita al usuario ingresar el nombre del pasajero
            System.out.println("Ingrese el nombre del pasajero: ");
            // Se guarda el nombre ingresado en la posición correspondiente del arreglo
            nombres[i]=leer.nextLine();
        // Se utiliza un ciclo while para validar que el nombre no esté vacío
        // Si el nombre está vacío, el sistema volverá a solicitarlo
        while (nombres[i].isEmpty()){
            // Se verifica nuevamente si el nombre está vacío
            if (nombres[i].isEmpty()){
                // Se muestra un mensaje de error indicando que el nombre no puede estar vacío
                System.out.println("Error: El nombre no puede estar vacio");
                // Se solicita nuevamente el nombre del pasajero
                System.out.println("Ingrese nuevamente el nombre");
                // Se vuelve a guardar el nombre en el arreglo
                nombres[i]=leer.nextLine();
            }
        }
        // Se muestran las opciones de destinos disponibles
        System.out.println("Destinos disponibles (CDMX - Local - Otros)");
        destinos[i] = leer.nextLine();// Se solicita y almacena el destino del pasajero
        }
        // Se crean variables contadoras para registrar cuántos pasajeros viajan a cada destino
        int cdmx =0;
        int local = 0;
        int otros = 0;
        // Se muestra un título indicando que se desplegará la lista de pasajeros
        System.out.println("Lista de pasajeros");
        
        // Se utiliza un ciclo for-each para recorrer el arreglo de nombres
        // Este ciclo permite mostrar todos los pasajeros registrados
        for(String nombre: nombres){
            // Se imprime el nombre de cada pasajero 
            System.out.println("Pasajero: "+nombre);
            }
        // Se utiliza un ciclo for-each para recorrer el arreglo de destinos
        // En este ciclo se clasifican los pasajeros según su destino
            for(String destino : destinos){
                    // Si el destino es CDMX se considera un viaje largo
                if (destino.equalsIgnoreCase("CDMX")){
                    // Se muestra el tipo de viaje
                    System.out.println("Destino a CDMX -> Viaje largo");
                    cdmx++; // Se incrementa el contador de pasajeros que viajan a CDMX
                }
                // Si el destino es Local se considera un viaje corto
                else if(destino.equalsIgnoreCase("Local")){
                    System.out.println("Destino a Local -> Viaje corto");
                    local++;
                }
                // Si el destino no es CDMX ni Local se clasifica como otros destinos
                else {
                    otros++;
                }
            }
            // Se crea una variable para almacenar el destino con mayor número de pasajeros
            String destinoMayor = "Otros";
            // Se inicializa una variable para comparar cuál destino tiene más pasajeros
            int mayor = otros;
            // Se compara si CDMX tiene más pasajeros que el valor actual almacenado
            if (cdmx> mayor){
                // Se actualiza el valor mayor
                mayor = cdmx;
                // Se establece CDMX como el destino con más pasajeros
                destinoMayor="CDMX";
            }
            // Se compara si el destino Local tiene más pasajeros
            if(local > mayor){
                mayor = local;
                    // Se establece Local como el destino con más pasajeros
                destinoMayor = "Local";
            }
            
            System.out.println("Resultados");
            System.out.println("Pasajeros Locales: "+local);
            System.out.println("Pasajeros a CDMX "+cdmx);
            System.out.println("Pasajeros a otros destinos "+otros);
            System.out.println("Destino con mas pasajeros "+destinoMayor);
            System.out.println("Pasajeros registrados "+n);
        }
        

    }
    

