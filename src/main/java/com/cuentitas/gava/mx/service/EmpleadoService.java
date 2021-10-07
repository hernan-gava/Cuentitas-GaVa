package com.cuentitas.gava.mx.service;

import java.util.List;

import com.cuentitas.gava.mx.exceptions.EmpleadoExceptions;
import com.cuentitas.gava.mx.model.Empleado;

public interface EmpleadoService {

    public void guardarEmpleado(Empleado empleado) throws EmpleadoExceptions;    

    public void eliminarEmpleado(Empleado empleado) throws EmpleadoExceptions;

    public List<Empleado> getListaEmpleado() throws EmpleadoExceptions;

}
