var app = angular.module('AltaEmpleado', ['ngResource']);
app.controller('controllerEmpleado', ["$scope", "$http", "EmpleadoService", function ($scope, $http, EmpleadoService) {

      EmpleadoService.ocultarElementosInicialmente();
      //Inicio cargando los registros
      cargarTableEmpleado();

      $scope.openAgregarEmpleado = function () {
         $("#formEmpleadoGuardar").show();
         $("#empleadoForm")[0].reset();
         $("#tablePricipal").hide();
         document.getElementById("btnShowTable").disabled = false;
         document.getElementById("btnAddEmpleado").disabled = true;
      };

      $scope.cerrarFormularioEmpleado = function () {
         $("#formEmpleadoGuardar").hide();
         $("#empleadoForm")[0].reset();
         document.getElementById("btnAddEmpleado").disabled = false;
      };

      $scope.openListarEmpleados = function () {
         $("#tablePricipal").show();
         $("#formEmpleadoGuardar").hide();
         document.getElementById("btnShowTable").disabled = true;
         document.getElementById("btnAddEmpleado").disabled = false;
      };

      var almacenaDatosComunidad = $scope.empleado = {};
      $scope.guardarDatosEmpleado = function () {

         var nombreEmpleado = document.getElementById("txtNombreEmpleado").value;
         var apellidoPEmpleado = document.getElementById("txtAp").value;
         var apellidoMEmpleado = document.getElementById("txtAm").value;
         var direccionEmpleado = document.getElementById("txtDireccion").value;

         var validar = EmpleadoService.validarDatosEmpleado(nombreEmpleado, apellidoPEmpleado, apellidoMEmpleado, direccionEmpleado);
         if (validar == 1) {
            $http({
               method: 'post',
               url: 'insertarEmpleado',
               data: almacenaDatosComunidad
            }).then(function onSuccess(response) {
               alertify.notify("Se Registro Correctamente", "success", 5, null);
               $('#tablaEmpleado').DataTable().ajax.reload();
               $("#empleadoForm")[0].reset();
            }).catch(function onError(response) {
               alertify.notify('Se genero error interno intente mas tarde', 'error', 5, null);
               //window.location.href = "/index";
            });
         } else {
            alertify.notify('Porfavor Asegurate llenar los campos correctamente', 'error', 7, null);
         }
      }

      $scope.actualizarDatosEmpleado = function () {
         let confirm = alertify.confirm('Actualizar Datos del Empleado', 'Desea Actualizar el registro ?', null, null).set('labels', {
            ok: 'Si',
            cancel: 'Cancelar'
         });
         confirm.set({
            transition: 'slide'
         });

         confirm.set('onok', function () {
            var idEmpleado = $("#txtidEmpleado2").val();
            var nombre = $("#txtNombreEmpleado2").val();
            var apellidoP = $("#txtAp2").val();
            var apellidoM = $("#txtAm2").val();
            var direccion = $("#txtDireccion2").val();
            var validar = EmpleadoService.validarDatosEmpleado(nombre, apellidoP, apellidoM, direccion);
            if (validar == 1) {
               $http({
                  method: 'put',
                  //headers: EmpleadoService.createAuthorizationTokenHeader(),
                  url: 'actualizarEmpleado',
                  data: {
                     idEmpleado: idEmpleado,
                     nombre: nombre,
                     apellidoPaterno: apellidoP,
                     apellidoMaterno: apellidoM,
                     direccion: direccion,
                  }
               }).then(function onSuccess(response) {
                  $('#tablaEmpleado').DataTable().ajax.reload();
                  alertify.notify("Se Actualizo Correctamente su Registro", "success", 5, null);
                  $('#myModalEmpleado').modal('toggle');
               }).catch(function onError(response) {
                  if (response == false) {
                     alertify.notify('Se genero error interno intente mas tarde', 'error', 5, null);
                  }
                  if (response.status == 401) {
                     alertify.notify('Su Sesion Expiro Inicie Sesion Nuevamente', 'error', 8, null);
                     //window.location.href = "/index";
                  }
               });
            } else {
               alertify.notify('Porfavor Asegurate llenar los campos correctamente, Vuelva Seleccionar una Comunidad Nuevamente', 'error', 7, null);
            }
         });
         confirm.set('oncancel', function () { //llama al pulsar botón negativo
            alertify.error('Cancelo Actualizar su registro', 3);
         });
      }


      function cargarTableEmpleado() {
         var datatable = $('#tablaEmpleado').DataTable({
            "ajax": {
               "url": 'listarEmpleado',
               "type": 'GET',
               "dataSrc": "",
               "dataType": "json",
               //"headers": { "Authorization": "Bearer " + storage },
               "error": function (jqXHR) {
                  alertify.notify("Error en la vista de la Tabla" + jqXHR.statusText + " " + jqXHR.responseText, 'error', 10, null);
                  //window.location.href = "/index";
               }
            },
            "columns": [
               {"data": "idEmpleado"},
               {"data": "nombre"},
               {"data": "apellidoPaterno"},
               {"data": "apellidoMaterno"},
               {"data": "direccion"}
            ],
            "columnDefs": [{
                  "targets": 5,
                  "bSortable": false,
                  "render": function () {
                     return '<button type="button" id="editar" class="editar edit-modal btn btn-outline-primary botonEditar"><span class="fa fa-pen"></span><span class="hidden-xs"></span></button>';
                  }
               }, {
                  "targets": 6,
                  "data": null,
                  "bSortable": false,
                  "mRender": function (o) {
                     return '<a class="btn btn-outline-danger" onclick="dialogEliminar(' + o.idEmpleado + ')" type="button"><span class="fas fa-trash-alt"></span><span class="hidden-xs"></span></a>';
                  }
               }],
         });

         var editar = function (tbody, table) {
            $(tbody).on("click", "button.editar", function () {
               if (table.row(this).child.isShown()) {
                  var data = table.row(this).data();
               } else {
                  var data = table.row($(this).parents("tr")).data();
               }
               $('#myModalEmpleado').modal('show');

               $("#txtidEmpleado2").val(data.idEmpleado);
               $("#txtNombreEmpleado2").val(data.nombre);
               $("#txtAp2").val(data.apellidoPaterno);
               $("#txtAm2").val(data.apellidoMaterno);
               $("#txtDireccion2").val(data.direccion);

            });
         }
         editar("#tablaEmpleado tbody", datatable);
      }



   }]);

