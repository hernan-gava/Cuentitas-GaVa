package com.cuentitas.gava.mx;

import com.cuentitas.gava.mx.exceptions.EmpleadoExceptions;
import com.cuentitas.gava.mx.model.Empleado;
import com.cuentitas.gava.mx.service.EmpleadoService;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CuentitasGaVaApplicationTests {
	
	@Autowired
	EmpleadoService empleadoService;		

	@Test
	void contextLoads() {
	}

	@Test 
	@DisplayName("Creacion de Empleado")
	void CrearEmpleado() throws EmpleadoExceptions {		
		Empleado empleado = new Empleado();
		
		empleado.setNombre("Hernan");
		empleado.setApellidoPaterno("Garcia");
		empleado.setApellidoMaterno("Valladares");
		empleado.setDireccion("Sultepec");		

		empleadoService.guardarEmpleado(empleado);
	}
}
