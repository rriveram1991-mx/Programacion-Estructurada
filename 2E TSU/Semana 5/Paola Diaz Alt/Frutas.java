//paola geraldine diaz altamira
import java.util.ArrayList;

public class Frutas {
    public static void main(String[] args) {
        String[] frutas = {"Manzana", "Pera", "Mango", "Fresa", "Mora", "Uva"};
        int contador = 0;

        for (String f : frutas) {
            if (f.startsWith("M")) {
                contador++;
            }
        }

        System.out.println("Hay " + contador + " frutas que empiezan con M.");
    }
}