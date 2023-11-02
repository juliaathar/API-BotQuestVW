package com.senai.apibotquestvw.repositories;

import com.senai.apibotquestvw.models.PerguntaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PerguntaRepository extends JpaRepository<PerguntaModel, UUID> {
    PerguntaModel findById(UUID id);
}