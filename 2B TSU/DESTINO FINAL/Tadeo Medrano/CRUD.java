package crud_2B;

import java.sql.*;

public class CRUD {
    Conexion conectar = new Conexion();

    public void agregar(pokemon p) {
        String sql = "INSERT INTO pokemon (nombre, tipo, nivel, ps_maximos) VALUES (?, ?, ?, ?)";
        try (Connection cnx = conectar.getConnection(); PreparedStatement ps = cnx.prepareStatement(sql)) {
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getTipo());
            ps.setInt(3, p.getNivel());
            ps.setInt(4, p.getPsMaximos());
            ps.executeUpdate();
            System.out.println("✅ Guardado correctamente.");
        } catch (SQLException e) { System.out.println("❌ Error al guardar: " + e.getMessage()); }
    }

    public void leer() {
        String sql = "SELECT * FROM pokemon";
        try (Connection cnx = conectar.getConnection(); Statement st = cnx.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            System.out.println("\n--- LISTA DE POKEMONES ---");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("i_pokemon") + " | " + rs.getString("nombre") + " | Nivel: " + rs.getInt("nivel"));
            }
        } catch (SQLException e) { System.out.println(e.getMessage()); }
    }

    public void actualizar(int id, int nuevoNivel) {
        String sql = "UPDATE pokemon SET nivel = ? WHERE i_pokemon = ?";
        try (Connection cnx = conectar.getConnection(); PreparedStatement ps = cnx.prepareStatement(sql)) {
            ps.setInt(1, nuevoNivel);
            ps.setInt(2, id);
            ps.executeUpdate();
            System.out.println("✅ Nivel actualizado.");
        } catch (SQLException e) { System.out.println(e.getMessage()); }
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM pokemon WHERE i_pokemon = ?";
        try (Connection cnx = conectar.getConnection(); PreparedStatement ps = cnx.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println(" Pokémon eliminado.");
        } catch (SQLException e) { System.out.println(e.getMessage()); }
    }
}