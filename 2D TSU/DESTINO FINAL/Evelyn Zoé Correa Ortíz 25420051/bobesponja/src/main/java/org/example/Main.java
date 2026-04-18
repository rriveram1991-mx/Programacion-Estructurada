package org.example;
import crud.Actualizar;
import crud.Insertarpersonajes;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner lr = new Scanner(System.in);
        int opcion;

        Insertarpersonajes pk = new Insertarpersonajes();
        BuscarPersonaje bs = new BuscarPersonaje();
        ActualizarPersonaje act = new ActualizarPersonaje();
        EliminarPersonaje rm = new EliminarPersonaje();

        do {
            System.out.println("===== MENU DE PERSONAJES =====");
            System.out.println("1. Insertar Personaje");
            System.out.println("2. Buscar Personaje");
            System.out.println("3. Actualizar Personaje");
            System.out.println("4. Eliminar Personaje");
            System.out.println("5. Salir");
            System.out.print("Elige una opcion: ");

            opcion = lr.nextInt();
            lr.nextLine();

            switch (opcion) {

                case 1:
                    System.out.print("Ingrese nombre: ");
                    String nom = lr.nextLine();
                    System.out.print("Ingrese color: ");
                    String tipo = lr.nextLine();
                    pk.insertar(nom, tipo);
                    break;
                case 2:
                    System.out.print("ID a buscar: ");
                    int idBuscar = lr.nextInt();
                    lr.nextLine();
                    bs.buscar(idBuscar);
                    break;
                case 3:
                    System.out.print("ID: ");
                    int id = lr.nextInt();
                    lr.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = lr.nextLine();

                    System.out.print("Color: ");
                    String color = lr.nextLine();
                    Actualizar.Actualizar(id, nombre, color);
                    break;

                case 4:
                    System.out.print("ID a eliminar: ");
                    int idEliminar = lr.nextInt();
                    lr.nextLine();
                    rm.eliminar(idEliminar);
                    break;

                case 5:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opcion invalida");
            }

        } while (opcion != 5);

        lr.close();
    }
}