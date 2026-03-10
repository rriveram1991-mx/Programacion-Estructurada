 * @author nohem
 */
public class Cine {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[][] asientos=new String [3][3];
        
        for (int i=0; i<3; i++){
            for (int j=0;j<3;j++){
                asientos[i][j]="L";//libre
            }
        }
        asientos [1][1]="X";//ocupado
        
        System.out.println("sala 3x3");
        for (int i=0; i<3;i++){
            for (int j=0; j<3; j++){
                System.out.print("["+asientos[i][j]+"]");
            }
            System.out.println();
        }
    }
    
}
