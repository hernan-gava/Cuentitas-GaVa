package com.cuentitas.gava.mx.repository;

import com.cuentitas.gava.mx.model.InversionInicial;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InversionInicialRepository extends JpaRepository<InversionInicial,Integer>{
    
}
