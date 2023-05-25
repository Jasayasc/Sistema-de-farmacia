/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Modelo;

import java.sql.*;

public class Connector {
    private String userDatabase = "root";
    private String passwordDatabase = "12345";
    private String nameDatabase = "farmacia";
    
    private Connection connection = null;
    
    
    public Connector() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/" + nameDatabase,
                userDatabase, passwordDatabase);
            System.out.println("Conectado con exito a "+nameDatabase);
        }
        catch (Exception exception) {
            System.out.println(exception);
        }
    }

    public Connection getConnection() {
        return connection;
    } 
}
