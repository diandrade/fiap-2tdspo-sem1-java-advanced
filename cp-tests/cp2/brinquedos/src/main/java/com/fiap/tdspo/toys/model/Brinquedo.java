package com.fiap.tdspo.toys.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TDS_TB_BRINQUEDO")
public class Brinquedo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_brinquedo")
    private Long id;

    @Column(name = "nm_nome", nullable = false)
    private String nome;

    @Column(name = "ds_tipo", nullable = false)
    private String tipo;

    @Column(name = "ds_classificacao", nullable = false)
    private String classificacao;

    @Column(name = "vl_tamanho", nullable = false)
    private Double tamanho;

    @Column(name = "vl_preco", nullable = false)
    private Double preco;

    public Brinquedo() {
    }

    public Brinquedo(Long id, String tutor, String tipo, String classificacao, Double tamanho, Double preco) {
        this.id = id;
        this.nome = tutor;
        this.tipo = tipo;
        this.classificacao = classificacao;
        this.tamanho = tamanho;
        this.preco = preco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String tutor) {
        this.nome = tutor;
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
