<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Historico</title>
        <!-- bootstrap -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    </head>
    <body>
        <h3 class="text-center">Historico</h3>
        <div class="d-flex justify-content-evenly align-items-center">
            <div class="card me-1 me-3 mt-1 p-3" style="width: 900px;">
                <div class="d-inline-flex justify-content-center align-items-start">
                    <h5 class="pt-2 mb-0 me-3">Filtrar por tipo:</h5>
                    <a href="Controlador?menu=historico&rol=1&accion=listarHE" class="btn btn-lg btn-info text-white rounded rounded-pill rounded-end">Entradas</a>
                    <a href="Controlador?menu=historico&rol=1&accion=listarHS" class="btn btn-lg btn-info text-white rounded rounded-pill rounded-start">Salidas</a>
                </div>
                <!-- TABLE Start -->
                <table class="table table-sm">
                    <thead>
                        <tr>
                            <th scope="col">idMovimiento</th>
                            <th scope="col">Tipo</th>
                            <th scope="col">idUsuario</th>
                            <th scope="col">Fecha Hora</th>
                            <th scope="col">idProducto</th>
                            <th scope="col">Cantidad</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${movimientos}" var="m">
                            <tr>
                                <td>${m.idMovimiento}</td>
                                <td>${m.tipo}</td>
                                <td>${m.idUsuario}</td>
                                <td>${m.fechaHora}</td>
                                <td>${m.idProducto}</td>
                                <td>${m.cantidad}</td>
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
