package org.example;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class mochilao {
// MOSTRAR MOCHILA------------------------------------------------------------------------------------------
        public void seebag() {

                String sql = "SELECT * FROM bag";

                try {
                    Connection con = Conexxxion.conectar();
                    PreparedStatement ps = con.prepareStatement(sql);
                    ResultSet rs = ps.executeQuery();

                    System.out.println("\n===== BAG =====");
                    System.out.println("--------------------------");

                    while (rs.next()) {
                        System.out.println("ID: " + rs.getInt("id_obj"));
                        System.out.println("Nombre: " + rs.getString("nombre"));
                        System.out.println("Tipo: " + rs.getString("tipo"));
                        System.out.println("Cantidad: " + rs.getInt("cantidad"));
                        System.out.println("Descripcion: " + rs.getString("descripcion"));
                        System.out.println("--------------------------");
                    }

                    rs.close();
                    ps.close();
                    con.close();

                } catch (SQLException e) {
                    System.out.println("Error al mostrar la bag.");
                    System.out.println("Mensaje: " + e.getMessage());
                }
            }

            public void obj(String nombre, String tipo, int cantidad, String descripcion) {
                String sql = "INSERT INTO bag (nombre, tipo, cantidad, descripcion) VALUES (?, ?, ?, ?)";

                try {
                    Connection con = Conexxxion.conectar();
                    PreparedStatement ps = con.prepareStatement(sql);

                    ps.setString(1, nombre);
                    ps.setString(2, tipo);
                    ps.setInt(3, cantidad);
                    ps.setString(4, descripcion);

                    ps.executeUpdate();

                    System.out.println("Objeto insertado correctamente en la mochila.");

                    ps.close();
                    con.close();

                } catch (SQLException e) {
                    System.out.println("Error al insertar objeto en la mochila.");
                    System.out.println("Mensaje: " + e.getMessage());
                }
            }
            //ACTUAIZAR
    public void actualizarObjeto(int id, String nombre, String tipo, int cantidad, String descripcion) {
        String sql = "UPDATE bag SET nombre = ?, tipo = ?, cantidad = ?, descripcion = ? WHERE id_obj = ?";

        try {
            Connection con = Conexxxion.conectar();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, nombre);
            ps.setString(2, tipo);
            ps.setInt(3, cantidad);
            ps.setString(4, descripcion);
            ps.setInt(5, id);

            int filas = ps.executeUpdate();

            if (filas > 0) {
                System.out.println("Objeto actualizado correctamente.");
            } else {
                System.out.println("No se encontro un objeto con ese ID.");
            }

            ps.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("Error al actualizar objeto.");
            System.out.println("Mensaje: " + e.getMessage());
        }
    }
    //ELIMINAR
    public void eliminarObjeto(int id) {
        String sql = "DELETE FROM bag WHERE id_obj = ?";

        try {
            Connection con = Conexxxion.conectar();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            int filas = ps.executeUpdate();

            if (filas > 0) {
                System.out.println("Objeto eliminado correctamente.");
            } else {
                System.out.println("No se encontro un objeto con ese ID.");
            }

            ps.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("Error al eliminar objeto.");
            System.out.println("Mensaje: " + e.getMessage());
        }
    }
    }
