package Controlador;

import Modelo.Empleado;
import Modelo.EmpleadoDAO;
import Modelo.Movimiento;
import Modelo.MovimientoDAO;
import Modelo.Producto;
import Modelo.ProductoDAO;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controlador extends HttpServlet {

    Empleado em = new Empleado();
    EmpleadoDAO edao = new EmpleadoDAO();
    Producto p = new Producto();
    ProductoDAO pdao = new ProductoDAO();
    Movimiento m = new Movimiento();
    MovimientoDAO mdao = new MovimientoDAO();
    int idUser = 0;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String login = request.getParameter("login");
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        String rol = request.getParameter("rol");
        String u = request.getParameter("idUser");

        if (u != null) {
            idUser = Integer.parseInt(u);
        }

        System.out.println("------------------------------------------------------------");
        System.out.println("accion=" + accion);
        System.out.println("rol=" + rol);
        System.out.println("menu=" + menu);
        System.out.println("idUser=" + idUser);


        /* LOGIN */
        if (login != null) {
            System.out.println("login=" + login);
            switch (login) {
                case "administrador":
                    request.getRequestDispatcher("administrador.jsp").forward(request, response);
                    break;
                case "almacenista":
                    request.getRequestDispatcher("almacenista.jsp").forward(request, response);
                    break;
                default:
                    System.out.println("no se puede redirigir a: " + accion);
                    throw new AssertionError();
            }
        }

        /*ACCIONES*/
        if (accion != null) {
            //LISTAR PRODUCTOS
            if (accion.equalsIgnoreCase("listar")) {
                request.setAttribute("rol", rol);
                if (rol.equals("1")) {
                    //administraodor
                    List<Producto> lista = pdao.listarProductos("todos");
                    request.setAttribute("productos", lista);
                }
                if (rol.equals("2")) {
                    //almacenista
                    List<Producto> lista = pdao.listarProductos("activos");
                    request.setAttribute("productos", lista);
                }

            }
            //LISTAR ENTRADA/SALIDA
            if (accion.equalsIgnoreCase("listarEntrada")) {
                if (request.getParameter("error") != null) {
                    request.setAttribute("error", "Error, revise la cantidad");
                }
                request.setAttribute("rol", rol);
                List<Producto> lista = pdao.listarProductos("activos");
                request.setAttribute("productos", lista);
            }
            //LISTAR HISTORICO
            if(accion.equals("listarHE")){
                request.setAttribute("rol", rol);
                List<Movimiento> lista = mdao.listarHistorico("Entrada");
                request.setAttribute("movimientos", lista);
            }
            if(accion.equals("listarHS")){
                request.setAttribute("rol", rol);
                List<Movimiento> lista = mdao.listarHistorico("Salida");
                request.setAttribute("movimientos", lista);
            }
            //Agregar nuevo producto
            if (accion.equalsIgnoreCase("Agregar")) {
                //request.setAttribute("rol", rol);
                if (rol.equals("1")) {
                    String nombre = request.getParameter("txtNombre");
                    pdao.agregar(nombre);
                    request.getRequestDispatcher("Controlador?menu=inventario&rol=1&accion=listar").forward(request, response);
                }
                if (rol.equals("2")) {
                    request.getRequestDispatcher("Controlador?menu=inventario&rol=2&accion=listar").forward(request, response);
                }

            }
            if (accion.equals("alta")) {
                if (rol.equals("1")) {
                    int id = Integer.parseInt(request.getParameter("id"));
                    System.out.println("-------idTabla: " + id);
                    pdao.actualizarEstado(id, 1);
                    request.getRequestDispatcher("Controlador?menu=inventario&rol=1&accion=listar").forward(request, response);
                }
                if (rol.equals("2")) {
                    request.getRequestDispatcher("Controlador?menu=inventario&rol=2&accion=listar").forward(request, response);
                }

            }
            if (accion.equals("baja")) {
                if (rol.equals("1")) {
                    int id = Integer.parseInt(request.getParameter("id"));
                    System.out.println("-------idTabla: " + id);
                    pdao.actualizarEstado(id, 0);
                    request.getRequestDispatcher("Controlador?menu=inventario&rol=1&accion=listar").forward(request, response);
                }
                if (rol.equals("2")) {
                    request.getRequestDispatcher("Controlador?menu=inventario&rol=2&accion=listar").forward(request, response);
                }
            }
            if (accion.equalsIgnoreCase("sumar")) {
                int idP = Integer.parseInt(request.getParameter("idP"));
                String inpu = request.getParameter("cantidad" + idP);
                if (!inpu.equals("")) {
                    int can = Integer.parseInt(request.getParameter("cantidad" + idP));
                    String tipo = "Entrada";
                    int oriC = Integer.parseInt(request.getParameter("oriC"));
                    Calendar c = Calendar.getInstance();
                    int y = c.get(Calendar.YEAR);
                    int m = c.get(Calendar.MONTH) + 1;
                    int d = c.get(Calendar.DAY_OF_MONTH);
                    LocalTime t = LocalTime.now();
                    String fecha = d + "/" + m + "/" + y + " - " + t;

                    if (can > 0) {
                        //System.out.println("actualizarCantidad(idP:"+idP+",can: "+can+",tipo,idUser,fecha)");
                        can = oriC + can;
                        pdao.actualizarCantidad(idP, can, tipo, idUser, fecha);
                        request.getRequestDispatcher("Controlador?menu=entrada&rol=1&accion=listarEntrada").forward(request, response);
                    } else {
                        //error la cantidad debe ser mayor
                        request.getRequestDispatcher("Controlador?menu=entrada&rol=1&accion=listarEntrada&error=1").forward(request, response);
                    }
                }else{
                    request.getRequestDispatcher("Controlador?menu=entrada&rol=1&accion=listarEntrada").forward(request, response);
                }

            }
            //RESTAR
            if (accion.equalsIgnoreCase("restar")) {
                int idP = Integer.parseInt(request.getParameter("idP"));
                String inpu = request.getParameter("cantidad" + idP);
                if (!inpu.equals("")) {
                    int can = Integer.parseInt(request.getParameter("cantidad" + idP));
                    String tipo = "Salida";
                    int oriC = Integer.parseInt(request.getParameter("oriC"));
                    Calendar c = Calendar.getInstance();
                    int y = c.get(Calendar.YEAR);
                    int m = c.get(Calendar.MONTH) + 1;
                    int d = c.get(Calendar.DAY_OF_MONTH);
                    LocalTime t = LocalTime.now();
                    String fecha = d + "/" + m + "/" + y + " - " + t;

                    if (can > 0 && can <= oriC) {
                        //System.out.println("actualizarCantidad(idP:"+idP+",can: "+can+",tipo,idUser,fecha)");
                        can = oriC - can;
                        pdao.actualizarCantidad(idP, can, tipo, idUser, fecha);
                        request.getRequestDispatcher("Controlador?menu=salida&rol=2&accion=listarEntrada").forward(request, response);
                    } else {
                        //error la cantidad debe ser mayor
                        request.getRequestDispatcher("Controlador?menu=salida&rol=2&accion=listarEntrada&error=1").forward(request, response);
                    }
                }else{
                    request.getRequestDispatcher("Controlador?menu=salida&rol=2&accion=listarEntrada").forward(request, response);
                }

            }
        }

        /*MENU*/
        if (menu != null) {
            switch (menu) {
                case "entrada":
                    //request.setAttribute("rol", rol);
                    request.getRequestDispatcher("entrada.jsp").forward(request, response);
                    break;
                case "inventario":
                    request.setAttribute("rol", rol);
                    System.out.println("request.setAtribute(''rol'', " + rol + ")");
                    request.getRequestDispatcher("inventario.jsp").forward(request, response);
                    break;
                case "salida":
                    request.getRequestDispatcher("salida.jsp").forward(request, response);
                    break;
                case "historico":
                    request.getRequestDispatcher("historico.jsp").forward(request, response);
                    break;
                default:
                    System.out.println("no se puede redirigir a: " + accion);
                    throw new AssertionError();
            }
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
