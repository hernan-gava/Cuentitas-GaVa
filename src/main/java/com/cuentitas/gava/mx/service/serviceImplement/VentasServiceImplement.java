package com.cuentitas.gava.mx.service.serviceImplement;

import java.util.List;

import com.cuentitas.gava.mx.exceptions.VentasExceptions;
import com.cuentitas.gava.mx.model.Ventas;
import com.cuentitas.gava.mx.repository.VentasRepository;
import com.cuentitas.gava.mx.service.VentasService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentasServiceImplement implements VentasService {

    private static final Logger log = Logger.getLogger(VentasServiceImplement.class);

    @Autowired
    private VentasRepository ventasRepository;

    @Override
    public void guardarVentas(Ventas ventas) throws VentasExceptions {
        StringBuilder mensaje = new StringBuilder();
        try {
            if (ventas.getDescripcion().trim().isEmpty() || ventas.getTotal()<0 || ventas.getFecha()==null) {
                log.warn("GUARDAR VENTAS ALGUNOS DATOS VIENEN VACIOS ");
                throw new VentasExceptions("DATOS NULL EN GUARDAR VENTAS:" + ventas.getDescripcion() + ventas.getTotal() + ventas.getFecha());
            }else{
                ventasRepository.save(ventas);
            } 
        } catch (VentasExceptions e) {
            mensaje.append("NO SE PUDO GUARDAR REGISTRO DE VENTAS").append(e.getMessage());
            log.error("ENTRO EN EL CATCH DE GUARDAR VENTAS");
            throw new VentasExceptions(e.getMessage());
        }        
    }    

    @Override
    public void eliminarVentas(Ventas ventas) throws VentasExceptions {
        ventasRepository.delete(ventas);        
    }

    @Override
    public List<Ventas> getListaVentas() throws VentasExceptions {
        return ventasRepository.findAll();        
    }

}
