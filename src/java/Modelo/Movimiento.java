package Modelo;

public class Movimiento {
    int idMovimiento;
    String tipo;
    int idUsuario;
    String fechaHora;
    int idProducto;
    int cantidad;

    public Movimiento() {
    }

    public Movimiento(int idMovimiento, String tipo, int idUsuario, String fechaHora, int idProducto, int cantidad) {
        this.idMovimiento = idMovimiento;
        this.tipo = tipo;
        this.idUsuario = idUsuario;
        this.fechaHora = fechaHora;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
    }

    public int getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(int idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
    
}
