package com.chamado.suporte.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chamado.suporte.model.ChamadoSuporte;

@Repository
public interface ChamadoSuporteRepository extends JpaRepository<ChamadoSuporte, Integer> {

}
