package com.cuentitas.gava.mx.model.dto;

import java.sql.*;

public class VentasFinalesDto {
    
    private int idVentasFinales;
    private Date fechaCalculo;
    private double calculoTotalVenta;
    private String observaciones;

    public int getIdVentasFinales() {
        return this.idVentasFinales;
    }

    public Date getFechaCalculo() {
        return this.fechaCalculo;
    }

    public double getCalculoTotalVenta() {
        return this.calculoTotalVenta;
    }

    public String getObservaciones() {
        return this.observaciones;
    }

}
