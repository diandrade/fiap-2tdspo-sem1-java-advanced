package exdois;

import java.util.ArrayList;

public class Contas {
    public static void main(String[] args){
        ContaCorrente diandrade = new ContaCorrente("Diego Andrade dos Santos", 187209, TipoConta.BLACK);
        ContaCorrente lumuller = new ContaCorrente("Lucas Muller de Campos", 167709, TipoConta.PLATINUM);
        ContaCorrente daavila = new ContaCorrente("Daniela Avila de Almeida", 263709, TipoConta.GOLD);

        ArrayList<ContaCorrente> contas = new ArrayList<>();
        contas.add(diandrade);
        contas.add(lumuller);
        contas.add(daavila);

        for (int i = 0; i < contas.size() ; i++){
            System.out.println(contas.get(i));
        }

        /* Contas Diversas
        ContaCorrente exemploBlack = new ContaCorrente("Lucas Muller de Campos", 187209, TipoConta.BLACK);

        ContaPoupanca exemploPlatinum = new ContaPoupanca("Luiza de Oliveira Araujo", 131229, TipoConta.PLATINUM);

        ContaInvestimento exemploGold = new ContaInvestimento("Fernanda de Andrade Curimin", 131229, TipoConta.GOLD, TipoAtivo.CDB);*/

        /* ToString
        System.out.println(exemploBlack);
        System.out.println(exemploPlatinum);
        System.out.println(exemploGold);*/

        /* Exception - Excedente
        exemploBlack.depositar(10000000);*/

        /* Testes na View (Contas)
        exemploBlack.depositar(1000);

        exemploGold.depositar(100);
        exemploPlatinum.depositar(10000);

        System.out.println(exemploBlack);
        System.out.println(exemploPlatinum);
        System.out.println(exemploGold);

        System.out.println(exemploBlack.rendimentoAnualSaldo());
        System.out.println(exemploPlatinum.rendimentoAnualSaldo());
        System.out.println(exemploGold.rendimentoAnualSaldo());

        exemploBlack.retirar(1000);
        exemploGold.retirar(100);
        exemploPlatinum.retirar(10000);

        System.out.println(exemploBlack);
        System.out.println(exemploPlatinum);
        System.out.println(exemploGold);*/


    }
}
