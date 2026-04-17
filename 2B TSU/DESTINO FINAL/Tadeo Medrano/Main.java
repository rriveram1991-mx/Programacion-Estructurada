package crud_2B;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CRUD crud = new CRUD();
        int opcion;

        do {
            System.out.println("\n--- SISTEMA POKÉMON ---");
            System.out.println("1. Agregar 2. Leer 3. Actualizar 4. Eliminar 0. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: "); String n = sc.next();
                    System.out.print("Tipo: "); String t = sc.next();
                    System.out.print("Nivel: "); int nv = sc.nextInt();
                    System.out.print("PS Máximos: "); int ps = sc.nextInt();
                    crud.agregar(new pokemon(n, t, nv, ps));
                    break;
                case 2:
                    crud.leer();
                    break;
                case 3:
                    System.out.print("ID a modificar: "); int idA = sc.nextInt();
                    System.out.print("Nuevo nivel: "); int nNv = sc.nextInt();
                    crud.actualizar(idA, nNv);
                    break;
                case 4:
                    System.out.print("ID a eliminar: "); int idE = sc.nextInt();
                    crud.eliminar(idE);
                    break;
            }
        } while (opcion != 0);
    }
}