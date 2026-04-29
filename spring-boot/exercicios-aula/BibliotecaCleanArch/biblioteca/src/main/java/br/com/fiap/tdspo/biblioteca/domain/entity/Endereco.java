package br.com.fiap.tdspo.biblioteca.domain.entity;

public class Endereco {
    private Integer codigo;
    private String logradouro;
    private String cep;

    public Endereco() {}

    public Endereco(String logradouro, String cep) {
        this.logradouro = logradouro;
        this.cep = cep;
    }

    public Endereco(Integer codigo, String logradouro, String cep) {
        this.codigo = codigo;
        this.logradouro = logradouro;
        this.cep = cep;
    }

    public Integer getCodigo() { return codigo; }
    public void setCodigo(Integer codigo) { this.codigo = codigo; }
    public String getLogradouro() { return logradouro; }
    public void setLogradouro(String logradouro) { this.logradouro = logradouro; }
    public String getCep() { return cep; }
    public void setCep(String cep) { this.cep = cep; }
}