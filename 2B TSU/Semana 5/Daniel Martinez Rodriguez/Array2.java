import java.util.Scanner;
public class Array2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("La vida es un carousel");
        String[] paises ={"Cerru","Japan","Cisterna","Santos"};
        System.out.println("Moriste y reviviras en un isekai selecciona tu lugar para revivir");
        for (int i = 0; i < paises.length; i++) {
            System.out.println(i + "- " + paises[i]);
        }
        int opcion ;
        System.out.println("Cual lugar eliges para revivir 🤯");
        opcion = scan.nextInt();
        if (opcion >= 0 && opcion < paises.length){
            System.out.println("WOOOOOOOOOOW 🥵 que buen lugar yo tambien renaceria en " + paises[opcion]);

        }
        else {
            System.out.println("nub");
        }

    }
    
}
