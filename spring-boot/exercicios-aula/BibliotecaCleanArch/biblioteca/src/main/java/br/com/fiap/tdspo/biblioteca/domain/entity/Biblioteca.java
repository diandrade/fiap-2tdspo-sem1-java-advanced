package br.com.fiap.tdspo.biblioteca.domain.entity;

import java.util.Calendar;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private Integer codigo;
    private String nome;
    private Calendar dataAbertura;
    private Endereco endereco;
    private List<Livro> livros = new ArrayList<>();

    public Biblioteca() {}

    public Biblioteca(String nome, Calendar dataAbertura, Endereco endereco) {
        this.nome = nome;
        this.dataAbertura = dataAbertura;
        this.endereco = endereco;
    }

    public Biblioteca(Integer codigo, String nome, Calendar dataAbertura, Endereco endereco) {
        this.codigo = codigo;
        this.nome = nome;
        this.dataAbertura = dataAbertura;
        this.endereco = endereco;
    }

    public Integer getCodigo() { return codigo; }
    public void setCodigo(Integer codigo) { this.codigo = codigo; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public Calendar getDataAbertura() { return dataAbertura; }
    public void setDataAbertura(Calendar dataAbertura) { this.dataAbertura = dataAbertura; }
    public Endereco getEndereco() { return endereco; }
    public void setEndereco(Endereco endereco) { this.endereco = endereco; }
    public List<Livro> getLivros() { return livros; }
    public void setLivros(List<Livro> livros) { this.livros = livros; }
}