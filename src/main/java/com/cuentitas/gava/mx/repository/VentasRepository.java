package com.cuentitas.gava.mx.repository;

import com.cuentitas.gava.mx.model.Ventas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentasRepository extends JpaRepository<Ventas,Integer> {
    
}
