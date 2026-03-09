import java.util.Scanner;

public class REQ1_SEM5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("¿Cuántos pacientes desea registrar? ");
        int cantidad = sc.nextInt();
        sc.nextLine();

        String[] nombres = new String[cantidad];
        int[] edades = new int[cantidad];

        //captura de datos con for
        for (int i = 0; i < cantidad; i++) {
            System.out.println("\nRegistro del paciente #" + (i + 1));
            System.out.print("Nombre: ");
            nombres[i] = sc.nextLine();

            //validar edad con while
            System.out.print("Edad: ");
            int edadAux = sc.nextInt();
            
            while (edadAux < 0 || edadAux > 120) {
                if (edadAux < 0 || edadAux > 120) {
                    System.out.println("Error: La edad debe estar entre 0 y 120.");
                    System.out.print("Ingrese la edad nuevamente: ");
                    edadAux = sc.nextInt();
                }
            }
            edades[i] = edadAux;
            sc.nextLine(); 
        }

        //analisis del sistema
        int menores = 0, adultos = 0, adultosMayores = 0, prioritarios = 0;

        System.out.println("\n--- Lista de Pacientes ---");
        
        //se usa for-each para mostrar pacientes y evaluar condiciones
        int indice = 0;
        for (int edad : edades) {
            String nombreActual = nombres[indice];
            System.out.print("Paciente: " + nombreActual + " | Edad: " + edad);

            //conteo y condiciones
            if (edad < 18) {
                menores++;
            } else if (edad >= 18 && edad <= 59) {
                adultos++;
            } else {
                adultosMayores++;
                System.out.print(" -> [Paciente prioritario]");
                prioritarios++;
            }
            
            System.out.println(); //salto de línea
            indice++;
        }

        //resultados finales
        System.out.println("\n--- Resumen de Datos ---");
        System.out.println("Menores de edad (<18): " + menores);
        System.out.println("Adultos (18-59): " + adultos);
        System.out.println("Adultos mayores (>=60): " + adultosMayores);
        System.out.println("Total de pacientes prioritarios: " + prioritarios);
        
        sc.close();
    }
}
