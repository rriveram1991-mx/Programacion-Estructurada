package PracticaJavaS3;
import java.util.Scanner;
public class PracticaJavaS3 {

    public static void main(String[] args) {
      // ---------------------------------------------------------------------------------------------------------------------
      
      Scanner sc = new Scanner(System.in);

        int opcion = 0;
        int total = 0;
        int cantidad = 0;
        boolean salir = false;
        double promedio = 0;

        System.out.println("=== SISTEMA DE CONTROL DE NOTAS ===");

        while (!salir) {

            System.out.println("\n1. Capturar notas");
            System.out.println("2. Mostrar promedio");
            System.out.println("3. Mostrar estadisticas");
            System.out.println("4. Reiniciar datos");
            System.out.println("5. Salir");

            System.out.print("Seleccione opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {

                case 1 -> {
                   
                    
                    System.out.print("Cuantas notas desea capturar: ");
                    int n = sc.nextInt();

                    for (int i = 1; i == n; i++) {

                        System.out.print("Ingrese nota #" + i + ": ");
                        int nota = sc.nextInt();
                        if(nota >= 0 && nota <= 10)
                        {
                            total += nota;
                            i++;
                        }
                        else
                        {
                            System.out.println("Nota invalida");
                        }
                        break;
                    }
                }
                        case 2 -> {
                        if (cantidad != 0 && total != 0){
                               promedio = (double) total / cantidad;}   
                        else{
                                System.out.println("Algo salio mal,(cantidad o total = 0)");
                                 break;
                        }
                        
                        System.out.println("Promedio: " +promedio);
                        if (promedio >= 9){
                        System.out.println("Excelente");}
                        else if (promedio >= 8 && promedio <= 9){
                        System.out.println("Bueno");}
                        else if (promedio >= 7&& promedio <= 8){
                        System.out.println("Regular"); }
                        else{
                        System.out.println("Reprobado");}
                        
                        break;
                }
                        case 3 -> {
                        
                        int aprobados = 0;
                        int reprobados = 0;
                        
                        int i = 0;
                        while (i < cantidad)          
                        if (total / cantidad >= 7) 
                        aprobados++;
                        else
                        reprobados++;
                        i++;
                    

                    System.out.println("Aprobados: " + aprobados);
                    System.out.println("Reprobados: " + reprobados);
                    break;
                    }
                    case 4 -> {

                    total = 0;
                    cantidad = 0;
                    System.out.println("Datos reiniciados");
                    }
                    case 5 -> {

                    salir = true;
                    System.out.println("Saliendo del sistema");
                    }
                    default -> {
                    System.out.println("Opcion no valida");
         
                    }
            }
        }

        sc.close();
    }
}