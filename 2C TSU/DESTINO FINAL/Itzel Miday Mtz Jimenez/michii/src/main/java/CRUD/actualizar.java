package CRUD;
import po.conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
public class actualizar {
    public static void actualizarGato(int id, int nuevaVida, int nuevaSalud) {
        try (Connection c = Conexion.getConnection()) {
            String sql = "UPDATE gatos SET vida = ?, saludact = ? WHERE idgatos = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, nuevaVida);
            ps.setInt(2, nuevaSalud);
            ps.setInt(3, id);

            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("--- Gato actualizado correctamente ---");
            }
        } catch (Exception e) {
            System.out.println("ERROR al actualizar gato: " + e.getMessage());
        }
    }
    public static void actualizarMochila(String nombreItem, int nuevaCantidad) {
        try (Connection c = Conexion.getConnection()) {
            String sql = "UPDATE mochila SET cantidad = ? WHERE nombre = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, nuevaCantidad);
            ps.setString(2, nombreItem);

            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("--- Mochila actualizada: " + nombreItem + " ahora tiene " + nuevaCantidad + " unidades ---");
            }
        } catch (Exception e) {
            System.out.println("ERROR al actualizar mochila: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        actualizarGato(1, 120, 120);
        actualizarMochila("Pocion", 10);
    }
}

