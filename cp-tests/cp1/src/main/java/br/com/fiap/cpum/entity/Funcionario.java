package br.com.fiap.cpum.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "JCP1_FUNCIONARIO")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tp_func", discriminatorType = DiscriminatorType.STRING)
public abstract class Funcionario {
    // ATRIBUTOS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_funcionario")
    private Long id;

    @Column(name = "nm_func", nullable = false, length = 100)
    private String nome;

    @Column(name = "nr_horas_trabalhadas", nullable = false)
    private Integer horasTrabalhadas;

    @Column(name = "vl_sal_func", nullable = false, precision = 6, scale = 2)
    protected BigDecimal salarioCalculado;

    @Transient
    private int valorHora;

    // CONSTRUTORES
    protected Funcionario() {

    }

    public Funcionario(String nome, int horasTrabalhadas, int valorHora) {
        this.nome = nome;
        this.horasTrabalhadas = horasTrabalhadas;
        this.valorHora = valorHora;
    }

    // GETTERS E SETTERS
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setHorasTrabalhadas(Integer horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public void setValorHora(int valorHora) {
        this.valorHora = valorHora;
    }

    // MÉTODOS
    public int calcularSalario() {
        return horasTrabalhadas * valorHora;
    }

    public String imprimirInformacao() {
        return STR."""
    \n---------- INFORMAÇÕES DO FUNCIONÁRIO ----------
    Nome do Funcionário(a) = \{nome}
    Horas Trabalhadas = \{horasTrabalhadas}
    Salário = R$\{calcularSalario()}
    """;
    }

    @PrePersist
    @PreUpdate
    public void atualizarSalarioAntesDeSalvar() {
        this.salarioCalculado = BigDecimal.valueOf(calcularSalario());
    }
}
