import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Rto {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int opcion, asiento;
        int[][] asientos = new int[10][10];
        String ti_no;
        System.out.println("Quiere entrar al estacionamiento si o no");
        ti_no = scan.nextLine();
        while (ti_no.equals("si")) {
            System.out.println("1. Ver estacionamiento ");
            System.out.println("2. Estacionar auto ");
            System.out.println("3. Retirar auto ");
            System.out.println("4. Contar espacios ocupados ");
            System.out.println("5. Salir ");
            opcion = scan.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Los ceros son espacios disponibles");
                    System.out.println("Los unos son espacios ocupados");
                    for (int i = 0; i < asientos.length; i++) {
                        for (int j = 0; j < asientos[i].length; j++) {
                            System.out.print(asientos[i][j] + " ");

                        }
                        System.out.println();
                    }
                    break;
                case 2:
                    System.out.println("En que asiento le gustaria estacionarse ");
                    asiento = scan.nextInt();
                    if (asiento >= 1 && asiento <= 100) {
                        asientos[(asiento - 1) / 10][(asiento - 1) % 10] = 1;
                        System.out.println("Auto estacionado en el asiento " + asiento);
                    } else {
                        System.out.println("Asiento no disponible");
                    }
                    break;
                case 3:
                    System.out.println("Cual asiento va a desocupar");
                    asiento = scan.nextInt();
                    if (asiento >= 1 && asiento <= 100) {
                        asientos[(asiento - 1) / 10][(asiento - 1) % 10] = 0;
                        System.out.println("Asiento desocupado");
                    } else {
                        System.out.println("Asiento no disponible");
                    }
                    break;
                case 4:
                    int contador = 0;
                    for (int i = 0; i < asientos.length; i++) {
                        for (int j = 0; j < asientos[i].length; j++) {
                            if (asientos[i][j] == 1) {
                                contador++;
                            }
                        }
                    }
                    System.out.println("Los espacios ocupados son " + contador);
                    break;
                case 5:
                    System.out.println("Gracias por usar el estacionamiento");
                    ti_no = "no";
                    break;

                default:
                    System.out.println("Opcion no valida");
                    break;
            }

        }

        try {
            File miFile = new File("Rto_Estacionamiento.txt");
            if (miFile.createNewFile()) {
                System.out.println("Archivo creado ");
            } else {
                System.out.println("Archivo ya creado ");
            }
            FileWriter writer = new FileWriter("Rto_Estacionamiento.txt");
            int ocupados = 0;
            for (int i = 0; i < asientos.length; i++) {
                for (int j = 0; j < asientos[i].length; j++) {
                    writer.write(asientos[i][j] + " ");
                    if (asientos[i][j] == 1) {
                        ocupados++;
                    }
                }
                writer.write("\n");
            }
            writer.write("\nTotal de espacios ocupados: " + ocupados + "\n");
            writer.close();
            System.out.println("Datos guardados en el archivo ");
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo ");
            e.printStackTrace();
        }

    }

}
