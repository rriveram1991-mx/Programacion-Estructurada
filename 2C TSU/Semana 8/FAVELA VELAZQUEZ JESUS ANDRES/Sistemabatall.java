/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemabatall;

import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class Sistemabatall {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {    
        Scanner leer = new Scanner(System.in); 

        // REQUERIMIENTOS: Inicialización de matrices (2 jugadores, 3 héroes cada uno)
        String[][] nombres = new String[2][3]; // Matriz para almacenar los nombres de los héroes
        int[][] vida = new int[2][3]; // Matriz para almacenar los puntos de vida de cada héroe
        int[][] ataque = new int[2][3]; // Matriz para el daño de ataque físico
        int[][] magia = new int[2][3]; // Matriz para el daño de ataque mágico
        int[][] energia = new int[2][3]; // Matriz para la energía disponible para usar magia
        boolean[][] vivo = new boolean[2][3]; // Matriz booleana para saber si el héroe sigue vivo
        int[][] curaciones = new int[2][3]; // Matriz para llevar el conteo de curaciones (máximo 2)

        // Llenado de datos base para el Jugador 1 (Índice 0)
        nombres[0][0] = "Guerrero J1"; vida[0][0] = 100; ataque[0][0] = 25; magia[0][0] = 10; energia[0][0] = 30; vivo[0][0] = true; curaciones[0][0] = 0; // Héroe 1 del J1
        nombres[0][1] = "Mago J1"; vida[0][1] = 80; ataque[0][1] = 10; magia[0][1] = 35; energia[0][1] = 50; vivo[0][1] = true; curaciones[0][1] = 0; // Héroe 2 del J1
        nombres[0][2] = "Arquero J1"; vida[0][2] = 90; ataque[0][2] = 20; magia[0][2] = 15; energia[0][2] = 20; vivo[0][2] = true; curaciones[0][2] = 0; // Héroe 3 del J1

        // Llenado de datos base para el Jugador 2 (Índice 1)
        nombres[1][0] = "Guerrero J2"; vida[1][0] = 100; ataque[1][0] = 25; magia[1][0] = 10; energia[1][0] = 30; vivo[1][0] = true; curaciones[1][0] = 0; // Héroe 1 del J2
        nombres[1][1] = "Mago J2"; vida[1][1] = 80; ataque[1][1] = 10; magia[1][1] = 35; energia[1][1] = 50; vivo[1][1] = true; curaciones[1][1] = 0; // Héroe 2 del J2
        nombres[1][2] = "Arquero J2"; vida[1][2] = 90; ataque[1][2] = 20; magia[1][2] = 15; energia[1][2] = 20; vivo[1][2] = true; curaciones[1][2] = 0; // Héroe 3 del J2

        // Variables de control del juego
        boolean jugador1_tiene_vivos = true; // Bandera para saber si el Jugador 1 no ha perdido
        boolean jugador2_tiene_vivos = true; // Bandera para saber si el Jugador 2 no ha perdido
        int turno = 0; // Variable para alternar turnos (0 = Jugador 1, 1 = Jugador 2)

        // Variables para guardar las selecciones temporales
        int hActual = -1; // Guardará el índice del héroe que está atacando
        int hEnemigo = -1; // Guardará el índice del héroe enemigo que recibirá el daño

        System.out.println("¡COMIENZA LA BATALLA!"); // Mensaje de bienvenida al juego

        // Bucle principal del juego: mientras ambos tengan vivos
        while (jugador1_tiene_vivos && jugador2_tiene_vivos) { // Verifica la condición de victoria/derrota
            
            int enemigo = (turno == 0) ? 1 : 0; // Si es turno de J1(0), el enemigo es J2(1), y viceversa
            System.out.println("\n--- TURNO DEL JUGADOR " + (turno + 1) + " ---"); // Imprime de quién es el turno

            // Fase 1: Selección de héroe propio
            boolean heroeValido = false; // Bandera para controlar que elija un héroe vivo
            while (!heroeValido) { // Repite hasta que elija un héroe válido
                System.out.println("Elige a tu héroe (0, 1 o 2):"); // Pide al usuario elegir
                for (int i = 0; i < 3; i++) { // Recorre los 3 héroes del jugador actual
                    if (vivo[turno][i]) { // Valida si el héroe en la posición 'i' está vivo
                        // Muestra las estadísticas actuales del héroe vivo
                        System.out.println(i + ". " + nombres[turno][i] + " [Vida: " + vida[turno][i] + " | Energía: " + energia[turno][i] + "]"); 
                    }
                }
                hActual = leer.nextInt(); // Lee el número del héroe seleccionado
                
                // Valida que el número esté entre 0 y 2, y que el héroe esté vivo
                if (hActual >= 0 && hActual <= 2 && vivo[turno][hActual]) { 
                    heroeValido = true; // Cambia la bandera para salir del ciclo de selección
                } else { // Si eligió mal
                    System.out.println("Héroe no válido o está muerto. Intenta de nuevo."); // Mensaje de error
                }
            }

            // Fase 2: Menú de acciones
            boolean turnoCompletado = false; // Bandera para saber si ya hizo una acción que consuma el turno
            while (!turnoCompletado) { // Bucle de menú por si elige una opción inválida o sin recursos
                System.out.println("\n¿Qué hará " + nombres[turno][hActual] + "?"); // Muestra el héroe activo
                System.out.println("1. Ataque físico"); // Opción 1
                System.out.println("2. Ataque mágico"); // Opción 2
                System.out.println("3. Curarse"); // Opción 3
                System.out.println("4. Cambiar héroe"); // Opción 4
                int opcion = leer.nextInt(); // Lee la decisión del jugador

                int daño = 0; // Variable para calcular el daño final antes de aplicarlo

                // Estructura condicional para evaluar la opción seleccionada
                if (opcion == 1 || opcion == 2) { // Si eligió atacar (físico o mágico), necesita un objetivo
                    
                    if (opcion == 2 && energia[turno][hActual] < 10) { // Valida si quiere usar magia pero no tiene energía
                        System.out.println("No tienes suficiente energía (mínimo 10). Elige otra acción."); // Mensaje de error
                        continue; // Vuelve al inicio del menú de acciones
                    }

                    // Selección de objetivo enemigo
                    boolean objetivoValido = false; // Bandera para validar al enemigo
                    while (!objetivoValido) { // Bucle hasta elegir enemigo válido
                        System.out.println("Elige a quién atacar (0, 1 o 2):"); // Pide objetivo
                        for (int i = 0; i < 3; i++) { // Recorre héroes enemigos
                            if (vivo[enemigo][i]) { // Si el enemigo está vivo
                                // Muestra nombre y vida del enemigo
                                System.out.println(i + ". " + nombres[enemigo][i] + " [Vida: " + vida[enemigo][i] + "]"); 
                            }
                        }
                        hEnemigo = leer.nextInt(); // Lee selección de objetivo
                        if (hEnemigo >= 0 && hEnemigo <= 2 && vivo[enemigo][hEnemigo]) { // Valida rango y si está vivo
                            objetivoValido = true; // Sale del bucle de selección de objetivo
                        } else { // Si el objetivo no es válido
                            System.out.println("Objetivo inválido. Intenta de nuevo."); // Mensaje de error
                        }
                    }

                    // Calculamos el daño base según la opción
                    if (opcion == 1) { // Si fue ataque físico
                        daño = ataque[turno][hActual]; // El daño es igual a su stat de ataque
                        System.out.println(nombres[turno][hActual] + " usa Ataque Físico contra " + nombres[enemigo][hEnemigo] + "!"); // Anuncio
                    } else if (opcion == 2) { // Si fue ataque mágico
                        daño = magia[turno][hActual]; // El daño es igual a su stat de magia
                        energia[turno][hActual] -= 10; // Resta el costo de energía (10)
                        System.out.println(nombres[turno][hActual] + " usa Magia contra " + nombres[enemigo][hEnemigo] + "! (-10 energía)"); // Anuncio
                    }

                    // EVENTO ALEATORIO: Probabilidad de crítico
                    int prob = (int)(Math.random() * 100); // Genera número aleatorio del 0 al 99
                    if (prob < 20) { // 20% de probabilidad (del 0 al 19)
                        daño *= 2; // Duplica el daño calculado
                        System.out.println("¡Golpe crítico!"); // Anuncia el golpe crítico
                    }

                    // Aplicamos el daño al enemigo
                    vida[enemigo][hEnemigo] -= daño; // Resta el daño final a la vida del enemigo
                    System.out.println("Causa " + daño + " puntos de daño."); // Muestra el daño causado
                    
                    // Sistema de muerte
                    if (vida[enemigo][hEnemigo] <= 0) { // Si la vida bajó a 0 o menos
                        vida[enemigo][hEnemigo] = 0; // La vida se iguala a 0 exacto (para no mostrar negativos)
                        vivo[enemigo][hEnemigo] = false; // Cambia su estado a muerto (false)
                        System.out.println("¡" + nombres[enemigo][hEnemigo] + " ha MUERTO!"); // Anuncia la muerte
                    } else { // Si sobrevivió
                        System.out.println("Vida restante de " + nombres[enemigo][hEnemigo] + ": " + vida[enemigo][hEnemigo]); // Muestra vida actual
                    }
                    turnoCompletado = true; // Termina el turno correctamente

                } else if (opcion == 3) { // Si eligió Curarse
                    if (curaciones[turno][hActual] < 2) { // Valida que tenga menos de 2 curaciones usadas
                        vida[turno][hActual] += 20; // Le suma 20 a su vida actual
                        curaciones[turno][hActual]++; // Incrementa el contador de curaciones de este héroe en 1
                        System.out.println(nombres[turno][hActual] + " se ha curado 20 de vida! (Vida actual: " + vida[turno][hActual] + ")"); // Anuncio
                        System.out.println("Curaciones restantes: " + (2 - curaciones[turno][hActual])); // Muestra cuántas le quedan
                        turnoCompletado = true; // Termina el turno correctamente
                    } else { // Si ya se curó 2 veces
                        System.out.println("Ya no puedes curarte más con este héroe (Máximo 2 veces)."); // Mensaje de error
                        // No cambia turnoCompletado a true, por lo que el while repite el menú
                    }

                } else if (opcion == 4) { // Si eligió Cambiar héroe
                    System.out.println("Decidiste cambiar de héroe."); // Anuncio
                    break; // Rompe el ciclo del menú (turnoCompletado sigue false). Al salir, repetirá la fase 1.
                } else { // Si puso un número que no es del 1 al 4
                    System.out.println("Opción no válida."); // Mensaje de error
                }
            } // Fin del while del menú

            // Si el jugador eligió la opción 4 (Cambiar), se rompió el bucle pero turnoCompletado es false.
            // Para evitar que pase al siguiente jugador si solo quería cambiar, usamos un if.
            if (!turnoCompletado) { // Si el turno no se completó (ej. cambió héroe)
                continue; // Vuelve al inicio del while principal sin cambiar de jugador
            }

            // Fase 3: Verificación de victoria/derrota antes de pasar el turno
            jugador1_tiene_vivos = vivo[0][0] || vivo[0][1] || vivo[0][2]; // Es true si al menos un héroe de J1 está vivo
            jugador2_tiene_vivos = vivo[1][0] || vivo[1][1] || vivo[1][2]; // Es true si al menos un héroe de J2 está vivo

            // Cambio de turno (siempre que el juego deba continuar)
            if (jugador1_tiene_vivos && jugador2_tiene_vivos) { // Si nadie ha perdido aún
                turno = (turno == 0) ? 1 : 0; // Si turno era 0, pasa a 1. Si era 1, pasa a 0.
            }

        } // Fin del while principal de batalla

        // Resultados finales cuando alguien pierde
        System.out.println("\n===== FIN DE LA BATALLA ====="); // Anuncio de fin de juego
        if (!jugador1_tiene_vivos) { // Si jugador 1 no tiene vivos
            System.out.println("¡El Jugador 2 ha GANADO!"); // Gana jugador 2
        } else if (!jugador2_tiene_vivos) { // Si jugador 2 no tiene vivos
            System.out.println("¡El Jugador 1 ha GANADO!"); // Gana jugador 1
        }
        
        leer.close(); // Cerramos el Scanner para liberar recursos en memoria
    }
}
    
    

