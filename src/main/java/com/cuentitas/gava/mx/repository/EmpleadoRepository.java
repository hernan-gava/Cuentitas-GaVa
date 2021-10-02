package com.cuentitas.gava.mx.repository;

import com.cuentitas.gava.mx.model.Empleado;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer>{
    
}
