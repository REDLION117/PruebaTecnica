package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public Empleado validar(String email, String pass) {
        Empleado em = new Empleado();
        String sql = "select * from usuarios where correo=? and contrasena=? ;";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                em.setIdUsuario(rs.getInt("idUsuario"));
                em.setNombre(rs.getString("nombre"));
                em.setCorreo(rs.getString("correo"));
                em.setContrasena(rs.getString("contrasena"));
                em.setIdRol(rs.getInt("idRol"));
                em.setEstatus(rs.getInt("estatus"));
            }
        } catch (SQLException e) {
            System.err.println("EmpleadoDao error: " + e);
        }
        return em;
    }

    public Empleado getEmpleadoByID(int id) {
        Empleado em = new Empleado();
        String sql = "select * from almacen.usuarios where idUsuario=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                em.setIdUsuario(id);
                em.setNombre(rs.getString(2));
                em.setCorreo(rs.getString(3));
                em.setContrasena(rs.getString(4));
                em.setIdRol(rs.getInt(6));
            }
        } catch (Exception e) {
            System.out.println("EmpleadoDAO getEmpleadoByID catch: " + e);
        }
        return em;
    }
}
