package com.fiap.tdspo.toys.api.dto.request;

import jakarta.validation.constraints.*;

public class BrinquedoRequestDTO {

    @NotBlank(message = "Nome é obrigatório")
    @Size(min = 3, max = 100, message = "Nome deve ter entre 3 e 100 caracteres")
    private String nome;

    @NotBlank(message = "Tipo é obrigatório")
    private String tipo;

    @NotBlank(message = "Classificação é obrigatória")
    private String classificacao;

    @NotNull(message = "Tamanho é obrigatório")
    @Positive(message = "Tamanho deve ser positivo")
    private Double tamanho;

    @NotNull(message = "Preço é obrigatório")
    @Positive(message = "Preço deve ser positivo")
    private Double preco;

    public BrinquedoRequestDTO() {
    }

    public BrinquedoRequestDTO(String nome, String tipo, String classificacao, Double tamanho, Double preco) {
        this.nome = nome;
        this.tipo = tipo;
        this.classificacao = classificacao;
        this.tamanho = tamanho;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public Double getTamanho() {
        return tamanho;
    }

    public Double getPreco() {
        return preco;
    }
}