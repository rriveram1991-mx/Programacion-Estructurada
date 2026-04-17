
import java.sql.*;

public class Mustra {


        public static void ver() {
            try {
                Connection con = Conexion.conectar();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM pokemons");

                while (rs.next()) {
                    System.out.println(
                            rs.getInt("id") + " - " +
                            rs.getString("nombre") + " - " +
                                    rs.getString("tipo") + " - Nivel " +
                                    rs.getInt("nivel")
                    );
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    public static void verMochila() {
        try {
            Connection con = Conexion.conectar();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM mochila");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " - " +
                                rs.getString("nombre_objeto") + " - Cantidad: " +
                                rs.getInt("cantidad")
                );
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    }
