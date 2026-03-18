/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestorerrores;

/**
 *
 * @author Memer
 */
import java.util.Scanner;

public class GestorErrores {

    public static void main(String[] args) {
        
        

        Scanner sc = new Scanner(System.in);

        String[][] juegos = new String[10][3];

        int opcion = 0;

        while (opcion != 5) {
           
            if (juegos[0][0] == null) {
                System.out.println("no hay juegos registrados\n");
            }

            System.out.println("1. Registrar");
            System.out.println("2. Mostrar");
            System.out.println("3. Buscar");
            System.out.println("4. Estadisticas");
            System.out.println("5. Salir");

            opcion = sc.nextInt();
            sc.nextLine(); //limpia el buffer
            
            
            
            switch (opcion) {

                case 1:
                    int fila = -1; //es para que el if, en caso de que la lista se llene, no permita al usuario ingresar mas datos

                    for (int i = 0; i < juegos.length; i++) { //1# error logico, java al contar su I desde 0, ponerlo <= hace que se salga del Array
                        if (juegos[i][0] == null) {
                            fila = i;
                            break;//2# error de ejecucion, el ciclo va a terminar con el ultimo null de la lista, haciendo que tome siempre ese valor, en este caso, en caso de que encuentre un null   
                        } //va acabar con el ciclo en ese instante
                        
                    }
                    
                    if (fila != -1){ //validacion en caso de que se llene el array
                    System.out.print("Nombre: "); //3# error logico, es redudante pedir en nombre, en cambio, se podia simplificar a la linea con la que comparte los demas 
                    juegos[fila][0] = sc.nextLine();
                    

                    System.out.print("Genero: ");
                    juegos[fila][1] = sc.nextLine();
                    
                    
                    System.out.print("Horas: ");
                    juegos[fila][2] = sc.nextLine();
                    } else{
                        System.out.println("iNVENTARIOS LLENO");
                    }
                    break;

                case 2:
                    for (int i = 0; i < juegos.length; i++) {
                        System.out.println(juegos[i][0] + " - " + juegos[i][1] + " - " + juegos[i][2]);
                    }
                    break;

                case 3:
                    boolean encontrado = false;
                    System.out.print("Buscar: ");
                    String buscar = sc.nextLine();

                    for (int i = 0; i < juegos.length; i++) {
                        if (juegos[i][0] != null && juegos[i][0].equals(buscar)) { //4# error logico, no se puede comparar strings con == si no con .equals 5#como al inicio del programa todos los datos son null, va a tronar el progama, asi que en el if se valida eso mismo que sea diferente de null 
                            System.out.println("Encontrado");
                            encontrado = true;
                            break; //5# error de ejecucion, el ciclo no termina, haciendo que tome siempre compare ese valor con todos los demas, en este caso, en caso de que encuentre un null 
                            //termina el ciclo en ese instante
                        }
                    }
                    
                    if (!encontrado) {
                        System.out.println("No se encontro/aun no se registra");
                    }
                    
                    break;

                case 4:
                    int suma = 0;
                    int cjuegos = 0;
                    
                    for (int i = 0; i < juegos.length; i++) {
                        if(juegos[i][2] != null){ //6# error de ejecucion, esta linea funciona para que agarre los datos que no sean nulles
                        suma = suma + Integer.parseInt(juegos[i][2]);
                        cjuegos ++;
                        break;
                        }
                    }
                    
                    if (suma != 0) { 
                        System.out.println("Promedio: " + suma / cjuegos); //7# al querer dividir por el largo del array, hace que se divda por ello, sin embargo, si queremos dividir por los que tenemos, no calcula bien el promedio
                    }
                    else{
                        System.out.println("por favor, ingrese algun videojuego");
                    }
                    
                    break;

                case 5://8# error de sintaxis seria confuso poner 7 en vez de 5
                    System.out.println("Adios");
                    break;
                default: //9# error de sintaxis, simplemente para que arroje la opcion de eliga otra opcion
                    System.out.println("Elegia otra opcion");
                    break;
            }
        }
    }
}