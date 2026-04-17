package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PokemonDAO dao = new PokemonDAO();
        BagDAO bag = new BagDAO();
        int opcion;

        do {
            System.out.println("\n=== POKEDEX MENU ===");
            System.out.println("1. Registrar Pokemon");
            System.out.println("2. Mostrar Pokemon");
            System.out.println("3. Actualizar Pokemon");
            System.out.println("4. Eliminar Pokemon");
            System.out.println("5. Buscar Pokemon");
            System.out.println("6. Ver Bag");
            System.out.println("7. Agregar Item a Bag");
            System.out.println("8. Actualizar Bag");
            System.out.println("9. Eliminar Item Bag");
            System.out.println("10. Salir");

            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {

                case 1:
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("Tipo: ");
                    String tipo = sc.nextLine();

                    dao.insertar(nombre, tipo);
                    break;

                case 2:
                    dao.listar();
                    break;

                case 3:
                    System.out.print("ID a actualizar: ");
                    int idAct = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Nuevo tipo: ");
                    String nuevoTipo = sc.nextLine();

                    dao.actualizar(idAct, nuevoTipo);
                    break;

                case 4:
                    System.out.print("ID a eliminar: ");
                    int idElim = sc.nextInt();

                    dao.eliminar(idElim);
                    break;

                case 5:
                    System.out.print("Nombre a buscar: ");
                    String buscar = sc.nextLine();
                    dao.buscarPorNombre(buscar);
                    break;

                case 6:
                    bag.listar();
                    break;

                case 7:
                    System.out.print("Nombre del item: ");
                    String item = sc.nextLine();

                    System.out.print("Cantidad: ");
                    int cantidad = sc.nextInt();
                    sc.nextLine();

                    bag.insertar(item, cantidad);
                    break;

                case 8:
                    System.out.print("ID del item: ");
                    int idBag = sc.nextInt();

                    System.out.print("Nueva cantidad: ");
                    int nuevaCant = sc.nextInt();
                    sc.nextLine();

                    bag.actualizar(idBag, nuevaCant);
                    break;

                case 9:
                    System.out.print("ID a eliminar: ");
                    int idDel = sc.nextInt();
                    sc.nextLine();

                    bag.eliminar(idDel);
                    break;

                case 10:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion invalida");
            }

        } while (opcion != 10);

        sc.close();
    }
}