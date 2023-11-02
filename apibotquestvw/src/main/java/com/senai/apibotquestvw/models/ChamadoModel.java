package com.senai.apibotquestvw.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "tb_chamado")
public class ChamadoModel implements Serializable {
    @Serial
    private static final long serialVersion = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;

    String descricao;

    Date dataChamado;

    Boolean status;

    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    private UsuarioModel usuario;
}