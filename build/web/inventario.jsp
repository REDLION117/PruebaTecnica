<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inventario</title>
        <!-- bootstrap -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    </head>
    <body>
        <h3 class="text-center">Inventario</h3>
        <div class="d-flex justify-content-evenly align-items-start">
            <!-- AGREGAR Start -->
            <div class="card ms-3 me-1 mt-1" style="width: 300px; height: auto; display: block;">
                <div class="card-body">
                    <h5>Agregar un nuevo producto</h5>
                    <form action="Controlador?menu=inventario&rol=${rol}" method="POST" class="">
                        <div class="input-group mb-3">
                            <input type="text" name="txtNombre" class="form-control" placeholder="Nombre del producto" aria-label="Nombre del producto" aria-describedby="basic-addon2">
                            <!--<span class="input-group-text" id="basic-addon2">@example.com</span>-->
                            <input id="btnAdd" type="submit" name="accion" value="Agregar" class="btn btn-success btn-block">
                        </div>
                    </form>
                </div>
            </div>
            <!-- AGREGAR End -->

            <div class="card me-1 me-3 mt-1 p-3" style="width: 800px;">
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
                                    <a href="Controlador?menu=inventario&rol=${rol}&accion=alta&id=${p.idProducto}" id="alta" class="btn btn-success btn-block">Alta</a>
                                    <a href="Controlador?menu=inventario&rol=${rol}&accion=baja&id=${p.idProducto}" id="baja" class="btn btn-danger btn-block">Baja</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <!-- TABLE End -->
            </div>
        </div>
        <!-- Alert -->
        <script>
                const rolJS = ${rol};
                const btnAdd = document.getElementById("btnAdd");
                btnAdd.addEventListener('click', function() {
                    //alert('accion');
                    if(rolJS === 2){
                        alert('No tiene permiso para realizar esta acción');
                    }
                });
                const btsAlta = document.querySelectorAll("#alta");
                btsAlta.forEach((boton) => {
                    boton.addEventListener("click", function() {
                        if(rolJS === 2){
                            alert('No tiene permiso para realizar esta acción');
                        }
                        if(rolJS === 1){
                            alert('Alta');
                        }
                    });
                });
                const btsBaja = document.querySelectorAll("#baja");
                btsBaja.forEach((boton) => {
                    boton.addEventListener("click", function() {
                        if(rolJS === 2){
                            alert('No tiene permiso para realizar esta acción');
                        }
                        if(rolJS === 1){
                            alert('Baja');
                        }
                    });
                });

        </script>

        <!-- bootstrap scripts-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
    </body>
</html>
