package com.cuentitas.gava.mx.service.implement;

import java.util.List;

import com.cuentitas.gava.mx.exceptions.ProcesoInversionesExceptions;
import com.cuentitas.gava.mx.model.ProcesoInversiones;
import com.cuentitas.gava.mx.service.ProcesoInversionService;

import org.springframework.stereotype.Service;

@Service
public class ProcesoInversionesServiceImplement implements ProcesoInversionService {

    @Override
    public void guardarProcesoInversiones(ProcesoInversiones procesoInversiones) throws ProcesoInversionesExceptions {    
    }

    @Override
    public void eliminarProcesoInversiones(ProcesoInversiones procesoInversiones) throws ProcesoInversionesExceptions {
        
    }

    @Override
    public List<ProcesoInversiones> getListaProcesoInversiones() throws ProcesoInversionesExceptions {
        return null;
    }
    


}
