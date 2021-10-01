<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
        <meta name="generator" content="Hugo 0.80.0">
        <title>Dashboard Template · Bootstrap v4.6</title>

        <!-- Bootstrap core CSS -->
        <%@ include file="/WEB-INF/Contenido-WEB/Recursos-Web/bootstrap.jsp"%>	
        <!-- Importamos las librerias de Java-Core y JSP-->
        <%@ include file="/WEB-INF/Contenido-WEB/Recursos-Web/include.jsp"%>           
        <!-- Favicons -->
        <%@ include file="/WEB-INF/Contenido-WEB/Recursos-Web/fontawesome.jsp"%>

        <style>
            .bd-placeholder-img {
                font-size: 1.125rem;
                text-anchor: middle;
                -webkit-user-select: none;
                -moz-user-select: none;
                -ms-user-select: none;
                user-select: none;
            }

            @media (min-width: 768px) {
                .bd-placeholder-img-lg {
                    font-size: 3.5rem;
                }
            }
        </style>

        <!-- Custom styles for this template -->
        <!-- Dashboard -->
        <%@ include file="/WEB-INF/Contenido-WEB/Recursos-Web/dashboarStyle.jsp"%>    
    </head>
    <body>

        <jsp:include page="../Recursos-Web/NavarLogout.jsp"></jsp:include>

            <div class="container-fluid">
                <div class="row">

                <jsp:include page="../Recursos-Web/MenuPricipalAdministrador.jsp"></jsp:include>

                <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
                    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                        <h1 class="h2">Dashboard</h1>
                        <div class="btn-toolbar mb-2 mb-md-0">
                            <div class="btn-group mr-2">
                                <button type="button" class="btn btn-sm btn-outline-secondary">Share</button>
                                <button type="button" class="btn btn-sm btn-outline-secondary">Export</button>
                            </div>
                            <button type="button" class="btn btn-sm btn-outline-secondary dropdown-toggle">
                                <span data-feather="calendar"></span>
                                This week
                            </button>
                        </div>
                    </div>



                    <h2>Section title</h2>
                    <div>
                        Aqui hiba una tabla con datos
                    </div>
                </main>
            </div>
        </div>


    </body>
</html>
