
import java.sql.Connection;
import java.sql.PreparedStatement;

public class PokemoDB {
        public static void insertar(String nombre, String tipo, int nivel) {
            try {
                Connection con = Conexion.conectar();

                String sql = "INSERT INTO pokemons(nombre, tipo, nivel) VALUES (?, ?, ?)";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, nombre);
                ps.setString(2, tipo);
                ps.setInt(3, nivel);

                ps.executeUpdate();

                System.out.println("Pokémon guardado en la BD");
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    public static void actualizarNivel(int id, int nuevoNivel) {
        try {
            Connection con = Conexion.conectar();

            String sql = "UPDATE pokemons SET nivel=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, nuevoNivel);
            ps.setInt(2, id);

            ps.executeUpdate();

            System.out.println("Pokémon actualizado");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void insertarObjeto(String nombre, int cantidad) {
        try {
            Connection con = Conexion.conectar();

            String sql = "INSERT INTO mochila(nombre_objeto, cantidad) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, nombre);
            ps.setInt(2, cantidad);

            ps.executeUpdate();

            System.out.println("Objeto agregado a la mochila");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    }

