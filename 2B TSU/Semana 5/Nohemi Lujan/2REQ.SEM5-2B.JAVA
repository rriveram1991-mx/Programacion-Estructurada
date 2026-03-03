* @author nohemi
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     
        // precio de lo q se comprará
        double[] p= {150.0, 2300.0, 450.0, 1200.0, 80.0, 3500.0};
        double cuentaf=0;
        //for y condición
        for (double a :p) {
            if (a > 1000) {
                cuentaf+= (a * 0.85); 
            } else {
                cuentaf+= a;
            }
        }

        System.out.println("El total de la compra con descuentos es: $" + cuentaf);
    }
}
