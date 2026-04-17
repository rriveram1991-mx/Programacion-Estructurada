package org.example;

import java.sql.*;
import java.util.Scanner;

public class PokedexApp {


    private static final String URL = "jdbc:mysql://localhost:3306/pokedex";
    private static final String USER = "root";
    private static final String PASS = "20001224"; // <--- REVISA QUE ESTA SEA TU CONTRASEÑA

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = -1;

        do {
            System.out.println("\n--- MENU POKEDEX ---");
            System.out.println("1. Insertar Pokemon");
            System.out.println("2. Búsqueda (Pokemones y Mochila)");
            System.out.println("3. Actualizar Pokemon");
            System.out.println("4. Eliminar objeto Mochila");
            System.out.println("5. Agregar objeto a mochila");
            System.out.println("0. Salir");
            System.out.print("Opción: ");

            try {
                opcion = Integer.parseInt(sc.nextLine());

                switch (opcion) {
                    case 1:
                        insertar(sc);
                        break;
                    case 2:
                        buscar();
                        break;
                    case 3:
                        actualizar(sc);
                        break;
                    case 4:
                        eliminar(sc);
                        break;
                    case 5: agregarObjeto(sc);
                    break;
                    case 0:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("No válida.");
                }
            } catch (Exception e) {
                System.out.println("Error: Ingresa un número.");
            }
        } while (opcion != 0);
    }

    public static void insertar(Scanner sc) {
        System.out.print("Nombre: ");
        String n = sc.nextLine();
        System.out.print("Total: ");
        int t = Integer.parseInt(sc.nextLine());
        String sql = "INSERT INTO Pokemones (nombre_pokemon, total_pokemon) VALUES (?, ?)";
        try (Connection con = DriverManager.getConnection(URL, USER, PASS); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, n);
            ps.setInt(2, t);
            ps.executeUpdate();
            System.out.println(" Guardado.");
        } catch (SQLException e) {
            System.out.println(" Error: " + e.getMessage());
        }
    }

    public static void buscar() {
        try (Connection con = DriverManager.getConnection(URL, USER, PASS); Statement st = con.createStatement()) {
            ResultSet rsP = st.executeQuery("SELECT * FROM Pokemones");
            System.out.println("\n-- TABLA POKEMONES --");
            while (rsP.next()) {
                System.out.println(rsP.getInt("id_pokemon") + " | " + rsP.getString("nombre_pokemon") + " | " + rsP.getInt("total_pokemon"));
            }
            ResultSet rsM = st.executeQuery("SELECT * FROM mochila");
            System.out.println("\n-- TABLA MOCHILA --");
            while (rsM.next()) {
                System.out.println(rsM.getInt("id_objeto") + " | " + rsM.getString("nombre_objeto") + " | " + rsM.getInt("total_objeto"));
            }
        } catch (SQLException e) {
            System.out.println(" Error: " + e.getMessage());
        }
    }

    public static void actualizar(Scanner sc) {
        System.out.print("ID del Pokemon: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Nuevo Nombre: ");
        String nn = sc.nextLine();
        String sql = "UPDATE Pokemones SET nombre_pokemon = ? WHERE id_pokemon = ?";
        try (Connection con = DriverManager.getConnection(URL, USER, PASS); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, nn);
            ps.setInt(2, id);
            ps.executeUpdate();
            System.out.println(" Actualizado.");
        } catch (SQLException e) {
            System.out.println(" Error: " + e.getMessage());
        }
    }

    public static void eliminar(Scanner sc) {
        System.out.print("Nombre del objeto a borrar: ");
        String obj = sc.nextLine();
        String sql = "DELETE FROM mochila WHERE nombre_objeto = ?";
        try (Connection con = DriverManager.getConnection(URL, USER, PASS); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, obj);
            int filas = ps.executeUpdate();
            if (filas > 0) System.out.println("🗑️ Borrado.");
            else System.out.println(" No se encontró.");
        } catch (SQLException e) {
            System.out.println(" Error: " + e.getMessage());
        }
    }

    public static void agregarObjeto(Scanner sc) {
        System.out.print("Nombre del objeto: ");
        String nombre = sc.nextLine();
        System.out.print("Cantidad: ");
        int total = Integer.parseInt(sc.nextLine());

        String sql = "INSERT INTO mochila (nombre_objeto, total_objeto) VALUES (?, ?)";

        try (Connection con = DriverManager.getConnection(URL, USER, PASS); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, nombre);
            ps.setInt(2, total);
            ps.executeUpdate();
            System.out.println(" Objeto agregado a la mochila.");
        } catch (SQLException e) {
            System.out.println(" Error: " + e.getMessage());
        }
    }
}

