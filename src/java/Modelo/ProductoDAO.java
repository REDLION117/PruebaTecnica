package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;

    //Operaciones CRUD
    /**
     * La lista solo contiene productos activos estatus=1
     * @param cuales Escribe "todos" para obtener una lista con todos los productos de otro modo 
     * @return lista: una lista de tipo Producto
     */
    public List listarProductos(String cuales) {
        String sql = "select * from almacen.productos where estatus=1;";
        if(cuales.equals("todos")){
            System.out.println("TODOS");
            sql = "select * from almacen.productos;";
        }
        List<Producto> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Producto p = new Producto();
                p.setIdProducto(rs.getInt("idProducto"));
                p.setNombre(rs.getString("nombre"));
                p.setCantidad(rs.getInt("cantidad"));
                p.setEstatus(rs.getInt("estatus"));
                lista.add(p);
            }
        } catch (Exception e) {
            System.out.println("ProductoDAO listar() catch: " + e);
        }
        return lista;

    }
    
    public int agregar(String newNombre) {
        String sql = "insert into almacen.productos (nombre,cantidad,estatus) values (?,?,?);";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, newNombre);
            ps.setInt(2, 0);
            ps.setInt(3, 1);
            ps.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("ProductoDAO agregar() catch: " + e);
        }
        return r;

    }

    public int actualizarCantidad(int idP, int cantidad, String tipo, int idU, String fecha) {
        String sql = "update almacen.productos set cantidad=? where idProducto=?;";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cantidad);
            ps.setInt(2, idP);
            ps.executeUpdate();
            registrarHistorico(tipo,idU,fecha,idP,cantidad);
            
        } catch (Exception e) {
            System.out.println("ProductoDAO actualizarCantidad() catch: " + e);
        }
        return r;
    }
    
    public int actualizarEstado(int id, int estatus) {
        String sql = "update almacen.productos set estatus=? where idProducto=?;";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, estatus);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("ProductoDAO actualizarEstado() catch: " + e);
        }
        return r;
    }
    

    private void registrarHistorico(String tipo, int idU, String fecha, int idP, int cantidad) {
        String sql = "insert into almacen.historico (tipo,idUsuario,fechaHora,idProducto,cantidad) values (?,?,?,?,?);";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1,tipo);
            ps.setInt(2,idU);
            ps.setString(3, fecha.toString());
            ps.setInt(4, idP);
            ps.setInt(5, cantidad);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("ProductoDAO registrarHistorico() catch: " + e);
        }
        
    }

}
