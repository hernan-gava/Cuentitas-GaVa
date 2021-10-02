package com.cuentitas.gava.mx.model.dto;

import java.sql.Date;

public class ProcesoInversionesDto {
    
    private int idProcesoInversion;
    private String descripcion;
    private double totalInversion;
    private Date fecha;

    public int getIdProcesoInversion() {
        return this.idProcesoInversion;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public double getTotalInversion() {
        return this.totalInversion;
    }

    public Date getFecha() {
        return this.fecha;
    }

}
