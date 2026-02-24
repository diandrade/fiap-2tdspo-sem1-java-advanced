package fiap.java.advanced.poo.exercises.exquatro;

/**
 *
 * @author labsfiap
 */
public class NovoImovel extends Imovel {
    public NovoImovel(String endereco, double preco, double adicional) {
        super(endereco, preco);
        setPreco(getPreco() + adicional);
    }
    
    public void valorDoImovel()
    {
        System.out.printf("O valor total do novo imóvel é: %s\n", getPreco());
    }
}
