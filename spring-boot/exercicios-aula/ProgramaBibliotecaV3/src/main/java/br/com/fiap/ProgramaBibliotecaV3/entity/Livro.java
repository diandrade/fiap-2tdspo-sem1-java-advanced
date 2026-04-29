package br.com.fiap.ProgramaBibliotecaV3.entity;

import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="TB_LIVRO")
@SequenceGenerator(name="livro", sequenceName = "SQ_TB_LIVRO", allocationSize = 1)
public class Livro {

    @Id
    @Column(name="cd_livro")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "livro")
    private Integer codigo;

    @Column(name="ds_titulo", nullable = false, length = 50)
    private String titulo;

    @Column(name="nr_pagina", precision = 5)
    private Integer numeroPaginas;

    //Relacionamento P:1
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="cd_editora", nullable = false)
    private Editora editora;

    //Relacionamento Bidirecional N:M
    @ManyToMany(mappedBy = "livros")
    private List<Biblioteca> bibliotecas;

    public Livro() {}

    public Livro(String titulo, Integer numeroPaginas) {
        this.titulo = titulo;
        this.numeroPaginas = numeroPaginas;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(Integer numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    public List<Biblioteca> getBibliotecas() {
        return bibliotecas;
    }

    public void setBibliotecas(List<Biblioteca> bibliotecas) {
        this.bibliotecas = bibliotecas;
    }

}
