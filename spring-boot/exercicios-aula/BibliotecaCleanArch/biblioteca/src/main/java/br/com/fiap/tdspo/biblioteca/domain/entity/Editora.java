package br.com.fiap.tdspo.biblioteca.domain.entity;

import java.util.ArrayList;
import java.util.List;

public class Editora {
    private Integer codigo;
    private String nome;
    private List<Livro> livros = new ArrayList<>();

    public Editora() {}

    public Editora(String nome) {
        this.nome = nome;
    }

    public Editora(Integer codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public void adicionarLivro(Livro livro) {
        livro.setEditora(this);
        this.livros.add(livro);
    }

    public Integer getCodigo() { return codigo; }
    public void setCodigo(Integer codigo) { this.codigo = codigo; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public List<Livro> getLivros() { return livros; }
    public void setLivros(List<Livro> livros) { this.livros = livros; }
}