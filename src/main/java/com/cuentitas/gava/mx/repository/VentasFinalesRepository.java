package com.cuentitas.gava.mx.repository;

import com.cuentitas.gava.mx.model.VentasFinales;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentasFinalesRepository extends JpaRepository<VentasFinales,Integer>{
    
}
