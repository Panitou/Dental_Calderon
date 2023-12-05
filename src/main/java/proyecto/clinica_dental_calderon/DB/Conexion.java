package proyecto.clinica_dental_calderon.DB;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;

public class Conexion {

    private static int connectionCount = 0;

    private static final String URL = "jdbc:mysql://database-calderon-clinica.cxoo1zsccafn.sa-east-1.rds.amazonaws.com:3306/Clinica_Calderon_DB";
    private static final String USER = "admin";
    private static final String PASSWORD = "Kmm-Nt?cSy4eX9Jj#ThJ";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo básico de la excepción
        }
        return connection;
    }

    public static synchronized void incrementConnectionCount() {
        connectionCount++;
        System.out.println("Número de conexiones activas: " + connectionCount);
    }

    public static synchronized void decrementConnectionCount() {
        connectionCount--;
        System.out.println("Número de conexiones activas: " + connectionCount);
    }
}
