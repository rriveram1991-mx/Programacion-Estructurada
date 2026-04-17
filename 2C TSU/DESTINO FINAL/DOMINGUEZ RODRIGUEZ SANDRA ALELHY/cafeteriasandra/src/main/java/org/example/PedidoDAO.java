package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PedidoDAO {
    private Connection conexion;

    public void listarPedidos() {
        String sql = "SELECT * FROM pedidos";
        try (Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("Pedido ID: " + rs.getInt("idpedidos") +
                        " | Cliente: " + rs.getString("cliente") +
                        " | Cantidad: " + rs.getInt("cantidad"));
            }
        } catch (SQLException e) {
            System.out.println("Error al listar pedidos: " + e.getMessage());
        }
    }
}