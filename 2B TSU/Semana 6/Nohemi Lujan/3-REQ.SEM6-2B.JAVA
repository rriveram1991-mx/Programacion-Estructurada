* @author nohem
 */
public class Estacionamiento {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       String[][] espacios = new String[3][3];
       
       for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                espacios[i][j] = "L";//libre
            }
       }
       espacios [0][2]="C";//carro
       espacios [1][1]="C";
       
       System.out.println("=== ESTACIONAMIENTO UTT ===");
        for (int i = 0; i < 3; i++) {
            System.out.print("Sección " + i + ": ");
            for (int j = 0; j < 3; j++) {
                System.out.print("[" + espacios[i][j] + "] ");
            }
            System.out.println();
        }
    }
    
}
