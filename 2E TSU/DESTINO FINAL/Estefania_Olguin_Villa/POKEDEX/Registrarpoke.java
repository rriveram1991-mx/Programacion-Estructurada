

import conexion.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Registrarpoke {
    public static void Registrarpoke() {
        try {
            Connection cnx = conexion.getConection();
            String sql = "INSERT INTO poke.registro (nombre, tipo) VALUES (?,?)";
            PreparedStatement ps = cnx.prepareStatement(sql);
            ps.setString(1, "Mewtwo");
            ps.setString(2, "Psiquico");
            ps.executeUpdate();
            System.out.println("Pokemon registrado correctamente");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public static void main(String[] args) {
        Registrarpoke();
    }
}
