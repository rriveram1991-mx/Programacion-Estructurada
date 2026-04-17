package pokemon.logica;

import pokemon.modelos.pokemon;
import java.util.Random;

public class batalla {

    public static void pelear(pokemon p1, pokemon p2) {
        Random r = new Random();

        System.out.println("🔥 BATALLA 🔥");

        while (p1.salud > 0 && p2.salud > 0) {

            int daño1 = r.nextInt(p1.ataque);
            p2.salud -= daño1;

            System.out.println(p1.nombre + " hace " + daño1);

            if (p2.salud <= 0) break;

            int daño2 = r.nextInt(p2.ataque);
            p1.salud -= daño2;

            System.out.println(p2.nombre + " hace " + daño2);
        }

        if (p1.salud > 0)
            System.out.println("🏆 Gana: " + p1.nombre);
        else
            System.out.println("🏆 Gana: " + p2.nombre);
    }
}