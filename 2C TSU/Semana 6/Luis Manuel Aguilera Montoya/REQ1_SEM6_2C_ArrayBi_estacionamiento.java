/* Luis Manuel Aguilera Montoya
Realizar ejemplo de array bidimensional: Estacionamientos carros */

import java.util.Scanner;

public class REQ1_SEM6_2C_ArrayBi_estacionamiento
{

    public static void main(String[] args)
    {
        // Creamos un estacionamiento de 3 filas y 4 columnas
        // true = Ocupado, false = Disponible
        boolean[][] estacionamiento = new boolean[3][4];

        // 1. Simulamos algunos carros ya estacionados
        estacionamiento[0][1] = true;
        estacionamiento[1][2] = true;
        estacionamiento[2][0] = true;
        estacionamiento[2][3] = true;

        // 2. Recorremos el arreglo para mostrar la disponibilidad
        System.out.println("ESTACIONAMIENTO:");
        System.out.println("---------------------------");

        for (int f = 0; f < 3; f++) {
            for (int c = 0; c < 4; c++)
                {
                // Usamos un if para escribir si esta ocupado o libre
                if (estacionamiento[f][c] == true)
                {
                    System.out.print("[OCUPADO] ");
                } else
                {
                    System.out.print("[ LIBRE ] ");
                }
            }
            System.out.println(); // Salto de línea para la siguiente fila
        }
    }
}