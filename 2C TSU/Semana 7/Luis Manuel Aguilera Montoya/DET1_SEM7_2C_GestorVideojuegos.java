/* Luis Manuel Aguilera Montoya*/

/* ERRORES
Tipo de error      Linea aprox.    Explicacion
1. Ejecución	       46/50       sc.nextInt() deja un carácter de "nueva línea" (\n) en el búfer. Esto hace que el siguiente sc.nextLine() se salte la lectura del nombre. Agregar algo que limpie el bufer                                                                       Corrección
2. Ejecución	        59         El bucle usa i <= juegos.length, lo que causa un ArrayIndexOutOfBoundsException.	Cambiar a i < juegos.length.
3. Logico               64         El bucle recorre toda la matriz y se queda con la última fila vacía. Además, sobreescribirá los datos si no se detiene (break) al encontrar el primer espacio libre.
4. Logico               85          Si no hay espacios vacíos, fila se queda en 0 y sobreescribe el primer registro. Validar si hay espacio antes de pedir datos.
5. Logico               103        La comparación de Strings se hace con == , lo cual fallará. Se debe usar .equals(juegos[i][0]).
6. Ejecución            122          Intentar convertir un null o una cadena vacía a entero con Integer.parseInt lanzará una excepción. Validar que la posición no sea null antes de sumar.
7. Ejecución            132        Si no hay juegos registrados, suma / juegos.length podría dar error o un promedio falso (dividir entre 10 aunque solo haya 1 juego). Dividir entre un contador real de juegos.
8. Logico               118          El reporte muestra los 10 espacios, incluso los vacíos (null), lo cual se ve desordenado. Solo imprimir si la posición no es nula.
*/

import java.util.Scanner;

public class DET1_SEM7_2C_GestorVideojuegos
{
    public static void main(String[] args)
    {
        // Declaración de variables al inicio
        Scanner sc = new Scanner(System.in);
        String[][] juegos = new String[10][3];
        int opcion = 0;
        int filaLibre;
        int i, j;
        int contadorJuegos;
        int sumaHoras;
        String nombre, genero, horasStr, buscar;
        boolean encontrado;

        while (opcion != 7)
        {
            System.out.println("\n--- GESTOR DE VIDEOJUEGOS ---");
            System.out.println("1. Registrar");
            System.out.println("2. Mostrar");
            System.out.println("3. Buscar");
            System.out.println("4. Estadisticas");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opcion: ");

            // Validación de entrada numérica
            if (sc.hasNextInt())
            {
                opcion = sc.nextInt();
                sc.nextLine(); // Limpiar buffer
            } else
            {
                System.out.println("Error: Por favor ingresa un numero valido.");
                sc.nextLine(); // Limpiar buffer del error
                continue;
            }

            switch (opcion)
            {
                case 1:
                    filaLibre = -1;
                    // Buscar primer espacio disponible
                    for (i = 0; i < juegos.length; i++)
                    {
                        if (juegos[i][0] == null)
                        {
                            filaLibre = i;
                            break; 
                        }
                    }

                    if (filaLibre != -1)
                    {
                        System.out.print("Nombre: ");
                        juegos[filaLibre][0] = sc.nextLine();
                        System.out.print("Genero: ");
                        juegos[filaLibre][1] = sc.nextLine();
                        System.out.print("Horas: ");
                        juegos[filaLibre][2] = sc.nextLine();
                        System.out.println("Registrado con exito.");
                    } else
                    {
                        System.out.println("Error: Memoria llena, no puedes agregar mas juegos.");
                    }
                    break;

                case 2:
                    contadorJuegos = 0;
                    for (i = 0; i < juegos.length; i++) //ERROR 5 (Lógico): Si la fila está vacía, imprimirá "null - null - null".
                    {
                        if (juegos[i][0] != null)
                        {
                            System.out.println("[" + i + "] " + juegos[i][0] + " | Gen: " + juegos[i][1] + " | Hrs: " + juegos[i][2]);
                            contadorJuegos++;
                        }
                    }
                    if (contadorJuegos == 0) System.out.println("No hay videojuegos registrados.");
                    break;

                case 3:
                    System.out.print("Nombre del juego a buscar: ");
                    buscar = sc.nextLine();
                    encontrado = false;

                    for (i = 0; i < juegos.length; i++)
                    {
                        if (juegos[i][0] != null && juegos[i][0].equalsIgnoreCase(buscar))
                        {
                            System.out.println("Encontrado en posicion " + i + ": " + juegos[i][1]);
                            encontrado = true;
                        }
                    }
                    if (!encontrado) System.out.println("Juego no encontrado.");
                    break;

                case 4:
                    sumaHoras = 0;
                    contadorJuegos = 0;

                    for (i = 0; i < juegos.length; i++)
                    {
                        if (juegos[i][0] != null)
                        {
                            try {
                                sumaHoras += Integer.parseInt(juegos[i][2]);
                                contadorJuegos++;
                            } catch (NumberFormatException e){
                                // En caso de que las horas no sean numéricas
                            }
                        }
                    }

                    if (contadorJuegos > 0)
                    {
                        System.out.println("Total de juegos: " + contadorJuegos);
                        System.out.println("Promedio de horas: " + (double) sumaHoras / contadorJuegos);
                    } else
                    {
                        System.out.println("No hay datos para calcular estadisticas.");
                    }
                    break;

                case 7:
                    System.out.println("Saliendo del sistema... Adios.");
                    break;

                default:
                    System.out.println("Opcion no valida.");
            }
        }
    }
}

