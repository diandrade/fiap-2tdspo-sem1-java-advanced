package br.com.fiap.ProgramaBibliotecaV3.entity;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="TB_EDITORA")
@SequenceGenerator(name="editora", sequenceName = "SQ_TB_EDITORA", allocationSize = 1)
public class Editora {

    @Id
    @Column(name="cd_editora")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "editora")
    private Integer codigo;

    @Column(name="nm_editora", nullable = false, length = 80)
    private String nome;

    //Relacionamento 1:P
    @OneToMany(mappedBy = "editora",cascade = CascadeType.MERGE)
    private List<Livro> livros = new ArrayList<Livro>();

    public Editora() {}

    public Editora(String nome) {
        this.nome = nome;
    }

    public void addLivro(Livro livro) {
        //Setar a editora (FK) do livro
        livro.setEditora(this);
        //Adicionar o livro na lista de livros da editora
        this.livros.add(livro);
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

}
