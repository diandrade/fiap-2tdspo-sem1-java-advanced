package br.com.fiap.cpum.entity;

import br.com.fiap.cpum.anotation.Description;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Transient;

import java.math.BigDecimal;

@Entity
@DiscriminatorValue("SENIOR")
@Description(descricao = "Tabela de Funcionarios Seniores - Bônus a cada 15 horas.")
public class Senior extends Funcionario{
    // ATRIBUTOS
    @Transient
    private double valorBonus;

    // CONSTRUTORES
    protected Senior() {
        super();
        this.setValorHora(25);
        this.valorBonus = 90.0;
    }

    public Senior(String nome, int horasTrabalhadas, int valorHora, double valorBonus) {
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
        if (getHorasTrabalhadas() >= 15)
        {
            quantidadeBonus = getHorasTrabalhadas() / 15;
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
    Valor Bônus P/ 15 Horas (Senior) = R$\{valorBonus}
    """;
    }
}
