
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html lang="en">

    <head>
        <!-- basic -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <!-- mobile metas -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="viewport" content="initial-scale=1, maximum-scale=1">
        <!-- site metas -->
        <title>Enemigo / Agregar </title>
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
                                            <h1>CREAR ENEMIGO</h1>
                                            <form method="post" action="<%=request.getContextPath()%>/EnemigoServlet?action=guardar">

                                                <div class="mb-3">
                                                    <label for="Nombre" class="arial">Nombre</label>
                                                    <input type="text" class="form-control rounded" id="Nombre" placeholder="Nombre" name="Nombre">
                                                </div>
                                                <div class="mb-3">
                                                    <label for="Clase" class="form-label">Clase</label>
                                                    <input type="text" class="form-control rounded" id="Clase" placeholder="Clase" name="Clase">
                                                </div>
                                                <div class="mb-3">
                                                    <label for="Ataque" class="form-label">Ataque</label>
                                                    <input type="text" class="form-control rounded" id="Ataque" placeholder="Ataque" name="Ataque">
                                                </div>
                                                <div class="mb-3">
                                                    <label for="ExperienciaporDerrota" class="form-label">Experiencia por Derrota</label>
                                                    <input type="text" class="form-control rounded" id="ExperienciaporDerrota" placeholder="Experiencia por Derrota" name="ExperienciaporDerrota">
                                                </div>
                                                <div class="mb-3">
                                                    <label for="Obejtodejado" class="form-label">Obejto dejado</label>
                                                    <input type="text" class="form-control rounded" id="Obejtodejado" placeholder="Obejto dejado" name="Obejtodejado">
                                                </div>
                                                <div class="mb-3">
                                                    <label for="ProbabildiaddedejarObjetos" class="form-label">Probabildiad de dejar Objetos</label>
                                                    <input type="text" class="form-control rounded" id="ProbabildiaddedejarObjetos" placeholder="Probabildiad de dejar Objetos" name="ProbabildiaddedejarObjetos">
                                                </div>
                                                <button type="submit" class="btn btn-primary">Guardar</button>
                                                <a href="<%=request.getContextPath()%>/EnemigoServlet" class="btn btn-danger">Regresar</a>
                                            </form>
                                        </div>
                                    </div>
                                </div>

                                <div class="col-5 ">
                                    <div class="text-img">
                                        <figure><img src="images/enemig.png" /></figure>
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