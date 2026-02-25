/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package s4.corrección_de_errores;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Lex
 */
public class S4Corrección_de_errores {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        
        ArrayList<Double> notas = new ArrayList<>(); //Agregamos un import de ArrayList para almacenar datos individuales

        int opcion = 0;
        double total = 0; //Cambiamos el tipo de variable para evitar errores de logica
        int cantidad = 0;
        boolean salir = false;

        System.out.println("=== SISTEMA DE CONTROL DE NOTAS ===");

        while (!salir) { //Corregimos el = por el comparativo !

            System.out.println("1. Capturar notas"); //Corregimos la escritura
            System.out.println("2. Mostrar promedio");
            System.out.println("3. Mostrar estadisticas");
            System.out.println("4. Reiniciar datos");
            System.out.println("5. Salir");

            System.out.print("Seleccione opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {

                case 1:

                    System.out.print("Cuantas notas desea capturar: ");
                    int n = sc.nextInt();

                    for (int i = 1; i <= n; i++) { //Cambiamos el i=0 por un uno para que no cuente el valor extra y empiece de 1

                        System.out.print("Ingrese nota #" + i + ": ");
                        double nota = sc.nextInt();//reemplazo int por double para mejorar el alcance de las notas

                        if (nota >= 0 && nota <= 10){//Se corrigio el ; por un {
                            notas.add(nota);//Aqui se guarda el valor individual de cada nota
                            total += nota;
                            cantidad++;
                        } else { //Se cierra la llave y se habre una segunda para evitar errores
                            System.out.println("Nota invalida");
                            i--;} //Linea que anexe para mejorar la calidad del codigo para que repita la misma nota
                    }
                    break; //Breack faltante

                case 2:

                    if (cantidad > 0) { //Anexo este if para resolver error de logica al operar sin datos
                        double promedio = total / cantidad; //Ya es posible reemplazar tambien la variable cantidad por un notas.size
                        System.out.println("Promedio: " + promedio);

                        if (promedio >= 9) {
                            System.out.println("Excelente");
                        } else if (promedio >= 8) {
                            System.out.println("Bueno");
                        } else if (promedio >= 7) {
                            System.out.println("Regular");
                        } else {
                            System.out.println("Reprobado");
                        }
                    } else {     
                        System.out.println("Aun no hay notas");
                    }
                    break;

                case 3:

                    double aprobados = 0;
                    double reprobados = 0;

                    //Cambio el while por un for para ingresar datos de manera mas especifica
                    for (double nota : notas) { //Borramos un ; que provocaba un error
                        //Cambio la logica dentro del if para adecuarse al arraylist
                        if (nota >= 7){ //Agrego las llaves restantes
                            aprobados++;
                        } else {
                            reprobados++;
                        } //Elimino la variable i no utilizada
                    }

                    System.out.println("Aprobados: " + aprobados);
                    System.out.println("Reprobados: " + reprobados);
                    break;

                case 4:

                    notas.clear();//Limpiamos el valor de notas y de la lista individual
                    total = 0;
                    cantidad = 0;
                    System.out.println("Datos reiniciados");
                    break;//Breack faltante

                case 5:

                    salir = true;
                    System.out.println("Saliendo del sistema");
                    break; //Breack faltante

                default:
                    System.out.println("Opcion no valida");
                    break; //Break faltante
            }

        }

        sc.close();
    
    }
    
}
