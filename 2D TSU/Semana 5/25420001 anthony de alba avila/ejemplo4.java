
public class ejemplo4 {
     public static void main(String[] args) {
        double[] notas = {8.5, 9.0, 7.5, 10.0, 6.5};
        
        double suma = 0;

        for (int i = 0; i < notas.length; i++) {
            suma += notas[i];
        }

        double promedio = suma / notas.length;

        System.out.println("La suma total es: " + suma);
        System.out.println("El promedio del estudiante es: " + promedio);
    }
}
