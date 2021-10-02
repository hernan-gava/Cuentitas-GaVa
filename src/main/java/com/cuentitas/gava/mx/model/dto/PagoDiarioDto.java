package com.cuentitas.gava.mx.model.dto;

import com.cuentitas.gava.mx.model.Empleado;

public class PagoDiarioDto {
    
    private int idPago;    
    private String totalPago;
    private Empleado empleado;

    public int getIdPago() {
        return this.idPago;
    }

    public String getTotalPago() {
        return this.totalPago;
    }

    public Empleado getEmpleado() {
        return this.empleado;
    }
    
}
