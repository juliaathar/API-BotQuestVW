package com.senai.apibotquestvw.repositories;

import com.senai.apibotquestvw.models.ChapaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ChapaRepository extends JpaRepository<ChapaModel, UUID> {
}