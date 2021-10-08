package com.cuentitas.gava.mx.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pago_diario")
public class PagoDiario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_pago")
    private int idPago;

    @Column(name = "total_pago")
    private double totalPago;

    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_empleado", nullable = false)
    private Empleado empleado;

    public PagoDiario() {
        PagoDiario pagoDiario;
    }

    public int getIdPago() {
        return this.idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }
    

    public double getTotalPago() {
        return this.totalPago;
    }

    public void setTotalPago(double totalPago) {
        this.totalPago = totalPago;
    }

    public Empleado getEmpleado() {
        return this.empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    
    
}
