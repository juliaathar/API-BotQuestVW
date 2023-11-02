package com.senai.apibotquestvw.repositories;

import com.senai.apibotquestvw.models.PerguntaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PerguntaRepository extends JpaRepository<PerguntaModel, UUID> {
    Optional<PerguntaModel> findById(UUID id);
}