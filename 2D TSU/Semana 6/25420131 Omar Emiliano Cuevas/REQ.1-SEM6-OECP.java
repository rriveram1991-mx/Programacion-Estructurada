REQ.1-SEM6-OECP

creación de archivo

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;



    public class CreateFile {  
        public static void main(String[] args) {  
            try {  
                File myObj = new File("ejemplo.txt");  
                if (myObj.createNewFile()) {  
                    System.out.println("Archivo creado: " + myObj.getName());  
                } else {  
                    System.out.println("El archivo ya existe.");  
                }  
            
            //Escribir en el archivo
                FileWriter myWriter = new FileWriter("ejemplo.txt");
                myWriter.write("Omar Emiliano Cuevas Peña\n");
                myWriter.write("18 años\n");
                myWriter.write("Estudiante de desarrollo de software\n");
                myWriter.write("Universidad Tecnológica de Torreon\n");
                myWriter.write("Mi Lenguaje de programación favorito es Java");
                myWriter.close();
                System.out.println("Archivo escrito exitosamente.");

            } catch (IOException e) {  
                System.out.println("Ocurrió un error.");  
                e.printStackTrace();  
            }  
        }
        
}
cine

import java.util.Scanner;
public class ArrayB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    int opc = 0;
//Ejemplo de arrays cine
        int[][] matriz = {
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
        };
        System.out.println("Reservar asientos 1:si 2:no");
            opc = sc.nextInt();
            sc.nextLine();

        while (opc==1) {
            

        System.out.println("Bienvenido al sistema de reservaciones del cine");
        System.out.println("El cine tiene 3 filas y 3 columnas;");
        System.out.println("Elige una fila (1-3):");
        int fila = sc.nextInt() - 1;
        System.out.println("Elige una columna (1-3):");
        int columna = sc.nextInt() - 1;
        if (matriz[fila][columna] == 0) {
            matriz[fila][columna] = 1;
            System.out.println("Asiento reservado exitosamente.");
        } else {
            System.out.println("Lo siento, ese asiento ya está ocupado.");
        }

        System.out.println("Reservar asientos 1:si 2:no");
        opc = sc.nextInt();
        sc.nextLine();
    }

    

sc.close();
    }
        }
estacionamiento

import java.util.Scanner;

public class ArrayB2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    int opc = 0;
//Ejemplo de arrays Estacionamiento
        int[][] matriz = {
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
        };
        System.out.println("Reservar Lugar 1:si 2:no");
            opc = sc.nextInt();
            sc.nextLine();

        while (opc==1) {
            

        System.out.println("Bienvenido al sistema de reservaciones del Estacionamiento");
        System.out.println("El estacionamiento tiene 3 filas y 3 columnas;");
        System.out.println("Elige una fila (1-3):");
        int fila = sc.nextInt() - 1;
        System.out.println("Elige una columna (1-3):");
        int columna = sc.nextInt() - 1;
        if (matriz[fila][columna] == 0) {
            matriz[fila][columna] = 1;
            System.out.println("Asiento reservado exitosamente.");
        } else {
            System.out.println("Lo siento, ese asiento ya está ocupado.");
        }

        System.out.println("Reservar asientos 1:si 2:no");
        opc = sc.nextInt();
        sc.nextLine();
    }

    

sc.close();
    }
        }
