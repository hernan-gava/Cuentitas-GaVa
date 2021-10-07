package com.cuentitas.gava.mx.service;

import java.util.List;

import com.cuentitas.gava.mx.exceptions.ProcesoInversionesExceptions;
import com.cuentitas.gava.mx.model.ProcesoInversiones;

public interface ProcesoInversionService {
    public void guardarProcesoInversiones(ProcesoInversiones procesoInversiones) throws ProcesoInversionesExceptions;

    public void eliminarProcesoInversiones(ProcesoInversiones procesoInversiones) throws ProcesoInversionesExceptions;

    public List<ProcesoInversiones> getListaProcesoInversiones() throws ProcesoInversionesExceptions;
}