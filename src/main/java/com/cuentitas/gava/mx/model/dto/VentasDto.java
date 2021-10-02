package com.cuentitas.gava.mx.model.dto;

import java.sql.*;

public class VentasDto {
    
    private int idVentas;
    private String descripcion;
    private double total;
    private Date fecha;


    public int getIdVentas() {
        return this.idVentas;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public double getTotal() {
        return this.total;
    }

    public Date getFecha() {
        return this.fecha;
    }
}
