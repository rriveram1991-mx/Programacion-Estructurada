package pokemon;

import pokemon.dao.pokedex;
import pokemon.modelos.pokemon;
import pokemon.logica.batalla;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Registrar Pokémon");
            System.out.println("2. Ver Pokédex");
            System.out.println("3. Eliminar");
            System.out.println("4. Actualizar");
            System.out.println("5. Batalla");
            System.out.println("0. Salir");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> pokedex.registrarPokemon();
                case 2 -> pokedex.mostrarPokemon();
                case 3 -> pokedex.eliminarPokemon();
                case 4 -> pokedex.actualizarPokemon();
                case 5 -> {
                    pokemon p1 = new pokemon("Pikachu", "Eléctrico", 100, 20);
                    pokemon p2 = new pokemon("Charmander", "Fuego", 100, 18);
                    batalla.pelear(p1, p2);
                }
            }

        } while (opcion != 0);
    }
}