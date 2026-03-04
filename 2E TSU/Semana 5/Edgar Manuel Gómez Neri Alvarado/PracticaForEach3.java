package PracticaForEach;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class PracticaForEach3 {

    public static void main(String[] args) {
                Scanner output = new Scanner(System.in);
      // ---------------------------------------------------------------------------------------------------------------------
      
      List<String> ListaDeAlumnos = Arrays.asList("Gabriel","Luis","Edwin","Oscar","Edgar"); 
      
      ListaDeAlumnos.forEach(Alumno -> System.out.println("Alumno: "+Alumno));
      
    }
}