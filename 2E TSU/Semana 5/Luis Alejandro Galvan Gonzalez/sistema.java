package cuatri2.unidad3;

import java.util.Scanner;

public class sistema {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[]  nombres;
        int[] edades;
        int pacientes;
        

        System.out.println("Cuántos pacientes se registrarán?");
        pacientes = sc.nextInt();
   
        nombres = new String[pacientes];
        edades = new int[pacientes];

        for(int i = 0; i < pacientes ; i++ ){
            System.out.println("Ingrese el nombre:");
            nombres[i] = sc.next();
            System.out.println("Ingrese la edad del paciente:");
            edades[i] = sc.nextInt();
            while (edades[i] >= 120 || edades[i] <= 0) {
                System.out.println("No se permite esa edad");
                edades[i] = sc.nextInt();
            }
        }
        for (int j = 0;j < nombres.length; j++ ){
             System.out.println("Nombre: "+nombres[j]);
             System.out.println("Edas: "+edades[j]);
        }
        int k = 0;
        int menor = 0,adultos = 0,abuelos = 0;
        for(int pacien : edades){

            if (edades[k] < 18) {
                menor ++;
            } else if(edades[k]>= 18 && edades[k] <=59){
                adultos ++;
            } else if(edades[k] >= 60){
                abuelos ++;
            }
            k ++;
        }
        System.out.println("Pacientes prioritaros: "+abuelos);
    }
}
    