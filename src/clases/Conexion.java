package clases;
import java.sql.*;

public class Conexion {
    //Conexión Local
    public static Connection conectar(){
        try {
            String url = "jdbc:mysql://localhost:3306/bd_juguetes";
            String usuario = "root";
            String pass = "";

            //Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/bd_juguetes", "root", "");
            Connection cn = DriverManager.getConnection(url, usuario, pass);
            return cn;
        } catch (SQLException e) {
            System.out.println("Error en conexión local " + e);
        }
        return (null);
    }
}
