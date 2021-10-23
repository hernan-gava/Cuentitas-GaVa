<!doctype html>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html lang="es" data-ng-app="AltaEmpleado" data-ng-controller="controllerEmpleado">

   <head>
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
      <meta name="description" content="">
      <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
      <meta name="generator" content="Hugo 0.80.0">
      <title>Cuentitas-GaVa</title>

      <!-- Bootstrap core CSS -->
      <%@ include file="/WEB-INF/Contenido-WEB/Recursos-Web/bootstrap.jsp" %>
      <!-- Importamos las librerias de Java-Core y JSP-->
      <%@ include file="/WEB-INF/Contenido-WEB/Recursos-Web/include.jsp" %>
      <%@ include file="/WEB-INF/Contenido-WEB/Recursos-Web/angular.jsp"%>
      <!-- Favicons -->
      <%@ include file="/WEB-INF/Contenido-WEB/Recursos-Web/fontawesome.jsp" %>
      <%@ include file="/WEB-INF/Contenido-WEB/Recursos-Web/empleadoDataJs.jsp"%>
      <%@ include file="/WEB-INF/Contenido-WEB/Recursos-Web/notificaciones.jsp"%>
      <%@ include file="/WEB-INF/Contenido-WEB/Recursos-Web/dataTable.jsp"%>

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
      <!-- Dashboard -->
      <%@ include file="/WEB-INF/Contenido-WEB/Recursos-Web/dashboarStyle.jsp" %>
   </head>

   <body>

      <jsp:include page="../Recursos-Web/NavarLogout.jsp"></jsp:include>

         <div class="container-fluid">
            <div class="row">

            <jsp:include page="../Recursos-Web/MenuPricipalAdministrador.jsp"></jsp:include>

            <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
               <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                  <h1 class="h2">Empleados</h1>
                  <div class="btn-toolbar mb-2 mb-md-0">
                     <div class="btn-group mr-2">
                        <button id="btnAddEmpleado" type="button" class="btn btn-outline-primary" data-ng-click="openAgregarEmpleado()">Agregar Nuevo Empleado</button>
                     </div>
                     <div class="btn-group mr-2">
                        <button id="btnShowTable" data-ng-click="openListarEmpleados()" type="button" class="btn btn-outline-info">Lista de Empleados</button>
                     </div>
                     <button type="button" class="btn btn-sm btn-outline-secondary dropdown-toggle">
                        <span data-feather="calendar"></span>
                        This week
                     </button>
                  </div>
               </div>

               <!-- Formulario para llenar infomarcion a guardar -->
               <div id="formEmpleadoGuardar">
                  <div class="card-body">
                     <form id="empleadoForm">
                        <div class="form-group">
                           <input id="txtidEmpleado" hidden="true" type="text" class="form-control" placeholder="Id" data-ng-model="empleado.id_empleado" pattern="^[A-Z\u00C0-\u00DCa-z\u00E0-\u00FC0-9\s]{1,99}$">
                        </div>
                        <div class="form-group">
                           <label class="col-form-label">Nombre del Empleado: </label>
                           <input id="txtNombreEmpleado" type="text" class="form-control" placeholder="Nombre del Empleado" data-ng-model="empleado.nombre" required="true" pattern="^[A-Z\u00C0-\u00DCa-z\u00E0-\u00FC0-9\s]{1,99}$">
                        </div>

                        <div class="form-group">
                           <label class="col-form-label">Apellido Paterno: </label> 
                           <input id="txtAp" type="text" class="form-control" placeholder="Apellido Paterno" data-ng-model="empleado.apellidoPaterno" required="required" pattern="^[A-Z\u00C0-\u00DCa-z\u00E0-\u00FC0-9\s]{1,99}$">
                        </div>

                        <div class="form-group">
                           <label class="col-form-label">Apellido Materno: </label> 
                           <input id="txtAm" type="text" class="form-control" placeholder="Apellido Materno" data-ng-model="empleado.apellidoMaterno" required="required" pattern="^[A-Z\u00C0-\u00DCa-z\u00E0-\u00FC0-9\s]{1,99}$">
                        </div>

                        <div class="form-group">
                           <label class="col-form-label">Direccion: </label> 
                           <input id="txtDireccion" type="text" class="form-control" placeholder="Direccion" data-ng-model="empleado.direccion" required="required" pattern="^[A-Z\u00C0-\u00DCa-z\u00E0-\u00FC0-9\s]{1,99}$">
                        </div>
                  </div>

                  <button type="submit" class="btn btn-success" data-ng-click="guardarDatosEmpleado()">Guardar Datos</button>
                  <button type="submit" class="btn btn-success" data-ng-click="cerrarFormularioEmpleado()">Cerrar</button>
                  </form>
               </div>


               <!--Tabla para Mostar clientes-->
               <div id="tablePricipal">
                  <div class="card-body">
                     <div class="table-responsive">
                        <table id="tablaEmpleado" class="table table-hover" style="width: 100%;">
                           <thead valign="top" class="thead-dark">
                              <tr valign="top">
                                 <th align="center">Id Empleado</th>
                                 <th align="center">Nombre</th>
                                 <th align="center">Apellido Paterno</th>
                                 <th align="center">Apellido Materno</th>
                                 <th align="center">Dirección</th>
                                 <th align="center">Actualizar</th>
                                 <th align="center">Eliminar</th>
                              </tr>
                           </thead>
                        </table>
                     </div>
                  </div>
               </div>

               <!-- Modal para actualizar Datos cliente -->
               <div class="modal fade" id="myModalEmpleado" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
                  <div class="modal-dialog">
                     <div class="modal-content">
                        <div class="modal-header">
                           <h5 class="modal-title" id="modalLabel">Actualizar Datos del Empleado</h5>
                           <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                              <span aria-hidden="true">&times;</span></button>
                        </div>

                        <div class="modal-body">
                           <form id="empleadoForm2">
                              <div class="form-group">
                                 <input id="txtidEmpleado2" hidden="true" type="text" class="form-control" placeholder="Id" data-ng-model="empleado.id_empleado" pattern="^[A-Z\u00C0-\u00DCa-z\u00E0-\u00FC0-9\s]{1,99}$">
                              </div>
                              <div class="form-group">
                                 <label class="col-form-label">Nombre del Empleado: </label> <input id="txtNombreEmpleado2" type="text" class="form-control" placeholder="Nombre del Empleado" data-ng-model="empleado.nombre" required="true" pattern="^[A-Z\u00C0-\u00DCa-z\u00E0-\u00FC0-9\s]{1,99}$">
                              </div>

                              <div class="form-group">
                                 <label class="col-form-label">Apellido Paterno: </label> <input id="txtAp2" type="text" class="form-control" placeholder="Apellido Paterno" data-ng-model="empleado.apellidoPaterno" required="required" pattern="^[A-Z\u00C0-\u00DCa-z\u00E0-\u00FC0-9\s]{1,99}$">
                              </div>

                              <div class="form-group">
                                 <label class="col-form-label">Apellido Materno: </label> <input id="txtAm2" type="text" class="form-control" placeholder="Apellido Materno" data-ng-model="empleado.apellidoMaterno" required="required" pattern="^[A-Z\u00C0-\u00DCa-z\u00E0-\u00FC0-9\s]{1,99}$">
                              </div>

                              <div class="form-group">
                                 <label class="col-form-label">Direccion: </label> <input id="txtDireccion2" type="text" class="form-control" placeholder="Direccion" data-ng-model="empleado.direccion" required="required" pattern="^[A-Z\u00C0-\u00DCa-z\u00E0-\u00FC0-9\s]{1,99}$">
                              </div>
                           </form>
                        </div>

                        <div class="modal-footer">
                           <button type="submit" class="btn btn-primary" data-ng-click="actualizarDatosEmpleado()">Actualizar Datos</button>
                           <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                        </div>
                     </div>
                  </div>
               </div>
               <!-- Termina div del Modal -->

            </main>
         </div>
      </div>
   </body>

</html>