import java.util.Scanner;
public class ProblemasArrays3 {

    static Scanner read = new Scanner(System.in);

    public static void main(String[] args) {
        // Problema 3: recoleccion de 5 nombres de personas
        String[] nombres = new String[5];
        for(int i=0; i<nombres.length; i++){
            System.out.print("Ingrese un nombre: ");
            nombres[i] = read.nextLine();
        }
        // mostrar los nombres
        System.out.println("Los nombres ingresados son:");
        for(String nombre : nombres){
            System.out.println(nombre);
        }
    }

}