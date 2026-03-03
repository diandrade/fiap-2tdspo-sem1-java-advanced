package exdois;

public class ContaCorrente extends Conta {
    public ContaCorrente(String nome, int numero, TipoConta conta) {
        super(nome, numero, conta);
        setRendimento(0.0);
    }
}
