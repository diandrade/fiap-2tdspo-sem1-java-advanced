package exdois;

public class Conta {
    private String nome;
    private int numero;
    private double saldo;
    private double limite;
    private double rendimento;
    private TipoConta conta;

    public Conta(String nome, int numero, TipoConta conta) {
        this.nome = nome;
        this.numero = numero;
        this.conta = conta;

        if (conta == TipoConta.PLATINUM){
            limite = 10000;
        } else if (conta == TipoConta.GOLD) {
            limite = 100000;
        } else {
            limite = 1000000;
        }
    }

    public void setRendimento(double rendimento) {
        this.rendimento = rendimento;
    }

    public void depositar(double valor){
        if (valor <= limite)
        {
            this.saldo = valor;
        }
        else{
            throw new SaldoExcedenteException("O valor para saque informado é superior ao limite disponível.");
        }
    }

    public void retirar(double valor){
        if (valor >= saldo){
            this.saldo = valor;
        }
        else {
            throw new SaldoInsuficienteException("O valor para saque informado é maior que o saldo disponível.");
        }
    }

    public double rendimentoAnualSaldo(){
        return (rendimento + 100) * saldo;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "nome='" + nome + '\'' +
                ", numero=" + numero +
                ", saldo=" + saldo +
                ", limite=" + limite +
                ", rendimento=" + rendimento +
                ", conta=" + conta +
                "}\n";
    }
}
