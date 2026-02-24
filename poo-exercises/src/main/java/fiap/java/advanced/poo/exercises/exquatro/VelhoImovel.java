package fiap.java.advanced.poo.exercises.exquatro;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author labsfiap
 */
public class VelhoImovel extends Imovel {
    public VelhoImovel(String endereco, double preco, double desconto) {
        super(endereco, preco);
        setPreco(getPreco() - desconto);
    }
    
    public void valorDoImovel()
    {
        System.out.printf("O valor total do velho imóvel é: %s\n", getPreco());
    }
}
