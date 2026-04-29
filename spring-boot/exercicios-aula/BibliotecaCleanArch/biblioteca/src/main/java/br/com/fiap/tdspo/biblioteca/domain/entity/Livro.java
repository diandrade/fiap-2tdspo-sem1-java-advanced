package br.com.fiap.tdspo.biblioteca.domain.entity;

public class Livro {
    private Integer codigo;
    private String titulo;
    private Integer numeroPaginas;
    private Editora editora;

    public Livro() {}

    public Livro(String titulo, Integer numeroPaginas) {
        this.titulo = titulo;
        this.numeroPaginas = numeroPaginas;
    }

    public Livro(Integer codigo, String titulo, Integer numeroPaginas) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.numeroPaginas = numeroPaginas;
    }

    public Integer getCodigo() { return codigo; }
    public void setCodigo(Integer codigo) { this.codigo = codigo; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public Integer getNumeroPaginas() { return numeroPaginas; }
    public void setNumeroPaginas(Integer numeroPaginas) { this.numeroPaginas = numeroPaginas; }
    public Editora getEditora() { return editora; }
    public void setEditora(Editora editora) { this.editora = editora; }
}