package com.cuentitas.gava.mx.service;

import java.util.List;

import com.cuentitas.gava.mx.exceptions.PagoDiarioExceptions;
import com.cuentitas.gava.mx.model.PagoDiario;

public interface PagoDiarioService {
    public void guardarPagoDiario(PagoDiario pagoDiario) throws PagoDiarioExceptions;

    public void eliminarPagoDiario(PagoDiario pagoDiario) throws PagoDiarioExceptions;

    public List<PagoDiario> getListaPagoDiario() throws PagoDiarioExceptions;
}