package br.com.fiap.ProgramaBibliotecaV3.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="TB_ENDERECO")
@SequenceGenerator(name ="enderecoTranquilo", sequenceName = "SQ_TB_ENDERECO", allocationSize = 1)
public class Endereco {

    @Id
    @Column(name = "cd_endereco")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "enderecoTranquilo")
    private Integer codigo;

    @Column(name = "ds_logradouro", nullable = false, length = 100)
    private String logradouro;

    @Column(name = "nr_cep",  nullable = false, length = 9)
    private String cep;

    //Relacionamento 1:1
    //nome do atributo que mapeia a FK
    @OneToOne(mappedBy = "endereco",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Biblioteca biblioteca;

    public Endereco() {}

    public Endereco(String logradouro, String cep) {
        this.logradouro = logradouro;
        this.cep = cep;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

}
