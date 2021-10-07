package com.cuentitas.gava.mx.service;

import java.util.List;

import com.cuentitas.gava.mx.exceptions.VentasFinalesExceptions;
import com.cuentitas.gava.mx.model.VentasFinales;

public interface VentasFinalesService {
    
    public void guardarVentasFinales(VentasFinales ventasFinales) throws VentasFinalesExceptions;

    public void eliminarVentasFinales(VentasFinales ventasFinales) throws VentasFinalesExceptions;

    public List<VentasFinales> getListaVentasFinales() throws VentasFinalesExceptions;
}