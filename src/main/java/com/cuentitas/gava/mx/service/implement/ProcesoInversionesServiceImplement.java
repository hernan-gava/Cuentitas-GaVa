package com.cuentitas.gava.mx.service.implement;

import java.util.List;

import com.cuentitas.gava.mx.exceptions.ProcesoInversionesExceptions;
import com.cuentitas.gava.mx.model.ProcesoInversiones;
import com.cuentitas.gava.mx.repository.ProcesoInversionRepository;
import com.cuentitas.gava.mx.service.ProcesoInversionService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProcesoInversionesServiceImplement implements ProcesoInversionService {

    private static final Logger log = Logger.getLogger(ProcesoInversionesServiceImplement.class);

    @Autowired
    private ProcesoInversionRepository procesoInversionRepository;

    @Override
    public void guardarProcesoInversiones(ProcesoInversiones procesoInversiones) throws ProcesoInversionesExceptions {
        StringBuilder mensaje = new StringBuilder();
        try {
            if(procesoInversiones.getDescripcion().isEmpty() || procesoInversiones.getTotalInversion()<0 || procesoInversiones.getFecha()==null){
                log.warn("guardarProcesoInversiones ESTA EN NULL LOS DATOS NO PUEDE SER GUARDADO");
                throw new ProcesoInversionesExceptions("ERROR EN GUARDAR DATOS PROCESO DE IVERSIONES NULLOS" );
            }else{
                procesoInversionRepository.save(procesoInversiones);
            }
        } catch (ProcesoInversionesExceptions e) {
            mensaje.append("ERROR INTERNO EN GUARDAR PROCESO INVERSIONES").append(e.getMessage());
            log.error("ENTRO EN EL CATCH DE GUARDAR PROCESO INVERSIONES");
            throw new ProcesoInversionesExceptions(e.getMessage());
        }
        
    }

    @Override
    public void eliminarProcesoInversiones(ProcesoInversiones procesoInversiones) throws ProcesoInversionesExceptions {
        procesoInversionRepository.delete(procesoInversiones);
    }

    @Override
    public List<ProcesoInversiones> getListaProcesoInversiones() throws ProcesoInversionesExceptions {
        return procesoInversionRepository.findAll();
    }

}