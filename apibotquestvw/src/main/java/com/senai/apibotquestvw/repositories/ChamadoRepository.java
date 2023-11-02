package com.senai.apibotquestvw.repositories;

import com.senai.apibotquestvw.models.ChamadoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ChamadoRepository extends JpaRepository<ChamadoModel, UUID> {
//    ChamadoModel findById(UUID id); arrumar método de buscar por id
}