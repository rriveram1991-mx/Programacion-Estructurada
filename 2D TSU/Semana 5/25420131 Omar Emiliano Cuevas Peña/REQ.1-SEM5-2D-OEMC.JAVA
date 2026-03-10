import java.util.Scanner;
public class SistemaPacientes {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N;
        
        
        System.out.println("Ingrese Num. de pacientes:");
        N = sc.nextInt();
        sc.nextLine();


        int[] pacientes = new int[N];
        String[] nombre = new String[N];
        
        for (int i = 0; i < pacientes.length; i++) {

        System.out.println("Ingrese su Nombre del paciente " + (i+1)+ ":" );
        nombre[i] = sc.nextLine();

        System.out.println("Ingrese la edad del paciente "+(i+1) +":");
        pacientes[i]=sc.nextInt();

        sc.nextLine();

        while (pacientes[i]<0 || pacientes[i]>120){
        if (pacientes[i] < 0) {
        System.out.println("Error: la edad no puede ser negativa.");

            System.out.println("Edad invalida. Intente nuevamente:");
            pacientes[i]=sc.nextInt();
            sc.nextLine();

        } else if (pacientes[i] > 120) {
        System.out.println("Error: la edad no puede ser mayor a 120.");

            System.out.println("Edad invalida. Intente nuevamente:");
            pacientes[i]=sc.nextInt();
            sc.nextLine();
        }
            System.out.println("Edad invalida. Intente nuevamente:");
            pacientes[i]=sc.nextInt();}
            sc.nextLine();
        }

        int menores    = 0;
        int adultos    = 0;
        int mayores    = 0;
        int prioritarios = 0;

        System.out.println("\n===== PACIENTES REGISTRADOS =====");

        for (int edad : pacientes) {
            
            int idx = 0;
            for (int j = 0; j < pacientes.length; j++) {
                if (pacientes[j] == edad) { idx = j; break; }
            }

            System.out.println("Nombre: " + nombre[idx] + " | Edad: " + edad);

            
            if (edad < 18) {
                menores++;
                System.out.println("  → Menor de edad");
            } else if (edad <= 59) {
                adultos++;
                System.out.println("  → Adulto");
            } else {
                mayores++;
                prioritarios++;
                System.out.println("  → Adulto mayor | Paciente prioritario");
            }
        }

        // ── Resumen final ─────────────────────────────────────
        System.out.println("\n========== RESUMEN ==========");
        System.out.println("Menores de edad  (< 18)  : " + menores);
        System.out.println("Adultos          (18-59) : " + adultos);
        System.out.println("Adultos mayores  (60+)   : " + mayores);
        System.out.println("Total prioritarios       : " + prioritarios);
        
        




        sc.close();
        }
        







    }
import java.util.Scanner;

public class SistemaPasajeros {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);

    System.out.println("Ingrese Num. de pasajeros:");
    int N = sc.nextInt();
    sc.nextLine();

    String[] nombre  = new String[N];
    String[] destino = new String[N];

    
    for (int i = 0; i < N; i++) {

        
        System.out.println("Ingrese nombre del pasajero " + (i + 1) + ":");
        nombre[i] = sc.nextLine();

        while (nombre[i].trim().isEmpty()) {
            if (nombre[i].trim().isEmpty()) {
                System.out.println("Error: el nombre no puede estar vacio.");
            }
            System.out.println("Ingrese un nombre valido:");
            nombre[i] = sc.nextLine();
        }

        
        System.out.println("Ingrese destino del pasajero " + (i + 1) + " (CDMX / Local):");
        destino[i] = sc.nextLine();

        while (destino[i].trim().isEmpty()) {
            if (destino[i].trim().isEmpty()) {
                System.out.println("Error: el destino no puede estar vacio.");
            }
            System.out.println("Ingrese un destino valido:");
            destino[i] = sc.nextLine();
        }
    }

    
    int contCDMX  = 0;
    int contLocal = 0;
    int contOtro  = 0;

    
    System.out.println("\n====== LISTA DE PASAJEROS ======");

    for (int i = 0; i < N; i++) {
        System.out.println("Pasajero : " + nombre[i]);
        System.out.println("Destino  : " + destino[i]);

        if (destino[i].equalsIgnoreCase("CDMX")) {
            System.out.println("  → Viaje largo");
            contCDMX++;
        } else if (destino[i].equalsIgnoreCase("Local")) {
            System.out.println("  → Viaje corto");
            contLocal++;
        } else {
            System.out.println("  → Destino: " + destino[i]);
            contOtro++;
        }
        System.out.println("--------------------------------");
    }


    String destinoTop;
    int maxPasajeros;

    if (contCDMX >= contLocal && contCDMX >= contOtro) {
        destinoTop   = "CDMX";
        maxPasajeros = contCDMX;
    } else if (contLocal >= contCDMX && contLocal >= contOtro) {
        destinoTop   = "Local";
        maxPasajeros = contLocal;
    } else {
        destinoTop   = "Otro";
        maxPasajeros = contOtro;
    }


    System.out.println("\n========== RESUMEN ==========");
    System.out.println("Pasajeros a CDMX  : " + contCDMX);
    System.out.println("Pasajeros a Local : " + contLocal);
    System.out.println("Pasajeros a Otro  : " + contOtro);
    System.out.println("Destino con mas pasajeros: " + destinoTop + " (" + maxPasajeros + " pasajeros)");
    System.out.println("Total de pasajeros: " + N);

    sc.close();

}
}
