package org.example.jogo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Jogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoAtivacao;

    @NotBlank(message = "Deve por Nome")
    private String nome;

    @NotNull(message = "Deve conter preço")
    private Double preco;

    @NotBlank(message = "Deve ter Categoria")
    private String categoria;
}
