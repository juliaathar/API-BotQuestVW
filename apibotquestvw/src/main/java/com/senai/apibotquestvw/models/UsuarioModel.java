package com.senai.apibotquestvw.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "tb_usuario")
public class UsuarioModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;

    private int tipo_usuario;
    private String nome;
    private String email;
    private String senha;
    private int vwId;
    private Date dataNascimento;

    @ManyToOne
    @JoinColumn(name = "id_chapa", referencedColumnName = "id")
    private ChapaModel chapa;

}