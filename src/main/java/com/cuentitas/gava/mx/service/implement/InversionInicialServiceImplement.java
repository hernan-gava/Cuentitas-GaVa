package com.cuentitas.gava.mx.service.implement;

import java.util.List;

import com.cuentitas.gava.mx.exceptions.InversionInicialExceptions;
import com.cuentitas.gava.mx.model.InversionInicial;
import com.cuentitas.gava.mx.repository.InversionInicialRepository;
import com.cuentitas.gava.mx.service.InversionInicialService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InversionInicialServiceImplement implements InversionInicialService {

    private static final Logger log = Logger.getLogger(InversionInicialServiceImplement.class);
    @Autowired

    private InversionInicialRepository inversionRepository;
    
    @Override
    public void guardarInversionInicial(InversionInicial inversionInicial) throws InversionInicialExceptions {        
        StringBuilder mensaje = new StringBuilder();
        try {
            if (inversionInicial.getFecha()==null || inversionInicial.getNombreProducto().trim().isEmpty() || inversionInicial.getTotal()<0) {
                log.warn("ALGUNOS ATRIBUTOS DE INVERSION INICIAL VIENEN VACIOS O NULL");
                throw new InversionInicialExceptions("ERROR EN GUARDAR INVERSION INICIAL" + inversionInicial.getNombreProducto() + inversionInicial.getTotal() + inversionInicial.getFecha());
            }else{
                inversionRepository.save(inversionInicial);
            }
        } catch (InversionInicialExceptions e) {
            mensaje.append("ERROR INTERNO EN GUARDAR INVERSION").append(e.getMessage());
            log.error("ENTRO EN EL CATCH DE GUARDAR INVERSION INICIAL");
            throw new InversionInicialExceptions(e.getMessage());
        }
    }

    @Override
    public void eliminarInversionInicial(InversionInicial inversionInicial) throws InversionInicialExceptions {        
        inversionRepository.delete(inversionInicial);
    }

    @Override
    public List<InversionInicial> getListaInversionInicial() throws InversionInicialExceptions {
        return inversionRepository.findAll();
    }
    
}