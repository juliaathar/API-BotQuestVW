package com.senai.apibotquestvw.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "pergunta_model")
public class PerguntaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;

    String titulo;

    @ManyToOne
    @JoinColumn(name = "id_chapa", referencedColumnName = "id")
    private ChapaModel chapa;
}