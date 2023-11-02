package com.senai.apibotquestvw.repositories;

import com.senai.apibotquestvw.models.ChamadoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ChamadoRepository extends JpaRepository<ChamadoModel, UUID> {
    Optional<ChamadoModel> findById(UUID id); //Optional para caso ele retornar ausente fazer validação
}