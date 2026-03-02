import java.util.Scanner;
public class ProblemasArrays2 {

    static Scanner read = new Scanner(System.in);

    public static void main(String[] args) {
    // Problema 2: recoleccion de 4 identificaciones
    int[] identifiaciones = new int[4];
    for(int i=0; i<identifiaciones.length; i++){
        // recoleccion de las identificaciones, si es igual a 3456, el usuario es un admin
        System.out.print("Ingrese un numero de identificacion: ");
        identifiaciones[i] = read.nextInt();
    }
    // proceso de la identificacion
    boolean isAdmin = false;
    for(int i = 0; i < identifiaciones.length; i++){
        // si la identificacion es igual a 3456, el usuario es un admin
        if(identifiaciones[i] == 3456){
            isAdmin = true;
            break;
        }
    }
    if(isAdmin){
        System.out.println("Bienvenido admin");
    } else {
        System.out.println("Usuario no reconocido");
    }

    }

}
