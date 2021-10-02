package com.cuentitas.gava.mx.model.dto;

import java.sql.*;

public class InversionInicialDto {
 
    private int idInversionInicial;    
    private String nombreProducto;
    private int total;
    private Date fecha;

    public int getIdInversionInicial() {
        return this.idInversionInicial;
    }

    public String getNombreProducto() {
        return this.nombreProducto;
    }

    public int getTotal() {
        return this.total;
    }

    public Date getFecha() {
        return this.fecha;
    }

}
