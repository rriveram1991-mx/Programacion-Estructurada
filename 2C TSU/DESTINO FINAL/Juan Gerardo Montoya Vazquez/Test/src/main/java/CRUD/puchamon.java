package CRUD;

import Conexion.Conexion;
import java.sql.*;
import java.util.Scanner;

public class puchamon {

    static Connection con = Conexion.getConnection();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int op;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Registrar Pokemon");
            System.out.println("2. Actualizar Pokemon/Mochila");
            System.out.println("3. Eliminar Pokemon");
            System.out.println("4. Vaciar todo");
            System.out.println("0. Salir");

            op = sc.nextInt();

            switch (op) {
                case 1 -> registrarPokemon();
                case 2 -> actualizar();
                case 3 -> eliminarPokemon();
                case 4 -> vaciarTodo();
            }

        } while (op != 0);
    }

    // 1️⃣ Registrar
    public static void registrarPokemon() {
        try {
            System.out.print("Nombre: ");
            String nombre = sc.next();

            System.out.print("Tipo: ");
            String tipo = sc.next();

            System.out.print("salud: ");
            String salud = sc.next();

            System.out.print("ataque: ");
            String ataque = sc.next();

            System.out.print("defensa: ");
            String defensa = sc.next();


            String sql = "INSERT INTO pokemones (nombre, tipo,salud,ataque,defensa) VALUES (?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, nombre);
            ps.setString(2, tipo);
            ps.setString(3, salud);
            ps.setString(4, ataque);
            ps.setString(5, defensa);
            ps.executeUpdate();

            System.out.println("Pokemon registrado");

        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            String sql = "INSERT INTO bag (nombre, cantidad) VALUES (?,?)";

            PreparedStatement insert = con.prepareStatement(sql);

            insert.setString(1, "cerveza");
            insert.setString(2, "1");

            insert.executeUpdate();

            System.out.println("mochila registrada.");

        } catch (Exception e) {
            System.out.println("Error al registrar mochila.");
            e.printStackTrace();
        }
    }


    // 2️⃣ Actualizar
    public static void actualizar() {
        try {
            System.out.println("1. Pokemon  2. Mochila");
            int op = sc.nextInt();

            if (op == 1) {
                System.out.print("ID Pokemon: ");
                int id = sc.nextInt();

                System.out.print("Nuevo nombre: ");
                String nombre = sc.next();

                System.out.print("Nuevo Tipo: ");
                String tipo = sc.next();

                System.out.print("Nuevo NVL salud ");
                int salud = sc.nextInt();

                System.out.print("Nuevo Nvl ataque ");
                int ataque = sc.nextInt();

                System.out.print("Nuevo Nvl defensa  ");
                int defensa = sc.nextInt();

                String sql = "UPDATE pokemones SET nombre=?,tipo=?,salud=?,ataque=?,defensa=? WHERE idpokemones=?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, nombre);
                ps.setString(2, tipo);
                ps.setInt(6, id);
                ps.setInt(3, salud);
                ps.setInt(4, ataque);
                ps.setInt(5, defensa);
                ps.executeUpdate();

            } else {
                System.out.print("Nueva cantidad de pociones: ");
                int cant = sc.nextInt();

                String sql = "UPDATE bag SET cantidad=?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, cant);
                ps.executeUpdate();
            }

            System.out.println("Actualizado");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 3️⃣ Eliminar Pokemon
    public static void eliminarPokemon() {
        try {
            System.out.print("ID a eliminar: ");
            int id = sc.nextInt();

            String sql = "DELETE FROM pokemones WHERE idpokemones=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

            System.out.println("Eliminado");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 4️⃣ Vaciar todo
    public static void vaciarTodo() {
        try {
            // Mostrar mochila antes
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM bag");

            System.out.println("Objetos en mochila:");
            while (rs.next()) {
                System.out.println(rs.getString("nombre") + " - " + rs.getInt("cantidad"));
            }

            // Borrar todo
            st.executeUpdate("DELETE FROM pokemones");
            st.executeUpdate("DELETE FROM bag");

            System.out.println("Todo eliminado");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
