package org.example;

import CRUD.DINO.tabladinosaurios;
import CRUD.MOCHILA.tablamochila;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- PANEL DE CONTROL JURASIC ---");
            System.out.println("1. Registrar nuevo Dinosaurio");
            System.out.println("2. Registrar objeto en Mochila");
            System.out.println("3. Actualizar un valor");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opción: ");

            opcion = entrada.nextInt();

            switch (opcion) {
                case 1:
                    tabladinosaurios.registrarDino();
                    break;
                case 2:
                    tablamochila.registrarArma();
                    break;
                case 3:
                    System.out.println("¿Qué valor deseas actualizar? (1. Dinosaurio / 2. Mochila)");
                    int subOpcion = entrada.nextInt();
                    if(subOpcion == 1) {
                        tabladinosaurios.actualizarDino();
                    } else {
                        tablamochila.actualizarMochila();
                    }
                    break;
                case 4:
                    System.out.println("Cerrando sistema...");
                    break;
                default:
                    System.out.println("Opción no válida, intenta de nuevo.");
            }
        } while (opcion != 4);
    }
}