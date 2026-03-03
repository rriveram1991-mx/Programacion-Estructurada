 * @author nohemi
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     

        Scanner leer = new Scanner(System.in);

        // que objetos  se llevan y cuales faltan
        String[] cosas = {"Cuaderno", "Pluma", "Libro", "Calculadora", "Borrador"};
        int[] cantidad = {1, 0, 2, 0, 1};

        System.out.println("--- ¿QUÉ SE FALTA? ---");
        
       
        for (int i = 0; i < cosas.length; i++) {
            if (cantidad[i] == 0) {
                System.out.println("te falta: " + cosas[i]);
            }
        }

        
        String buscarObjeto = "Pluma"; 
        
        for (String item : cosas) {
            if (item.equalsIgnoreCase(buscarObjeto)) {
                System.out.println("El objeto " + buscarObjeto + " sí está en la lista de materiales.");
            }
        }
        
        leer.close();
    }
}
