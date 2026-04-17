package org.example;

import java.sql.*;

public class PokemonDAO {

    // INSERTAR
    public void insertar(String nombre, String tipo) {
        String sql = "INSERT INTO pokemon(nombre, tipo) VALUES (?, ?)";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nombre);
            stmt.setString(2, tipo);
            stmt.executeUpdate();

            System.out.println("Pokemon guardado tioooo");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // LISTAR
    public void listar() {
        String sql = "SELECT * FROM pokemon";

        try (Connection conn = Conexion.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("=== POKEDEX ===");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " - " +
                                rs.getString("nombre") + " - " +
                                rs.getString("tipo")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ACTUALIZAR
    public void actualizar(int id, String tipo) {
        String sql = "UPDATE pokemon SET tipo=? WHERE id=?";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, tipo);
            stmt.setInt(2, id);
            stmt.executeUpdate();

            System.out.println("Pokemon actualizado");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ELIMINAR
    public void eliminar(int id) {
        String sql = "DELETE FROM pokemon WHERE id=?";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

            System.out.println("Pokemon eliminado jolines");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Busca
    public void buscarPorNombre(String nombre) {
        String sql = "SELECT * FROM pokemon WHERE nombre LIKE ?";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, "%" + nombre + "%");

            ResultSet rs = stmt.executeQuery();

            System.out.println("=== RESULTADOS ===");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " - " +
                                rs.getString("nombre") + " - " +
                                rs.getString("tipo")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}