package com.cuentitas.gava.mx.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "empleados")
public class Empleado implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado")
    private int idEmpleado;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido_materno")
    @NotNull(message = "Limite de pago no debe ir vacio")
    private String apellidoMaterno;

    @Column(name = "apellido_paterno")
    @NotNull(message = "Limite de pago no debe ir vacio")
    private String apellidoPaterno;

    @Column(name = "direccion")
    private String direccion;    

    @OneToMany(mappedBy="empleado",fetch = FetchType.LAZY)
    private List<PagoDiario> pagoDiarios;

    @OneToMany(mappedBy="empleado",fetch = FetchType.LAZY)
    private List<PagoMensuales> pagosMensuales;

    public Empleado(){
        Empleado empleado;
    }

    public int getIdEmpleado() {
        return this.idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoMaterno() {
        return this.apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getApellidoPaterno() {
        return this.apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<PagoDiario> getPagoDiarios() {
        return this.pagoDiarios;
    }

    public void setPagoDiarios(List<PagoDiario> pagoDiarios) {
        this.pagoDiarios = pagoDiarios;
    }

    public List<PagoMensuales> getPagosMensuales() {
        return this.pagosMensuales;
    }

    public void setPagosMensuales(List<PagoMensuales> pagosMensuales) {
        this.pagosMensuales = pagosMensuales;
    }


}
