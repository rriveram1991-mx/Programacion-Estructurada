import java.sql.*;
import java.util.Scanner;

public class PokemonGame {

    static Connection conn;

    public static void main(String[] args) {
        try {
            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/pokemon_game",
                "root",
                "1234"
            );

            Scanner sc = new Scanner(System.in);
            int op;

            do {
                System.out.println("\n1. Registrar Pokemon");
                System.out.println("2. Actualizar Pokemon y Mochila");
                System.out.println("3. Eliminar Pokemon");
                System.out.println("4. Borrar Pokemon y mostrar Mochila");
                System.out.println("0. Salir");
                op = sc.nextInt();

                switch(op) {
                    case 1: registrarPokemon(sc); break;
                    case 2: actualizar(sc); break;
                    case 3: eliminarPokemon(sc); break;
                    case 4: borrarYMostrar(); break;
                }

            } while(op != 0);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    static void registrarPokemon(Scanner sc) throws SQLException {
        System.out.println("Nombre:");
        String nombre = sc.next();
        System.out.println("Tipo:");
        String tipo = sc.next();

        PreparedStatement ps = conn.prepareStatement(
            "INSERT INTO pokemones(nombre,tipo) VALUES (?,?)"
        );
        ps.setString(1, nombre);
        ps.setString(2, tipo);
        ps.executeUpdate();

        System.out.println("Pokemon registrado!");
    }

    static void actualizar(Scanner sc) throws SQLException {
        System.out.println("ID del pokemon:");
        int id = sc.nextInt();

        System.out.println("Nuevo nombre:");
        String nombre = sc.next();
        System.out.println("Nuevo tipo:");
        String tipo = sc.next();

        PreparedStatement ps = conn.prepareStatement(
            "UPDATE pokemones SET nombre=?, tipo=? WHERE id=?"
        );
        ps.setString(1, nombre);
        ps.setString(2, tipo);
        ps.setInt(3, id);
        ps.executeUpdate();

        System.out.println("Cuantas pociones agregar:");
        int extra = sc.nextInt();

        PreparedStatement ps2 = conn.prepareStatement(
            "UPDATE mochila SET cantidad = cantidad + ? WHERE id = 1"
        );
        ps2.setInt(1, extra);
        ps2.executeUpdate();

        System.out.println("Actualizado!");
    }

    static void eliminarPokemon(Scanner sc) throws SQLException {
        System.out.println("ID a eliminar:");
        int id = sc.nextInt();

        PreparedStatement ps = conn.prepareStatement(
            "DELETE FROM pokemones WHERE id=?"
        );
        ps.setInt(1, id);
        ps.executeUpdate();

        System.out.println("Eliminado!");
    }

    static void borrarYMostrar() throws SQLException {
        Statement st = conn.createStatement();
        st.executeUpdate("DELETE FROM pokemones");

        ResultSet rs = st.executeQuery("SELECT * FROM mochila");
        while(rs.next()) {
            System.out.println(
                rs.getString("nombre") +
                " - Cantidad: " +
                rs.getInt("cantidad")
            );
        }
    }
}