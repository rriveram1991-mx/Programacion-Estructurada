package org.example;

import gim.Conexion.Conexion;
import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Connection con = Conexion.getConnection();
        if (con == null) return;

        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 5) {
            System.out.println("\n--- SISTEMA POKEMON UTT ---");
            System.out.println("1. Insertar Pokemon");
            System.out.println("2. Leer Pokedex y Mochila");
            System.out.println("3. Actualizar Pokemon");
            System.out.println("4. Eliminar Pokemon");
            System.out.println("5. Salir");
            System.out.print("Elige: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1: insertar(con, sc); break;
                case 2: leerTodo(con); break;
                case 3: actualizar(con, sc); break;
                case 4: eliminar(con, sc); break;
            }
        }
    }

    public static void insertar(Connection con, Scanner sc) {
        System.out.print("Nombre: "); String n = sc.nextLine();
        System.out.print("Elemento: "); String e = sc.nextLine();
        System.out.print("Vida: "); int v = sc.nextInt();
        System.out.print("Daño: "); int d = sc.nextInt();

        String sql = "INSERT INTO pokemones (name, element, vida, daño) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, n);
            ps.setString(2, e);
            ps.setInt(3, v);
            ps.setInt(4, d);
            ps.executeUpdate();
            System.out.println("¡Pokemon guardado!");
        } catch (SQLException err) { System.out.println("Error: " + err.getMessage()); }
    }

    public static void leerTodo(Connection con) {
        try (Statement st = con.createStatement()) {
            ResultSet rs = st.executeQuery("SELECT * FROM pokemones");
            System.out.println("\n-- TU POKEDEX --");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("idpokemones") + " | " + rs.getString("name"));
            }

            ResultSet rs2 = st.executeQuery("SELECT * FROM mochila");
            System.out.println("\n-- TU MOCHILA --");
            while (rs2.next()) {
                System.out.println("Curas: " + rs2.getString("curas") + " | Balls: " + rs2.getString("poke balls"));
            }
        } catch (SQLException err) { System.out.println("Error: " + err.getMessage()); }
    }

    public static void actualizar(Connection con, Scanner sc) {
        System.out.print("ID del pokemon: "); int id = sc.nextInt();
        System.out.print("Nueva vida: "); int nv = sc.nextInt();
        String sql = "UPDATE pokemones SET vida = ? WHERE idpokemones = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, nv);
            ps.setInt(2, id);
            ps.executeUpdate();
            System.out.println("¡Actualizado!");
        } catch (SQLException err) { System.out.println("Error: " + err.getMessage()); }
    }

    public static void eliminar(Connection con, Scanner sc) {
        System.out.print("ID a eliminar: "); int id = sc.nextInt();
        String sql = "DELETE FROM pokemones WHERE idpokemones = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("¡Eliminado!");
        } catch (SQLException err) { System.out.println("Error: " + err.getMessage()); }
    }
}