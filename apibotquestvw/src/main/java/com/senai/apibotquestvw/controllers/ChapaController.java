package com.senai.apibotquestvw.controllers;

import com.senai.apibotquestvw.models.ChapaModel;
import com.senai.apibotquestvw.repositories.ChapaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "/chapa", produces = {"application/json"})
public class ChapaController {
    @Autowired
    ChapaRepository chapaRepository;

    @GetMapping
    public ResponseEntity<List<ChapaModel>> listarChapas() {
        return ResponseEntity.status(HttpStatus.OK).body(chapaRepository.findAll());
    }

    @GetMapping("/{idChapa}")
    public ResponseEntity<Object> buscarChapa(@PathVariable(value = "idChapa") UUID id) {
        Optional<ChapaModel> chapaBuscada = chapaRepository.findById(id);

        if (chapaBuscada.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Essa chapa não existe");
        }

        return ResponseEntity.status(HttpStatus.OK).body(chapaBuscada.get());
    }

}
