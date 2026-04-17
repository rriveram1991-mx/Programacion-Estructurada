package org.example;

import org.w3c.dom.ls.LSOutput;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class titandao {

    public void mostrarTitanes() {
        String sql = "SELECT * FROM titanes";

        try {
            Connection con = Conexxxion.conectar();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            System.out.println("\n===== LISTA DE TITANES =====");

            while (rs.next()) {
                System.out.println("--------------------------");
                System.out.println("ID: " + rs.getInt("id_titan"));
                System.out.println("Nombre: " + rs.getString("nombre"));
                System.out.println("Clase: " + rs.getString("clase"));
                System.out.println("Vida: " + rs.getInt("vida"));
                System.out.println("Damage: " + rs.getInt("damage"));
                System.out.println("Descipcion: " + rs.getString("descipcion"));
            }

            rs.close();
            ps.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("Error al mostrar titanes.");
            System.out.println("Mensaje: " + e.getMessage());
        }
    }
    //------------------------------INGRESO--------------------------------------------------
    public void insertarTitan(String nombre, String clase, int vida, int damage, String descipcion) {
        String sql = "INSERT INTO titanes (nombre, clase, vida, damage, descipcion) VALUES (?, ?, ?, ?, ?)";

        try {
            Connection con = Conexxxion.conectar();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, nombre);
            ps.setString(2, clase);
            ps.setInt(3, vida);
            ps.setInt(4, damage);
            ps.setString(5, descipcion);

            ps.executeUpdate();

            System.out.println("Titan insertado correctamente.");

            ps.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("Error al insertar titan.");
            System.out.println("Mensaje: " + e.getMessage());
        }
    }
    //--------------------------------ACTUALIZACION-------------------------------------------------
    public void actualizarTitan(int id, String nombre, String clase, int vida, int damage, String descipcion) {
        String sql = "UPDATE titanes SET nombre = ?, clase = ?, vida = ?, damage = ?, descipcion = ? WHERE id_titan = ?";

        try {
            Connection con = Conexxxion.conectar();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, nombre);
            ps.setString(2, clase);
            ps.setInt(3, vida);
            ps.setInt(4, damage);
            ps.setString(5, descipcion);
            ps.setInt(6, id);

            int filas = ps.executeUpdate();

            if (filas > 0) {
                System.out.println("Titan actualizado correctamente.");
            } else {
                System.out.println("No se encontro un titan con ese ID.");
            }

            ps.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("Error al actualizar titan.");
            System.out.println("Mensaje: " + e.getMessage());
        }
    }
    //---------------------------ELIMINACION----------------------------------------------------------
    public void eliminarTitan(int id) {
        String sql = "DELETE FROM titanes WHERE id_titan = ?";

        try {
            Connection con = Conexxxion.conectar();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            int filas = ps.executeUpdate();

            if (filas > 0) {
                System.out.println("Titan eliminado correctamente.");
            } else {
                System.out.println("No se encontro un titan con ese ID.");
            }

            ps.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("Error al eliminar titan.");
            System.out.println("Mensaje: " + e.getMessage());
        }
    }
}