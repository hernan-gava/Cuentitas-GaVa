package com.cuentitas.gava.mx.service.implement;

import java.util.List;

import com.cuentitas.gava.mx.exceptions.VentasFinalesExceptions;
import com.cuentitas.gava.mx.model.VentasFinales;
import com.cuentitas.gava.mx.repository.VentasFinalesRepository;
import com.cuentitas.gava.mx.service.VentasFinalesService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentasFinalesServiceImplement implements VentasFinalesService {

    private static final Logger log= Logger.getLogger(VentasFinalesServiceImplement.class);

    @Autowired
    private VentasFinalesRepository ventasFinalesRepository;

    @Override
    public void guardarVentasFinales(VentasFinales ventasFinales) throws VentasFinalesExceptions {
        StringBuilder mensaje = new StringBuilder();
        try {
            if(ventasFinales.getFechaCalculo()==null || ventasFinales.getCalculoTotalVenta()<0 || ventasFinales.getObservaciones().trim().isEmpty()){
                log.warn("guardarVentasFinales ESTA EN NULL LOS DATOS NO PUEDE SER GUARDADO");
                throw new VentasFinalesExceptions("ERROR EN GUARDAR DATOS VENTAS FINALES NULLOS");
            }else{
                ventasFinalesRepository.save(ventasFinales);
            }
        } catch (VentasFinalesExceptions e) {
            mensaje.append("ERROR INTERNO EN GUARDAR VENTAS FINALES").append(e.getMessage());
            log.error("ENTRO EN EL CATCH DE GUARDAR VENTAS FINALES");
            throw new VentasFinalesExceptions(e.getMessage());
        }
        
    }

    @Override
    public void eliminarVentasFinales(VentasFinales ventasFinales) throws VentasFinalesExceptions {
        ventasFinalesRepository.delete(ventasFinales);
    }

    @Override
    public List<VentasFinales> getListaVentasFinales() throws VentasFinalesExceptions {    
        return ventasFinalesRepository.findAll();
    }
    
}
