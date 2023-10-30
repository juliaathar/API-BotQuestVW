package com.senai.apibotquestvw.dtos;

import jakarta.validation.constraints.NotBlank;

public record ChapaDto(@NotBlank String nome) {
}
