<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        <title>Hehizo / Agregar </title>
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
            <div id="mago2">
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

                                <div class= "col-5">
                                    <div>
                                        <div class="col-md-10 col-sm-10 col-lg-10">
                                            <h1>CREAR HECHIZO</h1>
                                            <form method="post" action="<%=request.getContextPath()%>/HechizoServlet?accion=guardar">
                                                <div class="mb-3">
                                                    <label for="Nombre" class="arial">Nombre</label>
                                                    <input type="text" class="form-control rounded" id="Nombre" placeholder="Nombre" name="Nombre">
                                                </div>
                                                <div class="mb-3">
                                                    <label for="Elemento" class="form-label">Elemento</label>
                                                    <input type="text" class="form-control rounded" id="Elemento" placeholder="Elemento" name="Elemento">
                                                </div>
                                                <div class="mb-3">
                                                    <label for="Potencia" class="form-label">Potencia</label>
                                                    <input type="text" class="form-control rounded" id="Potencia" placeholder="Potencia" name="Potencia">
                                                </div>
                                                <div class="mb-3">
                                                    <label for="Precisión" class="form-label">Precisión</label>
                                                    <input type="text" class="form-control rounded" id="Precisión" placeholder="Precisión" name="Precisión">
                                                </div>

                                                <div class="mb-3">
                                                    <label for="HechizoBase" class="form-label">HechizoBase</label>
                                                    <input type="text" class="form-control rounded" id="HechizoBase" placeholder="Hechizo Base" name="Hechizo_Base">
                                                </div>
                                                <div class="mb-3">
                                                    <label for="Niveldeaprendizaje" class="form-label">Nivel de Aprendizaje</label>
                                                    <input type="text" class="form-control rounded" id="Niveldeaprendizaje" placeholder="Nivel de Aprendizaje" name="NiveldeAprendizaje">
                                                </div>

                                                <button type="submit" class="btn btn-primary">Guardar</button>
                                                <a class="btn btn-danger" href="<%=request.getContextPath()%>/index?action=hechizos">Regresar</a>
                                            </form>
                                        </div>
                                    </div>
                                </div>

                                <div class="col-5 ">
                                    <div class="text-img">
                                        <figure><img src="images/maga.png" /></figure>
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
