package br.com.fiap.tdspo.biblioteca.infrastructure.persistence.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "TB_LIVRO")
@SequenceGenerator(name = "livro", sequenceName = "SQ_TB_LIVRO", allocationSize = 1)
public class LivroJpaEntity {
    @Id
    @Column(name = "cd_livro")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "livro")
    private Integer codigo;

    @Column(name = "ds_titulo", nullable = false, length = 50)
    private String titulo;

    @Column(name = "nr_pagina")
    private Integer numeroPaginas;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "cd_editora", nullable = false)
    private EditoraJpaEntity editora;

    @ManyToMany(mappedBy = "livros")
    private List<BibliotecaJpaEntity> bibliotecas;

    public LivroJpaEntity() {}

    public Integer getCodigo() { return codigo; }
    public void setCodigo(Integer codigo) { this.codigo = codigo; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public Integer getNumeroPaginas() { return numeroPaginas; }
    public void setNumeroPaginas(Integer numeroPaginas) { this.numeroPaginas = numeroPaginas; }
    public EditoraJpaEntity getEditora() { return editora; }
    public void setEditora(EditoraJpaEntity editora) { this.editora = editora; }
    public List<BibliotecaJpaEntity> getBibliotecas() { return bibliotecas; }
    public void setBibliotecas(List<BibliotecaJpaEntity> bibliotecas) { this.bibliotecas = bibliotecas; }
}