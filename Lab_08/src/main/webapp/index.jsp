<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
        <title>La última fantasía</title>
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
                                            <a href="index.html"><img style ="width: 80px"; src="images/icono.png" alt="#" /></a>
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
                                <div class="col-xl-6 col-lg-6 col-md-6 col-sm-12 ">
                                    <div class="text-bg">
                                        <h1>Bienvenido a  <br> <strong class="b_bold">la última fantasía </strong></h1>
                                        <span>Desde hace mucho tiempo el mundo se ha mantenido en paz y
									prosperidad gracias al poder de los cristales elementales. Sin embargo, Forond, el rey de la
									oscuridad se ha propuesto destruir estos cristales para ser el amo de la magia. Mold y su
									grupo de jóvenes aventureros parten en una travesía para poder proteger los cristales y
									vencer a Forond en su malvado plan.
									</span>

                                    </div>
                                </div>
                                <div class="col-xl-6 col-lg-6 col-md-6 col-sm-12">
                                    <div class="text-img">
                                        <figure><img src="images/papu.png" /></figure>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
            </div>
            </section>
            </div>
            </div>
        </header>
        <!-- about  -->
        <div id="about" class="about">
            <div class="container">
                <div class="row">

                    <div class="col-xl-10 col-lg-10 col-md-12 col-sm-12">
                        <div class="about-box">

                            <span>Sobre el juego</span>
                            <p>
                                La última fantasía es un juego de aventura en el que un grupo de jovenes
                                aventureros buscarán derrotar al malvado Forod, el rey de la oscuridad
                                que se propuesto ser el amo de la magir. Para alcanzar su obetivo quiere destruir los
                                cristales elementales que por mucho tiempo han mantenido en paz al mundo.

                                Los jovenes héroes, liderados por Mold y su hermanda Erde, partirán en una travesía derrotando
                                a los enemigos de diferentes clases que se les presenten en su camino haciendo uso de numerosos hechizos y objetos que iran
                                desbloquenando a medida que suban de nivel. Cada enemigo que los héroes derroten les sumará puntos de experiencia
                                para mejorar la presición y potencia de sus hechizos.

                            </p>
                            <a href="heroes.html">Conoce más</a>

                        </div>
                    </div>
                </div>

            </div>
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