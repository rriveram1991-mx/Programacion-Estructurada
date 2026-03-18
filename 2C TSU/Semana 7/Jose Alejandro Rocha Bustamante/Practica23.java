import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class Practica23 {
    /**
     * @param args
     */
    public static void main(String[]args){
        Scanner leer = new Scanner(System.in);
        String[][] estacionamiento = new String[5][5];

        for (int i = 0; i < estacionamiento.length; i++){
            for (int n = 0; n < estacionamiento[i].length; n++){
                estacionamiento[i][n]= "[Libre]";
            }
        }
            while (true){
                 System.out.println("== Bienvenido al estacionamiento Mr K ==");
                 System.out.println("== Seleccione una opción ==");
                 System.out.println("== 1. Ver estacionamiento ==");
                 System.out.println("== 2. Estacionar auto ==");
                 System.out.println("== 3. Retirar auto ==");
                 System.out.println("== 4. Contar espacios ocupados ==");
                 System.err.println("== 5. Salir ==");
                 int opcion = leer.nextInt();
                    switch(opcion){
                        case 1:
                             for (int i = 0; i < estacionamiento.length; i++){
                            for (int n = 0; n < estacionamiento[i].length; n++){
                                System.out.print(estacionamiento [i][n]+"");
                            }
                            System.out.println();
                        }
                            break;
                        case 2: 
                        System.out.println("== Ingrese el numero de fila ==");
                        int fila = leer.nextInt();
                        System.out.println("== Ingrese numero de columna ==");
                        int columna = leer.nextInt();
                        if (estacionamiento[fila][columna].equals("[Ocupado]")){
                            System.out.println("== El lugar ya esta ocupado ==");
                        }
                        else {
                        System.out.print("== El lugar se ha ocupado exitosamente ==");
                        estacionamiento[fila][columna] = "[Ocupado]";
                        }
                        for (int i = 0; i < estacionamiento.length; i++) {
                            for (int n = 0; n < estacionamiento[i].length; n++) {
                            System.out.print(estacionamiento[i][n]+"");
                        }
                        System.out.println("");
                    }
                          
                    break;
                        case 3:
                        System.out.println("== Ingrese el numero de fila que desa retirar ==");
                        int retirar = leer.nextInt();
                        System.out.println("== Ingrese el numero de columna que desea retirar ==");
                        int retirar2 = leer.nextInt();      
                        if (estacionamiento[retirar][retirar2].equals("[Ocupado]")){
                            System.out.println("== El lugar se ha retirado exitosamente ==");
                            estacionamiento[retirar][retirar2] = "[Libre]";
                        }
                        else {
                            System.out.println("== El lugar ya esta libre ==");
                        }
                        case 4: 
                        int contador = 0;
                        for (String[] fila2 : estacionamiento){
                            for (String estado : fila2){
                                if (estado.equals("[Ocupado]")){
                                    contador++;
                                }
                            }  
                        }
                        System.out.println("== El numero de espacios ocupados es: " + contador + " ==");    
                        break;

                        case 5:
                            System.out.println("== Gracias por usar el estacionamiento Mr K, saliendo... ==");
                            break;
                        default:
                            System.out.println("== Opcion invalida ==");
                    }
                     try {
            FileWriter archivo = new FileWriter("estacionamiento.txt");

            archivo.write("== Estado final del estacionamiento: ==\n");

            for (int i = 0; i < estacionamiento.length; i++) {
                archivo.write("Espacio " + (i + 1) + ": " + estacionamiento[i][0] + "\n");
            }

            archivo.close();
            System.out.println("== El archivo se generó correctamente. ==");

        } catch (IOException e) {
            System.out.println("== Error al crear el archivo. ==");
        }

    }
    }
}
