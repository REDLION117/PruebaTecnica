<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Almacen</title>
        <!-- bootstrap -->

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    </head>
    <body>
        <!-- Navbar Start -->
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container-fluid">
                <a class="navbar-brand" href="#"><b>ALMACENISTA</b></a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link text-white btn btn-secondary mx-2" aria-current="page" href="Controlador?menu=inventario&accion=listar&rol=2" target="myFrame">Inventario</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-white btn btn-secondary mx-2 disabled" href="Controlador?menu=entrada&rol=2" target="myFrame">Entrada Producto</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-white btn btn-secondary mx-2 " href="Controlador?menu=salida&rol=2&accion=listarEntrada" target="myFrame">Salida Producto</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-white btn btn-secondary mx-2 disabled" href="Controlador?menu=historico&rol=2" target="myFrame">Historico</a>
                        </li>
                        <!--<li class="nav-item">
                            <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
                        </li>-->
                    </ul>
                </div>
                <div class="d-block">
                    <h6>${logueado.getNombre()}</h6>
                    <form action="Validar" method="POST">
                        <button name="accion" value="Salir" class="btn btn-dark">Cerrar Sesión</button>
                    </form>
                </div>
            </div>
        </nav>
        <!-- Navbar End -->
        <!-- background: #343434; -->
        <div style="height: 550px; " class="m-3 border border-3">
            <iframe name="myFrame" style="height: 100%; width: 100%;"></iframe>
        </div>

        <h5>Puede:</h5>
        <p>Ver modulo inventario</p>
        <p>X Agregar nuevos productos</p>
        <p>X Aumentar inventario</p>
        <p>X Cambiar estatus producto</p>
        <p>ver modulo Salida de Productos</p>
        <p>Sacar inventario del almacen</p>
        <p>X Ver Historico</p>

        <!-- Scrips -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
    </body>
</html>

