import java.util.Scanner;

public class RTO1_sem7 {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String[] espacio = new String[10];

    for (int i = 0; i < espacio.length; i++) {
            espacio[i] = "LIBRE";
        }

    int opc = 0;

    while (opc != 5) {
        System.out.println("1.Ver estacionamiento");
        System.out.println("2.Estacionar auto");
        System.out.println("3.Retirar auto");
        System.out.println("4.Contar espacios ocupados");
        System.out.println("5.salir");
        opc = sc.nextInt();

        switch (opc){
            case 1:
                for (int i = 0; i < espacio.length; i++) {
                        System.out.println("Espacio " + (i + 1) + ": " + espacio[i]);
                    }
                    break;
            case 2:
                        System.out.print("Ingrese el número de espacio (1-10): ");
                    int eIngreso = sc.nextInt() - 1;

                    if (eIngreso >= 0 && eIngreso < 10) {
                        if (espacio[eIngreso].equals("LIBRE")) {
                            espacio[eIngreso] = "OCUPADO";
                            System.out.println("Auto estacionado con éxito.");
                        } else {
                            System.out.println("Error: El espacio ya está ocupado.");
                        }
                    } else {
                        System.out.println("Número de espacio inválido.");
                    }
                    break; 
            case 3:
                System.out.print("Ingrese el número de espacio (1-10): ");
                    int eRetiro = sc.nextInt() - 1;

                    if (eRetiro >= 0 && eRetiro < 10) {
                        if (espacio[eRetiro].equals("OCUPADO")) {
                            espacio[eRetiro] = "LIBRE";
                            System.out.println("Auto retirado. El espacio ahora está libre.");
                        } else {
                            System.out.println("El espacio ya estaba libre.");
                        }
                    } else {
                        System.out.println("Número de espacio inválido.");
                    }
                    break; 
            case 4:
                   int contador = 0;
                    for (String e : espacio) { 
                        if (e.equals("OCUPADO")) { 
                            contador++;
                        }
                    }
                    System.out.println("Total de autos estacionados: " + contador);
                    break;
             case 5:
                System.out.println("Saliendo del programa...");
                break;

                default:
                    System.out.println("Opción no válida.");
        }
    }
    sc.close();
    }    
}
