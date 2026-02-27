package errores;

import java.util.ArrayList;
import java.util.Scanner;

public class SistemaControlNotas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        boolean salir = false;
        ArrayList<Integer> notas = new ArrayList<>();
        System.out.println("=== SISTEMA DE CONTROL DE NOTAS ===");
        while (!salir) {
            System.out.println("\n1. Capturar notas");
            System.out.println("2. Mostrar promedio");
            System.out.println("3. Mostrar estadísticas");
            System.out.println("4. Reiniciar datos");
            System.out.println("5. Salir");
            System.out.print("Seleccione opción: ");
            
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    System.out.print("¿Cuántas notas desea capturar?: ");
                    int n = sc.nextInt();
                    if (n <= 0) {
                        System.out.println("Cantidad inválida"); break;}
                    for (int i = 1; i <= n; i++) {
                        System.out.print("Ingrese nota #" + i + ": ");
                        int nota = sc.nextInt();
                        if (nota >= 0 && nota <= 10) {
                            notas.add(nota);
                        } else {
                            System.out.println("Nota inválida, debe estar entre 0 y 10");
                        }} break;
                case 2:
                    if (notas.size() > 0) {
                        double promedio = notas.stream().mapToInt(Integer::intValue).average().orElse(0);
                        System.out.println("Promedio: " + promedio);
                        if (promedio >= 9)
                            System.out.println("Excelente");
                        else if (promedio >= 8)
                            System.out.println("Bueno");
                        else if (promedio >= 7)
                            System.out.println("Regular");
                        else
                            System.out.println("Reprobado"); }
                    else { System.out.println("No hay notas registradas"); } break;
                case 3:
                    int aprobados = 0;
                    int reprobados = 0;
                    for (int nota : notas) {
                        if (nota >= 7)
                            aprobados++;
                        else reprobados++; }
                    System.out.println("Aprobados: " + aprobados);
                    System.out.println("Reprobados: " + reprobados); break;
                case 4:
                    notas.clear();
                System.out.println("Datos reiniciados"); break;
                case 5:
                    salir = true;
                    System.out.println("Saliendo del sistema..."); break;
                default:
                    System.out.println("Opción no válida");
            } }
        sc.close();
    } }