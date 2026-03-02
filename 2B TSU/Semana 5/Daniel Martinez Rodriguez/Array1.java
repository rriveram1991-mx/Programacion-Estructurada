import java.util.Scanner;
public class Array1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] perros =  new String[4];
       System.out.println("Imagina que tienes 4 perros, como les pondrias ");
       for (int i=0 ; i < perros.length; i++){
        System.out.println("Como le llamaras al perro "+(i+1) );
        perros[i]=scan.nextLine();

       }
       System.out.println("GUAU que bonitos nombres asi quedaron");
         for (int i=0 ; i < perros.length; i++){
            System.out.println("-" + perros[i]);


    
        
    }
}}
