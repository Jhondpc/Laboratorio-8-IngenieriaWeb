<%@ page import="com.example.lab_08.model.Beans.Heroes" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%
    ArrayList<Heroes> listaHeroes = (ArrayList<Heroes>) request.getAttribute("listaHeroes");
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
        <title>Héroes</title>
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
            <div class="header-top">
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

                        <div class="container">

                            <div class="row">
                                <div class="col-10  ">


                                    <section class="section profile" style="padding-top: 30px">
                                        <div class="container">
                                            <div class="container-fluid">
                                                <div class="row" >
                                                    <div class="col-3">

                                                        <a class="btn btn-danger" href="<%=request.getContextPath()%>/HeroeServlet?accion=crear"
                                                           role="button">Añadir nuevo héroe</a>

                                                    </div>

                                                </div>
                                                <br>
                                                <div></div>
                                                <form class="d-flex input-group w-auto">
                                                    <input
                                                            type="search"
                                                            class="form-control rounded"
                                                            placeholder="Buscar héroe"
                                                            aria-label="Search"
                                                            aria-describedby="search-addon"
                                                    />

                                                </form>

                                                <br>
                                                <table class="table table-striped table-hover">
                                                    <thead>
                                                        <tr style="align-content: center">
                                                            <th>ID</th>
                                                            <th>Nombre</th>
                                                            <th>Edad</th>
                                                            <th>Genero</th>
                                                            <th>Clase</th>
                                                            <th>Nivel Inicial</th>
                                                            <th>Ataque</th>
                                                            <th>Pareja</th>
                                                            <th>Puntos Experiencia iniciales</th>

                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                    <%
                                                        for (Heroes heroes : listaHeroes) { %>
                                                    <tr>
                                                        <td><%=heroes.getIdHeroes()%>
                                                        </td>
                                                        <td><%=heroes.getNombre()%>
                                                        </td>
                                                        <td><%=heroes.getEdad()%>
                                                        </td>
                                                        <td><%=heroes.getGenero()%>
                                                        </td>
                                                        <td><%=heroes.getClase()%>
                                                        </td>
                                                        <td><%=heroes.getNivelInicial()%>
                                                        </td>
                                                        <td><%=heroes.getAtaque()%>
                                                        </td>
                                                        <td><%=""%>
                                                        </td>
                                                        <td><%=heroes.getPtosExperiencia()%>
                                                        </td>

                                                        <td>
                                                            <a type="button" class="btn btn-primary"
                                                               href="<%=request.getContextPath()%>/HeroeServlet?action=editar&id=<%=heroes.getIdHeroes()%>">
                                                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                                                     class="bi bi-pencil" viewBox="0 0 16 16">
                                                                    <path d="M12.146.146a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1 0 .708l-10 10a.5.5 0 0 1-.168.11l-5 2a.5.5 0 0 1-.65-.65l2-5a.5.5 0 0 1 .11-.168l10-10zM11.207 2.5 13.5 4.793 14.793 3.5 12.5 1.207 11.207 2.5zm1.586 3L10.5 3.207 4 9.707V10h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.293l6.5-6.5zm-9.761 5.175-.106.106-1.528 3.821 3.821-1.528.106-.106A.5.5 0 0 1 5 12.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.468-.325z"></path>
                                                                </svg>
                                                            </a>
                                                        </td>
                                                        <td>

                                                            <a
                                                                onclick="return confirm('¿Estas seguro(a) que deseas borrar?')"
                                                               class="btn btn-danger" href="<%=request.getContextPath()%>/HeroeServlet?action=borrar&id=<%=heroes.getIdHeroes()%>"
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


                                    </section>


                                </div>
                                <div class="col-5 ">
                                    <div class="text-img">
                                        <figure><img src="images/papu.png" /></figure>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>


            </div>


        </header>
        <!-- about  -->
        <div id="about" class="about">

        </div>
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
