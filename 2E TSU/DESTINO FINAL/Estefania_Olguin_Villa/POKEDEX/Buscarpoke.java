

import conexion.conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Buscarpoke {
    public static void Buscarpoke() {
        try {
            Connection cnx = conexion.getConection();
            Statement st = cnx.createStatement();

            // Buscar pokemones
            ResultSet rs = st.executeQuery("SELECT * FROM poke.registro");
            System.out.println("=== POKEDEX ===");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("idpokemon"));
                System.out.println("Nombre: " + rs.getString("nombre"));
                System.out.println("Tipo: " + rs.getString("tipo"));
                System.out.println();
            }

            // Buscar bag
            ResultSet rs2 = st.executeQuery("SELECT * FROM bag.inventario");
            System.out.println("=== MOCHILA ===");
            while (rs2.next()) {
                System.out.println("ID: " + rs2.getInt("idinventario"));
                System.out.println("Objeto: " + rs2.getString("nombre"));
                System.out.println("Cantidad: " + rs2.getInt("cont"));
                System.out.println();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        Buscarpoke();
    }
}