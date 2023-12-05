package proyecto.clinica_dental_calderon.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import proyecto.clinica_dental_calderon.DB.Conexion;

/**
 *
 * @author Panito GitHub https://github.com/Panitou
 */
public class Test1 {

    public static void main(String[] args) {
        Conexion c = new Conexion();
        try {
            Connection cn = c.getConnection();
            PreparedStatement ps = null;
            ResultSet rs = null;
            if (cn != null) {
                System.out.println("Conexión establecida");
                c.incrementConnectionCount();
                c.decrementConnectionCount();
                cn.close();
                // Aquí realizas tus operaciones con la base de datos (ps, rs, etc.)
            } else {
                System.out.println("Conexión fallida");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
