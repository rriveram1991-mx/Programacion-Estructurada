/* Luis Manuel Aguilera Montoya
Realizar ejemplo de array bidimensional: Asientos de cine */

import java.util.Scanner;

public class REQ1_SEM6_2C_ArrayBi_cine
{

    public static void main(String[] args)
    {
         Scanner entrada = new Scanner(System.in);
         int col, fila;
        
        // Definimos las dimensiones del cine (5 filas x 5 columnas)
        char[][] asientos = new char[5][5];
        
        // Inicializamos la sala: todos los asientos están Libres ('O')
        for (int i = 0; i < asientos.length; i++)
            {
            for (int j = 0; j < asientos[i].length; j++)
            {
                asientos[i][j] = 'O';
            }
        }
        
        while (true)
        {
            System.out.println("\n--- ESTADO DE LA SALA ---");
            System.out.println("   0 1 2 3 4 (Columnas)");
            for (int i = 0; i < asientos.length; i++)
            {
                System.out.print(i + " ["); // Índice de fila
                for (int j = 0; j < asientos[i].length; j++)
                {
                    System.out.print(asientos[i][j] + " ");
                }
                System.out.println("]");
            }

            System.out.println("\n1. Comprar asiento");
            System.out.println("2. Salir");
            System.out.print("Elige una opción: ");
            int opcion = entrada.nextInt();

            if (opcion == 1)
            {
                System.out.print("Introduce fila (0-4): ");
                fila = entrada.nextInt();
                System.out.print("Introduce columna (0-4): ");
                col = entrada.nextInt();

                if (fila >= 0 && fila < 5 && col >= 0 && col < 5)
                {
                    if (asientos[fila][col] == 'O')
                    {
                        asientos[fila][col] = 'X';  //Se reserva, y se cambia a no disponible el asiento
                        System.out.println("¡Reserva realizada con éxito!");
                    } else
                    {
                        System.out.println("Este asiento ya está ocupado...");
                    }
                }
                else
                {
                    System.out.println("Coordenadas inválidas.");
                }
            }
            else
            {
                System.out.println("Hasta luego!");
                break;
            }
        }
    }
}