* @author nohemi
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // temperaturas de las tazas servidas
        double[] tazas = {22.5, 30.1, 18.4, 35.0, 27.8, 15.2, 31.4};
        double limite= 30.0;
        int tazasc= 0;
        //for y condicion
        for (double temp:tazas) {
            if (temp>limite) {
                tazasc++;
            }
        }
        System.out.println("cantidad de tazas revisadas: " + tazas.length);
        System.out.println("tazas que están muy calientes (>30°C): " + tazasc);
    }
}
