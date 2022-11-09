<%--
  Created by IntelliJ IDEA.
  User: Labtel
  Date: 9/11/2022
  Time: 17:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.example.lab_08.model.Beans.Enemigos" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="enemigo" type="com.example.lab_08.model.Beans.Enemigos" scope="request"/>
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
    <title>enemigo / Editar </title>
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
                                        <li> <a href="<%=request.getContextPath()%>/index?action=catalogo">Catálogo de Objetos</a> </li>

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

                        <div class= "col-5">
                            <div>
                                <div class="col-md-10 col-sm-10 col-lg-10">
                                    <h1>EDITAR ENEMIGO</h1>
                                    <form method="post" action="<%=request.getContextPath()%>/EnemigoServlet?accion=actualizar">
                                        <input type="hidden" name="IdEnemigo" value="<%=enemigo.getIdEnemigos()%>">
                                        <div class="mb-3">
                                            <label for="Nombre" class="arial">Nombre</label>
                                            <input type="text" class="form-control rounded" id="Nombre" placeholder="Nombre" name="Nombre"
                                                   value="<%=enemigo.getNombre()%>">
                                        </div>

                                        <div class="mb-3">
                                            <label for="Ataque" class="form-label">Ataque</label>
                                            <input type="text" class="form-control rounded" id="Ataque" placeholder="Ataque" name="Ataque"
                                                   value="<%=enemigo.getAtaque()%>">
                                        </div>

                                        <div class="mb-3">
                                            <label for="Experiencia" class="form-label">Ataque</label>
                                            <input type="text" class="form-control rounded" id="Experiencia" placeholder="Experiencia" name="ExperienciaPorDerrota"
                                                   value="<%=enemigo.getExperienciaPorDerrota()%>">
                                        </div>
                                        <div class="mb-3">
                                            <label for="Prob" class="form-label">Ataque</label>
                                            <input type="text" class="form-control rounded" id="Prob" placeholder="Prob" name="ProbabilidaDeDejarObjetos"
                                                   value="<%=enemigo.getProbaDejarObjetos()%>">
                                        </div>

                                        <% String idClaseStr = null;
                                            switch (enemigo.getIdClase()){
                                                case 1: idClaseStr = "Dragon"; break;
                                                case 2: idClaseStr = "Fantasma"; break;
                                                case 3: idClaseStr = "Demonio"; break;
                                                case 4: idClaseStr = "Pez"; break;
                                                case 5: idClaseStr = "Humano"; break;
                                                case 6: idClaseStr = "Bestia"; break;
                                                case 7: idClaseStr = "Ave"; break;
                                                case 8: idClaseStr = "Otros"; break;
                                            }
                                        %>
                                        <div class="mb-3">
                                            <label for="Clase" class="form-label">Clase</label>
                                            <input type="text" class="form-control rounded" id="Clase" placeholder="Clase" name="Clase"
                                                   value="<%=idClaseStr%>">
                                        </div>
                                        <button type="submit" class="btn btn-primary">Actualizar</button>
                                        <a class="btn btn-danger" href="<%=request.getContextPath()%>/EnemigoServlet">Regresar</a>
                                    </form>
                                </div>
                            </div>
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

