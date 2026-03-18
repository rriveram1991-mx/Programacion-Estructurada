
package videojuego.sandra;
import java.util.Scanner;

public class VIDEOJUEGOSandra {
//SANDRA DOMINGUEZ
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[][] juegos = new String[10][3];

        int opcion = 0;

        while (opcion != 5) {
            
            System.out.println("-----------------MENU------------------");
            System.out.println("1. Registrar");
            System.out.println("2. Mostrar");
            System.out.println("3. Buscar");
            System.out.println("4. Estadisticas");
            System.out.println("5. Salir");  //CAMBIE EL 7 A 5, PARA QUE SIGUIERAN UN ORDEN.
            System.out.println("INGRESE UNA OPCION:");  
            opcion = sc.nextInt();
            
            System.out.println("--------------------------------------");
            switch (opcion) {

                case 1:
                    int fila = -1;  //ERROR 1: TIPO: LOGICO, TENIA 0 CAMBIAR A -1, PORQUE SE ESTABA INICIALIZANDO EN 0 Y EL RESULTADO ESTARIA INCORRECTO.

                    for (int i = 0; i < juegos.length; i++) //ERROR 2: TIPO:LOGICO  QUITAR EL =, POR QUE SIN EL EL ARREGLO SI SE DETIENE EN LO DE juegos.length, QUE SERIA VALIDO.
                    {
                        if (juegos[i][0] == null) 
                        {
                            fila = i;break;//agregue un break
                        }
                    }

                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    juegos[fila][0] = nombre;
                    sc.nextLine(); //ERROR 3: TIPO:SINTAXIS , FALTABA HACER UN SALTO DE LINEA

                    System.out.print("Genero: ");
                    juegos[fila][1] = sc.nextLine();
                     
                    System.out.print("Horas: ");
                    juegos[fila][2] = sc.nextLine();
                    break;

                case 2:
                    for (int i = 0; i < juegos.length; i++)
                    {
                        if (juegos[i][0] !=null)  //ERROR 5, TIPO:LOGICO, SE NECESITA AGREGUE EL IF
                        {
                            System.out.println(juegos[i][0] + " - " + juegos[i][1] + " - " + juegos[i][2]);
                        }
                        
                    }
                    break;
                    
                case 3:
                    System.out.print("Buscar: ");
                    String buscar = sc.nextLine();

                    for (int i = 0; i < juegos.length; i++)
                    {
                        if (juegos[i][0] !=null && juegos[i][0].equals(buscar)) //ERROR:4 TIPO: LOGICO, SE ESTABA COMPARANDO CON ==, TIENE QUE SER .equals
                        {
                            System.out.println("Encontrado");
                        }
                    } 
                    break;

                case 4:
                    int suma = 0;
                    int contador=0; //FALTABA CONTADOR

                    for (int i = 0; i < juegos.length; i++)
                    {
                        if (juegos[i][0] !=null && juegos[i][2] !=null) //ERROR 6, TIPO:LOGICO, FALTABA UN IF
                        {
                        suma = suma + Integer.parseInt(juegos[i][2]);
                        contador++; //ERROR 7, TIPO:LOGICO, AGREGAR EL CONTADOR
                        }
                    }
                    
                    if (contador >0)  // ERROR 8, TIPO: LOGICO, AGREGUE UN if PARA QUE SE CALCULE BIEN EL PROMEDIO
                    {
                    System.out.println("Promedio: " + suma / juegos.length);
                    }else
                    {
                        System.out.println("NO HAY JUEGOS REGISTRADOS");
                    }
                    break;

                case 5:
                    System.out.println("Adios");
                    break;
                    
            }
        }
    }
}
