//paola geraldine diaz altamira
import java.util.ArrayList;

public class ListaDeTareas {
    public static void main(String[] args) {
        ArrayList<String> tareas = new ArrayList<>();
        tareas.add("Volver a cancun");
        tareas.add("Entenderle al prof Kenneth");
        tareas.add("Adoptar al chango punch");

        System.out.println("Tu lista de pendientes:");
        for (String tarea : tareas) {
            System.out.println("- " + tarea);
        }
    }
}