package com.cuentitas.gava.mx.repository;

import com.cuentitas.gava.mx.model.PagoDiario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagoDiarioRepository extends JpaRepository<PagoDiario, Integer> {
    
}
