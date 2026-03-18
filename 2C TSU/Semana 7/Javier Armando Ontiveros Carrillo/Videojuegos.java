package videojuegos;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Videojuegos {
    
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        
        String[][] juegos = new String[10][3];
        int numeroJuegosRegistrados = 0; 

        int opcion = 0;
        
        while (opcion != 7) {

            mostrarMenu();

            try {
                System.out.print("Seleccione una opción: ");
                opcion = leer.nextInt();
                leer.nextLine();

                switch (opcion) {

                    case 1: 
                        
                        int filaLibre = -1;
                        
                        for (int i = 0; i < juegos.length; i++) {
                            if (juegos[i][0] == null) {
                                filaLibre = i;
                                break; 
                            }
                        }
                        
                        if (filaLibre != -1) { 
                            System.out.println("\n--- Registrar Nuevo Videojuego ---");
                            System.out.print("Nombre: ");
                            String nombre = leer.nextLine();
                            
                            if (nombre.trim().isEmpty()) {
                                System.out.println("Error: El nombre del videojuego no puede estar vacío.");
                                break; 
                            }

                            System.out.print("Género: ");
                            String genero = leer.nextLine();
                            
                            if (genero.trim().isEmpty()) {
                                System.out.println("Error: El género del videojuego no puede estar vacío.");
                                break; 
                            }

                            int horasJugadas = -1;
                            boolean entradaValida = false;
                            while (!entradaValida) {
                                System.out.print("Horas jugadas (número entero): ");
                                try {
                                    horasJugadas = leer.nextInt();
                                    
                                    leer.nextLine();
                                    
                                    if (horasJugadas < 0) {
                                        System.out.println("Error: Las horas jugadas no pueden ser negativas.");
                                    } else {
                                        entradaValida = true; 
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.println("Error: Por favor, ingrese un número entero válido para las horas.");
                                    leer.nextLine();
                                }
                            }
                            
                            juegos[filaLibre][0] = nombre;
                            juegos[filaLibre][1] = genero;
                            juegos[filaLibre][2] = String.valueOf(horasJugadas); 
                            numeroJuegosRegistrados++;
                            System.out.println("¡Videojuego '" + nombre + "' registrado con éxito!");

                        } else {
                            System.out.println("Error: El registro de videojuegos está lleno. No se pueden agregar más.");
                        }
                        break;

                    case 2: 
                        System.out.println("\n--- Lista de Videojuegos Registrados ---");
                        
                        if (numeroJuegosRegistrados == 0) {
                            System.out.println("No hay videojuegos registrados aún.");
                        } else {
                            
                            for (int i = 0; i < numeroJuegosRegistrados; i++) {
                                
                                System.out.println("ID: " + (i + 1) + " | Nombre: " + juegos[i][0] +
                                                   " | Género: " + juegos[i][1] +
                                                   " | Horas: " + juegos[i][2]);
                            }
                        }
                        break;

                    case 3: 
                        System.out.println("\n--- Buscar Videojuego ---");
                        
                        if (numeroJuegosRegistrados == 0) {
                            System.out.println("No hay videojuegos registrados para buscar.");
                            break; 
                        }

                        System.out.print("Ingrese el nombre del videojuego a buscar: ");
                        String buscar = leer.nextLine(); 

                        boolean encontrado = false;
                        
                        for (int i = 0; i < numeroJuegosRegistrados; i++) {
                            
                            if (juegos[i][0] != null && juegos[i][0].equalsIgnoreCase(buscar)) {
                                System.out.println("Encontrado:");
                                System.out.println("  ID: " + (i + 1) + " | Nombre: " + juegos[i][0] +
                                                   " | Género: " + juegos[i][1] +
                                                   " | Horas: " + juegos[i][2]);
                                encontrado = true;
                                
                            }
                        }
                        if (!encontrado) {
                            System.out.println("No se encontró ningún videojuego con el nombre '" + buscar + "'.");
                        }
                        break;

                    case 4:
                        System.out.println("\n--- Estadísticas ---");
                        
                        if (numeroJuegosRegistrados == 0) {
                            System.out.println("No hay videojuegos registrados para calcular estadísticas.");
                            break;
                        }

                        int sumaHoras = 0;
                        
                        for (int i = 0; i < numeroJuegosRegistrados; i++) {
                            try {
                                
                                sumaHoras += Integer.parseInt(juegos[i][2]);
                            } catch (NumberFormatException e) {
                                
                                System.err.println("Advertencia: Se encontró un valor de horas no numérico para el juego ID " + (i + 1) + ". Se ignorará para el promedio.");
                            }
                        }

                        double promedioHoras = (double) sumaHoras / numeroJuegosRegistrados;

                        System.out.println("Total de videojuegos registrados: " + numeroJuegosRegistrados);
                        System.out.println("Suma total de horas jugadas: " + sumaHoras);
                        
                        System.out.printf("Promedio de horas jugadas por videojuego: %.2f%n", promedioHoras);
                        break;

                    case 7:
                        System.out.println("¡Adiós! Gracias por usar el Gestor de Videojuegos.");
                        break;

                    default: 
                        System.out.println("Opción no válida. Por favor, seleccione una opción del menú (1-4, 7).");
                        break;
                }
            } catch (InputMismatchException e) {
                
                System.out.println("Error: Debe ingresar un número para seleccionar una opción.");
                leer.nextLine(); 
                opcion = 0;
            } catch (Exception e) {
                
                System.err.println("Ocurrió un error inesperado: " + e.getMessage());
                opcion = 7; 
            }
        }

        System.out.println("Programa finalizado.");
    }
    
    public static void mostrarMenu() {
        System.out.println("\n=====================================");
        System.out.println("     Gestor de Videojuegos");
        System.out.println("=====================================");
        System.out.println("1. Registrar Videojuego");
        System.out.println("2. Mostrar Todos los Videojuegos");
        System.out.println("3. Buscar Videojuego por Nombre");
        System.out.println("4. Estadísticas (Horas Totales y Promedio)");
        System.out.println("7. Salir");
        System.out.println("-------------------------------------");
    }
}
