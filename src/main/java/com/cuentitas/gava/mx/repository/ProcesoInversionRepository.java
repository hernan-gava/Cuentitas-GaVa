package com.cuentitas.gava.mx.repository;

import com.cuentitas.gava.mx.model.ProcesoInversiones;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcesoInversionRepository extends JpaRepository<ProcesoInversiones,Integer>{
    
}
