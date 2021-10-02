package com.cuentitas.gava.mx.model.dto;

public class EmpleadoDto {
    
    private int idEmpleado;
    private String nombre;
    private String apellidoMaterno;
    private String apellidoPaterno;
    private String direccion;
    private double montoPago;

    public int getIdEmpleado() {
        return this.idEmpleado;
    }    

    public String getNombre() {
        return this.nombre;
    }

    public String getApellidoMaterno() {
        return this.apellidoMaterno;
    }

    public String getApellidoPaterno() {
        return this.apellidoPaterno;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public double getMontoPago() {
        return this.montoPago;
    }
        
}
