package exdois;

public class Conta {
    private String nome;
    private int numero;
    private double saldo;
    private double limite;
    private TipoConta conta;

    public Conta(String nome, int numero, int saldo, TipoConta conta) {
        this.nome = nome;
        this.numero = numero;
        this.saldo = saldo;
        this.conta = conta;

        if (conta == TipoConta.PLATINUM){
            limite = 10000;
        } else if (conta == TipoConta.GOLD) {
            limite = 100000;
        } else {
            limite = 1000000;
        }
    }

    public void depositar(double valor){
        this.saldo = valor;
    }

    public void retirar(double valor){
        if (valor >= saldo){
            this.saldo = valor;
        }
    }
}
