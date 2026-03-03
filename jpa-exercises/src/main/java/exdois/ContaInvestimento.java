package exdois;

public class ContaInvestimento extends Conta{
    private final TipoAtivo ativo;

    public ContaInvestimento(String nome, int numero, TipoConta conta, TipoAtivo ativo) {
        super(nome, numero, conta);
        this.ativo = ativo;
        setRendimento(rendimentoPorAtivo(ativo));
    }

    public double rendimentoPorAtivo(TipoAtivo ativo){
        if (ativo == TipoAtivo.CDB){
            return 10.65;
        } else if (ativo == TipoAtivo.TESOURO_SELIC){
            return 10.80;
        } else{
            return 9.5;
        }
    }

    @Override
    public String toString() {
        return super.toString() + "ContaInvestimento{" +
                "ativo=" + ativo +
                '}';
    }
}
