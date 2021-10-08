package com.cuentitas.gava.mx.service.implement;

import java.util.List;

import com.cuentitas.gava.mx.exceptions.PagoDiarioExceptions;
import com.cuentitas.gava.mx.model.PagoDiario;
import com.cuentitas.gava.mx.repository.PagoDiarioRepository;
import com.cuentitas.gava.mx.service.PagoDiarioService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagoDiarioServiceImplement implements PagoDiarioService {

    private static final Logger log= Logger.getLogger(PagoDiarioServiceImplement.class);

    @Autowired
    private PagoDiarioRepository pagoDiarioRepository;
    
    @Override
    public void guardarPagoDiario(PagoDiario pagoDiario) throws PagoDiarioExceptions {   
        StringBuilder mensaje = new StringBuilder();
        try {
            if(pagoDiario.getTotalPago() <0 || pagoDiario.getEmpleado()==null){
                log.warn("PagoDiario ESTA EN NULL LOS DATOS NO PUEDE SER GUARDADO");
                throw new PagoDiarioExceptions("ERROR EN GUARDAR DATOS PAGOS ATRIBUTOS NULLOS" + pagoDiario.getTotalPago() + pagoDiario.getEmpleado());
            }else{
                pagoDiarioRepository.save(pagoDiario);
            }
        } catch (PagoDiarioExceptions e) {
            mensaje.append("ERROR INTERNO EN GUARDAR PAGO DIARIO").append(e.getMessage());
            log.error("ENTRO EN EL CATCH DE GUARDAR PAGOS DIARIOS ");
            throw new PagoDiarioExceptions(e.getMessage());
        }         
    }

    @Override
    public void eliminarPagoDiario(PagoDiario pagoDiario) throws PagoDiarioExceptions {    
        pagoDiarioRepository.delete(pagoDiario);
    }

    @Override
    public List<PagoDiario> getListaPagoDiario() throws PagoDiarioExceptions {    
        return pagoDiarioRepository.findAll();
    }
    
}
