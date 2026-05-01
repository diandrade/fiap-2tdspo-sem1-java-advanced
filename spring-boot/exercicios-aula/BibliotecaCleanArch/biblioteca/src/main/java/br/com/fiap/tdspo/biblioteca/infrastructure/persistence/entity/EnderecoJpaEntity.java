package br.com.fiap.tdspo.biblioteca.infrastructure.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_ENDERECO")
@SequenceGenerator(name = "endereco", sequenceName = "SQ_TB_ENDERECO", allocationSize = 1)
public class EnderecoJpaEntity {
    @Id
    @Column(name = "cd_endereco")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "endereco")
    private Integer codigo;

    @Column(name = "ds_logradouro", nullable = false, length = 100)
    private String logradouro;

    @Column(name = "nr_cep", nullable = false, length = 9)
    private String cep;

    @OneToOne(mappedBy = "endereco", cascade = CascadeType.ALL)
    private BibliotecaJpaEntity biblioteca;

    public EnderecoJpaEntity() {}

    public Integer getCodigo() { return codigo; }
    public void setCodigo(Integer codigo) { this.codigo = codigo; }
    public String getLogradouro() { return logradouro; }
    public void setLogradouro(String logradouro) { this.logradouro = logradouro; }
    public String getCep() { return cep; }
    public void setCep(String cep) { this.cep = cep; }
    public BibliotecaJpaEntity getBiblioteca() { return biblioteca; }
    public void setBiblioteca(BibliotecaJpaEntity biblioteca) { this.biblioteca = biblioteca; }
}