package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;

public class Model {

    Connection connect = null;

    public Connection Conectar() {
        String url = "jdbc:sqlite:./farmacia.db";
        try {
            Class.forName("org.sqlite.JDBC");
            connect = DriverManager.getConnection(url);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage() + " No se pudo conectar a la bd");
        }
        return connect;
    }

    public void desconectar() {
        try {
            connect.close();
        } catch (SQLException ex) {
            System.out.println("No se pudo desconectar de la bd " + ex.getMessage());
        }
    }
}
