package com.cuentitas.gava.mx.service;

import java.util.List;

import com.cuentitas.gava.mx.exceptions.VentasExceptions;
import com.cuentitas.gava.mx.model.Ventas;

public interface VentasService {
    
    public void guardarVentas(Ventas ventas) throws VentasExceptions;    

    public void eliminarVentas(Ventas ventas) throws VentasExceptions;

    public List<Ventas> getListaVentas() throws VentasExceptions;
}
