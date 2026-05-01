package br.com.fiap.tdspo.biblioteca.infrastructure.persistence.entity;

import jakarta.persistence.*;
import java.util.Calendar;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TB_BIBLIOTECA")
@SequenceGenerator(name = "biblioteca", sequenceName = "SQ_TB_BIBLIOTECA", allocationSize = 1)
public class BibliotecaJpaEntity {
    @Id
    @Column(name = "cd_biblioteca")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "biblioteca")
    private Integer codigo;

    @Column(name = "nm_biblioteca", nullable = false, length = 80)
    private String nome;

    @Temporal(TemporalType.DATE)
    @Column(name = "dt_abertura")
    private Calendar dataAbertura;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "cd_endereco", nullable = false)
    private EnderecoJpaEntity endereco;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "TB_LIVRO_BIBLIOTECA",
            joinColumns = @JoinColumn(name = "cd_biblioteca"),
            inverseJoinColumns = @JoinColumn(name = "cd_livro")
    )
    private List<LivroJpaEntity> livros = new ArrayList<>();

    public BibliotecaJpaEntity() {}

    public Integer getCodigo() { return codigo; }
    public void setCodigo(Integer codigo) { this.codigo = codigo; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public Calendar getDataAbertura() { return dataAbertura; }
    public void setDataAbertura(Calendar dataAbertura) { this.dataAbertura = dataAbertura; }
    public EnderecoJpaEntity getEndereco() { return endereco; }
    public void setEndereco(EnderecoJpaEntity endereco) { this.endereco = endereco; }
    public List<LivroJpaEntity> getLivros() { return livros; }
    public void setLivros(List<LivroJpaEntity> livros) { this.livros = livros; }
}