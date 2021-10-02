package com.cuentitas.gava.mx.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "inversion_inicial")
public class InversionInicial {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_inversion_inicial")
    private int idInversionInicial;

    @Column(name = "nombre_producto")
    private String nombreProducto;

    @Column(name = "total")
    private int total;

    @Column(name = "fecha")
    private Date fecha;

    public InversionInicial(){
        InversionInicial inversionInicial;
    }    

    public int getIdInversionInicial() {
        return this.idInversionInicial;
    }

    public void setIdInversionInicial(int idInversionInicial) {
        this.idInversionInicial = idInversionInicial;
    }

    public String getNombreProducto() {
        return this.nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getTotal() {
        return this.total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Date getFecha() {
        return this.fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

}
