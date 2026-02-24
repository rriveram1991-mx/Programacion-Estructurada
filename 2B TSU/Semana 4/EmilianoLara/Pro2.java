
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pro2;
import java.util.Scanner;

/**
 *
 * @author emili
 */
public class Pro2 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
 int aprobados = 0;
                    int reprobados = 0;
        int opcion = 0;
        double total = 0;
        int cantidad = 0;
        boolean salir = false;
        System.out.println("=== SISTEMA DE CONTROL DE NOTAS ===");
        while (!salir) {
            System.out.println("1. Capturar notas");
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
                    for (int i = 1; i <= n; i++) {
                        System.out.print("Ingrese nota #" + i + ": ");
                        double nota = sc.nextDouble();
                        if (nota >= 0 && nota <= 10){
                            
                            total += nota;
                            cantidad++;}
                        else{
                            System.out.println("Nota invalida");}
                         if (nota>= 7){
                            aprobados++;   
                        }
                        else{                          
                            reprobados++;
                        }
                    }
                    break;
                case 2:
                    if (cantidad > 0) {
                    double promedio = total / cantidad;
                    System.out.println("Promedio: " + promedio);
                 if (promedio >= 9){
                        System.out.println("Excelente");}
                    else if (promedio >= 8){
                        System.out.println("Bueno");}
                    else if (promedio >= 7){
                        System.out.println("Regular");}
                    else {
                        System.out.println("Reprobado");
                    }
                    } else{
                 System.out.println("No hay notas leídas");}
                    break;
                case 3:
                   
                    System.out.println("Aprobados: " + aprobados);
                    System.out.println("Reprobados: " + reprobados);
                    break;
                case 4:
                    total = 0;
                    cantidad = 0;
                    aprobados = 0;
                    reprobados =0;
                    System.out.println("Datos reiniciados");
                    break;
                case 5:
                    
                    System.out.println("Saliendo del sistema");
                    salir = true;
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        }
        sc.close();
    }
}
    