package org.example;

import java.sql.*;

public class BagDAO {

    // INSERTAR
    public void insertar(String nombre, int cantidad) {
        String sql = "INSERT INTO bag(nombre, cantidad) VALUES (?, ?)";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nombre);
            stmt.setInt(2, cantidad);
            stmt.executeUpdate();

            System.out.println("Item agregado a la bag (mochila para los cuates)");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // LISTAR
    public void listar() {
        String sql = "SELECT * FROM bag";

        try (Connection conn = Conexion.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("=== BAG ===");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " - " +
                                rs.getString("nombre") + " - Cantidad: " +
                                rs.getInt("cantidad")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ACTUALIZAR
    public void actualizar(int id, int cantidad) {
        String sql = "UPDATE bag SET cantidad=? WHERE id=?";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, cantidad);
            stmt.setInt(2, id);
            stmt.executeUpdate();

            System.out.println("Cantidad actualizada ");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ELIMINAR
    public void eliminar(int id) {
        String sql = "DELETE FROM bag WHERE id=?";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

            System.out.println("Item eliminado ");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}