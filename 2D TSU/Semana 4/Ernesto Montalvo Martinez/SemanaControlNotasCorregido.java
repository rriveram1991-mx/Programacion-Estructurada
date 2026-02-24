/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package semana_4;

/**
 *
 * @author Ernesto Montalvo
 */
import java.util.Scanner;

public class SemanaControlNotasCorregido {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int opcion = 0;
        int total = 0;
        int cantidad = 0;
        boolean salir = false;

        System.out.println("=== SISTEMA DE CONTROL DE NOTAS ===");

        while (salir == false) /*Se corrigio al aplicar otro signo de igual
            de no ser asi, se consideraria que se le esta asignando un valor */
        {

            System.out.println("\n1. Capturar notas 1-10");
            System.out.println("2. Mostrar promedio");
            System.out.println("3. Mostrar estadisticas");
            System.out.println("4. Reiniciar datos");
            System.out.println("5. Salir");

            System.out.print("Seleccione opcion: ");
            opcion = sc.nextInt();
double promedio=0;
//se declaro la variable promedio asignando valor de 0
            switch (opcion) {

                case 1:

                    System.out.print("Cuantas notas desea capturar: ");
                    int n = sc.nextInt();

                    for (int i = 1; i < n; i++) {
//se cambio el 0 por el 1

                        System.out.print("Ingrese nota #" + i + ": ");
                        int nota = sc.nextInt();

                        if (nota >= 0 && nota <= 10){
                            /*se elimino el ";" ya que no va ahi
                            de igual manera se agregaron llaves
                           */
                            total += nota;
                            cantidad++;
                        }else{
                            System.out.println("Nota invalida");
                    }}
                    //Asignacion de segunda llave para cerrar el for y else
break; //se asignó el break, porque faltaba y si no, se rompe el programa
case 2:
                    if(cantidad==0){
                        System.out.println("No hay notas registradas");
                        break;
                        //asignacion de if para en caso de no recibir la cantidad
                    }
                    promedio = total / cantidad;
                    //se elimino el double
                    System.out.println("Promedio: " + promedio);

                    if (promedio >= 9){
                        System.out.println("Excelente");
                        //asignacion de llaves
                    }else if (promedio >= 8){
                        System.out.println("Bueno");
                    }else if (promedio >= 7) {
//se elimino el ";" de la linea 79
                        System.out.println("Regular");
                    }else{
                        System.out.println("Reprobado");
                    }
                    break;
//asignacion de llaves en cada else if
                case 3:

                    int aprobados = 0;
                    int reprobados = 0;

                    int i = 0;
                    if(cantidad==0){
                        System.out.println("No hay datos");
                    break;
                    //asignacion de if en caso de no recibir datos de la cantidad
                    //eliminacion de while para  ser mas eficiente el if
                    }
                    promedio =  total / cantidad;
                    //se elimino el double
                        if (promedio >= 7){
                            //se asigno de una vez el promedio, en lugar de hacer toda la operacion
                            aprobados=cantidad;
                            reprobados=0;
                        }else{
                            aprobados=0;
                        reprobados=cantidad;
                        //se elimino el "i++"
                        //se asigno los aprobados y reprobados
                    }

                    System.out.println("Aprobados: " + aprobados);
                    System.out.println("Reprobados: " + reprobados);
                    break;

                case 4:

                    total = 0;
                    cantidad = 0;
                    System.out.println("Datos reiniciados");
                    break; //se asignó el break, porque faltaba y si no, se rompe el programa

                case 5:

                    salir = true;
                    System.out.println("Saliendo del sistema");
                    break; //asignacion de break

                default:
                    System.out.println("Opcion no valida");
            }

        }
        sc.close();
    }
}
/*no captura los datos, ademas de que no se cierran los casos en algunos case, faltando el break
los if y else tienen ";" cuando no deberian
el promedio se calculaba de manera erronea, asignando el double
*/