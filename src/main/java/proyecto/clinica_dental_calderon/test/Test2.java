package proyecto.clinica_dental_calderon.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import proyecto.clinica_dental_calderon.DB.Conexion;

/**
 *
 * @author Panito GitHub https://github.com/Panitou
 */
public class Test2 {

    public static void main(String[] args) {
        // Obtener la conexión a la base de datos
        Connection c = Conexion.getConnection();
        PreparedStatement p;
        if (c != null) {
            System.out.println("Conexion establecida");
            // Consulta para insertar datos en la tabla login
            String sql = "INSERT INTO login(username, pass) VALUES (?, ?)";

            try {
                // Preparar la consulta con parámetros
                p = c.prepareStatement(sql);
                p.setString(1, "admin");// Establecer el valor del primer parámetro
                p.setString(2, "123");// Establecer el valor del segundo parámetro
                
                // Ejecutar la consulta y obtener el número de filas afectadas
                int ject = p.executeUpdate();
                
                if(ject > 0){
                    System.out.println("Datos insertados correctamente");
                }else{
                    System.out.println("No se pudo insertar los datos correctamente");
                }
                p.close();
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else {
            System.out.println("Conexion fallida");
        }

    }
}
