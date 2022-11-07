<%@ page import="com.example.lab_08.model.Beans.Hechizos" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%
    ArrayList<Hechizos> listaHechizos = (ArrayList<Hechizos>) request.getAttribute("listaHechizos");
%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <!-- basic -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <!-- mobile metas -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="viewport" content="initial-scale=1, maximum-scale=1">
        <!-- site metas -->
        <title>Hechizos</title>
        <meta name="keywords" content="">
        <meta name="description" content="">
        <meta name="author" content="">
        <!-- bootstrap css -->
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <!-- style css -->
        <link rel="stylesheet" href="css/style.css">
        <!-- Responsive-->
        <link rel="stylesheet" href="css/responsive.css">
        <!-- fevicon -->
        <link rel="icon" href="images/fevicon.png" type="image/gif" />
        <!-- Scrollbar Custom CSS -->
        <link rel="stylesheet" href="css/jquery.mCustomScrollbar.min.css">
        <!-- Tweaks for older IEs-->
        <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.css" media="screen">
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
    </head>
    <!-- body -->

    <body class="main-layout">
        <!-- loader  -->
        <div class="loader_bg">
            <div class="loader"><img src="images/loading.gif" alt="#" /></div>
        </div>
        <!-- end loader -->
        <!-- header -->
        <header>
            <!-- header inner -->
            <div id="mago">
                <div class="header">
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-xl-3 col-lg-3 col-md-3 col-sm-3 col logo_section">
                                <div class="full">
                                    <div class="center-desk">
                                        <div class="logo">
                                            <a href="index.html"><img style ="width: 80px" ; src="images/icono.png" alt="#" /></a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xl-9 col-lg-9 col-md-9 col-sm-9">
                                <div class="menu-area">
                                    <div class="limit-box">
                                        <nav class="main-menu">
                                            <ul class="menu-area-main">
                                                <li class="active"> <a href="<%=request.getContextPath()%>/index">Menú Principal</a> </li>
                                                <li> <a href="<%=request.getContextPath()%>/index?action=heroes">Héroes</a> </li>
                                                <li> <a href="<%=request.getContextPath()%>/index?action=enemigos">Enemigos</a> </li>
                                                <li> <a href="<%=request.getContextPath()%>/index?action=hechizos">Hechizos</a> </li>
                                                <li> <a href="<%=request.getContextPath()%>/index?action=catalogo">Catálogo de Obejtos</a> </li>

                                            </ul>
                                        </nav>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- end header inner -->

                <!-- end header -->
                <section class="slider_section">
                    <div class="banner_main">
                        <div class="row">
                            <div class="container col-xxl-7 col-xs-12 ">
                                <div class="container-fluid">
                                    <div class="container">
                                        <div class="row" >
                                            <div class="col-3">

                                                <a class="btn btn-danger" href="<%=request.getContextPath()%>/HechizoServlet?accion=agregarHechizo"
                                                   role="button">Añadir nuevo Hechizo</a>
                                            </div>

                                        </div>
                                    </div>
                                    <br>
                                    <table class="table table-striped table-hover">
                                        <thead>
                                        <tr style="align-content: center">
                                            <th>ID</th>
                                            <th>Nombre</th>
                                            <th>Elemento</th>
                                            <th>Potencia</th>
                                            <th>Precisión</th>
                                            <th>Hechizo Base</th>
                                            <th>Nivel de Aprendizaje</th>
                                            <th></th>


                                        </tr>
                                        </thead>

                                        <tbody>
                                        <%
                                            for (Hechizos hechizos : listaHechizos) { %>
                                        <tr>
                                            <td><%=hechizos.getIdHechizos()%>
                                            </td>
                                            <td><%=hechizos.getNombre()%>
                                            </td>
                                            <td><%=hechizos.getElemento()%>
                                            </td>
                                            <td><%=hechizos.getPotencia()%>
                                            </td>
                                            <td><%=hechizos.getPrecision()%>
                                            </td>
                                            <td><%=hechizos.getHechizoBase()%>
                                            </td>
                                            <td><%=hechizos.getNivelAprendizaje()%>
                                            </td>
                                            <td>
                                                <a
                                                        onclick="return confirm('¿Estas seguro(a) que deseas borrar?')"
                                                        class="btn btn-danger" href="<%=request.getContextPath()%>/HechizoServlet?accion=borrar&id=<%=hechizos.getIdHechizos()%>"
                                                        role="button">Eliminar
                                                </a>

                                            </td>


                                        </tr>
                                        <%
                                            }

                                        %>
                                        </tbody>

                                    </table>

                                </div>
                            </div>
                            <div class="col-xxl-5 col-xs-8">
                                <div class="text-img">
                                    <figure><img src="images/maga.png" /></figure>
                                </div>
                            </div>


                        </div>
                    </div>
                </section>

            </div>


        </header>
        <!-- about  -->

        <!-- end abouts -->

        <!-- our how_it -->


        <!-- end how_it -->

        <!-- end We are -->
        <!-- contact -->

        <!-- end contact -->
        <!-- clients -->


        <!-- end clients -->


        <!-- end footer -->
        <!-- Javascript files-->
        <script src="js/jquery.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.bundle.min.js"></script>
        <script src="js/jquery-3.0.0.min.js"></script>
        <script src="js/plugin.js"></script>
        <!-- sidebar -->
        <script src="js/jquery.mCustomScrollbar.concat.min.js"></script>
        <script src="js/custom.js"></script>
    </body>

</html>
