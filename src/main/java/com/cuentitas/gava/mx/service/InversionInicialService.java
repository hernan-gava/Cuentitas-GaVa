package com.cuentitas.gava.mx.service;

import java.util.List;

import com.cuentitas.gava.mx.exceptions.InversionInicialExceptions;
import com.cuentitas.gava.mx.model.InversionInicial;

public interface InversionInicialService {

    public void guardarInversionInicial(InversionInicial inversionInicial) throws InversionInicialExceptions;

    public void eliminarInversionInicial(InversionInicial inversionInicial) throws InversionInicialExceptions;

    public List<InversionInicial> getListaInversionInicial() throws InversionInicialExceptions;
}
