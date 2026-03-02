import java.util.Scanner;
public class Array3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("holaaaaaa este programa hace una sumatoria de numeros ");
        int[] numeros = new int[5];
        int suma = 0;
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Ingrese su numero " + (i + 1) + ":");
            numeros[i] = scan.nextInt();
           
        }
        for (int num : numeros ){
            suma += num;


        }
        System.out.println("La sumatoria de todo es "+ suma);
   
    }
}
