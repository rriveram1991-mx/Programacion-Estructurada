

import conexion.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Eliminarpoke {
    public static void Eliminarpoke() {
        try {
            Connection cnx = conexion.getConection();
            Statement st = cnx.createStatement();

            // Contar antes de eliminar
            ResultSet rs = st.executeQuery("SELECT COUNT(*) as total FROM poke.registro");
            if (rs.next()) {
                System.out.println("Pokemones antes de eliminar: " + rs.getInt("total"));
            }

            // Eliminar pokemon
            String sql = "DELETE FROM poke.registro WHERE idpokemon=?";
            PreparedStatement ps = cnx.prepareStatement(sql);
            ps.setInt(1, 1);
            ps.executeUpdate();
            System.out.println("Pokemon eliminado correctamente");

            // Contar despues de eliminar
            ResultSet rs2 = st.executeQuery("SELECT COUNT(*) as total FROM poke.registro");
            if (rs2.next()) {
                System.out.println("Pokemones despues de eliminar: " + rs2.getInt("total"));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        Eliminarpoke();
    }
}
