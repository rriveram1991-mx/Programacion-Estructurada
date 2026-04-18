
import conexion.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Actualizarpoke {
    public static void Actualizarpoke() {
        try {
            Connection cnx = conexion.getConection();

            // Actualizar pokemon
            String sql = "UPDATE poke.registro SET nombre=?, tipo=? WHERE idpokemon=?";
            PreparedStatement ps = cnx.prepareStatement(sql);
            ps.setString(1, "Mewtwo");
            ps.setString(2, "Psiquico");
            ps.setInt(3, 1);
            ps.executeUpdate();
            System.out.println("Pokemon actualizado correctamente");
            System.out.println();

            // Actualizar bag
            String sql2 = "UPDATE bag.inventario SET nombre=?, cont=? WHERE idinventario=?";
            PreparedStatement ps2 = cnx.prepareStatement(sql2);
            ps2.setString(1, "Pocion");
            ps2.setInt(2, 10);
            ps2.setInt(3, 1);
            ps2.executeUpdate();
            System.out.println("Objeto actualizado correctamente");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        Actualizarpoke();
    }
}
