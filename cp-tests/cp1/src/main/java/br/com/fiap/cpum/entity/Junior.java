package br.com.fiap.cpum.entity;

import br.com.fiap.cpum.anotation.Description;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Transient;

import java.math.BigDecimal;

@Entity
@DiscriminatorValue("JUNIOR")
@Description(descricao = "Tabela de Funcionarios Juniores - Bônus a cada 60 horas.")
public class Junior extends Funcionario{
    // ATRIBUTOS
    @Transient
    private double valorBonus;

    // CONSTRUTORES
    protected Junior() {
        super();
        this.setValorHora(22);
        this.valorBonus = 130.0;
    }

    public Junior(String nome, int horasTrabalhadas, int valorHora, double valorBonus) {
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
        if (getHorasTrabalhadas() >= 60)
        {
            quantidadeBonus = getHorasTrabalhadas() / 60;
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
    Valor Bônus P/ 60 Horas (Junior) = R$\{valorBonus}
    """;
    }
}
