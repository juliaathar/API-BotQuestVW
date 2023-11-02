package com.senai.apibotquestvw.controllers;

import com.senai.apibotquestvw.dtos.ChamadoDto;
import com.senai.apibotquestvw.dtos.UsuarioDto;
import com.senai.apibotquestvw.models.ChamadoModel;
import com.senai.apibotquestvw.models.UsuarioModel;
import com.senai.apibotquestvw.repositories.ChamadoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "chamados", produces =
        {"application/json"})
public class ChamadoController {
    @Autowired
    ChamadoRepository chamadoRepository;

    @GetMapping
    public ResponseEntity<List<ChamadoModel>> listarChamados() {
        return ResponseEntity.status(HttpStatus.OK).body(chamadoRepository.findAll());
    }

    @GetMapping("/{idChamado}")
    public ResponseEntity<Object> buscarChamado(@PathVariable(value = "idChamado") UUID id) {
        Optional<ChamadoModel> chamadoBuscado = chamadoRepository.findById(id);

        if (chamadoBuscado.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Chamado inexistente");
        }

        return ResponseEntity.status(HttpStatus.OK).body(chamadoBuscado.get());
    }

    @PostMapping
    public ResponseEntity<Object> cadastrarChamado(@RequestBody @Valid ChamadoDto chamadoDto) {
        ChamadoModel chamado = new ChamadoModel();

        BeanUtils.copyProperties(chamadoDto, chamado);

        return ResponseEntity.status(HttpStatus.CREATED).body(chamadoRepository.save(chamado));
    }

    @PutMapping(value = "/{idChamado}")
    public ResponseEntity<Object> editarChamado(@PathVariable(value = "idChamado") UUID id,
                                                @ModelAttribute @Valid ChamadoDto chamadoDto) {
        Optional<ChamadoModel> chamadoBuscado = chamadoRepository.findById(id);

        if (chamadoBuscado.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Chamado não encontrado");
        }

        ChamadoModel chamado = chamadoBuscado.get();
        BeanUtils.copyProperties(chamadoDto
                , chamado);

        return ResponseEntity.status(HttpStatus.CREATED).body(chamadoRepository.save(chamado));
    }
}
