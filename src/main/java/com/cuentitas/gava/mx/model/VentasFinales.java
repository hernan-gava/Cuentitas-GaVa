package com.cuentitas.gava.mx.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="ventas_finales")
public class VentasFinales {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_ventas_finales")
    private int idVentasFinales;

    @Column(name ="fecha_calculo")
    private Date fechaCalculo;

    @Column(name ="calculo_total_venta")
    private double calculoTotalVenta;

    @Column(name ="observaciones")
    private String observaciones;

    public VentasFinales() {
        VentasFinales ventasFinales;
    }

    public int getIdVentasFinales() {
        return this.idVentasFinales;
    }

    public void setIdVentasFinales(int idVentasFinales) {
        this.idVentasFinales = idVentasFinales;
    }

    public Date getFechaCalculo() {
        return this.fechaCalculo;
    }

    public void setFechaCalculo(Date fechaCalculo) {
        this.fechaCalculo = fechaCalculo;
    }

    public double getCalculoTotalVenta() {
        return this.calculoTotalVenta;
    }

    public void setCalculoTotalVenta(double calculoTotalVenta) {
        this.calculoTotalVenta = calculoTotalVenta;
    }

    public String getObservaciones() {
        return this.observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

}
