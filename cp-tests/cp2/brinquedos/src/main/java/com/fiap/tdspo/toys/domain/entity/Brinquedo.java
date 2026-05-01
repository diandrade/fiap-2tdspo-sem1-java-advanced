package com.fiap.tdspo.toys.domain.entity;

public class Brinquedo {
    private Integer id;
    private String Nome;
    private String tipo;
    private String classificacao;
    private Double tamanho;
    private Double preco;

    public Brinquedo() {
    }

    public Brinquedo(Integer id, String name, String type, String classification, Double height, Double price) {
        this.id = id;
        this.Nome = name;
        this.tipo = type;
        this.classificacao = classification;
        this.tamanho = height;
        this.preco = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return Nome;
    }

    public void setName(String name) {
        this.Nome = name;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public Double getTamanho() {
        return tamanho;
    }

    public void setTamanho(Double tamanho) {
        this.tamanho = tamanho;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
