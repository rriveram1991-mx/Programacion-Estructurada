package org.example;

import gim.Conexion.Conexion;
import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Connection prueba = Conexion.getConnection();

        if (prueba != null) {
            System.out.println("¡Todo quedó perfecto, Adrian!");
        } else {
            System.out.println("No se pudo conectar. Revisa tu contraseña en Conexion.java");
        }
    }
}