package br.com.fiap.tdspo.biblioteca.infrastructure.persistence.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TB_EDITORA")
@SequenceGenerator(name = "editora", sequenceName = "SQ_TB_EDITORA", allocationSize = 1)
public class EditoraJpaEntity {
    @Id
    @Column(name = "cd_editora")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "editora")
    private Integer codigo;

    @Column(name = "nm_editora", nullable = false, length = 80)
    private String nome;

    @OneToMany(mappedBy = "editora", cascade = CascadeType.MERGE)
    private List<LivroJpaEntity> livros = new ArrayList<>();

    public EditoraJpaEntity() {}

    public Integer getCodigo() { return codigo; }
    public void setCodigo(Integer codigo) { this.codigo = codigo; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public List<LivroJpaEntity> getLivros() { return livros; }
    public void setLivros(List<LivroJpaEntity> livros) { this.livros = livros; }
}