function dialogEliminar(idEmpleado) {
   let confirm = alertify.confirm('Eliminar Producto', 'Desea eliminar el registro ?', null, null).set('labels', {
      ok: 'Si',
      cancel: 'Cancelar'
   });
   confirm.set({
      transition: 'slide'
   });

   confirm.set('onok', function () {
      eliminarEmpleado(idEmpleado);
   });

   confirm.set('oncancel', function () { //llama al pulsar botón negativo
      alertify.error('Cancelo eliminar su registro', 3);
   });
}

function eliminarEmpleado(idEmpleado) {
   console.log(idEmpleado);
   var id_p = idEmpleado;
   let json = {};
   json.idEmpleado = id_p;
   $.ajax({
      type: 'DELETE',
      contentType: 'application/json',
      dataType: 'json',
      url: 'eliminarEmpleado',
      data: JSON.stringify(json),
      //headers: { "Authorization": "Bearer " + storage },
      success: function (data) {
         alertify.notify("Se elimino correctamente", 'success', 10, null);
         $('#tablaEmpleado').DataTable().ajax.reload();
      },
      error: function (response) {
         if (response.status == 401) {
            alertify.notify("Error Expiro su Sesion Vuelva De Entrar", 'error', 10, null);
            // window.location.href = "/index";
         }
      },
   });
}