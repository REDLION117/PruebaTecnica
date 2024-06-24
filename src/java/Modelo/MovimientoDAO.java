package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MovimientoDAO {
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public List listarHistorico(String tipo){
        List<Movimiento> lista = new ArrayList<>();
        String sql = "select * from almacen.historico where tipo=?;";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, tipo);
            rs = ps.executeQuery();
            while (rs.next()) {
                Movimiento m = new Movimiento();
                m.setIdMovimiento(rs.getInt("idMovimiento"));
                m.setTipo(rs.getString("tipo"));
                m.setIdUsuario(rs.getInt("idUsuario"));
                m.setFechaHora(rs.getString("fechaHora"));
                m.setIdProducto(rs.getInt("idProducto"));
                m.setCantidad(rs.getInt("cantidad"));
                lista.add(m);
            }
        } catch (Exception e) {
            System.out.println("MovimientoDAO listarHistorico() catch: " + e);
        }
        return lista;
    }
    
}
