app.service("EmpleadoService", function () {

   this.ocultarElementosInicialmente = function () {
      //son componentes de la web ocultos inicialmente
      $("#formEmpleadoGuardar").hide();
      $("#tablePricipal").hide();
   }

   this.validarDatosEmpleado = function (nombre, apellidoPEmpleado, apellidoMEmpleado, direccion) {
      //variable binary de inicio
      var valido = 16;

      if (nombre.length > 0) {
         let validaNombre = /^[A-Z\u00C0-\u00DCa-z\u00E0-\u00FC0-9\s]{1,99}$/
         let esValido = validaNombre.exec(nombre);

         if (esValido == null || nombre.length == 0 || /^\s+$/.test(nombre)) {
            alertify.notify('Nombre del Empleado es incorrecto', 'error', 3, null);
         } else {
            valido >>= 1;
         }
      }

      if (apellidoPEmpleado.length > 0) {
         let validaApellidoP = /^[A-Z\u00C0-\u00DCa-z\u00E0-\u00FC0-9\s]{1,99}$/
         let esValido = validaApellidoP.exec(apellidoPEmpleado);

         if (esValido == null || apellidoPEmpleado.length == 0 || /^\s+$/.test(apellidoPEmpleado)) {
            alertify.notify('Apellido Paterno del Empleado es incorrecto', 'error', 3, null);
         } else {
            valido >>= 1;
         }
      }

      if (apellidoMEmpleado.length > 0) {
         let validaApellidoM = /^[A-Z\u00C0-\u00DCa-z\u00E0-\u00FC0-9\s]{1,99}$/
         let esValido = validaApellidoM.exec(apellidoMEmpleado);

         if (esValido == null || apellidoMEmpleado.length == 0 || /^\s+$/.test(apellidoMEmpleado)) {
            alertify.notify('Apellido Materno del Empleado es incorrecto', 'error', 3, null);
         } else {
            valido >>= 1;
         }
      }


      if (direccion.length > 0) {
         let validaPassword = /^[A-Z\u00C0-\u00DCa-z\u00E0-\u00FC0-9\s]{1,99}$/
         let esValido = validaPassword.exec(direccion);

         if (esValido == null || direccion.length == 0 || /^\s+$/.test(direccion)) {
            alertify.notify('Datos incorrectos en la direccion', 'error', 3, null);
         } else {
            valido >>= 1;
         }
      }
      return valido;
   }

});