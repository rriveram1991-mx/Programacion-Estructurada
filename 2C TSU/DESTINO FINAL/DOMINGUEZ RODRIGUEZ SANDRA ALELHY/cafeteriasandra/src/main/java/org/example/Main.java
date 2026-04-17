package org.example;

import java.sql.Connection;
import org.example.Producto;

public class Main {
    public static void main(String[] args) {
        // Abrir conexión
        Connection conn = Conexion.conectar();
        ProductoDAO dao = new ProductoDAO(conn);

        // Insertar producto nuevo
        Producto nuevo = new Producto("Capuchino", "Bebida", 45.00, 20);
        dao.insertarProducto(nuevo);

        // Leer productos
        System.out.println("--- Lista de Productos ---");
        dao.listarProductos();

        // Actualizar producto existente
        System.out.println("--- Actualizando Producto ---");
        Producto editado = new Producto("Cafe Americano", "Bebida", 30.00, 50);
        editado.setIdproductos(1);
        dao.actualizarProducto(editado);

        //Eliminar el producto
        System.out.println("--- Eliminando Producto ---");
        dao.eliminarProducto(1);

        //Leer otra vez, para listar
        System.out.println("--- Lista de Productos Despues de Eliminar ---");
        dao.listarProductos();

        // Cerrar conexión
        try {
            conn.close();
            System.out.println("Conexión cerrada correctamente.");
        } catch (Exception e) {
            System.out.println("Error al cerrar conexión: " + e.getMessage());
        }
    }
}

