package PracticaForEach;

import java.util.Scanner;
public class PracticaForEach1 {

    public static void main(String[] args) {
                Scanner output = new Scanner(System.in);
      // ---------------------------------------------------------------------------------------------------------------------

String[] lenguajes = {"Lua", "Java", "Python","C++"};
int n=0;
for (String lenguaje : lenguajes) {
    n+=1;
    System.out.println("lenguaje de programacion N. "+n+" - "+lenguaje);
}
    }
}

