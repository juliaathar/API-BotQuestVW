package com.senai.apibotquestvw.controllers;

import com.senai.apibotquestvw.dtos.ChamadoDto;
import com.senai.apibotquestvw.dtos.PerguntaDto;
import com.senai.apibotquestvw.dtos.UsuarioDto;
import com.senai.apibotquestvw.models.ChamadoModel;
import com.senai.apibotquestvw.models.PerguntaModel;
import com.senai.apibotquestvw.models.UsuarioModel;
import com.senai.apibotquestvw.repositories.PerguntaRepository;
import com.senai.apibotquestvw.repositories.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "/perguntas", produces = {"application/json"})

public class PerguntaController {
    @Autowired
    PerguntaRepository perguntaRepository;

    @GetMapping
    public ResponseEntity<List<PerguntaModel>> listarPerguntas() {
        //retorna uma resposta de requisicao onde o status code for 200(OK) listando todos os usuarios
        return ResponseEntity.status(HttpStatus.OK).body(perguntaRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Object> cadastrarPergunta(@RequestBody @Valid PerguntaDto perguntaDto) {
        PerguntaModel pergunta = new PerguntaModel();

        BeanUtils.copyProperties(perguntaDto, pergunta);

        return ResponseEntity.status(HttpStatus.CREATED).body(perguntaRepository.save(pergunta));
    }

    @DeleteMapping("/{idPergunta}")
    public ResponseEntity<Object> deletarPergunta(@PathVariable(value = "idPergunta") UUID id) {
        Optional<PerguntaModel> perguntaBuscada = (perguntaRepository.findById(id));

        if (perguntaBuscada.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pergunta não encontrada");
        }

        perguntaRepository.delete(perguntaBuscada.get());

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Pergunta deletada!");
    }
}
