package pokemon.dao;

import pokemon.conexion.conexion;
import java.sql.*;
import java.util.Scanner;

public class pokedex {

    public static void registrarPokemon() {
        Scanner sc = new Scanner(System.in);
        try (Connection con = conexion.conectar()) {

            System.out.print("Nombre: ");
            String nombre = sc.nextLine();

            System.out.print("Tipo: ");
            String tipo = sc.nextLine();

            System.out.print("Salud: ");
            int salud = sc.nextInt();

            System.out.print("Ataque: ");
            int ataque = sc.nextInt();

            String sql = "INSERT INTO pokemon(nombre,tipo,salud,ataque) VALUES(?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, nombre);
            ps.setString(2, tipo);
            ps.setInt(3, salud);
            ps.setInt(4, ataque);

            ps.executeUpdate();
            System.out.println("✔ Pokémon registrado");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void mostrarPokemon() {
        try (Connection con = conexion.conectar()) {

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM pokemon");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " - " +
                                rs.getString("nombre") + " | " +
                                rs.getString("tipo") + " | HP: " +
                                rs.getInt("salud") + " | ATK: " +
                                rs.getInt("ataque")
                );
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void eliminarPokemon() {
        Scanner sc = new Scanner(System.in);
        try (Connection con = conexion.conectar()) {

            System.out.print("ID: ");
            int id = sc.nextInt();

            PreparedStatement ps = con.prepareStatement("DELETE FROM pokemon WHERE id=?");
            ps.setInt(1, id);
            ps.executeUpdate();

            System.out.println("✔ Eliminado");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void actualizarPokemon() {
        Scanner sc = new Scanner(System.in);
        try (Connection con = conexion.conectar()) {

            System.out.print("ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Nuevo nombre: ");
            String nombre = sc.nextLine();

            PreparedStatement ps = con.prepareStatement(
                    "UPDATE pokemon SET nombre=? WHERE id=?"
            );
            ps.setString(1, nombre);
            ps.setInt(2, id);

            ps.executeUpdate();
            System.out.println("✔ Actualizado");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
