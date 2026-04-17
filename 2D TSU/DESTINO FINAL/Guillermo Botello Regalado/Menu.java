
import java.util.Scanner;
import java.sql.Connection;

public class Menu {
    public static void main(String[] args) {
        Connection con = Conexion.conectar();

        if (con != null) {
            System.out.println("Conectado correctamente");
        } else {
            System.out.println("Error de conexión");
        }

        Scanner sc = new Scanner(System.in);
        int op;

        do {
            System.out.println("1. Insertar");
            System.out.println("2. Mostrar");
            System.out.println("3. Actualizar nivel Pokemon");
            System.out.println("4. Agregar objeto a mochila");
            System.out.println("0. Salir");
            op = sc.nextInt();

            switch (op) {
                case 1:
                    System.out.print("Nombre: ");
                    String n = sc.next();
                    System.out.print("Tipo: ");
                    String t = sc.next();
                    System.out.print("Nivel: ");
                    int lvl = sc.nextInt();

                    PokemoDB.insertar(n, t, lvl);
                    break;

                case 2:
                    Mustra.ver();
                    break;
                case 3:
                    System.out.print("ID del Pokemon: ");
                    int id = sc.nextInt();

                    System.out.print("Nuevo nivel: ");
                    int nivel = sc.nextInt();

                    PokemoDB.actualizarNivel(id, nivel);
                    break;
                case 4:
                    System.out.print("Nombre del objeto: ");
                    String obj = sc.next();

                    System.out.print("Cantidad: ");
                    int cant = sc.nextInt();

                    PokemoDB.insertarObjeto(obj, cant);
                    break;
            }
        } while (op != 0) ;
    }
}


