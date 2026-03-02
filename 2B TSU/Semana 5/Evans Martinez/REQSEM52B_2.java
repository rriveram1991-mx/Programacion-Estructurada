import java.util.Scanner;

public class REQSEM52B_2 {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("--- Buscador de Invitados ---");
        String[] invitados = {"Juan", "Maria", "Evans", "Pedro", "Lucia"};
        
        System.out.print("Escribe el nombre a buscar: ");
        
        String busqueda = sc.next();
        
        boolean encontrado = false;

      
        for (String invitado : invitados) {
            if (invitado.equalsIgnoreCase(busqueda)) { 
                encontrado = true;
                break; 
            }
        }

        if (encontrado) {
            System.out.println("¡Acceso concedido! Está en la lista.");
        } else {
            System.out.println("Lo siento, no aparece en la lista de invitados.");
        }

        sc.close();
    }
}

