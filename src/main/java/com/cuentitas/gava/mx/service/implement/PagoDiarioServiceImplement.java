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
        if(pagoDiario.getTotalPago() <0 || pagoDiario.getEmpleado()==null){

        }
    }

    @Override
    public void eliminarPagoDiario(PagoDiario pagoDiario) throws PagoDiarioExceptions {    
        
    }

    @Override
    public List<PagoDiario> getListaPagoDiario() throws PagoDiarioExceptions {    
        return null;
    }
    
}
