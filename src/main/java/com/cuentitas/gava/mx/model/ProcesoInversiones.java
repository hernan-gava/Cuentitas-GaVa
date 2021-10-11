package com.cuentitas.gava.mx.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "procesos_inversiones")
public class ProcesoInversiones {
        
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proceso_inversion")
    private int idProcesoInversion;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "total_inversion")
    private double totalInversion;

    @Column(name = "fecha")
    private Date fecha;

    public ProcesoInversiones() {
        ProcesoInversiones  procesosInversiones;
    }

    public int getIdProcesoInversion() {
        return this.idProcesoInversion;
    }

    public void setIdProcesoInversion(int idProcesoInversion) {
        this.idProcesoInversion = idProcesoInversion;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getTotalInversion() {
        return this.totalInversion;
    }

    public void setTotalInversion(double totalInversion) {
        this.totalInversion = totalInversion;
    }

    public Date getFecha() {
        return this.fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
