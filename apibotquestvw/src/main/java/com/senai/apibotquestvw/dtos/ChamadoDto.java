package com.senai.apibotquestvw.dtos;

import com.senai.apibotquestvw.models.UsuarioModel;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.Date;
import java.util.UUID;


//@Data
public record ChamadoDto(
        @NotBlank String descricao,
        @NotBlank Date dataChamado,
        @NotBlank String status,
        UsuarioModel usuario

) {

}
