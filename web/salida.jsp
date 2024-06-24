<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Salida</title>
        <!-- bootstrap -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    </head>
    <body>
        <h3 class="text-center">Salida de Producto (Restar)</h3>
        <!-- En tu archivo.jsp -->
        <%-- Muestra el mensaje de error --%>
        <h5 class="text-center text-danger">${requestScope.error}</h5>

        <div class="d-flex justify-content-evenly align-items-start">
            <div class="card me-1 me-3 mt-1 p-3" style="width: 900px;">
                <!-- TABLE Start -->
                <table class="table table-sm">
                    <thead>
                        <tr>
                            <th scope="col">idProducto</th>
                            <th scope="col">Nombre</th>
                            <th scope="col">Cantidad</th>
                            <th scope="col">Estatus</th>
                            <th scope="col"></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${productos}" var="p">
                            <tr>
                                <td>${p.idProducto}</td>
                                <td>${p.nombre}</td>
                                <td>${p.cantidad}</td>
                                <td>${p.estatus}</td>
                                <td>
                                    <form action="Controlador?menu=salida&rol=${rol}&accion=restar&idP=${p.idProducto}&oriC=${p.cantidad}" method="POST">
                                        <div class="d-inline-flex justify-content-evenly align-items-start">
                                            <input type="number" name="cantidad${p.idProducto}" step="1" class="form-control d-block" placeholder="Cantidad" style="width: 110px;">
                                            <input type="submit" name="accion" value="Restar" class="btn btn-info px-1 mx-1">
                                        </div>
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <!-- TABLE End -->
            </div>
        </div>
        <!-- bootstrap scripts-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
    </body>
</html>
