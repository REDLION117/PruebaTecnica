package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    Connection con;
    String url = "jdbc:mysql://localhost:3306/almacen";
    String user = "root";
    String pass = "";
    
    public Connection Conexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url,user,pass);
            System.out.println("conexion bien");
        }catch (ClassNotFoundException | SQLException e) {
            System.out.println("Conexion mal: "+e);
        }
        return con;
    }
}
