package br.com.fiap.cpum.entity;

import br.com.fiap.cpum.anotation.Description;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Transient;

import java.math.BigDecimal;

@Entity
@DiscriminatorValue("PLENO")
@Description(descricao = "Tabela de Funcionarios Plenos - Bônus a cada 30 horas.")
public class Pleno extends Funcionario{
    // ATRIBUTOS
    @Transient
    private double valorBonus;

    // CONSTRUTORES
    protected Pleno() {
        super();
        this.setValorHora(12);
        this.valorBonus = 50.0;
    }

    public Pleno(String nome, int horasTrabalhadas, int valorHora, double valorBonus) {
        super(nome, horasTrabalhadas, valorHora);
        this.valorBonus = valorBonus;
        this.salarioCalculado = BigDecimal.valueOf(calcularSalario());
    }

    // MÉTODOS
    @Override
    public int calcularSalario() {
        int quantidadeBonus;
        int totalBonus;

        totalBonus = 0;
        if (getHorasTrabalhadas() >= 30)
        {
            quantidadeBonus = getHorasTrabalhadas() / 30;
            totalBonus = (int) (quantidadeBonus * valorBonus);
        }

        return super.calcularSalario() + totalBonus;
    }

    @Override
    public String imprimirInformacao() {
        return STR."""
    \n---------- INFORMAÇÕES DO FUNCIONÁRIO ----------
    Nome do Funcionário(a) = \{getNome()}
    Horas Trabalhadas = \{getHorasTrabalhadas()}
    Salário = R$\{calcularSalario()}
    Valor Bônus P/ 30 Horas (Pleno) = R$\{valorBonus}
    """;
    }
}
