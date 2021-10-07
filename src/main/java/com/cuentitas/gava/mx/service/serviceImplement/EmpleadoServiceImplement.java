package com.cuentitas.gava.mx.service.serviceImplement;

import java.util.List;

import com.cuentitas.gava.mx.exceptions.EmpleadoExceptions;
import com.cuentitas.gava.mx.model.Empleado;
import com.cuentitas.gava.mx.repository.EmpleadoRepository;
import com.cuentitas.gava.mx.service.EmpleadoService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoServiceImplement implements EmpleadoService {

    private static final Logger log= Logger.getLogger(EmpleadoServiceImplement.class);

    @Autowired
    private EmpleadoRepository empleadoReposiroty;

    @Override
    public void guardarEmpleado(Empleado empleado) throws EmpleadoExceptions {
        StringBuilder mensaje = new StringBuilder();
        try {
            if (empleado.getNombre().trim().isEmpty() || empleado.getApellidoMaterno().trim().isEmpty() || empleado.getApellidoPaterno().trim().isEmpty() || empleado.getDireccion().trim().isEmpty() || empleado.getMontoPago()<0) {
                log.warn("EMPLEADO ERROR EN ATRIBUTOS VACIOS");
                throw new EmpleadoExceptions("ATRIBUTOS VACIOS AL GUARDAR EMPLEADO"+ empleado.getNombre() + empleado.getApellidoMaterno() + empleado.getApellidoPaterno() + empleado.getDireccion() + empleado.getMontoPago());
            }else{
                empleadoReposiroty.save(empleado);
            }
        } catch (EmpleadoExceptions e) {
            mensaje.append("ERROR INTERNO SERVER CAIDO EN GUARDAR EMPLEADO").append(e.getMessage());
            log.error("ENTRO EN EL CATCH DE GUARDAR EMPLEADO");
            throw new EmpleadoExceptions(e.getMessage());
        }
        
    }

    @Override
    public void eliminarEmpleado(Empleado empleado) throws EmpleadoExceptions {
        empleadoReposiroty.delete(empleado);
        
    }

    @Override
    public List<Empleado> getListaEmpleado() throws EmpleadoExceptions {
        return empleadoReposiroty.findAll();
    }
    
}