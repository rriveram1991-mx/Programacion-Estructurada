import java.util.Scanner;

public class Batalla_RGP 
{
    public static void main(String[] args) 
    {

        Scanner leer = new Scanner(System.in);

        String[][] nombresHeroes = new String[2][3];
        int[][] vidaHeroes = new int[2][3];
        int[][] ataqueHeroes = new int[2][3];
        int[][] magiaHeroes = new int[2][3];
        int[][] energiaHeroes = new int[2][3];
        boolean[][] estadoVivo = new boolean[2][3];
        int[][] contadorCuraciones = new int[2][3];

        
        for (int jugador = 0; jugador < 2; jugador++) 
        {
            System.out.println("\nJugador " + (jugador + 1));

            for (int heroe = 0; heroe < 3; heroe++) 
            {

                System.out.print("Nombre del héroe: ");
                nombresHeroes[jugador][heroe] = leer.next();

                vidaHeroes[jugador][heroe] = 100;
                ataqueHeroes[jugador][heroe] = 20;
                magiaHeroes[jugador][heroe] = 35;
                energiaHeroes[jugador][heroe] = 50;
                estadoVivo[jugador][heroe] = true;
                contadorCuraciones[jugador][heroe] = 0;
            }
        }

        int turnoJugador = 0;

    
        while (equipoTieneVivos(estadoVivo, 0) && equipoTieneVivos(estadoVivo, 1)) 
        {

            int jugadorEnemigo = (turnoJugador == 0) ? 1 : 0;

            System.out.println("\nTurno del Jugador " + (turnoJugador + 1));

            int heroeActivo = seleccionarHeroe(estadoVivo, nombresHeroes, vidaHeroes, turnoJugador,leer);

            boolean accion = false;

            while (!accion) 
            {
                System.out.println("~~~~~~~~~~~~ELIGE QUE DESEAS REALIZAR~~~~~~~~~~~~");

                System.out.println("\n1. Ataque fisico");
                System.out.println("2. Ataque mágico");
                System.out.println("3. Curarse");
                System.out.println("4. Cambiar heroe");

                int opcion = leer.nextInt();

                switch (opcion) 
                {

                    case 1: 

                        int objetivo = seleccionarHeroe(estadoVivo, nombresHeroes, vidaHeroes, jugadorEnemigo, leer);

                        int daño = ataqueHeroes[turnoJugador][heroeActivo];

                        int probabilidad = (int)(Math.random() * 100);
                        if (probabilidad < 20) 
                        {
                            daño *= 2;
                            System.out.println("Golpe critico!");
                        }

                        vidaHeroes[jugadorEnemigo][objetivo] -= daño;

                        System.out.println(nombresHeroes[turnoJugador][heroeActivo] + " ataco a " + nombresHeroes[jugadorEnemigo][objetivo] + " causando " + daño + " de daño");

                        revisarEstadoHeroe(vidaHeroes, estadoVivo, jugadorEnemigo, objetivo, nombresHeroes);

                        accion = true;
                        break;

                    case 2: 

                        if (energiaHeroes[turnoJugador][heroeActivo] >= 10) 
                        {

                            int objetivoMagico = seleccionarHeroe(estadoVivo, nombresHeroes, vidaHeroes, jugadorEnemigo, leer);

                            vidaHeroes[jugadorEnemigo][objetivoMagico] -= magiaHeroes[turnoJugador][heroeActivo];
                            energiaHeroes[turnoJugador][heroeActivo] -= 10;

                            System.out.println("Ataque magico realizado");

                            revisarEstadoHeroe(vidaHeroes, estadoVivo, jugadorEnemigo, objetivoMagico, nombresHeroes);

                            accion = true;

                        } 
                        else 
                        {
                            System.out.println("No tienes suficiente energia");
                        }
                        break;

                    case 3:

                        if (contadorCuraciones[turnoJugador][heroeActivo] < 2) 
                        {

                            vidaHeroes[turnoJugador][heroeActivo] += 20;
                            contadorCuraciones[turnoJugador][heroeActivo]++;

                            System.out.println("Te curaste. Vida actual: " +
                                    vidaHeroes[turnoJugador][heroeActivo]);

                            accion = true;

                        } 
                        else 
                        {
                            System.out.println("Ya no puedes curarte mas");
                        }
                        break;

                    case 4: 
                        

                        heroeActivo = seleccionarHeroe(estadoVivo, nombresHeroes, vidaHeroes, turnoJugador, leer );
                        break;
                }
            }

            turnoJugador = jugadorEnemigo;
        }

        
        System.out.println("\nFIN DEL JUEGO");

        if (equipoTieneVivos(estadoVivo, 0)) 
        {
            System.out.println("Gana Jugador 1");
        } 
        else 
        {
            System.out.println("Gana Jugador 2");
        }
    }

 
    public static boolean equipoTieneVivos(boolean[][] estadoVivo, int jugador) 
    {

        for (int heroe = 0; heroe < 3; heroe++) 
        {
            if (estadoVivo[jugador][heroe]) 
            {
                return true;
            }
        }
        return false;
    }

    public static int seleccionarHeroe
        (boolean[][] estadoVivo, String[][] nombresHeroes, int[][] vidaHeroes, int jugador, Scanner leer ) 
        {

        int opcion = -1;

        while (opcion == -1) 
        {

            System.out.println("Selecciona un heroe:");

            for (int heroe = 0; heroe < 3; heroe++) 
            {
                if (estadoVivo[jugador][heroe]) 
                {
                    System.out.println(heroe + ". " + nombresHeroes[jugador][heroe] +
                            " (HP: " + vidaHeroes[jugador][heroe] + ")");
                }
            }

            int seleccion = leer.nextInt();

            if (seleccion >= 0 && seleccion < 3 && estadoVivo[jugador][seleccion]) 
            {
                opcion = seleccion;
            } 
            else 
            {
                System.out.println("Seleccion invalida");
            }
        }

        return opcion;
    }

    public static void revisarEstadoHeroe(int[][] vidaHeroes, boolean[][] estadoVivo, int jugador, int heroe, String[][] nombresHeroes) 
    {

        if (vidaHeroes[jugador][heroe] <= 0) 
        {

            vidaHeroes[jugador][heroe] = 0;
            estadoVivo[jugador][heroe] = false;

            System.out.println(nombresHeroes[jugador][heroe] + " ha muerto");

        } 
        else 
        {
            System.out.println("Vida restante: " + vidaHeroes[jugador][heroe]);
        }
    }
}