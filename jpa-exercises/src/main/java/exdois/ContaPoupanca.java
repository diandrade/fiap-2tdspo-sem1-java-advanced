package exdois;

public class ContaPoupanca extends Conta{
    public ContaPoupanca(String nome, int numero, TipoConta conta) {
        super(nome, numero, conta);
        setRendimento(6.17);
    }
}
