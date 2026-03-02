public class REQSEM52B_1 {
    public static void main(String[] args) {
    
    
        System.out.println("--- Cálculo de Promedio ---");
       
        double[] calificaciones = {8.5, 9.0, 7.8, 10.0, 6.0, 9.2};
        double suma = 0;

       
        for (double nota : calificaciones) {
            suma += nota;
        }

        
        double promedio = suma / calificaciones.length;
        System.out.println("El promedio final es: " + promedio + "\n");

    }}
