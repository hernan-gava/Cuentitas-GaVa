package com.cuentitas.gava.mx.repository;

import com.cuentitas.gava.mx.model.PagoMensuales;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagoMensualRepository extends JpaRepository<PagoMensuales, Integer> {
    
}
