<%@ page import="com.example.lab_08.model.Beans.Clase" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%
    ArrayList<Clase> listaClase = (ArrayList<Clase>) request.getAttribute("listaClase");
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
        <title>Clase / Enemigo</title>
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
            <div id="enemigo">
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

                                                <li> <a href="<%=request.getContextPath()%>/index?action=enemigos">Volver</a> </li>

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
                <section id="clase">
                    <div class="banner_main">

                        <div class="container">

                            <div class="row">
                                <div class="col-7  ">


                                    <section class="section profile" style="padding-top: 30px">
                                        <div class="container">
                                            <div class="container-fluid">
                                                <div class="row" "container" >


                                            </div>



                                            <br>
                                            <table class="table table-striped table-hover">
                                                <thead>
                                                    <tr style="align-content: center">

                                                        <th>ID de la Clase</th>
                                                        <th>Nombre de la Clase</th>
                                                        <th> </th>



                                                    </tr>
                                                </thead>

                                                <tbody>
                                                <%
                                                    for (Clase clase : listaClase) { %>
                                                <tr>
                                                    <td><%=clase.getIdClase()%>
                                                    </td>
                                                    <td><%=clase.getNombre()%>
                                                    </td>

                                                    <td>

                                                        <a

                                                            class="btn btn-danger" href="<%=request.getContextPath()%>/EnemigoServlet?accion=elements"
                                                            role="button">Debilidades y Fortalezas

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
                <div class="row" "text-img">
                <figure><img src="images/ave.png" /></figure>
            </div>

            <div class="row" "text-img">

            <figure><img src="images/demonio.png" /></figure>



            </div>
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
